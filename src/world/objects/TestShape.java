package world.objects;

public class TestShape extends Shape{

    public TestShape(double x, double y, double z) {
        super(x, y, z);

        vertices = new Point3D[2];
        vertices[0] = new Point3D(6,0,0);
        vertices[1] = new Point3D(6,0,2);

    }
}
