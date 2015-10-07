/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;

/**
 *
 * @author jnb
 */
public class BadConsequence {
    private String text;
    private int levels;
    private int nVisibleTreasures;
    private int nHiddenTreasures;
    private boolean death;
    private ArrayList<TreasureKind> specificHiddenTreasures = new ArrayList();
    private ArrayList<TreasureKind> specificVisibleTreasures = new ArrayList();
    
    public BadConsequence (String text, int levels, int nVisible, int nHidden) {
        
    }
    
    public BadConsequence (String text, boolean death) {
        
    }
    
    public BadConsequence(String text, int levels, ArrayList<TreasureKind> tVisible, ArrayList<TreasureKind> tHidden) {
    
    }
    
    public String getText () {
        return this.text;
    }
    
    public int getLevels () {
        return this.levels;
    }
    
    public int getNVisibleTreasures () {
        return this.nVisibleTreasures;
    }
    
    public int getNHiddenTreasures () {
        return this.nHiddenTreasures;
    }
    
    public boolean getDeath () {
        return this.death;
    }
}
