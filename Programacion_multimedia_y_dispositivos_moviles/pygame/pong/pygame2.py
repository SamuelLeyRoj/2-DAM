import pygame, sys, random

## Crear un rectángulo para la paleta del jugador
##player = pygame.Rect(100, 200, 20, 140)  # x, y, ancho, alto

# Dibujarlo
## pygame.draw.rect(screen, (255,255,255), player)


#Aqui pierde vidas el oponente o el jugador
#Comportamiento general cuando la bola choca con player o oponente

def ball_animation():
    global ball, ball_speed_y, ball_speed_x, vidasPlayer1, vidasPlayer2, puntuacionPlayer1, puntuacionPlayer2

    ball.x += ball_speed_x
    ball.y += ball_speed_y

    if ball.left <= 0:


        puntuacionPlayer1 += 1
        vidasPlayer2 -= 1

    elif ball.right >= screen_width:


        puntuacionPlayer2 += 1
        vidasPlayer1 -= 1












    if vidasPlayer1 == 0 or vidasPlayer2 == 0:
        pantallaFin()

    if ball.top <= 0 or ball.bottom >= screen_height:
        ball_speed_y *= -1
    if ball.left <= 0 or ball.right >= screen_width:
        ball_restart()

    if ball.colliderect(player):
        ball_speed_x = abs(ball_speed_x)*-1

    if ball.colliderect(opponent):
        ball_speed_x = abs(ball_speed_x)


#Evita que ser salga de la pantalla
def player_animation():
    player.y += player_speed
    if player.top <= 0:
        player.top = 0
    if player.bottom >= screen_height:
        player.bottom = screen_height

#Pantalla
def pantallaFin():
    global puntuacionPlayer1, puntuacionPlayer2


    pygame.draw.rect(screen, (0, 0, 0), pantallaFinal)
    screen.blit(texto_final, texto_rect)
    pygame.display.flip()
    # Esperar 3 segundos antes de cerrar
    pygame.time.delay(3000)
    pygame.quit()
    sys.exit()


def opponent_animation():
    if opponent.centery < ball.centery:
        opponent.y += opponent_speed
    if opponent.centery > ball.centery:
        opponent.y -= opponent_speed

    if opponent.top <= 0:
        opponent.top = 0
    if opponent.bottom >= screen_height:
        opponent.bottom = screen_height

#Aumenta la velocidad cuando se marca un punto
def ball_restart():
    global ball_speed_x, ball_speed_y

    score_sound.play()
    score_sound.set_volume(0.9)

    if ball_speed_y < 16 and ball_speed_x < 16:
        ball_speed_y += 4
        ball_speed_x += 4

    ball.center = (screen_width / 2, screen_height / 2)
    ball_speed_y *= random.choice((1, -1))
    ball_speed_x *= random.choice((-1, 1))


def pantallaInicio():


    # El get rect sirve para crear y manejar posiciones y tamaños
    # Muestra en pantalla

    screen.fill((0, 0, 0))

    texto1= game_font.render("VENCE A TU ENEMIGO ", True, (255, 255, 255))
    textoPosicion1 = texto1.get_rect(center=(screen_width / 2, screen_height / 2 -120))

    texto6 =game_font.render("PRESIONA 'O' PARA ENCOJER Y 'P' PARA AGRANDAR", True, (255, 255, 255))
    textoPosicion6 = texto6.get_rect(center=(screen_width / 2, screen_height / 2 -70))

    texto2= game_font.render("'ARRIBA' PARA SUBIR y 'ABAJO' PARA BAJAR", True, (255, 255, 255))
    textoPosicion2 = texto2.get_rect(center=(screen_width / 2, screen_height / 2 - 20))

    texto3= game_font.render("GANA CON 5 PUNTOS", True, (255, 255, 255))
    textoPosicion3 = texto3.get_rect(center=(screen_width / 2, screen_height / 2 + 35))

    texto4 = game_font.render("- ENTER PARA JUGAR -", True, (255, 255, 255))
    textoPosicion4 = texto4.get_rect(center=(screen_width / 2, screen_height / 2 + 90))


    texto5 = game_font.render("CREADO POR -> LEYTON  :)", True, (200,0,0))
    textoPosicion5 = texto5.get_rect(center=(screen_width / 2, screen_height / 2 + 200))

    texto7 = game_font.render("EN COLABORACIÓN DE -> ÁNGELA :P",True,(255,0,255))
    textoPosicion7 = texto7.get_rect(center=(screen_width / 2, screen_height / 2 + 250))

    screen.blit(texto1, textoPosicion1)
    screen.blit(texto2, textoPosicion2)
    screen.blit(texto3, textoPosicion3)
    screen.blit(texto4, textoPosicion4)
    screen.blit(texto5, textoPosicion5)
    screen.blit(texto6, textoPosicion6)
    screen.blit(texto7, textoPosicion7)
    pygame.display.flip()



