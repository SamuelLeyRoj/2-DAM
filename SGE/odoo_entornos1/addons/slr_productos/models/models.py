from odoo import models, fields, api, _
from odoo.exceptions import ValidationError
from dateutil.relativedelta import relativedelta

class SlrProductTemplate(models.Model):
    _inherit = 'product.template'

    # Campos nuevos con tus iniciales 'slr_'
    slr_fec_lanz = fields.Date(string='Fecha de Lanzamiento', tracking=True)
    slr_activ = fields.Integer(string='Años activo', compute='_compute_slr_activ', store=False)
    slr_ilust = fields.Binary(string='Ilustración')
    
    # Modificación del selector de Tipo de producto
    detailed_type = fields.Selection(selection_add=[
        ('consu', 'Otra cosa SLR')
    ], ondelete={'consu': 'set default'})

    # Restricción: Fecha pasada
    @api.constrains('slr_fec_lanz')
    def _check_slr_fec_lanz_past(self):
        for rec in self:
            if rec.slr_fec_lanz and rec.slr_fec_lanz > fields.Date.today():
                raise ValidationError('La Fecha de Lanzamiento debe ser una fecha pasada.')

    # Cálculo: Años activo
    @api.depends('slr_fec_lanz', 'detailed_type')
    def _compute_slr_activ(self):
        for rec in self:
            rec.slr_activ = 0
            # Usamos 'detailed_type' que es lo correcto en Odoo moderno
            if rec.detailed_type == 'service' and rec.slr_fec_lanz:
                try:
                    start = rec.slr_fec_lanz
                    today = fields.Date.today()
                    # Cálculo preciso de años
                    years = today.year - start.year - ((today.month, today.day) < (start.month, start.day))
                    rec.slr_activ = years if years >= 0 else 0
                except Exception:
                    rec.slr_activ = 0