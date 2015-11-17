/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Cubes.Test;

import java.io.File;
import java.util.Random;

/**
 *
 * @author sawyera
 */
public interface Biome_Template {
    Random rand = new Random();
    
    public File Terrain();
    public int sizevarience();
    public int Size = rand.nextInt(1000);
    public SpawnMatrix Spawn();
}
