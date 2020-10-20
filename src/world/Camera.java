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

    public Camera(){

        this.camera_point = new Point3D(0,0,0);
        this.fovx = 0; //starting looking down X-axis
        this.fovy = 0;


        range_FOVX[0] = fovx - half_FOVX;
        range_FOVX[1] = fovx + half_FOVX;

        range_FOVY[0] = fovy - half_FOVY;
        range_FOVY[1] = fovy + half_FOVX;


    }




    public Boolean FOVContainsTheta(double theta_x, double theta_y){

        /* ranges from -180 to +180 */

        if(theta_x >= range_FOVX[0] && theta_x <= range_FOVX[1]){
            if(theta_y >= range_FOVY[0] && theta_y <= range_FOVY[1]){
                return true;
            }
        }

        return false;
    }


    public Point2D projectFromTheta(double theta_x, double theta_y){

        double delta_theta_x = fovx - theta_x;
        double delta_theta_y = fovy - theta_y;

        double x = Math.tan(Math.toRadians(delta_theta_x))/Math.tan(Math.toRadians(half_FOVX));
        double y = Math.tan(Math.toRadians(delta_theta_y))/Math.tan(Math.toRadians(half_FOVY));


        System.out.println("X: " + Double.toString(x));

        return new Point2D.Double(x,y);

    }

    public Point3D get_location(){
        return camera_point;
    }




}
