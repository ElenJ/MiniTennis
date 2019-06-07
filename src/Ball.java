import java.awt.*;

public class Ball {
    private static final int DIAMETER=30;
    int x = 0;
    int y = 0;
    int xa = 1;
    int ya = 1;
    private Game2 game;

    public Ball(Game2 game) {
        this.game= game;
    }

    void move() {
        boolean changeDirection=true;
        if (x + xa < 0)
            xa = game.getSpeed();
        else if (x + xa > game.getWidth() - DIAMETER)
            xa = -game.getSpeed();
        else if (y + ya < 0)
            ya = game.getSpeed();
        else if (y + ya > game.getHeight() - DIAMETER)
            game.gameOver();
        else if (collision()){
            ya = -game.getSpeed();
            y = game.racquet.getTopY() - DIAMETER;
            game.speedIncrease();
        } else changeDirection=false;

        if (changeDirection)
            SoundEffect.HIT.play();
        x = x + xa;
        y = y + ya;
    }

    private boolean collision(){
        return game.racquet.getBounds().intersects(getBounds());
    }

    public void paint(Graphics2D g) {
        g.setColor(Color.GREEN);
        g.fillOval(x, y, 30, 30);
    }
    public Rectangle getBounds(){
        return new Rectangle(x,y,DIAMETER, DIAMETER);
    }
}