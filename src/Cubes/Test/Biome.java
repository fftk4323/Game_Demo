/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Cubes.Test;

import java.io.File;

/**
 *
 * @author sawyera
 */
public class Biome implements Biome_Template{
    double TerrainVarience;
    public File Terrain() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public double sizevarience(double varience) {
        this.TerrainVarience = varience;
        return this.TerrainVarience;
    }

    public SpawnMatrix Spawn() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int sizevarience() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
