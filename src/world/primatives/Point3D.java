package world.primatives;

public class Point3D {

    public double x;
    public double y;
    public double z;

    //NODES
    public Point3D[] linked_points;

    public GPoint gpoint = null;

    public Point3D(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    //String functions
    public String toString(){
        return "Point3D["+getX()+", "+getY()+", "+getZ()+"] ";
    }
    public String toCleanString(){return  "X: "+getX()+ "  Y: " + getY() + "  Z: " + getZ();}


    //Arithmetic functions
    public static Point3D subtract(Point3D point1, Point3D point2){
        return new Point3D((point1.x - point2.x), (point1.y - point2.y), (point1.z - point2.z));
    }
    public static Point3D add(Point3D point1, Point3D point2){
        return new Point3D((point1.x + point2.x), (point1.y + point2.y), (point1.z + point2.z));
    }

    //Convenience functions
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


    public void setLinked_points(Point3D[] points){
        linked_points = points;
    }


}
