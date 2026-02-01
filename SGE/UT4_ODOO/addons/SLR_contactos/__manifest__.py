{
    'name': 'slr_contactos',
    'version': '1.0.0',
    'summary': 'Gestión de lotes e importación externa de contactos',
    'description': 'Módulo para la Práctica 2 de SGE - Extensión de res.partner',
    'author': 'Samuel Leyton Rojas',
    'license': 'LGPL-3',
    'depends': [
        'base',
        'contacts',
    ],
    'data': [
        'security/ir.model.access.csv',
        'wizard/import_logistics_view.xml',
        'views/slr_contactos_views.xml',
        # 'data/ir_cron.xml',  <-- COMENTADO (evita error si no existe el archivo)
    ],
    # 'assets': {          <-- COMENTADO hasta que crees la carpeta static
    #    'web.assets_backend': [
    #        'slr_contactos/static/src/css/estilos.css',
    #    ],
    # },
    'installable': True,
    'application': True,
}