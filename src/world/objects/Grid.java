package world.objects;

import java.util.ArrayList;

public class Grid extends Shape{

    public Point3D[] vertices;

    public Grid(int x, int y, int z) {
        super(x, y, z);


        ArrayList<Point3D> vers = new ArrayList<>();


        for(int i =1; i < 6; i++){
            for(int j=-8;j<8;j++){
                vers.add(new Point3D(i, j, -1));
            }
        }

        /*
        for(int i =0; i < 5; i++){
            vers.add(new Point3D(3,i-2,-1));
        }

        for(int i =0; i < 5; i++){
            vers.add(new Point3D(7,i-2,-1));
        }

        for(int i =0; i < 5; i++){
            vers.add(new Point3D(11,i-2,-1));
        } */


        this.vertices = vers.toArray(new Point3D[vers.size()]);

    }
}
