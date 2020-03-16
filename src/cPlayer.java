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

    Thread tp = new Thread();

    public void move() throws InterruptedException {

        Thread.sleep(100);

        if((POSICION_ANCHURA_X == 780)&&(cPuerta.abierta)){ //PUERTA ABIERTA

            Game.Puntos = Game.Puntos + 50;
            POSICION_ANCHURA_X = 0;

        }else if((POSICION_ANCHURA_X == 650) && (xa == 130) && (!cPuerta.abierta)) { //PUERTA CERRADA

        }else if((POSICION_ANCHURA_X + xa >= 0)&&(POSICION_ANCHURA_X + xa < game.getWidth() - SPRITE_ANCHURA)) { // MOVIMIENTO

            POSICION_ANCHURA_X = POSICION_ANCHURA_X + xa;
        }
        if(colision_martillo()) {
            Game.Vidas = Game.Vidas - 3;
        }else if (colision_destornillador()){
            Game.Vidas --;
        }else if (colision_llaveinglesa()){
            Game.Vidas = Game.Vidas - 2;
        }else if (colision_escudo()){
            Game.Vidas ++;
        }else if (colision_vidaextra()){
            Game.Vidas = Game.Vidas + 2;
        }
    }

    private boolean colision_martillo() {
        return game.cMartillo.getBounds().intersects(getBounds());
    }
    private boolean colision_destornillador() {
        return game.cDestornillador.getBounds().intersects(getBounds());
    }
    private boolean colision_llaveinglesa() {
        return game.cLlaveInglesa.getBounds().intersects(getBounds());
    }
    private boolean colision_escudo() {
        return game.cEscudo.getBounds().intersects(getBounds());
    }
    private boolean colision_vidaextra() {
        return game.cVidaExtra.getBounds().intersects(getBounds());
    }

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
        if ((e.getKeyCode() == KeyEvent.VK_LEFT)) {
            xa = -130;
        }else{

        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            xa = 130;

    }

    public Rectangle getBounds(){
        return new Rectangle(POSICION_ANCHURA_X, POSICION_ALTURA_Y, SPRITE_ANCHURA, SPRITE_ALTURA);
    }

    @Override
    public void run() {

        try {
            move();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void contador_vidas(){


    }
}
