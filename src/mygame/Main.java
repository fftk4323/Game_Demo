package mygame;

import com.cubes.BlockTerrainControl;
import com.cubes.Vector3Int;
import com.cubes.test.CubesTestAssets;
import com.jme3.app.SimpleApplication;
import com.jme3.bullet.control.CharacterControl;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.renderer.Camera;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;
import com.jme3.terrain.geomipmap.TerrainGrid;
import com.jme3.terrain.geomipmap.TerrainLodControl;
import com.jme3.terrain.geomipmap.TerrainQuad;
import com.jme3.terrain.geomipmap.grid.FractalTileLoader;
import com.jme3.terrain.heightmap.AbstractHeightMap;
import com.jme3.terrain.heightmap.HeightMap;
import com.jme3.terrain.heightmap.HillHeightMap;
import com.jme3.terrain.noise.basis.FilteredBasis;
import com.jme3.terrain.noise.filter.IterativeFilter;
import com.jme3.terrain.noise.filter.OptimizedErode;
import com.jme3.terrain.noise.filter.PerturbFilter;
import com.jme3.terrain.noise.filter.SmoothFilter;
import com.jme3.terrain.noise.fractal.FractalSum;
import java.util.ArrayList;
import java.util.List;


/**
 * test
 * @author normenhansen
 */
public class Main extends SimpleApplication {
 private TerrainGrid terrain;
 
 private CharacterControl player3;
    private FractalSum base;
    private PerturbFilter perturb;
    private OptimizedErode therm;
    private SmoothFilter smooth;
    private IterativeFilter iterate;
    private Material material;
    private Material matWire;
    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

    @Override
    public void simpleInitApp() {
         FilteredBasis ground = new FilteredBasis(this.base);

        this.perturb = new PerturbFilter();
        this.perturb.setMagnitude(0.119f);

        this.therm = new OptimizedErode();
        this.therm.setRadius(5);
        this.therm.setTalus(0.011f);

        this.smooth = new SmoothFilter();
        this.smooth.setRadius(1);
        this.smooth.setEffect(0.7f);

        this.iterate = new IterativeFilter();
        this.iterate.addPreFilter(this.perturb);
        this.iterate.addPostFilter(this.smooth);
        this.iterate.setFilter(this.therm);
        this.iterate.setIterations(1);

        ground.addPreFilter(this.iterate);
       //Create the block terrain (7x1x7 chunks)
BlockTerrainControl blockTerrain = new BlockTerrainControl(null, new Vector3Int(7, 1, 7));

 this.terrain = new TerrainGrid("terrain", 33, 257, new FractalTileLoader(ground, 256));
//Specify location, heightmap filepath, maximum height and the block class
//(See the heightmap at the right)

 
//Add the block terrain to a node
Node terrainNode = new Node();
terrainNode.addControl(blockTerrain);
rootNode.attachChild(terrainNode);

    }
    public HeightMap heightmap() throws Exception{
        AbstractHeightMap heightmap = null;
heightmap = new HillHeightMap(1025, 1000, 50, 100, (byte) 3);

TerrainQuad terrain = new TerrainQuad("terrain", 65, 513, heightmap.getHeightMap());
terrain.setLocalScale(2f, 1f, 2f); // scale to make it less steep
List<Camera> cameras = new ArrayList<Camera>();
cameras.add(getCamera());
TerrainLodControl control = new TerrainLodControl(terrain, cameras);
terrain.addControl(control);
return heightmap;

    }

    @Override
    public void simpleUpdate(float tpf) {
        //TODO: add update code
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}
