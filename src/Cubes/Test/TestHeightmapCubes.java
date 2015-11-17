/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Cubes.Test;


 
import java.util.logging.Level;
import java.util.logging.Logger;
import com.jme3.app.SimpleApplication;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.system.AppSettings;
import com.cubes.*;
import com.cubes.test.CubesTestAssets;
 
public class TestHeightmapCubes extends SimpleApplication{
 
    public static void main(String[] args){
        Logger.getLogger("").setLevel(Level.SEVERE);
       TestHeightmapCubes app = new TestHeightmapCubes();
        app.start();
    }
 
    public TestHeightmapCubes(){
        settings = new AppSettings(true);
        settings.setWidth(1280);
        settings.setHeight(720);
        settings.setTitle("Cubes Demo - Tutorial");
    }
 
    @Override
    public void simpleInitApp(){
        CubesTestAssets.registerBlocks();
 
        
        BlockTerrainControl blockTerrain = new BlockTerrainControl(CubesTestAssets.getSettings(this), new Vector3Int(1, 1, 1));
        
        blockTerrain.setBlocksFromHeightmap(new Vector3Int(0,0,0), new TestAlgorithum(null).setblocks(), CubesTestAssets.BLOCK_GRASS);
   
        //The terrain is a jME-Control, you can add it
        //to a node of the scenegraph to display it
        Node terrainNode = new Node();
        terrainNode.addControl(blockTerrain);
        rootNode.attachChild(terrainNode);
 
        cam.setLocation(new Vector3f(-10, 10, 16));
        cam.lookAtDirection(new Vector3f(1, -0.56f, -1), Vector3f.UNIT_Y);
        flyCam.setMoveSpeed(50);
    }
}