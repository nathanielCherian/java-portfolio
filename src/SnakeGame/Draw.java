package SnakeGame;

import SnakeGame.Snake;
import java.util.Random;
import javax.swing.*;
import java.awt.*;

public class Draw extends JLabel {

    Point p;

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);

        //Draw Background
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, Gui.width, Gui.height);

        //Draw Snake Tails
        Random rand = new Random();
        g.setColor(new Color(rand.nextInt(1), rand.nextInt(255), rand.nextInt(255)));
        for (int i = 0; i < Snake.tails.size(); i++) {
            p = Snake.ptc(Snake.tails.get(i).getX(), Snake.tails.get(i).getY());
            g.fillRect(p.x, p.y, 32, 32);
        }

        //Draw Snake Head
        g.setColor(new Color(0,255,0));
        p = Snake.ptc(Snake.head.getX(),Snake.head.getY());
        g.fillRect(p.x,p.y,32,32);

        //Draw PickUp
        g.setColor(new Color(204,51,0));
        p = Snake.ptc(Snake.pickup.getX(), Snake.pickup.getY());
        g.fillRect(p.x,p.y, 32,32);

        //Draw Border
        g.setColor(Color.BLACK);
        g.drawRect(Gui.xoff, Gui.yoff, 512, 512);

        //Draw Score
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.drawString("Score: "+Snake.score, 10,270);
        g.drawString("Best: "+Snake.bestscore, 655,270);

        repaint();

    }

}
