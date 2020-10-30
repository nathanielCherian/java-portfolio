package world.primatives;

public class Point3D {

    public double x;
    public double y;
    public double z;

    public GPoint gpoint = null;

    public Point3D(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public String toString(){
        return "Point3D["+getX()+", "+getY()+", "+getZ()+"] ";
    }
    public String toCleanString(){return  "X: "+getX()+ "  Y: " + getY() + "  Z: " + getZ();}

    public static Point3D subtract(Point3D point1, Point3D point2){
        return new Point3D((point1.x - point2.x), (point1.y - point2.y), (point1.z - point2.z));
    }


    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public double getZ(){
        return z;
    }

    public void setX(double x){this.x = x;}
    public void setY(double y){this.y = y;}
    public void setZ(double z){this.z = z;}



}
