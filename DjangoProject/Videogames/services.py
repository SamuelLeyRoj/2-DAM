# Videogames/services.py
import requests
from datetime import datetime
from .models import Juego

def importar_juegos():
    url = "https://www.freetogame.com/api/games"
    response = requests.get(url)
    if response.status_code != 200:
        return {"success": False, "error": "No se pudieron obtener datos de la API"}

    juegos = response.json()
    creados = 0
    actualizados = 0

    for j in juegos:
        juego, created = Juego.objects.update_or_create(
            codigo=j['id'],
            defaults={
                'titulo': j['title'],
                'imagen': j['thumbnail'],
                'descripcion': j['short_description'],
                'url_juego': j['game_url'],
                'genero': j['genre'],
                'plataforma': j['platform'],
                'publicador': j['publisher'],
                'desarrollador': j['developer'],
                'fecha_lanzamiento': datetime.strptime(j['release_date'], "%Y-%m-%d").date(),
                'perfil_freetogame': f"https://www.freetogame.com/game/{j['id']}",
                'categorias': [],
            }
        )
        if created:
            creados += 1
        else:
            actualizados += 1

    return {"success": True, "creados": creados, "actualizados": actualizados}
