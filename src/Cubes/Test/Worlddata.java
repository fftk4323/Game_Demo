/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Cubes.Test;

/**
 * Holds data for Classes to use with out the need of going the base class or the need to store the data in multiple classes.
 *
 * @author sawyera
 */
public class Worlddata {
    int Tilesize;
    
    Player main_player = new Player();
    
    public Biome Active_Biome(){
        return null;
        
    
    }
    //Is the sphere around the player where events happen, smaller sphere much faster events, larger sphere slower events. Objects leaving sphere are subject to a world edit algorithum
    public void PlayerBubble(){
        
    }
    public void Weather(){
        
    }
    /**
     * is a class that is defined in the begining of the game and is unchanged at any point.
     * 
     */
    private void FortraseGen(){
        
    }
    public TerrainData getActiveMatrix(){
        return null;
    }
    public int getTileSize(){
        return Tilesize;
    }
    
    //place holder method to show how startup should look.
    
    public void onStart(){
        if(ActiveSides.values() != null) return;
        if(Localfile.terrain != null) return;
        generate();
        
    }
    public void shuffle(){
        
        for(int x = 1; (ActiveSides.values())[x-1] !=null && x-1 < ActiveSides.values().length; x++){
            main_player.Orinentation(x);
        }
    }
}
