package world;

import game.Board;

import javax.swing.*;
import java.awt.*;

//Controls: WASD for X-Axis, Shift/Space for Y-Axis
public class Home extends JFrame {

    public static void main(String[] args){

        try{
            Home frame = new Home();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Home(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(700,700));


        World world = new World();
        add(world);


        pack();

    }



}
