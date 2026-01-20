import pygame, sys, random

def ball_animation():
    global ball_speed_y, ball_speed_x
    ball.x += ball_speed_x
    ball.y += ball_speed_y

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
    if ball_speed_y < 16 and ball_speed_x < 16:

        ball_speed_y += 2
        ball_speed_x += 2

    ball.center = (screen_width/2, screen_height/2)
    ball_speed_y *= random.choice((1,-1))
    ball_speed_x *= random.choice((-1,1))




# General setup
pygame.init()
clock = pygame.time.Clock()

# Setting up the main window
screen_width = 1280
screen_height = 660
screen = pygame.display.set_mode((screen_width, screen_height))
pygame.display.set_caption('Pong')


# Rectángulos del juego (Posición X, Posición Y, Ancho, Alto)
ball = pygame.Rect(screen_width/2 - 15, screen_height/2 - 15, 40, 40)
player = pygame.Rect(screen_width - 20, screen_height/2 - 70, 20, 140)
opponent = pygame.Rect(10, screen_height/2 - 70, 20, 140)

# Colores
bg_color = pygame.Color('grey12')
light_grey = (0,0,0)

background = pygame.image.load("img/naruto.png").convert()
background = pygame.transform.scale(background, (screen_width, screen_height))


ball_image = pygame.image.load("img/rasengan.png").convert_alpha()
ball_image = pygame.transform.scale(ball_image, (40, 40))

#Animaciones


ball_speed_x = 7 * random.choice((1,-1))
ball_speed_y = 7 *random.choice((-1,1))
player_speed = 0
opponent_speed = 7

while True:
    # Handling input
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


    #Visual

    # Visuals
    screen.blit(background, (0, 0))
    pygame.draw.rect(screen, light_grey, player)
    pygame.draw.rect(screen, light_grey, opponent)
    screen.blit(ball_image, ball)
    pygame.draw.aaline(screen, light_grey, (screen_width / 2, 0), (screen_width / 2, screen_height))

    # Updating the window
    pygame.display.flip()
    clock.tick(60)