/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.cubes.Block;
import com.cubes.BlockTerrainControl;
import com.cubes.CubesSettings;
import com.cubes.Vector3Int;
import javax.vecmath.Point3d;

/**
 *
 * @author sawyera
 */
public class BlockPlace extends BlockTerrainControl{

    public BlockPlace(CubesSettings settings, Vector3Int chunksCount) {
        super(settings, chunksCount);
    }
    public void setBlock(Point3d location, Block block) {
        Vector3Int connvert = new Vector3Int((int) location.x,(int) location.y, (int) location.z);
        super.setBlock(connvert, block); //To change body of generated methods, choose Tools | Templates.
    }
    /*
     * will be for generating minerals and biomes
     */
    public void generatePlaces(Block block, Point3d location){
        
    }
    
    
}
