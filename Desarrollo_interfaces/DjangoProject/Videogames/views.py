import requests # IMPORT NORMAL
from django.http import HttpResponse
from django.shortcuts import render

from Videogames.models import Juego


# Create your views here.

def cargarJuegos(request):
    url = "https://www.freetogame.com/api/games"

    try:
        response = requests.get(url)
        if response.ok:
            juegos = response.json()
            # Mostramos los primeros 12 para que la cuadrícula quede perfecta
            return render(request, 'home.html', {'juegos': juegos[:30]})
        else:
            return HttpResponse(f"Error de la API: {response.status_code}", status=400)
    except Exception as e:
        return HttpResponse(f"Error técnico real: {type(e).__name__} - {str(e)}", status=500)