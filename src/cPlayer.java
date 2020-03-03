import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class cPlayer implements Runnable {

    // load source images
   //BufferedImage images = ImageIO.read(new File("images/player.png")); //Imagen PNG
   Image image = new ImageIcon(String.valueOf(new File("images/player1.gif"))).getImage(); //Imagen GIF


    static int SPRITE_ALTURA = 100;
    static int SPRITE_ANCHURA = 100;
    static int POSICION_ALTURA_Y = 575;
    static int POSICION_ANCHURA_X = 0;

    int ya = 0;
    int xa = 0;

    private Game game;

    public cPlayer(Game game) throws IOException {
        this.game = game;
    }

    //limites de movimiento
    public void move() {

        if((POSICION_ANCHURA_X == 780)&&(cPuerta.abierta)){ //PUERTA ABIERTA

            Game.Puntos = Game.Puntos + 50;
            POSICION_ANCHURA_X = 0;

        }else if ((POSICION_ANCHURA_X == 650)&&(!cPuerta.abierta)){ //PUERTA CERRADA



        }else if((POSICION_ANCHURA_X + xa >= 0)&&(POSICION_ANCHURA_X + xa < game.getWidth() - SPRITE_ANCHURA)) { // MOVIMIENTO

            POSICION_ANCHURA_X = POSICION_ANCHURA_X + xa;
        }
    }

    //pintamos la rauqeta
    public void paint(Graphics2D g) {
        game.g2d.drawImage(image, POSICION_ANCHURA_X, POSICION_ALTURA_Y, SPRITE_ANCHURA, SPRITE_ALTURA, null);
    }

    //sin pulsar teclas
    public void keyReleased(KeyEvent e) {
        xa = 0;
        ya = 0;
    }

    //pulsando  [<--] o [-->]
    public void keyPressed(KeyEvent e) {
        //MOVIMIENTO HORIZONTAL
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
            xa = -130;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            xa = 130;
        //MOVIMIENTO VERTICAL
/*
        if (e.getKeyCode() == KeyEvent.VK_UP)
            ya = -3;
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
            ya = 3;
*/
    }

    public Rectangle getBounds(){
        return new Rectangle(POSICION_ANCHURA_X, POSICION_ALTURA_Y, SPRITE_ANCHURA, SPRITE_ALTURA);
    }

    public int getTop_RACQUET_POSITION() {
        return POSICION_ALTURA_Y - SPRITE_ALTURA;
    }

    @Override
    public void run() {
        while(true)
        {
            move();
            paint(game.g2d);

        }
    }
}
