from django.contrib import admin
from django.urls import path
from Videogames import views

urlpatterns = [

    path('admin/', admin.site.urls),
    path('', views.cargarHome, name='home'),
    path('LoginAdmin/', views.cargarloginAdmin, name='loginAdmin'),
    path('LoginUsuario/', views.cargarloginUsuario, name='loginUsuario'),
    path('RegistroUsuario', views.cargarregistroUsuario, name='registroUsuario'),
    path('PrincipalAdmin/', views.cargarprincipalAdmin, name='principalAdmin'),
    path('PrincipalUsuario/', views.cargarprincipalUsuario, name='principalUsuario'),
    path('CargarDatos/', views.cargarJuegos, name='cargarJuegos'),
    path('GestionCategoriasAdmin', views.cargarGestionCategoriasAdmin, name='gestionCategoriasAdmin'),
    path('GestionCategoriasRanking/', views.gestionCategoriasRanking, name='gestionCategoriasRanking'),
    path('RankingUsuario/', views.cargarRankingUsuarios, name='rankingUsuarios'),
    path('estadisticas/', views.estadisticasGlobales, name='estadisticasGlobales'),
    path('CargarJson/', views.cargarJson, name='cargarJson'),
    path('EstadisticasAdmin/', views.estadisticasGlobalesAdmin, name='estadisticasGlobalesAdmin'),
    path('EstadisticasAdminAdicional/',views.estadisticasGlobalesAdminAdicional, name='estadisticasGlobalesAdminAdicional'),

    path('CargarCategotiasUsuario/', views.cargarCategoriasUsuario, name='cargarCategoriasUsuario'),


    path('calificar-juego/', views.calificar_juego, name='calificar_juego'),



    path('tierlist/<str:pk>/', views.cargarTierList, name='tierlist'),
    path('categorias/editar/<str:pk>/', views.editar_categoria, name='editar_categoria'),
    path('categorias/eliminar/<str:pk>/', views.eliminar_categoria, name='eliminar_categoria'),
    path('categorias/<str:cat_pk>/quitar-juego/<str:juego_pk>/', views.quitar_juego_categoria,
         name='quitar_juego_categoria'),
    path('categorias/aniadir-juego/<str:cat_pk>/', views.aniadir_juego_categoria, name='aniadir_juego_categoria'),
    path('importar-categorias/', views.importar_categorias_json, name='importar_categorias_json'),
    path('importar-juegos/', views.importar_juegos_json, name='importar_juegos_json'),
    path('tierlist/<str:pk>/', views.cargarTierList, name='tierlist'),
    path('guardar-tierlist/', views.guardarTierList, name='guardarTierList'),
]
