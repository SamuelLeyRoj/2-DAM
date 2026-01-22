import datetime

from django.utils import timezone
from django_mongodb_backend.fields import ArrayField
from django.db import models


# Create your models here.
class Juego(models.Model):
    codigo = models.IntegerField(unique=True)
    titulo = models.CharField(max_length=200)
    imagen = models.URLField()
    descripcion = models.TextField()
    url_juego = models.URLField()
    genero = models.CharField(max_length=100)
    plataforma = models.CharField(max_length=100)
    publicador = models.CharField(max_length=100)
    desarrollador = models.CharField(max_length=100)
    fecha_lanzamiento = models.DateField()
    perfil_freetogame = models.URLField()
    categorias = ArrayField(models.IntegerField(), null=True, blank=True, default=list)

    class Meta:
        db_table = 'juegos'
        managed = False

    def __str__(self):
        return self.titulo


class Categoria(models.Model):

    nombre = models.CharField(max_length=150,unique=True)
    descripcion = models.CharField(max_length=150)

    class Meta:
        db_table = 'categorias'
        managed = False

    def __str__(self):
        return self.nombre


class Ranking(models.Model):

    usuario= models.CharField(max_length=150)
    rankingFecha = models.DateTimeField(default=timezone.now)
    categoriaCodigo = models.IntegerField(null=False)

    class Meta:
        db_table = 'rankings'
        managed = False

    def __str__(self):
        return self.usuario


















