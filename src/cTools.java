import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

abstract class cTools implements Runnable{

    static int VELOCIDAD = 50;
    static int SPRITE_ALTURA = 100;
    static int SPRITE_ANCHURA = 100;
    int POSICION_ALTURA_Y;
    int POSICION_ANCHURA_X;

    private Game game;

    public cTools(Game game) throws IOException {
        this.game = game;

    }



    public  void move() {

        int AlturaRandom = (int) (Math.random()*9+0);

        if(POSICION_ALTURA_Y >= 500){

            switch (AlturaRandom){

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

            int ColumnRandom = (int) (Math.random()*4+0);

            switch (ColumnRandom) {

                case 0:
                    POSICION_ANCHURA_X = 130;
                    break;
                case 1:
                    POSICION_ANCHURA_X = 260;
                    break;
                case 2:
                    POSICION_ANCHURA_X = 390;
                    break;
                case 3:
                    POSICION_ANCHURA_X = 520;
                    break;
                case 4:
                    POSICION_ANCHURA_X = 650;
                    break;
            }
        }else {
                    POSICION_ALTURA_Y = POSICION_ALTURA_Y + VELOCIDAD;
            }
        }

    public Rectangle getBounds(){
        return new Rectangle(POSICION_ANCHURA_X, POSICION_ALTURA_Y, SPRITE_ANCHURA, SPRITE_ALTURA);
    }

    Thread t = new Thread();
    @Override
    public void run() {

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.start();
    }


}
