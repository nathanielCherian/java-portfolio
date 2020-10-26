package world.objects;

import java.awt.*;

public class Shape {

    int x;
    int y;
    int z;

    public Point3D[] vertices;

    int point_size = 10;
    Color point_color = new Color(0,0,0);

    public Shape(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Shape(int x, int y, int z, int ps, Color c){
        this.x = x;
        this.y = y;
        this.z = z;

        this.point_size = ps;
        this.point_color = c;
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


    public int getPoint_size(){
        return point_size;
    }

    public Color getPoint_color(){
        return point_color;
    }

    public void setPoint_size(int ps){
        point_size = ps;
    }

    public void setPoint_color(Color c){
        point_color = c;
    }




}
