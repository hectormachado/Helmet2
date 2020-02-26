import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Game extends JPanel {

    BufferedImage backgroundImage = ImageIO.read(new File("images/fondo.jpg"));

    private static int ANCHURA = 1000;
    private static int ALTURA = 800;

    cPlayer cPlayer = new cPlayer(this);
    cTools cTools = new cTools(this);
    cMartillo cMartillo = new cMartillo(this);

    public static void main(String[] args) throws InterruptedException, IOException {
        JFrame frame = new JFrame("HELMET GAME");
        Game game = new Game();
        frame.add(game);
        frame.setSize(ANCHURA, ALTURA);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true){
            game.move();
            game.repaint();
        }

    }

    public Game() throws IOException {
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                cPlayer.keyReleased(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                cPlayer.keyPressed(e);
            }
        });
        setFocusable(true);
    }

    private void move() {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        cMartillo.move();
        cPlayer.move();
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g.drawImage(backgroundImage,0, 0, this.getWidth(), this.getHeight(), null);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        cPlayer.paint(g2d);
        //cTools.paint(g2d);
        cMartillo.paint(g2d);
    }


}