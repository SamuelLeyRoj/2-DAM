from django.contrib.auth import authenticate, login
from django.http import JsonResponse
from django.utils import timezone
from django.contrib.auth import get_user_model
from .forms import RegistroForm, LoginForm, CategoriaForm
from .models import Juego, Categoria, Ranking
import json
import os
from django.conf import settings
from django.shortcuts import render, redirect, get_object_or_404
from django.contrib import messages
from .models import Juego, Categoria


def cargarHome(request):

    cantidad_actual = Juego.objects.using('mongodb').count()


    if cantidad_actual < 15:
        print(f"DEBUG: Hay pocos juegos ({cantidad_actual}). Iniciando carga...")

        ruta_json = os.path.join(settings.BASE_DIR, 'Videogames', 'juegos.json')

        if os.path.exists(ruta_json):
            try:
                with open(ruta_json, 'r', encoding='utf-8') as f:
                    datos_api = json.load(f)

                datos_limitados = datos_api[:15]
                nuevos = 0
                for data in datos_limitados:
                    titulo_juego = data.get('title')


                    if not Juego.objects.using('mongodb').filter(titulo=titulo_juego).exists():
                        Juego.objects.using('mongodb').create(


                            titulo=titulo_juego,
                            imagen=data.get('thumbnail'),
                            descripcion=data.get('short_description'),
                            url_juego=data.get('game_url'),
                            genero=data.get('genre'),
                            plataforma=data.get('platform'),
                            publicador=data.get('publisher', 'Desconocido'),
                            desarrollador=data.get('developer', 'Desconocido'),

                            fecha_lanzamiento=data.get('release_date') if data.get('release_date') else '2000-01-01',
                            perfil_freetogame=data.get('freetogame_profile_url', '')
                        )
                        nuevos += 1


            except Exception as e:
                print(f"ERROR CRÍTICO: {e}")
        else:
            print(f"ERROR: No se encuentra el archivo JSON en: {ruta_json}")

    return render(request, 'html/home.html')

def cargarregistroAdmin(request):
    return render(request, 'html/registroAdmin.html')

def cargarprincipalAdmin(request):
    return render(request, 'html/principalAdmin.html')


def cargarloginAdmin(request):
    if request.method == 'POST':

        email_admin = request.POST.get('email')
        password_admin = request.POST.get('password')


        usuario = authenticate(request, username=email_admin, password=password_admin)

        if usuario is not None:

            if usuario.is_staff:
                login(request, usuario)
                return redirect('principalAdmin')
            else:

                messages.error(request, "ACCESO DENEGADO. Tu cuenta no tiene privilegios de administrador.")
                return redirect('loginAdmin')
        else:
            messages.error(request, "Correo o contraseña incorrectos.")



    return render(request, 'html/loginAdministrador.html')
def cargarprincipalUsuario(request):
    return render(request, 'html/principalUsuario.html')

def cargarJuegos(request):
    ruta_json = os.path.join(settings.BASE_DIR, 'Videogames', 'juegos.json')


