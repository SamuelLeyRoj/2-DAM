from time import sleep

import pygame, sys, random

def ball_animation():
    global ball_speed_y, ball_speed_x,vidasPlayer1, vidasPlayer2, puntuacionPlayer1, puntuacionPlayer2
    ball.x += ball_speed_x
    ball.y += ball_speed_y

    if ball.left <= 0:

        puntuacionPlayer1 += 1
        vidasPlayer2 -= 1

    elif ball.right >= screen_width:

        puntuacionPlayer2 += 1
        vidasPlayer1 -= 1

    if vidasPlayer1==0 or vidasPlayer2==0:

        pantallaFin()

    if ball.top <= 0 or ball.bottom >= screen_height:
        ball_speed_y *= -1
    if ball.left <= 0 or ball.right >= screen_width:
        ball_restart()

    if ball.colliderect(player) or ball.colliderect(opponent):
        ball_speed_x *= -1


def player_animation():
    player.y += player_speed
    if player.top <= 0:
        player.top = 0
    if player.bottom >= screen_height:
        player.bottom = screen_height

def pantallaFin():
    global puntuacionPlayer1, puntuacionPlayer2


    # Fondo negro con transparencia (opcional)
    pygame.draw.rect(screen, (0, 0, 0), pantallaFinal)
    # Texto de “HAS PERDIDO”
    screen.blit(texto_final, texto_rect)
    pygame.display.flip()
    # Esperar 3 segundos antes de cerrar
    pygame.time.delay(3000)



def opponent_animation():
    if opponent.centery < ball.centery:
        opponent.y += opponent_speed
    if opponent.centery > ball.centery:
        opponent.y -= opponent_speed

    if opponent.top <= 0:
        opponent.top = 0
    if opponent.bottom >= screen_height:
        opponent.bottom = screen_height


def ball_restart():
    global ball_speed_x, ball_speed_y

    score_sound.play()
    score_sound.set_volume(0.9)

    if ball_speed_y < 16 and ball_speed_x < 16:
        ball_speed_y += 4
        ball_speed_x += 4

    ball.center = (screen_width/2, screen_height/2)
    ball_speed_y *= random.choice((1,-1))
    ball_speed_x *= random.choice((-1,1))

# General setup
pygame.init()
pong_sound = pygame.mixer.Sound("pong.ogg")
score_sound = pygame.mixer.Sound("pong.ogg")
sonidoFondo = pygame.mixer.Sound("sonidoAmbiente.mp3")
clock = pygame.time.Clock()

screen_width = 1280
screen_height = 660
screen = pygame.display.set_mode((screen_width, screen_height))
pygame.display.set_caption('Pong')

game_font = pygame.font.Font(None, 50)

ball = pygame.Rect(screen_width/2 - 15, screen_height/2 - 15, 60, 60)
player = pygame.Rect(screen_width - 20, screen_height/2 - 70, 20, 140)
opponent = pygame.Rect(10, screen_height/2 - 70, 20, 140)
pantallaFinal = pygame.Rect(screen_width/2,screen_height/2,500,200)
texto_final = game_font.render("HAS PERDIDO", True, (255, 0, 0))  # rojo
texto_rect = texto_final.get_rect(center=pantallaFinal.center)



puntuacionPlayer1 = 0
puntuacionPlayer2 = 0
puntuacion1 = pygame.Rect(screen_width/2 -60,30,60,60)
puntuacion2 = pygame.Rect(screen_width/2 +60,30,60,60)

bg_color = pygame.Color('grey12')
light_grey = (144,213,255)
colorScore= (0,0,0)

background = pygame.image.load("img/kimetsu.jpg").convert()
background = pygame.transform.scale(background, (screen_width, screen_height))

ball_image = pygame.image.load("img/dragonball.png").convert_alpha()
ball_image = pygame.transform.scale(ball_image, (60, 60))

ball_speed_x = 7 * random.choice((1,-1))
ball_speed_y = 7 * random.choice((-1,1))
player_speed = 0
opponent_speed = 7
vidasPlayer1 = 5
vidasPlayer2 = 5


sonidoFondo.set_volume(0.1)
sonidoFondo.play(-1)
while True:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            pygame.quit()
            sys.exit()
        if event.type == pygame.KEYDOWN:
            if event.key == pygame.K_DOWN:
                player_speed += 7
            if event.key == pygame.K_UP:
                player_speed -= 7
        if event.type == pygame.KEYUP:
            if event.key == pygame.K_DOWN:
                player_speed -= 7
            if event.key == pygame.K_UP:
                player_speed += 7


    ball_animation()
    player_animation()
    opponent_animation()

    # ---- ORDEN CORREGIDO ----
    screen.blit(background, (0, 0))  # fondo
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
