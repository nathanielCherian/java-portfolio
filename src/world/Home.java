package world;

import game.Board;

import javax.swing.*;
import java.awt.*;

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
        setPreferredSize(new Dimension(500,500));


        World world = new World();
        add(world);


        pack();

    }



}
