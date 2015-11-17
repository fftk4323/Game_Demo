/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Cubes.Test;

import com.cubes.BlockTerrainControl;
import com.cubes.CubesSettings;
import com.cubes.Vector3Int;
import com.cubes.test.CubesTestAssets;
import com.jme3.app.SimpleApplication;
import com.jme3.math.Vector3f;
import com.jme3.terrain.heightmap.HeightMap;
import com.jme3.terrain.heightmap.HillHeightMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.vecmath.Point2d;
import javax.vecmath.Point3d;

    
 
/**
 *
 * @author sawyera
 */
public class TestAlgorithum 
{
    /* Loads Per chunck used as chunckZero(x,z)
     * uses Height map as a template as TestAlgorithum(heightmap, chunckZero)
     */
 
    List<Point3d> height = new ArrayList<Point3d>();
    Point2d ChunckZero = new Point2d();
    int[][] mapstat;
    
    float[] HardData = null;
    public TestAlgorithum(HeightMap map){
        
        int x =(int) ChunckZero.x;
        int y = (int) ChunckZero.y;
        if(map ==null)map = test();
        int count =0;
        for(int mapx = 0; mapx< map.getSize(); mapx++){
             for(int mapy = 0; mapy< map.getSize(); mapy++){
                 height.add(new Point3d(mapx,mapy,map.getHeightMap()[count]));
                 count++;
                 
             }
        }
        converttomapstat();
    }
    //Returning Index out of Bounds.... Find Error
        public TestAlgorithum(float[] actual, boolean structor){
           
            if(structor)return;
       HardData = actual;
        int x =(int) ChunckZero.x;
        int y = (int) ChunckZero.y;
        int count =0;
        for(int mapx = 0; mapx< HardData.length; mapx++){
             for(int mapy = 0; mapy< HardData.length; mapy++){
                 height.add(new Point3d(mapx,mapy,actual[count]));
                 count++;
                 
             }
        }
        converttomapstat();
        }
        public void converttomapstat(){
            for(int points = 0; points < height.size(); points++){
                mapstat[(int)height.get(points).x][(int)height.get(points).z] =(int) height.get(points).y;
            }
        }
       
        
       public int[][] setblocks(){
           
        return mapstat;
    }
    public int heightfromtopatpoint(int x, int z){
        return mapstat[x][z];
    }
    
    public HeightMap test(){
        HillHeightMap heightmap = null;
HillHeightMap.NORMALIZE_RANGE = 100; // optional
System.out.print("Possible error:");
try {
    heightmap = new HillHeightMap(512, 30, 20, 50, (byte) 3); // byte 3 is a random seed
} catch (Exception ex) {
    System.err.print("Error at Generating Heightmap " + ex);
}
        return heightmap;
                
    }
    }    
 

