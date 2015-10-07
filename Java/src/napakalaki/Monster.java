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
public class Monster {
    private String name;
    private int combatLevel;
    private BadConsequence bc;
    private Prize price;
    
    public String getName () {
        return this.name;
    }
    
    public int getCombatLevel () {
        return this.combatLevel;
    }
    
    public Monster(String name, int level, BadConsequence bc, Prize price) {
    
    }
}
