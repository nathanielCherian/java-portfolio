package app;

import  javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//To play: Click the circles as fast as you can
public class Home extends JFrame{

    public static void main(String[] args){

        try{
            Home frame = new Home();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    JPanel panelCont = new JPanel( new CardLayout()); // panel container

    JPanel home_panel = new JPanel();
    Game game_panel = new Game();

    JButton start_button = new JButton("Start Game!");
    CardLayout cl = new CardLayout();

    public Home() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500,500));
        //setLayout(null);

        panelCont.setLayout(cl);

        home_panel.setBackground(Color.GREEN);
        home_panel.add(start_button);
        start_button.addActionListener(e -> {
            cl.show(panelCont, "2");
        });

        panelCont.add(home_panel, "1");
        panelCont.add(game_panel, "2");
        cl.show(panelCont, "1");



        add(panelCont);
        pack();

    }

}
