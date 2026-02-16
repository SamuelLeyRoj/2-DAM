import datetime


from django.utils import timezone
from django.db import models
from django.contrib.auth.models import AbstractBaseUser, BaseUserManager, PermissionsMixin
from django_mongodb_backend.fields import ObjectIdAutoField, ArrayField


# Create your models here.
class Juego(models.Model):
    codigo = ObjectIdAutoField(primary_key=True)
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
    categorias = ArrayField(models.CharField(max_length=24), null=True, blank=True, default=list)
    valoraciones_usuarios = models.JSONField(default=list, blank=True)

    class Meta:
        db_table = 'juegos'
        managed = True

    def __str__(self):
        return self.titulo


class Categoria(models.Model):
    codigo = ObjectIdAutoField(primary_key=True)
    nombre = models.CharField(max_length=150,unique=True)
    descripcion = models.CharField(max_length=350)

    class Meta:
        db_table = 'categorias'
        managed = True

    def __str__(self):
        return self.nombre


# En models.py

class Ranking(models.Model):
    codigo = ObjectIdAutoField(primary_key=True)
    usuario = models.CharField(max_length=150)
    categoria_nombre = models.CharField(max_length=150)  # Ej: "Nuevos lanzamientos"

    # --- AQUÍ ESTÁ EL ARREGLO ---
    # En lugar de guardar 1 juego, guardamos LA LISTA ENTERA de ese ranking
    # Ejemplo de lo que se guardará aquí:
    # [ {"id": "698...", "tier": "S"}, {"id": "712...", "tier": "A"} ]
    datos = models.JSONField(default=list)
    # ----------------------------

    fecha = models.DateTimeField(default=timezone.now)

    class Meta:
        db_table = 'rankings'  # Se guardará en la colección 'rankings'
        managed = True
        # Esto asegura que solo haya UN ranking por usuario y categoría
        unique_together = ('usuario', 'categoria_nombre')

    fecha = models.DateTimeField(default=timezone.now)
class UsuarioManager(BaseUserManager):

    # Define la función. Recibe el email, el nombre y el rol como obligatorios.
    # El password es opcional por defecto (None) por si quieres crear usuarios sin contraseña inicial
    def create_user(self, email, nombre, rol, password=None):
        if not email:

            raise ValueError("El usuario debe tener un email")

    # normalize_email = Esta es una función de Django que "limpia" el correo. Por ejemplo,
    # convierte la parte del dominio a minúsculas
    # (Juan@Gmail.com -> Juan@gmail.com),
    # asegurando que no haya duplicados por errores de escritura.


        email = self.normalize_email(email)
        usuario = self.model(email=email, nombre=nombre, rol=rol)
        usuario.set_password(password)
        usuario.save(using=self._db)
        return usuario

    def create_superuser(self, email, nombre, rol='admin', password=None):

        usuario = self.create_user(email, nombre, rol, password)
        usuario.is_superuser = True
        usuario.is_staff = True
        usuario.save(using=self._db)
        return usuario

# Modelo de como es nuestro usuario

class Usuario(AbstractBaseUser, PermissionsMixin):
    ROLES = (
        ('admin', 'Administrador'),
        ('cliente', 'Cliente'),
    )


    email = models.EmailField(unique=True)
    nombre = models.CharField(max_length=100)
    rol = models.CharField(max_length=20, choices=ROLES)
    is_active = models.BooleanField(default=True)
    is_staff = models.BooleanField(default=False)

    objects = UsuarioManager()

    USERNAME_FIELD = 'email'
    REQUIRED_FIELDS = ['nombre', 'rol']

    class Meta:
        db_table = 'usuarios'

    def __str__(self):
        return self.email