#  General setup
pygame.init()
pong_sound = pygame.mixer.Sound("pong.ogg")
score_sound = pygame.mixer.Sound("pong.ogg")
sonidoFondo = pygame.mixer.Sound("sonidoAmbiente.mp3")
clock = pygame.time.Clock()
mostrarPantallaInicio = True

# Responsive
info = pygame.display.Info()
screen_width = info.current_w - 100
screen_height = info.current_h -120
screen = pygame.display.set_mode((screen_width, screen_height), pygame.RESIZABLE)

# Escalar fondo
background = pygame.image.load("img/kimetsu.jpg").convert()
background = pygame.transform.scale(background, (screen_width, screen_height))


game_font = pygame.font.Font(None, int(screen_height * 0.075))
# -----------------------------------------------------



player = pygame.Rect(screen_width - 30, screen_height / 2 - 70, 20, 140)
opponent = pygame.Rect(10, screen_height / 2 - 70, 20, 140)
pantallaFinal = pygame.Rect(0, 0, screen_width, screen_height)
texto_final = game_font.render("HAS PERDIDO", True, (255, 0, 0))  # rojo
texto_rect = texto_final.get_rect(center=pantallaFinal.center)

#Puntuaciones
puntuacionPlayer1 = 0
puntuacionPlayer2 = 0
puntuacion1 = pygame.Rect(screen_width / 2 - 60, 30, 60, 60)
puntuacion2 = pygame.Rect(screen_width / 2 + 60, 30, 60, 60)



#Colores y Fondo
ball = pygame.Rect(screen_width / 2 - 15, screen_height / 2 - 15, 60, 60)
bg_color = pygame.Color('grey12')
light_grey = (144, 213, 255)
colorScore = (0, 0, 0)
background = pygame.image.load("img/kimetsu.jpg").convert()
background = pygame.transform.scale(background, (screen_width, screen_height))
ball_image = pygame.image.load("img/dragonball.png").convert_alpha()
ball_image = pygame.transform.scale(ball_image, (60, 60))



#Velocidades y vidas
ball_speed_x = 7 * random.choice((1, -1))
ball_speed_y = 7 * random.choice((-1, 1))
player_speed = 0
opponent_speed = 7
vidasPlayer1 = 5
vidasPlayer2 = 5

#Musica
sonidoFondo.set_volume(0.1)
sonidoFondo.play(-1)

while True:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            pygame.quit()
            sys.exit()

        if mostrarPantallaInicio == True:
                if event.type == pygame.KEYDOWN and event.key == pygame.K_RETURN:
                    mostrarPantallaInicio = False


        if event.type == pygame.KEYDOWN:

            # Aumentar tamaño
            if event.key == pygame.K_p:


                if player.height < 300:
                    player.height += 30
                    player.y -= 15
                    if player.top < 0:
                        player.top = 0

            # Disminuir tamaño
            if event.key == pygame.K_o:

                if player.height > 40:
                    player.height -= 30
                    player.y += 15
                    if player.bottom > screen_height:
                        player.bottom = screen_height


            if event.key == pygame.K_DOWN:
                player_speed += 7
            if event.key == pygame.K_UP:
                player_speed -= 7

        if event.type == pygame.KEYUP:
            if event.key == pygame.K_DOWN:
                player_speed -= 7
            if event.key == pygame.K_UP:
                player_speed += 7

    if mostrarPantallaInicio:
        pantallaInicio()
        clock.tick(60)
        continue


    ball_animation()
    player_animation()
    opponent_animation()

    # Puntuación
    screen.blit(background, (0, 0))
    pygame.draw.rect(screen, colorScore, puntuacion1)  # rectángulos puntuación
    pygame.draw.rect(screen, colorScore, puntuacion2)

    # Renderizar y dibujar puntuación encima de los rectángulos
    score_text1 = game_font.render(str(puntuacionPlayer1), True, (255, 255, 255))
    score_text2 = game_font.render(str(puntuacionPlayer2), True, (255, 255, 255))
    screen.blit(score_text1, (puntuacion1.x + (puntuacion1.width - score_text1.get_width()) / 2,
                              puntuacion1.y + (puntuacion1.height - score_text1.get_height()) / 2))
    screen.blit(score_text2, (puntuacion2.x + (puntuacion2.width - score_text2.get_width()) / 2,
                              puntuacion2.y + (puntuacion2.height - score_text2.get_height()) / 2))

    pygame.draw.rect(screen, light_grey, player)
    pygame.draw.rect(screen, light_grey, opponent)
    screen.blit(ball_image, ball)

    pygame.display.flip()
    clock.tick(60)
