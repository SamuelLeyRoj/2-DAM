from odoo import models, fields, api

class ResPartner(models.Model):
    _inherit = 'res.partner'  # Esto indica que extendemos Contactos 

    # Campos requeridos por la Práctica 2 [cite: 7, 8, 9, 10]
    slr_n_lote = fields.Char(string="Num. lote", readonly=True, tracking=True)
    slr_id_ext = fields.Char(string="Id. Externo", readonly=True)
    slr_fecha_val = fields.Date(string="Fecha validado", readonly=True)
    slr_esta_lote = fields.Selection([
        ('en_espera', 'En espera'),
        ('enviado', 'Enviado'),
        ('confirmado', 'Confirmado'),
    ], string="Estado lote", default='en_espera', readonly=True)

    # El método para importar el CSV (Paso 3 de la práctica) [cite: 49]
    def action_import_external_csv(self, file_data):
        import csv
        import io
        import base64
        
        # Decodificamos el archivo que viene del wizard
        decoded_data = base64.b64decode(file_data).decode('utf-8')
        reader = csv.DictReader(io.StringIO(decoded_data), delimiter=';')
        
        for row in reader:
            # Buscamos el contacto por su ID original [cite: 50]
            contact = self.browse(int(row['id']))
            if contact.exists():
                contact.write({
                    'slr_id_ext': row['external_id'],
                    'slr_fecha_val': row['processing_date'],
                    'slr_esta_lote': 'confirmado', # El estado cambia a Confirmado [cite: 52]
                })