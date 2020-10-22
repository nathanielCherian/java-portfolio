package world;

import world.objects.Point3D;

import java.awt.*;
import java.awt.geom.Point2D;

public class Camera {

    public Point3D camera_point;
    public float fovx;
    public float fovy;


    public float FOVX = 120;
    public float FOVY = 120;

    public float half_FOVX = FOVX/2;
    public float half_FOVY = FOVY/2;

    public float[] range_FOVX = new float[2];
    public float[] range_FOVY = new float[2];

    public Camera(Point3D point){

        this.camera_point = point;
        this.fovx = 0; //starting looking down X-axis
        this.fovy = 0;



        changeXFOV(0);
        changeYFOV(0);


    }


    public void changeXFOV(float degs){
        this.fovx = number_to_system(this.fovx + degs);
        range_FOVX[0] = number_to_system(fovx - half_FOVX);
        range_FOVX[1] = number_to_system(fovx + half_FOVX);

        //System.out.println(fovx + " " + range_FOVX[0] + " " + range_FOVX[1]);
    }

    public void changeYFOV(float degs){
        this.fovy = number_to_system(this.fovy + degs);
        range_FOVY[0] = number_to_system(fovy - half_FOVY);
        range_FOVY[1] = number_to_system(fovy + half_FOVY);
    }

    public float number_to_system(float num){
        float diff_num = Math.abs(num) % 180;
        if(diff_num % 180 > 0){
            num = -num + (2*diff_num*Math.signum(num));
            return num;
        }

        return num;
    }

    public void move_east(int steps){
        camera_point.setX(camera_point.getX()+steps);
    }

    public void move_west(int steps){
        camera_point.setX(camera_point.getX()-steps);
    }

    public void move_north(int steps){
        camera_point.setY(camera_point.getY()+steps);
    }

    public void move_south(int steps){
        camera_point.setY(camera_point.getY()-steps);
    }

    public void move_up(int steps){
        camera_point.setZ(camera_point.getZ()+steps);
    }

    public void move_down(int steps){
        camera_point.setZ(camera_point.getZ()-steps);
    }


    public Boolean FOVContainsTheta(double theta_x, double theta_y){

        /* ranges from -180 to +180 */


        /*
        theta_x += 180;
        theta_y += 180;

        float x1 = range_FOVX [0] + 180;
        float x2 = range_FOVX [1] + 180;
        float y1 = range_FOVY [0] + 180;
        float y2 = range_FOVY [1] + 180;

        if(theta_x >= x1 && theta_x <= x2){
            if(theta_y >= y1 && theta_y <= y2){
                return true;
            }
        }


         */


        if(theta_x >= range_FOVX[0] && theta_x <= range_FOVX[1]){
            if(theta_y >= range_FOVY[0] && theta_y <= range_FOVY[1]){
                return true;
            }
        }

        return false;
    }


    public Point2D projectFromTheta(double theta_x, double theta_y){

        /*

        x = angle displacement
        tan(x)/tan(fov/2)

         */

        double delta_theta_x = fovx - theta_x;
        double delta_theta_y = fovy - theta_y;

        double x = Math.tan(Math.toRadians(delta_theta_x))/Math.tan(Math.toRadians(half_FOVX));
        double y = Math.tan(Math.toRadians(delta_theta_y))/Math.tan(Math.toRadians(half_FOVY));


        //System.out.println("X: " + Double.toString(x));

        return new Point2D.Double(x,y);

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


        Point3D new_vector = Point3D.subtract(point, get_location());


        int x = new_vector.getX();
        int y = new_vector.getY();
        int z = new_vector.getZ();

        double theta_x = 0;
        double theta_y = 0;

        if(x < 0){
            if(y <= 0){
                //QUADRANT 3
                theta_x = -180 + Math.toDegrees(Math.atan((double) y/x));
            }else {
                //QUADRANT 2
                theta_x = 180 + Math.toDegrees(Math.atan((double) y/x));
            }

        }else if (x == 0) {
            theta_x = 90 * Math.signum(y);

        }else {
            theta_x = Math.toDegrees(Math.atan((double) y/x));
        }


        // Calculate y degree
        if(x < 0){
            if(z <= 0){
                //QUADRANT 3
                theta_y = -180 + Math.toDegrees(Math.atan((double) z/x));
            }else {
                //QUADRANT 2
                theta_y = 180 + Math.toDegrees(Math.atan((double) z/x));
            }

        }else if (x == 0) {
            theta_y = 90 * Math.signum(z);

        }else {
            theta_y = Math.toDegrees(Math.atan((double) z/x));
        }


        //System.out.println("THETA_X: " + theta_x);
        //System.out.println("THETA_Y: " + theta_y);

        if(FOVContainsTheta(theta_x, theta_y)){
            //System.out.println("true");
            return projectFromTheta(theta_x,theta_y);
        }else {
            //System.out.println("false");
        }


        return null;

    }


    public Point3D get_location(){
        return camera_point;
    }


}