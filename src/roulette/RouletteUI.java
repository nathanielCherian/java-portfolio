package roulette;

import hangman.HangmanUI;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class RouletteUI extends JFrame {


    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                RouletteUI frame = new RouletteUI();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }




    public RouletteUI () {
        //setting standards for color and font
        Font f = new Font("Comic Sans MS", Font.PLAIN, 20);
        MatteBorder b = new MatteBorder(4, 4, 4, 4, Color.BLACK);
        Color c = new Color(0, 255, 85);

        //operations to set up the JFrame
        getContentPane().setBackground(new Color(3, 252, 198));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 500, 500);
        getContentPane().setLayout(null);



    }
}
