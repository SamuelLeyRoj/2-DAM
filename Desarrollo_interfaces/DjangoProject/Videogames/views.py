import json
import os
from django.shortcuts import render
from django.conf import settings # Usa settings de django.conf
from .models import Juego


def cargarInicio(request):
    return render(request, 'html/home.html')

def cargarJuegos(request):
    ruta_json = os.path.join(settings.BASE_DIR, 'Videogames', 'juegos.json')

    try:
        with open(ruta_json, 'r', encoding='utf-8') as f:
            datos_api = json.load(f)
    except FileNotFoundError:
        datos_api = []

    # 1. Guardar en MongoDB usando los nombres de TU MODELO
    if Juego.objects.using('mongodb').count() == 0:
        for data in datos_api[:32]:
            Juego.objects.using('mongodb').create(
                codigo=data.get('id'),
                titulo=data.get('title'),           # 'title' de la API -> 'titulo' de tu modelo
                imagen=data.get('thumbnail'),       # 'thumbnail' de la API -> 'imagen' de tu modelo
                descripcion=data.get('short_description'),
                url_juego=data.get('game_url'),
                genero=data.get('genre'),
                plataforma=data.get('platform'),
                publicador=data.get('publisher', 'Desconocido'),
                desarrollador=data.get('developer', 'Desconocido'),
                fecha_lanzamiento=data.get('release_date', '2026-01-22'),
                perfil_freetogame=data.get('freetogame_profile_url', '')
            )
        print("DEBUG: Datos guardados en MongoDB.")

    # 2. Recuperar de MongoDB
    juegos_db = Juego.objects.using('mongodb').all()

    # 3. EL TRUCO: "Disfrazamos" los objetos para el HTML
    # Creamos una lista de diccionarios con los nombres que espera tu HTML (title, thumbnail...)
    juegos_para_html = []
    for j in juegos_db:
        juegos_para_html.append({
            'title': j.titulo,
            'thumbnail': j.imagen,
            'genre': j.genero,
            'short_description': j.descripcion,
            'game_url': j.url_juego
        })

    return render(request, 'html/cargarDatos.html', {'juegos': juegos_para_html})