package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

public class Board extends JPanel{

    public Board(){

        JButton button = new JButton("press");
        add(button);

        timer.start();


        addKeyListener(new GameKeyListener());
        setFocusable(true);

    }

    Sprite s = new Sprite();
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        s.paint(g2d);

    }



    protected Timer timer = new Timer(50, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            s.digest_keys(pressed_keys);

            repaint();
        }
    });


    Set<Integer> pressed_keys = new HashSet<>();
    public class GameKeyListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
            //System.out.println("keypressed: " + KeyEvent.getKeyText(e.getKeyCode()));
        }

        @Override
        public synchronized void keyPressed(KeyEvent e) {

            if(e.getKeyCode() == 87){ // KEY: W
                pressed_keys.add(e.getKeyCode());

            }else if(e.getKeyCode() == 83){ // KEY: S
                pressed_keys.add(e.getKeyCode());

            }else if(e.getKeyCode() == 68){ // KEY: D
                pressed_keys.add(e.getKeyCode());

            }else if(e.getKeyCode() == 65){ // KEY: A
                pressed_keys.add(e.getKeyCode());
            }

        }

        @Override
        public void keyReleased(KeyEvent e) {
            pressed_keys.remove(e.getKeyCode());
        }

    }



}

