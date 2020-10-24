package game;

import javax.swing.*;
import java.awt.*;

//To play: WASD to move, Space to shoot
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

        Board board = new Board();

        add(board);


        pack();

    }




}
