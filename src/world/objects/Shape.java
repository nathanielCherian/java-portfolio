package world.objects;

public class Shape {

    int x;
    int y;
    int z;

    public Point3D[] vertices;

    public Shape(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
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

    public Point3D[] getPoints(){
        return vertices;
    }



}
