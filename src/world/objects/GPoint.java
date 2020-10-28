package world.objects;

import java.awt.*;
import java.awt.geom.Point2D;

public class GPoint extends Point2D.Double {

    public Color color = new Color(0,0,0);
    public int size = 10;

    public GPoint(double x, double y) {
        super(x, y);

    }

    public void setColor(float r, float g, float b){
        color = new Color(r,g,b);
    }

    public void setColor(Color c){
        color = c;
    }

    public void setSize(int s){
        size = s;
    }

}
