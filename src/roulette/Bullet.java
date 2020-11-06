package roulette;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Bullet {
    public static enum STATE {BLANK, REAL, FIRED};
    STATE state;


    public Bullet (STATE state) {
        this.state = state;
    }



}
