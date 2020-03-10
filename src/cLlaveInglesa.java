import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class cLlaveInglesa extends cTools{

    // load source images
    BufferedImage martillo = ImageIO.read(new File("images/llaveinglesa.png"));
    int posicionI = 390;

    public cLlaveInglesa(Game game) throws IOException {
        super(game);
        POSICION_ANCHURA_X = posicionI;
    }

    //pintamos la rauqeta
    public void paint(Graphics2D g) {
        g.drawImage(martillo, POSICION_ANCHURA_X, POSICION_ALTURA_Y, SPRITE_ANCHURA, SPRITE_ALTURA, null);
    }

    @Override
    public void run() {

    }
}
