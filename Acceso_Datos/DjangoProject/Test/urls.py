from django.contrib import admin
from django.urls import path
from Test.views import *

urlpatterns = [

    path('inicio/',mostrar_inicio,name='inicio'),
    path('',mostrar_inicio,name='inicio'),
]
