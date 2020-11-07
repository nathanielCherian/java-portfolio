package world.entities;

import world.Camera;
import world.objects.Cube;
import world.primatives.Point3D;

import java.awt.*;

public class Projectile extends Cube{

    double x_step;
    double y_step;
    double z_step;

    final double DECAY = 200;

    final double SPEED = 2;

    public Projectile(Point3D point, Camera camera) {
        super(point);
        scale(point, 0.20);
        set_color(new Color(255, 0, 0));
        x_step = Math.cos(Math.toRadians(camera.fovx))*SPEED;
        y_step = Math.sin(Math.toRadians(camera.fovx))*SPEED;
        z_step = Math.sin(Math.toRadians(camera.fovy))*SPEED;
    }



    @Override
    public Boolean update() {
        transform(x_step,y_step,z_step);

        if(Math.abs(getX()) >= DECAY || Math.abs(getY()) >= DECAY || Math.abs(getZ()) >= DECAY){
            return false;
        }

        return true;
    }


}
