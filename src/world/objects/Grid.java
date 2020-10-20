package world.objects;

public class Grid extends Shape{

    public Point3D[] vertices = new Point3D[5];

    public Grid(int x, int y, int z) {
        super(x, y, z);

        for(int i =0; i < vertices.length; i++){
            vertices[i] = new Point3D(i-2,3,0);
        }

    }
}