def cargarRankingUsuarios(request):
    return render(request, 'html/rankingUsuario.html')

    try:
        with open(ruta_json, 'r', encoding='utf-8') as f:
            datos_api = json.load(f)
    except FileNotFoundError:
        datos_api = []


    if Juego.objects.using('mongodb').count() == 0:
        for data in datos_api[:32]:
            Juego.objects.using('mongodb').create(
                codigo=data.get('id'),
                titulo=data.get('title'),
                imagen=data.get('thumbnail'),
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


    juegos_db = Juego.objects.using('mongodb').all()


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


def cargarregistroUsuario(request):
    if request.method == 'POST':
        form = RegistroForm(request.POST)
        if form.is_valid():

            usuario = form.save(commit=False)
            usuario.set_password(form.cleaned_data['password'])


            rol_seleccionado = request.POST.get('rol')
            if rol_seleccionado == 'admin':
                usuario.is_staff = True
                usuario.is_superuser = True
            else:
                usuario.is_staff = False
                usuario.is_superuser = False


            usuario.save()
            messages.success(request, "Cuenta creada. Por favor, inicia sesión en tu panel correspondiente.")


            return redirect('loginUsuario')
        else:
            messages.error(request, "Revisa los errores del formulario.")
    else:
        form = RegistroForm()

    return render(request, 'html/registroUsuario.html', {'form': form})


def cargarloginUsuario(request):
    if request.method == 'POST':
        form = LoginForm(request, data=request.POST)
        if form.is_valid():

            email_usuario = form.cleaned_data.get('username')
            password_usuario = form.cleaned_data.get('password')


            usuario = authenticate(request, username=email_usuario, password=password_usuario)

            if usuario is not None:
                login(request, usuario)
                print(f"DEBUG: Login exitoso para {email_usuario}")
                return redirect('principalUsuario')
            else:
                print(f"DEBUG: Fallo de autenticación para {email_usuario}")
                messages.error(request, "Correo o contraseña incorrectos.")
        else:
            messages.error(request, "Por favor, rellena los campos correctamente.")
    else:
        form = LoginForm()

    return render(request, 'html/loginUsuario.html', {'form': form})


def cargarGestionCategoriasAdmin(request):

    if request.method == 'POST':
        form = CategoriaForm(request.POST)
        if form.is_valid():

            categoria = form.save(commit=False)
            categoria.save(using='mongodb')




            juegos_ids = request.POST.getlist('juegos_seleccionados')

            if juegos_ids:

                nuevo_cat_id = str(categoria.pk)


                juegos_a_actualizar = Juego.objects.using('mongodb').filter(pk__in=juegos_ids)

                for juego in juegos_a_actualizar:

                    if not juego.categorias:
                        juego.categorias = []


                    if nuevo_cat_id not in juego.categorias:
                        juego.categorias.append(nuevo_cat_id)
                        juego.save(using='mongodb')



            return redirect('gestionCategoriasAdmin')


    categorias_query = Categoria.objects.using('mongodb').all()
    todos_los_juegos = Juego.objects.using('mongodb').all()


    for cat in categorias_query:
        id_str = str(cat.pk)

        cat.juegos_vinculados = Juego.objects.using('mongodb').filter(categorias__contains=[id_str])

    form = CategoriaForm()
    return render(request, 'html/gestionCategoriasAdmin.html', {
        'form': form,
        'categorias': categorias_query,
        'todos_los_juegos': todos_los_juegos
    })

def editar_categoria(request, pk):

    categoria = get_object_or_404(Categoria.objects.using('mongodb'), pk=pk)
    if request.method == 'POST':

        categoria.nombre = request.POST.get('nombre')
        categoria.descripcion = request.POST.get('descripcion')
        categoria.save(using='mongodb')
    return redirect('gestionCategoriasAdmin')

def eliminar_categoria(request, pk):

    categoria = get_object_or_404(Categoria.objects.using('mongodb'), pk=pk)
    categoria.delete(using='mongodb')
    return redirect('gestionCategoriasAdmin')


def quitar_juego_categoria(request, cat_pk, juego_pk):

    juego = get_object_or_404(Juego.objects.using('mongodb'), pk=juego_pk)


    cat_id_str = str(cat_pk)

    if juego.categorias and cat_id_str in juego.categorias:
        juego.categorias.remove(cat_id_str)
        juego.save(using='mongodb')

    return redirect('gestionCategoriasAdmin')


def aniadir_juego_categoria(request, cat_pk):
    if request.method == 'POST':
        juego_id = request.POST.get('juego_id')

        juego = get_object_or_404(Juego.objects.using('mongodb'), pk=juego_id)


        cat_id_str = str(cat_pk)


        if juego.categorias is None:
            juego.categorias = []


        if cat_id_str not in juego.categorias:
            juego.categorias.append(cat_id_str)
            juego.save(using='mongodb')

    return redirect('gestionCategoriasAdmin')


def cargarJson(request):

    return render(request, 'html/cargarJson.html')


def importar_categorias_json(request):

    if request.method == 'POST':

        archivo = request.FILES.get('archivo_json')

        if not archivo:
            messages.error(request, " Error: Debes seleccionar un archivo JSON.")
            return redirect('cargarJson')


        try:
            datos = json.load(archivo)
        except json.JSONDecodeError:
            messages.error(request, " Error: El archivo no tiene un formato JSON válido.")
            return redirect('cargarJson')

        contador = 0
        generos_unicos = set()


        for item in datos:
            genero = item.get('genre')
            if genero:
                generos_unicos.add(genero.strip())


        for genero_nombre in generos_unicos:
            existe = Categoria.objects.using('mongodb').filter(nombre=genero_nombre).exists()
            if not existe:
                Categoria.objects.using('mongodb').create(
                    nombre=genero_nombre,
                    descripcion=f"Categoría generada automáticamente para {genero_nombre}."
                )
                contador += 1

        if contador > 0:
            messages.success(request, f" Éxito: Se han procesado el archivo y creado {contador} categorías.")
        else:
            messages.info(request, " El archivo es válido, pero todas las categorías ya existían.")

    return redirect('cargarJson')


def importar_juegos_json(request):

    if request.method == 'POST':

        archivo = request.FILES.get('archivo_json')

        if not archivo:
            messages.error(request, " Error: Debes seleccionar un archivo JSON.")
            return redirect('cargarJson')


        try:
            datos = json.load(archivo)
        except json.JSONDecodeError:
            messages.error(request, " Error: El archivo no tiene un formato JSON válido.")
            return redirect('cargarJson')

        contador = 0
        errores = 0


        for data in datos:
            titulo = data.get('title')


            if not Juego.objects.using('mongodb').filter(titulo=titulo).exists():
                try:
                    Juego.objects.using('mongodb').create(
                        titulo=titulo,
                        imagen=data.get('thumbnail'),
                        descripcion=data.get('short_description'),
                        url_juego=data.get('game_url'),
                        genero=data.get('genre'),
                        plataforma=data.get('platform'),
                        publicador=data.get('publisher', 'Desconocido'),
                        desarrollador=data.get('developer', 'Desconocido'),
                        fecha_lanzamiento=data.get('release_date') if data.get('release_date') else '2000-01-01',
                        perfil_freetogame=data.get('freetogame_profile_url', '')
                    )
                    contador += 1
                except Exception as e:
                    print(f"Error importando {titulo}: {e}")
                    errores += 1

        if contador > 0:
            messages.success(request, f"✅ Éxito: Se han importado {contador} juegos del archivo subido.")
        elif errores > 0:
            messages.warning(request, f"⚠️ Hubo problemas importando {errores} juegos. Revisa el formato del JSON.")
        else:
            messages.info(request, "⚠️ El archivo se leyó correctamente, pero no hay juegos nuevos para importar.")

    return redirect('cargarJson')




def cargarCategoriasUsuario(request):
    if not request.user.is_authenticated:
        return redirect('loginUsuario')

    usuario_email = request.user.email


    categorias_query = Categoria.objects.using('mongodb').all()
    for cat in categorias_query:
        id_str = str(cat.pk)

        juegos_cat = Juego.objects.using('mongodb').filter(categorias__contains=[id_str])


        for juego in juegos_cat:
            procesar_puntuacion(juego, usuario_email)

        cat.juegos_vinculados = juegos_cat


    todos_los_juegos = Juego.objects.using('mongodb').all()

    for juego in todos_los_juegos:
        procesar_puntuacion(juego, usuario_email)

    return render(request, 'html/gestionCategoriasUsuario.html', {
        'categorias': categorias_query,
        'todos_juegos': todos_los_juegos
    })


def procesar_puntuacion(juego, email):

    juego.mi_puntuacion = None
    juego.mi_comentario = ""

    if juego.valoraciones_usuarios:
        for val in juego.valoraciones_usuarios:
            if val.get('email') == email:
                juego.mi_puntuacion = val.get('puntuacion')
                juego.mi_comentario = val.get('comentario')
                break




def calificar_juego(request):
    if request.method == 'POST' and request.user.is_authenticated:
        juego_id = request.POST.get('juego_id')
        try:
            puntuacion = int(request.POST.get('puntuacion'))
        except:
            puntuacion = 0
        comentario = request.POST.get('comentario', '').strip()
        usuario_email = request.user.email


        juego = get_object_or_404(Juego.objects.using('mongodb'), pk=juego_id)


        nueva_valoracion = {
            'email': usuario_email,
            'puntuacion': puntuacion,
            'comentario': comentario,
            'fecha': str(timezone.now())
        }


        lista = juego.valoraciones_usuarios
        encontrado = False

        for i, val in enumerate(lista):
            if val.get('email') == usuario_email:
                lista[i] = nueva_valoracion
                encontrado = True
                break

        if not encontrado:

            lista.append(nueva_valoracion)


        juego.valoraciones_usuarios = lista
        juego.save(using='mongodb')

        messages.success(request, "Tu puntuación se ha guardado en el juego.")

    return redirect('cargarCategoriasUsuario')


def gestionCategoriasRanking(request):
    if not request.user.is_authenticated:
        return redirect('loginUsuario')

    categorias_query = Categoria.objects.using('mongodb').all()
    usuario_email = request.user.email

    for cat in categorias_query:
        id_str = str(cat.pk)

        cat.juegos_vinculados = Juego.objects.using('mongodb').filter(categorias__contains=[id_str])


        existe_ranking = Ranking.objects.using('mongodb').filter(
            usuario=usuario_email,
            categoria_nombre=cat.nombre
        ).exists()


        cat.tiene_ranking = existe_ranking

    return render(request, 'html/gestionCategoriasRanking.html', {
        'categorias': categorias_query
    })




def guardarTierList(request):
    if request.method == 'POST':
        try:
            data = json.loads(request.body)

            array_juegos = data.get('rankings', [])
            categoria_nombre = data.get('categoria_nombre')

            if not categoria_nombre:
                return JsonResponse({'status': 'error', 'message': 'Falta la categoría'}, status=400)


            obj, created = Ranking.objects.using('mongodb').update_or_create(
                usuario=request.user.email,
                categoria_nombre=categoria_nombre,
                defaults={
                    'datos': array_juegos,
                    'fecha': timezone.now()
                }
            )

            return JsonResponse({'status': 'success', 'message': 'Ranking guardado correctamente'})
        except Exception as e:
            print(f"ERROR: {e}")
            return JsonResponse({'status': 'error', 'message': str(e)}, status=500)

    return JsonResponse({'status': 'error'}, status=405)




def cargarTierList(request, pk):
    if not request.user.is_authenticated:
        return redirect('loginUsuario')

    categoria = get_object_or_404(Categoria.objects.using('mongodb'), pk=pk)
    id_cat_str = str(pk)


    todos_juegos = Juego.objects.using('mongodb').filter(categorias__contains=[id_cat_str])


    ranking_obj = Ranking.objects.using('mongodb').filter(
        usuario=request.user.email,
        categoria_nombre=categoria.nombre
    ).first()


    mapa_tiers = {}
    if ranking_obj and ranking_obj.datos:
        for item in ranking_obj.datos:
            mapa_tiers[item['id']] = item['tier']

    tiers = {'S': [], 'A': [], 'B': [], 'C': [], 'D': [], 'F': [], 'Bank': []}

    for juego in todos_juegos:
        juego_id = str(juego.pk)


        mis_datos = None
        if juego.valoraciones_usuarios:
            for val in juego.valoraciones_usuarios:
                if val.get('email') == request.user.email:
                    mis_datos = val
                    break
        if mis_datos:
            juego.mi_puntuacion = mis_datos.get('puntuacion')
            juego.mi_comentario = mis_datos.get('comentario')

        tier_destino = mapa_tiers.get(juego_id, 'Bank')

        if tier_destino in tiers:
            tiers[tier_destino].append(juego)
        else:
            tiers['Bank'].append(juego)

    return render(request, 'html/rankingUsuario.html', {
        'categoria': categoria,
        'tiers': tiers
    })


def estadisticasGlobales(request):
    if not request.user.is_authenticated:
        return redirect('loginUsuario')


    todos_los_juegos = Juego.objects.using('mongodb').all()
    categorias = Categoria.objects.using('mongodb').all()

    total_valoraciones_app = 0
    juegos_stats = []


    for juego in todos_los_juegos:

        num_valoraciones = len(juego.valoraciones_usuarios) if juego.valoraciones_usuarios else 0
        total_valoraciones_app += num_valoraciones

        promedio = 0
        if num_valoraciones > 0:

            suma_notas = sum(int(val.get('puntuacion', 0)) for val in juego.valoraciones_usuarios)
            promedio = round(suma_notas / num_valoraciones, 1)

        juegos_stats.append({
            'juego': juego,
            'promedio': promedio,
            'num_valoraciones': num_valoraciones
        })


    juegos_top = sorted(juegos_stats, key=lambda x: (x['promedio'], x['num_valoraciones']), reverse=True)


    categorias_stats = []
    for cat in categorias:
        id_str = str(cat.pk)

        juegos_cat = [j for j in todos_los_juegos if j.categorias and id_str in j.categorias]

        suma_cat = 0
        total_val_cat = 0

        for j in juegos_cat:
            if j.valoraciones_usuarios:
                for val in j.valoraciones_usuarios:
                    suma_cat += int(val.get('puntuacion', 0))
                    total_val_cat += 1

        promedio_cat = round(suma_cat / total_val_cat, 1) if total_val_cat > 0 else 0

        categorias_stats.append({
            'nombre': cat.nombre,
            'promedio': promedio_cat,
            'total_valoraciones': total_val_cat
        })


    categorias_stats = sorted(categorias_stats, key=lambda x: x['promedio'], reverse=True)


    context = {
        'juegos_top': juegos_top,
        'categorias_stats': categorias_stats,
        'total_valoraciones_app': total_valoraciones_app,
        'total_juegos': len(todos_los_juegos)
    }

    return render(request, 'html/estadisticasGlobales.html', context)



def estadisticasGlobalesAdmin(request):
    if not request.user.is_authenticated:
        return redirect('loginUsuario')


    todos_los_juegos = Juego.objects.using('mongodb').all()
    categorias = Categoria.objects.using('mongodb').all()

    total_valoraciones_app = 0
    juegos_stats = []


    for juego in todos_los_juegos:

        num_valoraciones = len(juego.valoraciones_usuarios) if juego.valoraciones_usuarios else 0
        total_valoraciones_app += num_valoraciones

        promedio = 0
        if num_valoraciones > 0:

            suma_notas = sum(int(val.get('puntuacion', 0)) for val in juego.valoraciones_usuarios)
            promedio = round(suma_notas / num_valoraciones, 1)

        juegos_stats.append({
            'juego': juego,
            'promedio': promedio,
            'num_valoraciones': num_valoraciones
        })


    juegos_top = sorted(juegos_stats, key=lambda x: (x['promedio'], x['num_valoraciones']), reverse=True)


    categorias_stats = []
    for cat in categorias:
        id_str = str(cat.pk)

        juegos_cat = [j for j in todos_los_juegos if j.categorias and id_str in j.categorias]

        suma_cat = 0
        total_val_cat = 0

        for j in juegos_cat:
            if j.valoraciones_usuarios:
                for val in j.valoraciones_usuarios:
                    suma_cat += int(val.get('puntuacion', 0))
                    total_val_cat += 1

        promedio_cat = round(suma_cat / total_val_cat, 1) if total_val_cat > 0 else 0

        categorias_stats.append({
            'nombre': cat.nombre,
            'promedio': promedio_cat,
            'total_valoraciones': total_val_cat
        })


    categorias_stats = sorted(categorias_stats, key=lambda x: x['promedio'], reverse=True)


    context = {
        'juegos_top': juegos_top,
        'categorias_stats': categorias_stats,
        'total_valoraciones_app': total_valoraciones_app,
        'total_juegos': len(todos_los_juegos)
    }

    return render(request, 'html/estadisticasGlobalesAdmin.html', context)


def estadisticasGlobalesAdminAdicional(request):
    if not request.user.is_authenticated:
        return redirect('loginUsuario')


    todos_los_juegos = Juego.objects.using('mongodb').all()
    categorias = Categoria.objects.using('mongodb').all()


    User = get_user_model()

    usuarios_totales = User.objects.count()
    ultimos_usuarios = User.objects.all().order_by('-id')[:5]


    rankings_totales = Ranking.objects.using('mongodb').count()
    ultimos_rankings = Ranking.objects.using('mongodb').all().order_by('-fecha')[:5]


    context = {
        'total_juegos': len(todos_los_juegos),
        'total_categorias': len(categorias),
        'total_usuarios': usuarios_totales,
        'total_rankings': rankings_totales,


        'ultimos_usuarios': ultimos_usuarios,
        'ultimos_rankings': ultimos_rankings,
        'categorias': categorias,
    }

    return render(request, 'html/estadisticasAdicionalesAdmin.html', context)