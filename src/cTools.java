import java.awt.*;
import java.io.IOException;

abstract class cTools implements Runnable {

    static int VELOCIDAD = 1;
    static int SPRITE_ALTURA = 100;
    static int SPRITE_ANCHURA = 100;
    int POSICION_ALTURA_Y;
    int POSICION_ANCHURA_X;

    private Game game;

    public cTools(Game game) throws IOException {
        this.game = game;

    }


    public void move() {

        int AlturaRandom = (int) (Math.random() * 11 + 0);

        if (POSICION_ALTURA_Y >= 500) {

            switch (AlturaRandom) {

                case 0:
                    POSICION_ALTURA_Y = -100;
                    break;
                case 1:
                    POSICION_ALTURA_Y = -200;
                    break;
                case 2:
                    POSICION_ALTURA_Y = -300;
                    break;
                case 3:
                    POSICION_ALTURA_Y = -400;
                    break;
                case 4:
                    POSICION_ALTURA_Y = -500;
                    break;
                case 5:
                    POSICION_ALTURA_Y = -600;
                    break;
                case 6:
                    POSICION_ALTURA_Y = -700;
                    break;
                case 7:
                    POSICION_ALTURA_Y = -800;
                    break;
                case 8:
                    POSICION_ALTURA_Y = -900;
                    break;
                case 9:
                    POSICION_ALTURA_Y = -1000;
                    break;

            }

            if (POSICION_ALTURA_Y <= 0) {

                int ColumnRandom = (int) (Math.random() * 5 + 0);

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
            }
        }else {
            POSICION_ALTURA_Y = POSICION_ALTURA_Y + VELOCIDAD;
        }
    }
}
