package game;

import javax.sound.sampled.Port;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Board extends JPanel{

    public int TICK_SPEED = 50;
    ArrayList<Enemy> enemies = new ArrayList<>();
    ArrayList<Projectile> projectiles = new ArrayList<>();


    Random rand = new Random();

    public Board(){



        for(int i =0; i<5;i++){
            add_enemy();
        }



        timer.start();

        addMouseMotionListener(new GameMouseMotionListener());
        addKeyListener(new GameKeyListener());
        setFocusable(true);


    }

    Sprite s = new Sprite();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        s.paint(g2d);

        for(Enemy sp: enemies){
            sp.paint(g2d);
        }

        for(Projectile pr: projectiles){
            pr.paint(g2d);
        }

    }



    protected Timer timer = new Timer(TICK_SPEED, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            s.digest_keys(pressed_keys); //Controls player sprite



            projectiles.removeIf(projectile -> !projectile.update(getSize())); //check if goes off screen

            ArrayList<Rectangle> rects = new ArrayList<>();
            for(int i=0; i<projectiles.size();i++){
                Projectile pr = projectiles.get(i);
                if (!pr.update(getSize())){ //leaves screen
                    projectiles.remove(i);

                }else {
                    rects.add(pr.get_bounds());

                }
            }





            for(int i =0; i<enemies.size();i++){
                enemies.get(i).update(s.x, s.y);

                if(!enemies.get(i).check_collisions(rects.toArray(new Rectangle[rects.size()]))){
                    enemies.remove(i);
                    add_enemy();
                }

            }


            repaint();
        }
    });


    Set<Integer> pressed_keys = new HashSet<>();
    public class GameKeyListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) { }

        @Override
        public synchronized void keyPressed(KeyEvent e) {

            if(e.getKeyCode() == 87){ // KEY: W
                pressed_keys.add(e.getKeyCode());
                s.state = "NORTH";

            }else if(e.getKeyCode() == 83){ // KEY: S
                pressed_keys.add(e.getKeyCode());
                s.state = "SOUTH";

            }else if(e.getKeyCode() == 68){ // KEY: D
                pressed_keys.add(e.getKeyCode());
                s.state = "EAST";

            }else if(e.getKeyCode() == 65){ // KEY: A
                pressed_keys.add(e.getKeyCode());
                s.state = "WEST";

            }else if(e.getKeyCode() == 32){ // KEY: SPACE
                projectiles.add(new Projectile(s.x,s.y, s.state));

            }

        }

        @Override
        public void keyReleased(KeyEvent e) {
            pressed_keys.remove(e.getKeyCode());
        }

    }



    Point mouse_location = new Point();
    public class GameMouseMotionListener implements MouseMotionListener{

        @Override
        public void mouseDragged(MouseEvent e) { }

        @Override
        public void mouseMoved(MouseEvent e) {
            mouse_location = e.getPoint();
        }
    }



    public void add_enemy(){
        enemies.add(new Enemy(rand.nextInt(400), rand.nextInt(400), (rand.nextInt(3)+2)*10, rand.nextInt(3)+1));
    }


}

