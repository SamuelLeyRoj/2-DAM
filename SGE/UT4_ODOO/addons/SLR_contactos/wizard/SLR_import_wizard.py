from odoo import models, fields

class SlrImportWizard(models.TransientModel):
    _name = 'slr.import.wizard'  # Este es el nombre técnico unificado
    _description = 'Asistente Importación SLR'

    file_data = fields.Binary(string="Archivo CSV", required=True)

    def action_import(self):
        # Llama al método de importación que tienes en SLR_contactos.py
        self.env['res.partner'].action_import_external_csv(self.file_data)
        return {'type': 'ir.actions.client', 'tag': 'reload'}