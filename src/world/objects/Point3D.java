package world.objects;

public class Point3D {

    int x;
    int y;
    int z;

    public Point3D(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public String toString(){
        return "Point3D["+getX()+", "+getY()+", "+getZ()+"] ";
    }

    public static Point3D subtract(Point3D point1, Point3D point2){
        return new Point3D((point1.x - point2.x), (point1.y - point2.y), (point1.z - point2.z));
    }


    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getZ(){
        return z;
    }

}
