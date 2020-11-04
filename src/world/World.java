package world;

import world.objects.*;
import world.objects.Shape;
import world.primatives.GPoint;
import world.primatives.Point3D;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.security.PublicKey;
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



        Cube cube = new Cube(5,1,1);
        cube.set_color(new Color(39, 179, 30));
        objects.add(cube);

        Cube cube1 = new Cube(5,-3,1);
        cube1.set_color(new Color(11, 44, 212));
        objects.add(cube1);

        Pyramid pyramid = new Pyramid(3,3,3);
        objects.add(pyramid);

        Grid grid = new Grid(0,0,0);
        objects.add(grid);



        /*
        TestShape ts = new TestShape(0,0,0);
        objects.add(ts);
           */


        render();

        timer.start();

        addKeyListener(new WorldKeyListener());
        setFocusable(true);

        addMouseListener(new MouseClickListener());



        xyzLabel.setLocation(0,0);
        xyzLabel.setText(camera.get_location().toCleanString());
        add(xyzLabel);

        fovLabel.setText(camera.getFOVString());
        add(fovLabel);


    }


    double th = 0.0;
    protected Timer timer = new Timer(50, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            /*
            objects.get(0).rotateAboutZ(new Point3D(0,1,1),th);
            objects.get(0).rotateAboutX(new Point3D(0,1,1),th);
            objects.get(0).rotateAboutY(new Point3D(0,1,1),th);

            th += .01;
            */


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


    String SHAPE_STATE = "CUBE";

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


            //I should make this better :(

            switch (keycode){
                case 49: // 1
                    SHAPE_STATE = "CUBE";
                    break;
                case 50: // 2
                    SHAPE_STATE = "PYRAMID";
                    break;
                default:
                    break;

            }

            if(keycode == 88){
                Shape object = new Shape(0,0,0);
                switch (SHAPE_STATE){
                    case "CUBE":
                        object = new Cube(camera.camera_point.getX()+Math.cos(Math.toRadians(camera.fovx))*2, camera.camera_point.getY()+Math.sin(Math.toRadians(camera.fovx))*2, camera.camera_point.getZ());
                        break;
                    case "PYRAMID":
                        object = new Pyramid(camera.camera_point.getX()+Math.cos(Math.toRadians(camera.fovx))*2, camera.camera_point.getY()+Math.sin(Math.toRadians(camera.fovx))*2, camera.camera_point.getZ());
                        break;
                    default:
                        break;

                }

                object.set_color(new Color(134, 30, 179));
                objects.add(object);
            }


        }
    }


    public class MouseClickListener implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            /*
            Cube cube = new Cube(camera.get_location());
            cube.set_color(new Color(134, 30, 179));
            objects.add(cube);
            */

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }


    public void render(){

        points2D.clear();

        for (Shape object: objects){

            int ps = object.get_point_size();
            Color c = object.get_color();

            for(Point3D point: object.getPoints()){
                GPoint point2d;
                point.gpoint = null;
                if((point2d=camera.project2D(point)) != null){
                    point2d.setSize(ps);
                    point2d.setColor(c);
                    points2D.add(point2d);
                    point.gpoint = point2d;
                }
            }
        }

        repaint();

        xyzLabel.setText(camera.get_location().toCleanString());
        fovLabel.setText(camera.getFOVString());
    }



    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        for(Shape object: objects){

            object.draw_points(g2d, getSize());
            object.draw_connections(g2d, getSize());

        }

        

    }
}
