{
    'name': 'Extensión de Productos SLR',
    'version': '1.0',
    'category': 'Sales',
    'depends': ['product', 'sale'],
    'data': [
        # IMPORTANTE: Asegúrate de que tu archivo en la carpeta 'views'
        # se llame EXACTAMENTE así. Si se llama 'slr_productos_views.xml', cámbialo aquí.
        'views/xxx_productos_views.xml',
    ],
    'assets': {
        'web.assets_backend': [
            'slr_productos/static/src/css/styles.css',
        ],
    },
    'installable': True,
    'license': 'LGPL-3',
}