import app.Home;
import calc.CalculatorUI;

import  javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;

public class Portfolio extends JFrame{

    public static void main(String[] args){

        try{
            Portfolio frame = new Portfolio();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    JButton aimboost_button = new JButton("aimboost");
    JButton calculator_button = new JButton("calculator");

    public Portfolio(){

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500,500));
        setLayout(new FlowLayout());

        aimboost_button.addActionListener(e -> {
            System.out.println("aimboost");
            Home.main(null);
        });
        add(aimboost_button);


        calculator_button.addActionListener(e -> {
            System.out.println("calculator");
            CalculatorUI.main(null);
        });
        add(calculator_button);


        pack();

    }






}
