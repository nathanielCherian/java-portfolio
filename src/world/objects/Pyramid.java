package world.objects;

import world.primatives.Point3D;

public class Pyramid extends Shape{

    public Pyramid(double x, double y, double z) {
        super(x, y, z);
    }


    protected void init(){

        vertices = new Point3D[5];

        vertices[0] = new Point3D(0,0,0);
        vertices[1] = new Point3D(1,0,0);
        vertices[2] = new Point3D(0,1,0);
        vertices[3] = new Point3D(1,1,0);
        vertices[4] = new Point3D(0.5,0.5,1);


        vertices[0].setLinked_points(new Point3D[] {vertices[1], vertices[2], vertices[4]});
        vertices[1].setLinked_points(new Point3D[] {vertices[0], vertices[3], vertices[4]});
        vertices[2].setLinked_points(new Point3D[] {vertices[0], vertices[3], vertices[4]});
        vertices[3].setLinked_points(new Point3D[] {vertices[1], vertices[2], vertices[4]});

        transform();
    }



}
