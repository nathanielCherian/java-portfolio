package world;

import world.objects.*;
import world.objects.Shape;

import javax.annotation.processing.SupportedSourceVersion;
import javax.swing.*;
import javax.swing.text.TabSet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class World extends JPanel {

    Camera camera = new Camera(new Point3D(0,0,0));

    ArrayList<Shape> objects = new ArrayList<>();
    ArrayList<GPoint> points2D = new ArrayList<>();


    JLabel xyzLabel = new JLabel("xyz");
    JLabel fovLabel = new JLabel("fov");


    public World(){



        Cube cube = new Cube(5,0.5,1);
        cube.setPoint_color(new Color(39, 179, 30));
        objects.add(cube);

        Cube cube1 = new Cube(5,-3,1);
        cube1.setPoint_color(new Color(11, 44, 212));
        objects.add(cube1);

        Grid grid = new Grid(0,0,0);
        objects.add(grid);



        /*
        TestShape ts = new TestShape(0,0,0);
        objects.add(ts);
           */



        timer.start();
        render();

        addKeyListener(new WorldKeyListener());
        setFocusable(true);



        xyzLabel.setLocation(0,0);
        xyzLabel.setText(camera.get_location().toCleanString());
        add(xyzLabel);

        fovLabel.setText(camera.getFOVString());
        add(fovLabel);


    }


    protected Timer timer = new Timer(50, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            for(int key: pressed_keys){
                process_key(key);
            }
            render();

        }
    });

    public void process_key(int keycode){

        switch (keycode){
            case 87: //W
                camera.move_forward();
                //camera.move_east();
                break;
            case 83: //S
                //camera.move_west();
                camera.move_backward();
                break;
            case 68: //D
                //camera.move_south();
                camera.move_right();
                break;
            case 65: //A
                //camera.move_north();
                camera.move_left();
                break;
            case 32:
                camera.move_up();
                break;
            case 16:
                camera.move_down();
                break;
            case 37:
                camera.changeXFOV(5);
                break;
            case 38:
                camera.changeYFOV(5);
                break;
            case 39:
                camera.changeXFOV(-5);
                break;
            case 40:
                camera.changeYFOV(-5);
                break;
            default:
                break;
        }

    }


    Set<Integer> pressed_keys = new HashSet<>();
    public class WorldKeyListener implements KeyListener {


        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {

            int keycode = e.getKeyCode();
            pressed_keys.add(keycode);

        }

        @Override
        public void keyReleased(KeyEvent e) {
            int keycode = e.getKeyCode();
            pressed_keys.remove(keycode);
        }
    }



    public void render(){

        points2D.clear();

        for (Shape object: objects){

            int ps = object.getPoint_size();
            Color c = object.getPoint_color();

            for(Point3D point: object.getPoints()){
                GPoint point2d;
                if((point2d=camera.project2D(point)) != null){
                    point2d.setSize(ps);
                    point2d.setColor(c);
                    points2D.add(point2d);
                }
            }
        }

        repaint();

        xyzLabel.setText(camera.get_location().toCleanString());
        fovLabel.setText(camera.getFOVString());
    }



    public void draw_scaled_point(GPoint point, Graphics2D g2d){
        Dimension size = getSize();

        int half_width = size.width /2;
        int half_height = size.height /2;

        int x = (int) ((half_width*point.getX()) + half_width);
        int y = (int) ((half_height*point.getY()) + half_height);

        int r = point.size;
        Color c = point.color;

        g2d.setColor(c);
        g2d.fillOval(x, y, r, r);

    }




    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        for(GPoint point: points2D){
            draw_scaled_point(point, g2d);
        }


    }
}
