import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class Game extends JPanel{


    public static int Puntos = 0, Vidas = 5, Partes = 5;

    BufferedImage backgroundImage = ImageIO.read(new File("images/fondo.jpg"));

    static JFrame frame;
    private static int ANCHURA = 1000;
    private static int ALTURA = 800;
    private Thread t1, t2, t3;

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

    public void principal(Game game) throws InterruptedException {
        frame.add(game);
        frame.setSize(ANCHURA, ALTURA);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {

                    try {
                        movimiento();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {

                    try {
                        cPlayer.move();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        });
        if (Vidas > 1){
            t1.start();
            t3.start();

        }

        while (Vidas > 0){

            movimiento();
            repaint();

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


    public void movimiento() throws InterruptedException {

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
        g2d.drawString("Vidas: "+ Vidas, 200, 20);
        //g2d.drawString("Partes: "+ Partes, 300, 20);

        if(Vidas < 1){
            g2d.setFont(new Font("HAS PERDIDO!!", Font.PLAIN, 60));
            g2d.drawString("HAS PERDIDO!!! ", 250, 250);
        }

        cPlayer.paint(g2d);

        cMartillo.paint(g2d);
        cDestornillador.paint(g2d);
        cLlaveInglesa.paint(g2d);
        cVidaExtra.paint(g2d);
        cEscudo.paint(g2d);

        cPuerta.avisoPuertaAbrierta(g2d);
    }

}