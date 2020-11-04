package roulette;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Bullet {
    double circleX;
    double circleY;
    Ellipse2D circle;
    boolean loaded;


    public Bullet (double circleX, double circleY, boolean loaded) {
        this.circleX = circleX;
        this.circleY = circleY;
        this.loaded = loaded;
        circle = new Ellipse2D.Double(circleX, circleY, 50, 50);
    }



}
