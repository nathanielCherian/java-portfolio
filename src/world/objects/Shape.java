package world.objects;

import world.primatives.Point3D;

import javax.sound.sampled.Port;
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

        init();
    }

    public Shape(Point3D point){
        this.x = point.getX();
        this.y = point.getY();
        this.z = point.getZ();

        init();
    }

    public Shape(double x, double y, double z, int ps, Color c){
        this.x = x;
        this.y = y;
        this.z = z;

        this.point_size = ps;
        this.point_color = c;

        init();
    }


    protected void init(){}
    protected void transform(){

        for(Point3D point: vertices){
            point.x += x;
            point.y += y;
            point.z += z;
        }

    }


    //Move object in lateral directions
    public void transform(double x, double y, double z){
        for(Point3D point: vertices){
            point.x += x;
            point.y += y;
            point.z += z;
        }

    }


    //YAW=rotate about x, PITCH=rotate about z, ROLL=rotate about y
    public void rotate(Point3D origin, double yaw, double pitch, double roll){

        yaw = Math.toRadians(yaw);
        pitch = Math.toRadians(pitch);
        roll = Math.toRadians(roll);

        for(int i=0;i<vertices.length;i++){

            Point3D vpoint = Point3D.subtract(vertices[i],origin);

            // YAW
            double x = Math.cos(yaw)*vpoint.getX() + Math.sin(yaw)*vpoint.getY();
            double y = -1*Math.sin(yaw)*vpoint.getX() + Math.cos(yaw)*vpoint.getY();
            double z = vpoint.getZ();

            // PITCH
            x = x;
            y = Math.cos(pitch)*y + -1*Math.sin(pitch)*z;
            z = Math.sin(pitch)*y + Math.cos(pitch)*z;

            // ROLL
            x = Math.cos(roll)*x + -1*Math.sin(roll)*z;
            y = y;
            z = Math.sin(roll)*x + Math.cos(roll)*z;


            Point3D np = Point3D.add(new Point3D(x,y,z),origin);

            vertices[i].setX(np.getX());
            vertices[i].setY(np.getY());
            vertices[i].setZ(np.getZ());

        }

    }


    //Rotate object YAW
    public void rotateAboutX(Point3D origin, double thetax){

        thetax = Math.toRadians(thetax);

        for(int i=0;i<vertices.length;i++){

            Point3D vpoint = Point3D.subtract(vertices[i],origin);

            double x = Math.cos(thetax)*vpoint.getX() + Math.sin(thetax)*vpoint.getY();
            double y = -1*Math.sin(thetax)*vpoint.getX() + Math.cos(thetax)*vpoint.getY();
            double z = vpoint.getZ();

            Point3D np = Point3D.add(new Point3D(x,y,z),origin);

            vertices[i].setX(np.getX());
            vertices[i].setY(np.getY());
            vertices[i].setZ(np.getZ());

        }

    }

    // Rotate object PITCH
    public void rotateAboutZ(Point3D origin, double thetaz){

        thetaz = Math.toRadians(thetaz);

        for(int i=0;i<vertices.length; i++){

            Point3D vpoint = Point3D.subtract(vertices[i],origin);

            double x = vpoint.getX();
            double y = Math.cos(thetaz)*vpoint.getY() + -1*Math.sin(thetaz)*vpoint.getZ();
            double z = Math.sin(thetaz)*vpoint.getY() + Math.cos(thetaz)*vpoint.getZ();


            Point3D np = Point3D.add(new Point3D(x,y,z),origin);

            vertices[i].setX(np.getX());
            vertices[i].setY(np.getY());
            vertices[i].setZ(np.getZ());

        }

    }

    // Rotate object ROLL
    public void rotateAboutY(Point3D origin, double thetay){

        thetay = Math.toRadians(thetay);

        for(int i=0;i<vertices.length; i++){

            Point3D vpoint = Point3D.subtract(vertices[i],origin);

            double x = Math.cos(thetay)*vpoint.getX() + -1*Math.sin(thetay)*vpoint.getZ();
            double y = vpoint.getY();
            double z = Math.sin(thetay)*vpoint.getX() + Math.cos(thetay)*vpoint.getZ();


            Point3D np = Point3D.add(new Point3D(x,y,z),origin);

            vertices[i].setX(np.getX());
            vertices[i].setY(np.getY());
            vertices[i].setZ(np.getZ());

        }

    }



    public void scale(Point3D origin, double factor){

        for(int i=0;i<vertices.length;i++) {

            Point3D vpoint = Point3D.subtract(vertices[i], origin);

            double x = vpoint.getX()*factor;
            double y = vpoint.getY()*factor;
            double z = vpoint.getZ()*factor;

            Point3D np = Point3D.add(new Point3D(x,y,z),origin);

            vertices[i].setX(np.getX());
            vertices[i].setY(np.getY());
            vertices[i].setZ(np.getZ());

        }
    }



    public void draw_points(Graphics2D g2d, Dimension size){
        int half_width = size.width /2;
        int half_height = size.height /2;

        int r = get_point_size();
        Color c = get_color();

        for(Point3D point: vertices){
            if(point.gpoint != null){
                int x = (int) ((half_width*point.gpoint.getX()) + half_width);
                int y = (int) ((half_height*point.gpoint.getY()) + half_height);

                g2d.setColor(c);
                g2d.fillOval(x, y, r, r);
            }
        }
    }

    public void draw_connections(Graphics2D g2d, Dimension size){
        int half_width = size.width /2;
        int half_height = size.height /2;

        g2d.setStroke(new BasicStroke(5));
        g2d.setColor(point_color);

        for (Point3D point: vertices){

            if(point.gpoint != null && point.linked_points != null){

                for (Point3D lpoint: point.linked_points){

                    if (lpoint.gpoint != null){

                        int x = (int) ((half_width*point.gpoint.getX()) + half_width);
                        int y = (int) ((half_height*point.gpoint.getY()) + half_height);

                        int x2 = (int) ((half_width*lpoint.gpoint.getX()) + half_width);
                        int y2 = (int) ((half_height*lpoint.gpoint.getY()) + half_height);



                        g2d.drawLine(x, y, x2, y2);

                    }

                }

            }
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
