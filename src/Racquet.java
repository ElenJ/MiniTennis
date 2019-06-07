import java.awt.*;
import java.awt.event.KeyEvent;


public class Racquet {
    private static final int Y=330;
    private static final int WIDTH = 60;
    private static final int HEIGHT=10;
    int x = 120;
    int xa = 0;
    private Game2 game;

    public Racquet(Game2 game) {
        this.game= game;
    }


    void move() {
        if (x + xa > 0 && x + xa < game.getWidth()-60)
            x = x +xa;
    }

    public void paint(Graphics2D g) {
        g.setColor(Color.RED);
        g.fillRect(x, Y, WIDTH, HEIGHT);
    }
    public void keyReleased(KeyEvent e) {
        xa=0;
    }
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_LEFT)
            xa=-game.getSpeed();
        if (e.getKeyCode()==KeyEvent.VK_RIGHT)
            xa=game.getSpeed();
    }
    public Rectangle getBounds(){
        return new Rectangle(x,Y,WIDTH,HEIGHT);
    }
    public int getTopY(){
        return Y;
    }
}