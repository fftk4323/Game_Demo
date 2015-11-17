/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.cubes.BlockTerrainControl;
import com.cubes.CubesSettings;
import com.cubes.Vector3Int;
import com.cubes.test.CubesTestAssets;
import com.jme3.app.SimpleApplication;
import com.jme3.scene.Node;

/**
 *
 * @author sawyera
 */
public class fromnoise extends SimpleApplication {

    @Override
    public void simpleInitApp() {
        //Create the block terrain (4x1x4 chunks)
   
BlockTerrainControl blockTerrain = new BlockTerrainControl(new CubesSettings(this), new Vector3Int(4, 1, 4));
 
//Specify location, size, roughness and the block class
//(The smaller the roughness, the flatter the generated terrain)
blockTerrain.setBlock(new Vector3Int(0, 0, 0), CubesTestAssets.BLOCK_WOOD);
blockTerrain.setBlocksFromNoise(new Vector3Int(0, 0, 0), new Vector3Int(64, 50, 64), 0.3f, CubesTestAssets.BLOCK_WOOD);
 
//Add the block terrain to a node
Node terrainNode = new Node();
terrainNode.addControl(blockTerrain);
rootNode.attachChild(terrainNode);
    }
       public static void main(String[] args) {
        fromnoise app = new fromnoise();
        app.start();
    }
}
