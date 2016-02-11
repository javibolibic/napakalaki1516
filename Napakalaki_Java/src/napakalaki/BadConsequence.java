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
    
    protected String text;
    protected int levels;
    
    //Constructor
    public BadConsequence(String t, int l) {
        this.text = t;
        this.levels = l;
    }
    
    //Métodos
    public String getText() {
        return this.text;
    }
    
    public int getLevels() {
        return this.levels;
    }
    
    public int getNVisibleTreasures() {
        return 0;
    }
    
    public int getNHiddenTreasures() {
        return 0;
    }
    
    public ArrayList<TreasureKind> getSpecificVisibleTreasures() {
        return null;
    }
    
    public ArrayList<TreasureKind> getSpecificHiddenTreasures() {
        return null;
    }
    
    public BadConsequence adjustToFitTreasureList(ArrayList<Treasure> v, ArrayList<Treasure> h) {
        return null;
    }
    
    public void substractVisibleTreasure(Treasure t) {
    }
    
    public void substractHiddenTreasure(Treasure t) {
    }
    
    public boolean isEmpty() {
        return true;
    }
    
    @Override
    public String toString() {
        String malrollo = "Mal rollo: \n" + "Nombre: " + this.text + "\n";
        if (this.levels != 0)
            malrollo += "Niveles perdidos: " + this.levels + "\n";
        
        return malrollo;
    }
}
