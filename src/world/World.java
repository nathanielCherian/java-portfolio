package world;

import world.objects.Cube;
import world.objects.Grid;
import world.objects.Point3D;

import javax.annotation.processing.SupportedSourceVersion;
import javax.swing.*;
import javax.swing.text.TabSet;
import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class World extends JPanel {

    Camera camera = new Camera();


    ArrayList<Point2D> points = new ArrayList<>();

    public World(){

        Cube cube = new Cube(2,1,1);
        //Grid grid = new Grid(0,0,0);

        for(Point3D point: cube.vertices){
            System.out.println(point);

            Point2D point2d;
            if((point2d=project2D(point)) != null){
                points.add(point2d);
            }
        }

        Point3D test_point = new Point3D(-2,-2,-2);
        //project2D(test_point);

    }


    public Point2D project2D(Point3D point){

        /*

           Step 1: Find vector of every point to camera
                CAMERA_POINT - POINT
                [2,3,1]

           Step 2: Find x angle of each vector with respect to [1 0 0] + CAMERA_POINT

                X_angle = ArcTan(Z/X)

           Step 3: Find y angle of each vector with respect to [0 1 0] + CAMERA_POINT

                Y_angle = ArcTan(Y/Z)

           Step 4: Find the FOV of camera and calculate perspective for each of point inside this angle


         */


        Point3D new_vector = Point3D.subtract(point, camera.get_location());


        int x = new_vector.getX();
        int y = new_vector.getY();
        int z = new_vector.getZ();

        double theta_x = Math.atan((double) y/x);
        theta_x = Math.toDegrees(theta_x) * x / Math.abs(x);
        //System.out.println(theta_x);
        if(y < 0) {
            theta_x += (180 - (2*Math.abs(theta_x))) * (theta_x / Math.abs(theta_x));
        }


        double theta_y = Math.atan((double) z/y);
        theta_y = Math.toDegrees(theta_y) * y / Math.abs(y);
        //System.out.println(theta_y);
        if(x < 0){
            theta_y += (180 - (2*Math.abs(theta_y))) * (theta_y / Math.abs(theta_y));
        }


        System.out.println(theta_x);
        System.out.println(theta_y);

        if(camera.FOVContainsTheta(theta_x, theta_y)){
            System.out.println("true");
            return camera.projectFromTheta(theta_x,theta_y);
        }else {
            System.out.println("false");
        }


        return null;

    }



    public void draw_scaled_point(Point2D point, Graphics2D g2d){
        Dimension size = getSize();

        int half_width = size.width /2;
        int half_height = size.height /2;

        int x = (int) ((half_width*point.getX()) + half_width);
        int y = (int) ((half_height*point.getY()) + half_height);

        g2d.fillOval(x, y, 10, 10);

    }

    public void draw_point(Point point, Graphics2D g2d){
       g2d.fillOval(point.x, point.y, 10, 10);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        for(Point2D point: points){
            draw_scaled_point(point, g2d);
        }


    }
}
