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
    private int levels, nVisibleTreasures, nHiddenTreasures;
    private boolean death;
    private ArrayList<TreasureKind> specificHiddenTreasures = new ArrayList();
    private ArrayList<TreasureKind> specificVisibleTreasures = new ArrayList();
    
    public BadConsequence(String text, int levels, int nVisible, int nHidden) {
        this.text=text;
        this.levels=levels;
        this.nVisibleTreasures=nVisible;
        this.nHiddenTreasures=nHidden;
    }
    
    public BadConsequence(String text, boolean death) {
        this.text=text;
        this.death=death;
    }
    
    public BadConsequence(String text, int levels, ArrayList<TreasureKind> tVisible, ArrayList<TreasureKind> tHidden) {
        this.text=text;
        this.levels=levels;
        this.specificVisibleTreasures=tVisible;
        this.specificHiddenTreasures=tHidden;
    }
    
    public String getText() {
        return this.text;
    }
    
    public int getLevels() {
        return this.levels;
    }
    
    public int getNVisibleTreasures() {
        return this.nVisibleTreasures;
    }
    
    public int getNHiddenTreasures() {
        return this.nHiddenTreasures;
    }
    
    public ArrayList<TreasureKind> getSpecificVisibleTreasures() {
        return this.specificVisibleTreasures;
    }
    
    public ArrayList<TreasureKind> getSpecificHiddenTreasures() {
        return this.specificHiddenTreasures;
    }
    
    public boolean getDeath() {
        return this.death;
    }
    
    @Override
    public String toString() {
        return "Mal rollo: " + this.text + "\nNiveles: " + Integer.toString(this.levels) + "\nMuerte: " + Boolean.toString(this.death);
    }
}