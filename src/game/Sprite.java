package game;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Sprite{

    public String state = "NORTH";

    int x = 0;
    int y = 0;

    int r = 80;

    int speed = 5;


    public void paint(Graphics2D g2d) {

        Ellipse2D shape = new Ellipse2D.Double(x,y,r,r);
        g2d.setColor(Color.red);
        g2d.fill(shape);

    }


    Map<Integer, Runnable> key_map = Map.ofEntries(
            Map.entry(87, () -> move_forward()),
            Map.entry(83, () -> move_backward()),
            Map.entry(68, () -> move_right()),
            Map.entry(65, () -> move_left())

    );

    public void digest_keys(Set<Integer> pressed_keys){


        for (int code: pressed_keys){
            key_map.get(code).run();
        }

        /*
        if(pressed_keys.contains(87)){
            move_forward();
        }else if(pressed_keys.contains(83)){
            move_backward();
        }
        */

    }

    public void move_forward(){
        y -= speed;

    }

    public void move_backward(){
        y += speed;

    }

    public void move_left(){
        x -= speed;
    }

    public void move_right(){
        x += speed;
    }

    public Rectangle get_bounds(){
        return new Rectangle(x, y, r, r);
    }



}
