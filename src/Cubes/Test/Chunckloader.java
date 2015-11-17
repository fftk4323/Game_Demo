/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Cubes.Test;

import com.jme3.terrain.heightmap.HeightMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.vecmath.Point2d;
import javax.vecmath.Point3d;

/**
 *
 * @author sawyera
 */
public class Chunckloader {
    /*
     * At start generate List holding players current Height Map, This process is going to give the template for the edges to build a new height map.
     * 
     * @Varience
     * The class uses the current biome as a indicator to what height map type to generate. The generator will take into consideration, circular size determined by the biome class instance for each biome.
     */
    Worlddata data;
    public Chunckloader(HeightMap map, Worlddata world){
        this.data = world;
       List<Point3d> CurrentPlayerMap = new ArrayList<Point3d>();
    Point2d ChunckZero = new Point2d();
    int[][] mapstat;
    
    float[] HardData = null;
        
        int x =(int) ChunckZero.x;
        int y = (int) ChunckZero.y;
        int count =0;
        for(int mapx = 0; mapx< map.getSize(); mapx++){
             for(int mapy = 0; mapy< map.getSize(); mapy++){
                 CurrentPlayerMap.add(new Point3d(mapx,mapy,map.getHeightMap()[count]));
                 count++;
                 
             }
        }
    }
    public void build(){
        Random rand = new Random();
        int varience = rand.nextInt(data.Active_Biome().sizevarience());
        //go throught Algorithum to gen new points by the Active Biome
        //Save data to grid.
    }
}
