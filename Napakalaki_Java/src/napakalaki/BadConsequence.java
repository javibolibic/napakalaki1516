/*
********************************************************************
**       _   _                   _         _       _    _         **
**      | \ | | __ _ _ __   __ _| | ____ _| | __ _| | _(_)        **
**      |  \| |/ _` | '_ \ / _` | |/ / _` | |/ _` | |/ / |        **
**      | |\  | (_| | |_) | (_| |   < (_| | | (_| |   <| |        **
**      |_| \_|\__,_| .__/ \__,_|_|\_\__,_|_|\__,_|_|\_\_|        **
**                  |_|                                           **
** Creado por Javier Bolívar Valverde <javibolivar@correo.ugr.es> **
** Programación y Diseño Orientado a Objetos                      **
** Grado en Ingeniería Informática (Universidad de Granada)       **
********************************************************************
*/
package napakalaki;

import java.util.ArrayList;

public class BadConsequence {
    //Atributos
    static final int MAXTREASURES = 10;
    
    private String text;
    private int levels, nVisibleTreasures, nHiddenTreasures;
    private boolean death;
    
    private ArrayList<TreasureKind> specificHiddenTreasures = new ArrayList();
    private ArrayList<TreasureKind> specificVisibleTreasures = new ArrayList();
    
    //Métodos
    public BadConsequence(String t, int l, int nVisible, int nHidden) {
        this.text = t;
        this.levels = l;
        this.nVisibleTreasures = nVisible;
        this.nHiddenTreasures = nHidden;
    }
    
    public BadConsequence(String t, boolean death) {
        this.text = t;
        this.death = death;
    }
    
    public BadConsequence(String t, int l, ArrayList<TreasureKind> v, ArrayList<TreasureKind> h) {
        this.text = t;
        this.levels = l;
        this.specificVisibleTreasures = v;
        this.specificHiddenTreasures = h;
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
    
    //Devuelve true cuando el mal rollo que tiene que cumplir el jugador está vacío, eso
    //significa que el conjunto de atributos del mal rollo indican que no hay mal rollo que
    //cumplir.
    public boolean isEmpty() {
        boolean empty = false;
        if (specificHiddenTreasures.isEmpty() && specificVisibleTreasures.isEmpty() && nHiddenTreasures == 0 && nVisibleTreasures == 0)
            empty = true;
        return empty;
    }
    
    public void substractVisibleTreasure(Treasure t) {
        //¿Es esto lo que hay que hacer?
        if (t.getType() == null) {
            if (t.getBonus() != 0)
                this.nVisibleTreasures--;
        }
        else {
            this.specificVisibleTreasures.remove(t.getType());
        }
    }
    
    public void substractHiddenTreasure(Treasure t) {
        //¿Es esto lo que hay que hacer?
        if (t.getType() == null) {
            if (t.getBonus() != 0) {
                this.nHiddenTreasures--;
            }
        }
        else {
            this.specificHiddenTreasures.remove(t.getType());
        }
    }
    
    public BadConsequence adjustToFitTreasureList(ArrayList<Treasure> v, ArrayList<Treasure> h) {
        String t = this.text;
        int l = this.levels, resultNVisibleTreasures = 0, resultNHiddenTreasures = 0;
        ArrayList<Treasure> pV = v, pH = h;
        ArrayList<TreasureKind> resultSpecificVisibleTreasures = new ArrayList(), resultSpecificHiddenTreasures = new ArrayList();
        BadConsequence badConsequence;
        
        
        if(this.nVisibleTreasures > 0 || this.nHiddenTreasures > 0) {
            resultNVisibleTreasures = (pV.size() - this.nVisibleTreasures) % pH.size();
            resultNHiddenTreasures = (pH.size() - this.nHiddenTreasures) % pH.size();
            badConsequence = new BadConsequence(t, l, resultNVisibleTreasures, resultNHiddenTreasures);
        }
        else if(!this.specificVisibleTreasures.isEmpty() || !this.specificHiddenTreasures.isEmpty()) {
            for(TreasureKind mVTreasure : this.specificVisibleTreasures) {
                for(Treasure pVTreasure : pV) {
                    if(mVTreasure == pVTreasure.getType()) {
                        resultSpecificVisibleTreasures.add(mVTreasure);
                        pV.remove(pVTreasure);
                        break;
                    }
                }
            }
            
            for(TreasureKind mHTreasure : this.specificHiddenTreasures) {
                for(Treasure pHTreasure : pH) {
                    if(mHTreasure == pHTreasure.getType()) {
                        resultSpecificHiddenTreasures.add(mHTreasure);
                        pH.remove(pHTreasure);
                        break;
                    }
                }
            }
            
            badConsequence = new BadConsequence(t, l, resultSpecificVisibleTreasures, resultSpecificHiddenTreasures);
        }
        
        else {
            badConsequence = new BadConsequence(t, l, 0, 0);
        }
        
        return badConsequence;
    }
}
