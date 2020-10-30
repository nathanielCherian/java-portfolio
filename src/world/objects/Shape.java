package world.objects;

import world.primatives.Point3D;

import java.awt.*;

public class Shape {

    double x;
    double y;
    double z;

    public Point3D[] vertices;

    int point_size = 10;
    Color point_color = new Color(0,0,0);

    public Shape(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Shape(double x, double y, double z, int ps, Color c){
        this.x = x;
        this.y = y;
        this.z = z;

        this.point_size = ps;
        this.point_color = c;
    }

    protected void transform(){

        for(Point3D point: vertices){
            point.x += x;
            point.y += y;
            point.z += z;
        }

    }

    public void transform(double x, double y, double z){
        for(Point3D point: vertices){
            point.x += x;
            point.y += y;
            point.z += z;
        }

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


    public void setY(double y){this.y = y;}
    public void setZ(double z){this.z = z;}



    public Point3D[] getPoints(){
        return vertices;
    }


    public int get_point_size(){
        return point_size;
    }

    public Color get_color(){
        return point_color;
    }

    public void set_point_size(int ps){
        point_size = ps;
    }

    public void set_color(Color c){
        point_color = c;
    }




}
