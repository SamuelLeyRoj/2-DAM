from odoo import models, fields

class SLRImportWizard(models.TransientModel):
    _name = 'slr.import.wizard' # <--- ESTO genera el id 'model_slr_import_wizard'
    _description = 'Asistente Importación SLR'
    
    file_data = fields.Binary(string="Archivo CSV", required=True)
    file_name = fields.Char(string="Nombre del archivo")
    
    def action_import(self):
        # Llama al método de SLR_contactos.py
        self.env['res.partner'].action_import_external_csv(self.file_data)
        return {'type': 'ir.actions.client', 'tag': 'reload'}