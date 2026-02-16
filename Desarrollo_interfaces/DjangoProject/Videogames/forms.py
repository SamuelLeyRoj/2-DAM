from django import forms
from django.contrib.auth.forms import AuthenticationForm
from .models import Usuario, Categoria


class RegistroForm(forms.ModelForm):
    password = forms.CharField(widget=forms.PasswordInput)

    class Meta:
        model = Usuario
        fields = ['email', 'nombre', 'rol', 'password']

class LoginForm(AuthenticationForm):
    username = forms.EmailField(label="Correo")


class CategoriaForm(forms.ModelForm):
    class Meta:
        model = Categoria
        fields = ['nombre', 'descripcion']
        widgets = {
            'nombre': forms.TextInput(attrs={'class': 'form-control', 'placeholder': 'Nombre de la categoría'}),
            'descripcion': forms.Textarea(attrs={'class': 'form-control', 'rows': 3, 'placeholder': 'Breve descripción...'}),
        }