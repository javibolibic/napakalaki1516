/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 *
 * @author jnb
 */
public class Prize {
    private int treasures;
    private int level;
    
    public Prize(int treasures, int level){
        
    }
    
    public int getTreasures() {
        return this.treasures;
    }
    
    public int getLevel() {
        return this.level;
    }
    
    @Override
    public String toString() {
        return "Tesoros = " + Integer.toString(this.treasures) + " Niveles = " + Integer.toString(this.level);
    }
}
