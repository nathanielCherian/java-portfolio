package world.objects;

import java.util.ArrayList;

public class Grid extends Shape{


    public Grid(int x, int y, int z) {
        super(x, y, z);


        ArrayList<Point3D> vers = new ArrayList<>();


        for(int i =1; i < 8; i++){
            for(int j=-8;j<8;j++){
                vers.add(new Point3D(i, j, -1));
            }
        }


        this.vertices = vers.toArray(new Point3D[vers.size()]);


        setPoint_size(5);
    }
}
