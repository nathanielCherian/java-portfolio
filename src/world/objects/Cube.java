package world.objects;

import world.primatives.Point3D;

public class Cube extends Shape{



    public Cube(double x, double y, double z) {
        super(x, y, z); //left corner
    }

    public Cube(Point3D point) {
        super(point); //left corner
    }

    protected void init(){


        vertices = new Point3D[8];

        vertices[0] = new Point3D(0,0,0); //left corner
        vertices[1] = new Point3D(1,0,0); //right corner
        vertices[2] = new Point3D(0,1,0);
        vertices[3] = new Point3D(0,0,1);
        vertices[4] = new Point3D(1,1,0);
        vertices[5] = new Point3D(1,0,1);
        vertices[6] = new Point3D(0,1,1);
        vertices[7] = new Point3D(1,1,1);


        //ADDING CONNECTIONS
        vertices[0].setLinked_points(new Point3D[] {vertices[1], vertices[2], vertices[3]});
        vertices[1].setLinked_points(new Point3D[] {vertices[0], vertices[1], vertices[4]});
        vertices[2].setLinked_points(new Point3D[] {vertices[0], vertices[6], vertices[4]});
        vertices[6].setLinked_points(new Point3D[] {vertices[2], vertices[7], vertices[3]});
        vertices[4].setLinked_points(new Point3D[] {vertices[7]});
        vertices[5].setLinked_points(new Point3D[] {vertices[7], vertices[1], vertices[3]});

        transform();
    }




}
