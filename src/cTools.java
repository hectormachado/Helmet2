import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

abstract class cTools {
    int VELOCIDAD = 50;

    /*
    // load source images
    BufferedImage martillo = ImageIO.read(new File("images/martillo.png"));
    BufferedImage destornillador = ImageIO.read(new File("images/destornillador.png"));
    BufferedImage llaveInglesa = ImageIO.read(new File("images/llaveinglesa.png"));
    BufferedImage escudo = ImageIO.read(new File("images/escudo.png"));
    BufferedImage vidaExtra = ImageIO.read(new File("images/vidaextra.png"));
    */


    static int SPRITE_ALTURA = 100;
    static int SPRITE_ANCHURA = 100;
    int POSICION_ALTURA_Y;
    int POSICION_ANCHURA_X;

    int ya = 0;
    int xa = 0;

    private Game game;

    public cTools(Game game) throws IOException {
        this.game = game;
    }

    public void ColumnaRandom(){

        int ColumnRandom = (int) (Math.random()*4+0);

        int[] listaNumeros = new int[4];

        switch (ColumnRandom) {

            case 0:
                POSICION_ANCHURA_X = 130;
                listaNumeros[0]=0;
                break;
            case 1:
                POSICION_ANCHURA_X = 260;
                listaNumeros[1]=1;
                break;
            case 2:
                POSICION_ANCHURA_X = 390;
                listaNumeros[2]=2;
                break;
            case 3:
                POSICION_ANCHURA_X = 520;
                listaNumeros[3]=3;
                break;
            case 4:
                POSICION_ANCHURA_X = 650;
                listaNumeros[4]=4;
                break;
        }

    }

    public  void move() {

        int numRandom = (int) (Math.random()*9+0);

        if(POSICION_ALTURA_Y >= 500){

            switch (numRandom){

                case 0: POSICION_ALTURA_Y = -100; break;
                case 1: POSICION_ALTURA_Y = -200; break;
                case 2: POSICION_ALTURA_Y = -300; break;
                case 3: POSICION_ALTURA_Y = -400; break;
                case 4: POSICION_ALTURA_Y = -500; break;
                case 5: POSICION_ALTURA_Y = -600; break;
                case 6: POSICION_ALTURA_Y = -700; break;
                case 7: POSICION_ALTURA_Y = -800; break;
                case 8: POSICION_ALTURA_Y = -900; break;
                case 9: POSICION_ALTURA_Y = -1000; break;

            }
        }else {
                    POSICION_ALTURA_Y = POSICION_ALTURA_Y + VELOCIDAD;

            }
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
            xa = -50;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            xa = 50;
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

}
