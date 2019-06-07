import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;


@SuppressWarnings("serial")
public class Game2 extends JPanel {

    Ball ball = new Ball(this);
    Racquet racquet = new Racquet(this);
   // int speed = 1;
    private int speed = 1;

    public int getSpeed(){

        return speed;
    }

    public void speedIncrease(){

        speed=speed+1;
    }

    private int getScore() {
        return speed -1;
    }


    public Game2() {
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                racquet.keyPressed(e);

            }

            @Override
            public void keyReleased(KeyEvent e) {
                racquet.keyReleased(e);
            }
        });
        setFocusable(true);
       // Sound.BACK.loop();
    }

    private void move() {
        ball.move();
        racquet.move();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        ball.paint(g2d);
        racquet.paint(g2d);
        g2d.setColor(Color.GRAY);
        g2d.setFont(new Font("Verdana", Font.BOLD, 30));
        g2d.drawString(String.valueOf(getScore()), 10, 30);

    }

    public void gameOver(){
        SoundEffect.BACKGROUND.stop();
        SoundEffect.GAMEOVER.play();
        JOptionPane.showMessageDialog(this, "your score is: " + getScore(),"game over", JOptionPane.YES_NO_OPTION);
        System.exit(ABORT);
    }
    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Mini Tennis");
        Game2 game = new Game2();
        frame.add(game);
        frame.setSize(300, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        while (true) {
            SoundEffect.BACKGROUND.soundloop();
            game.move();
            game.repaint();
            Thread.sleep(10);
        }
    }

}
