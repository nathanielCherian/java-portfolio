package SnakeGame;

import SnakeGame.GameClock;
import SnakeGame.Gui;

import javax.swing.JFrame;

public class Start extends JFrame {

    public static void main(String[] args) {

        try {
            SnakeGame.Start frame = new SnakeGame.Start();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Gui g = new Gui();
        GameClock gc = new GameClock();
        g.create();
        gc.start();
    }
}



