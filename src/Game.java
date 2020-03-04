import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class Game extends JPanel{


    public static int Puntos = 0;
    BufferedImage backgroundImage = ImageIO.read(new File("images/fondo.jpg"));

    static JFrame frame;
    private static int ANCHURA = 1000;
    private static int ALTURA = 800;

    Graphics2D g2d;

    //**-- INSTANCIAMOS AL PLAYER Y LAS HERRAMIENTAS --**//
    cPlayer cPlayer = new cPlayer(this);
    cPuerta cPuerta = new cPuerta(this);

    cMartillo cMartillo = new cMartillo(this);
    cDestornillador cDestornillador = new cDestornillador(this);
    cLlaveInglesa cLlaveInglesa = new cLlaveInglesa(this);
    cVidaExtra cVidaExtra = new cVidaExtra(this);
    cEscudo cEscudo = new cEscudo(this);



    public static void main(String[] args) throws InterruptedException, IOException {
        frame = new JFrame("HELMET GAME");
        Game game = new Game();
        game.principal(game);

    }
    public void principal(Game game){
        frame.add(game);
        frame.setSize(ANCHURA, ALTURA);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true){

            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            game.repaint();
            game.move();

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
        cPlayer.move();

        movimiento();
    }

    public void movimiento(){

        cMartillo.move();
        cDestornillador.move();
        cLlaveInglesa.move();
        cVidaExtra.move();
        cEscudo.move();

    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g2d = (Graphics2D) g;
        g.drawImage(backgroundImage,0, 0, this.getWidth(), this.getHeight(), null);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.drawString("Puntos: "+ Puntos, 100, 20);

        cPlayer.paint(g2d);

        cMartillo.paint(g2d);
        cDestornillador.paint(g2d);
        cLlaveInglesa.paint(g2d);
        cVidaExtra.paint(g2d);
        cEscudo.paint(g2d);

        cPuerta.avisoPuertaAbrierta(g2d);
    }
}