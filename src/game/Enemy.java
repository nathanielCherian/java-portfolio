package game;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Enemy extends Sprite{

    public Enemy(){
        x = 100;
        y = 100;
        speed = 2;
    }

    public Enemy(int mx, int my, int radius, int s){
        x = mx;
        y = my;
        r = radius;
        speed = s;
    }


    public void paint(Graphics2D g2d) {

        Ellipse2D shape = new Ellipse2D.Double(x,y,r,r);
        g2d.setColor(Color.black);
        g2d.fill(shape);
    }


    public void update(int player_x, int player_y){

        //System.out.println(Integer.toString(x) + " " + Integer.toString(y));


        if(x < player_x){
            move_right();
        }else if(x > player_x){
            move_left();
        }

        if(y < player_y){
            move_backward();
        }else if(y > player_y){
            move_forward();
        }


    }


    public Boolean check_collisions(Rectangle[] rects){


        for(Rectangle r: rects){

            if(get_bounds().intersects(r)){
                return false;
            }

        }

        return true;
    }




}
