package world;

import world.objects.Cube;
import world.objects.Grid;
import world.objects.Point3D;
import world.objects.Shape;

import javax.annotation.processing.SupportedSourceVersion;
import javax.swing.*;
import javax.swing.text.TabSet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class World extends JPanel {

    Camera camera = new Camera(new Point3D(0,0,0));

    ArrayList<Shape> objects = new ArrayList<>();
    ArrayList<Point2D> points2D = new ArrayList<>();


    public World(){

        Cube cube = new Cube(5,1,1);
        Grid grid = new Grid(0,0,0);

        objects.add(cube);
        objects.add(grid);



        timer.start();
        render();

        addKeyListener(new WorldKeyListener());
        setFocusable(true);




    }


    protected Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {



        }
    });

    public class WorldKeyListener implements KeyListener {


        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {


            if(e.getKeyCode() == 87){ // KEY: W
                camera.move_east(1);
                render();

            }else if(e.getKeyCode() == 83){ // KEY: S
                camera.move_west(1);
                render();

            }else if(e.getKeyCode() == 68){ // KEY: D
                camera.move_south(1);
                render();

            }else if(e.getKeyCode() == 65){ // KEY: A
                camera.move_north(1);
                render();

            }else if(e.getKeyCode() == 32){ // KEY: SPACE
                camera.move_up(1);
                render();

            }else if(e.getKeyCode() == 16){ // KEY: SHIFT
                camera.move_down(1);
                render();
            }

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }



    public void render(){

        points2D.clear();

        for (Shape object: objects){
            for(Point3D point: object.getPoints()){
                Point2D point2d;
                if((point2d=camera.project2D(point)) != null){
                    points2D.add(point2d);
                }
            }
        }

        repaint();
    }



    public void draw_scaled_point(Point2D point, Graphics2D g2d){
        Dimension size = getSize();

        int half_width = size.width /2;
        int half_height = size.height /2;

        int x = (int) ((half_width*point.getX()) + half_width);
        int y = (int) ((half_height*point.getY()) + half_height);

        g2d.fillOval(x, y, 10, 10);

    }




    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        for(Point2D point: points2D){
            draw_scaled_point(point, g2d);
        }


    }
}
