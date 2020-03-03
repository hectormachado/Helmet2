import java.util.TimerTask;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Rectangle;

public class cPuerta {

    public static boolean abierta;

    private Game game;

    Color color;

    Graphics g;
    Graphics2D g2d = (Graphics2D) g;


    private Timer timer = new Timer("myTimer");
    private TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {

            if (color == Color.green) {
                abierta = false;
                color = Color.red;
            }
            else {
                abierta = true;
                color = Color.green;
            }
        }
    };

    int y_puerta = 480;
    int x_puerta = 790;

    int width = 100;
    int height = 10;
    int random = 3000;

    public cPuerta(Game game) {
        this.game = game;
        timer.scheduleAtFixedRate(timerTask, 0, random);

    }

    public void avisoPuertaAbrierta(Graphics2D g){
        g.setColor(color);
        g.fillRect(x_puerta, y_puerta, width, height);
    }
}