import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class cPlayer {

    // load source images
    BufferedImage image = ImageIO.read(new File("images/player4.png"));


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
        if ((POSICION_ANCHURA_X + xa > 0)&&(POSICION_ANCHURA_X + xa < game.getWidth() - SPRITE_ANCHURA))
            POSICION_ANCHURA_X = POSICION_ANCHURA_X + xa;
        /*
        if ((POSICION_ALTURA_Y + ya > 0)&&(POSICION_ALTURA_Y + ya < game.getWidth() - SPRITE_ALTURA))
            POSICION_ALTURA_Y = POSICION_ALTURA_Y + ya;
         */
    }

    //pintamos la rauqeta
    public void paint(Graphics2D g) {
        g.drawImage(image, POSICION_ANCHURA_X, POSICION_ALTURA_Y, SPRITE_ANCHURA, SPRITE_ALTURA, null);
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
            xa = -5;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            xa = 5;
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
