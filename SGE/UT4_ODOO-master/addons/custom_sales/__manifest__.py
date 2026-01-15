{
    'name': 'Extensión de Productos DEV',
    'version': '1.0',
    'category': 'Sales',
    'summary': 'Extensión personalizada del módulo de productos',
    'author': 'Tu Nombre',
    'depends': ['product', 'sale'], # Dependemos del módulo base de productos
    'data': [
        'views/product_views.xml',
    ],
    'assets': {
        'web.assets_backend': [
            'dev_productos/static/src/css/styles.css',
        ],
    },
    'installable': True,
    'application': False,
}