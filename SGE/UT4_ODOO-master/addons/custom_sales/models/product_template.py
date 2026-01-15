from odoo import models, fields, api, _
from odoo.exceptions import ValidationError
from dateutil.relativedelta import relativedelta

class ProductTemplate(models.Model):
    _inherit = 'product.template'

    # Campo 3 (Imagen): Lo definimos primero para usarlo en la vista
    dev_ilust = fields.Binary(string="Ilustración")

    # Modificación de etiqueta en 'detailed_type' (Tipo de producto)
    # Nota: Dependiendo de tu versión de Odoo (15, 16, 17), los keys pueden variar
    # (consu, service, product). Aquí redefinimos para cambiar la etiqueta.
    detailed_type = fields.Selection(selection_add=[
        ('consu', 'Otra cosa DEV')
    ], ondelete={'consu': 'set default'})

    # Campo 1: Fecha de Lanzamiento
    dev_fec_lanz = fields.Date(
        string="Fecha de Lanzamiento",
        tracking=True, # Registro en el chatter
        help="Fecha en que se lanzó el servicio."
    )

    # Campo 2: Años activo (Calculado)
    dev_activ = fields.Integer(
        string="Años activo",
        compute='_compute_dev_activ',
        store=False # No se guarda en BD, se calcula al vuelo
    )

    # Constraint para validar fecha pasada
    @api.constrains('dev_fec_lanz')
    def _check_fec_lanz(self):
        for record in self:
            if record.dev_fec_lanz and record.dev_fec_lanz > fields.Date.today():
                raise ValidationError("La Fecha de Lanzamiento debe ser una fecha pasada.")

    # Cálculo de años activo
    @api.depends('dev_fec_lanz', 'detailed_type')
    def _compute_dev_activ(self):
        for record in self:
            # Solo calcular si es servicio y tiene fecha
            if record.detailed_type == 'service' and record.dev_fec_lanz:
                # Calculamos la diferencia en años
                record.dev_activ = relativedelta(fields.Date.today(), record.dev_fec_lanz).years
            else:
                record.dev_activ = 0