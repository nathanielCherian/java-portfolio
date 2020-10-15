package app;

import  javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Random;

public class Game extends JPanel{

    ArrayList<Circle> circles = new ArrayList<Circle>();
    ArrayList<Circle> missed_clicks = new ArrayList<Circle>();

    int mistakes = 10;

    Random rand = new Random();

    public Game(){

        setSize(300,300);

        JButton button = new JButton("click me");
        button.addActionListener(e -> {
            timer.start();
        });
        add(button);


        for(int i =0; i < 5; i++){
            circles.add(new Circle(rand.nextInt(300), rand.nextInt(300), 70));
        }



        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);

                if(circles.removeIf(circle -> circle.circle.contains(e.getPoint()))){
                    circles.add(new Circle(rand.nextInt(300), rand.nextInt(300), 70));

                }else {
                    missed_clicks.add(new Circle(e.getX(), e.getY(), 10));
                    mistakes--;
                }


            }
        });


    }


    protected Timer timer = new Timer(100, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            if(mistakes <= 0){
                timer.stop();
            }

            if(circles.removeIf(circle -> !circle.increment(1))){
                circles.add(new Circle(rand.nextInt(300), rand.nextInt(300), 70));
                mistakes--;
            }

            missed_clicks.removeIf(circle -> !circle.increment(3));

            repaint();
        }
    });


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        for(Circle circle: circles){
            circle.paint(this, g2d, Color.RED);
        }

        for (Circle circle: missed_clicks){
            circle.paint(this, g2d, Color.black);
        }

    }

}
