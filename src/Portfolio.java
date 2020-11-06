import app.Circle;
import app.Home;
import calc.CalculatorUI;
import hangman.HangmanUI;

import  javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import SnakeGame.Start;
public class Portfolio extends JFrame{

    public static void main(String[] args){

        try{
            Portfolio frame = new Portfolio();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    JButton snake_button = new JButton("Snake");
    JButton aimboost_button = new JButton("aimboost");
    JButton calculator_button = new JButton("calculator");
    JButton hangman_button = new JButton("hangman");
    JButton game_button = new JButton("run game");
    JButton world_button = new JButton("3D World");
    JButton tictactoe_button = new JButton("tictactoe");


    int r = 100;
    int g = 100;
    int b = 100;
    Boolean rpeaked = false;
    Boolean gpeaked = false;
    Boolean bpeaked = false;

    Random rand = new Random();

    protected Timer timer = new Timer(20, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //System.out.println(Integer.toString(r) + ", " + Integer.toString(g) + ", " + Integer.toString(b));

            if (!rpeaked){
                r += rand.nextInt(5);
            }else{
                r -= rand.nextInt(5);
            }
            if(r >= 255){
                rpeaked=true;
                r = 255;
            }else if(r <= 0){
                rpeaked = false;
                r = 0;
            }


            if (!gpeaked){
                g += rand.nextInt(5);
            }else{
                g -= rand.nextInt(5);
            }
            if(g >= 255){
                gpeaked=true;
                g=255;
            }else if(g <= 0){
                gpeaked = false;
                g=0;
            }

            if (!bpeaked){
                b += rand.nextInt(5);
            }else{
                b -= rand.nextInt(5);
            }
            if(b >= 255){
                bpeaked=true;
                b = 255;
            }else if(b <= 0){
                bpeaked = false;
                b = 0;
            }

            getContentPane().setBackground(new Color(r, g, b));
        }
    });


    public Portfolio(){

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500,500));
        setLayout(new FlowLayout());

        snake_button.addActionListener(e -> {
            System.out.println("Snake");
            Start.main(null);
        });
        add(snake_button);

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

        game_button.addActionListener(e -> {
            game.Home.main(null);
        });
        add(game_button);

        world_button.addActionListener(e -> {
            world.Home.main(null);
        });
        add(world_button);

        hangman_button.addActionListener(e -> {
            HangmanUI.main(null);
        });
        add(hangman_button);

        tictactoe_button.addActionListener(e -> {
            System.out.println("Tic-Tac-Toe");
            TicTacToeGame.Home.main(null);
        });
        add(tictactoe_button);

        timer.start();
        pack();

    }





}
