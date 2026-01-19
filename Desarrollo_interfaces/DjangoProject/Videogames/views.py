from django.shortcuts import render

from Videogames.models import Juego


# Create your views here.

def home(request):
    juegos = Juego.objects.all()[:20]  # los primeros 20 juegos
    return render(request, 'home.html', {'juegos': juegos})