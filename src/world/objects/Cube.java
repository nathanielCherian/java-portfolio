package world.objects;

public class Cube extends Shape{

    public Point3D[] vertices = new Point3D[8];

    public Cube(int x, int y, int z) {
        super(x, y, z); //left corner

        vertices[0] = new Point3D(0,0,0); //left corner
        vertices[1] = new Point3D(1,0,0); //right corner
        vertices[2] = new Point3D(0,1,0);
        vertices[3] = new Point3D(0,0,1);
        vertices[4] = new Point3D(1,1,0);
        vertices[5] = new Point3D(1,0,1);
        vertices[6] = new Point3D(0,1,1);
        vertices[7] = new Point3D(1,1,1);


        for(Point3D point: vertices){
            point.x += x;
            point.y += y;
            point.z += z;
        }

    }




}
