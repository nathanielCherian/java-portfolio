package game;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Projectile extends Sprite{


    String direction;


    public Projectile(int x, int y, String d){
        this.x = x;
        this.y = y;
        this.r = 10;
        this.speed = 10;

        this.direction = d;

    }


    public void paint(Graphics2D g2d) {
        Ellipse2D shape = new Ellipse2D.Double(x,y,r,r);
        g2d.setColor(Color.blue);
        g2d.fill(shape);
    }

    public Boolean update(Dimension d){

        if(direction=="NORTH"){
            move_forward();
        }else if(direction=="SOUTH"){
            move_backward();
        }else if(direction=="WEST"){
            move_left();
        }else if(direction=="EAST"){
            move_right();
        }


        if(x > 0 && x < d.width && y > 0 && y < d.height){
            return true;
        }

        return false;
    }




}
