package world.objects;

import world.primatives.Point3D;

import java.awt.*;

public class Octahedron extends Shape{

    public Octahedron(double x, double y, double z) {
        super(x, y, z);
    }

    public Octahedron(Point3D point) {
        super(point);
    }

    public Octahedron(double x, double y, double z, int ps, Color c) {
        super(x, y, z, ps, c);
    }


    protected void init(){

        vertices = new Point3D[6];

        vertices[0] = new Point3D(0,0,0);
        vertices[1] = new Point3D(1,0,0);
        vertices[2] = new Point3D(1,1,0);
        vertices[3] = new Point3D(0,1,0);
        vertices[4] = new Point3D(.5,.5,1);
        vertices[5] = new Point3D(.5,.5,-1);

        vertices[0].setLinked_points(new Point3D[] {vertices[1], vertices[3]});
        vertices[2].setLinked_points(new Point3D[] {vertices[1], vertices[3]});
        vertices[4].setLinked_points(new Point3D[] {vertices[0], vertices[1], vertices[2], vertices[3]});
        vertices[5].setLinked_points(new Point3D[] {vertices[0], vertices[1], vertices[2], vertices[3]});

        transform();
    }

}
