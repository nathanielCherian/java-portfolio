package app;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Circle implements AnimatedShape{

    int x;
    int y;
    int max;
    int r = 5;

    Boolean peak = false;

    public Shape circle;

    public  Circle(int x1, int y1, int m){
        x = x1;
        y = y1;
        max = m;
    }

    public boolean increment(int steps){

        if(peak){
            r -= steps;
            x += steps;
            y += steps;
        }else{
            r += steps;
            x -= steps;
            y -= steps;
        }

        if(r >= max){
            peak=true;
        }else if (r <= 0){
            return false;
        }

        return true;

    }

    @Override
    public void update() {

    }

    @Override
    public void paint(JComponent parent, Graphics2D g2d, Color color) {
        circle = new Ellipse2D.Double(x, y, r, r);
        g2d.setColor(color);
        g2d.fill(circle);
    }
}
