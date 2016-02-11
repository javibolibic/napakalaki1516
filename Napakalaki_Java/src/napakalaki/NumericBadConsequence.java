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

public class NumericBadConsequence extends BadConsequence {
    //Atributos
    protected int nVisibleTreasures, nHiddenTreasures;
    
    //Métodos
    public NumericBadConsequence(String t, int l, int nVisible, int nHidden) {
        super(t, l);
        this.nVisibleTreasures = nVisible;
        this.nHiddenTreasures = nHidden;
    }
    
    @Override
    public int getNVisibleTreasures() {
        return this.nVisibleTreasures;
    }
    
    @Override
    public int getNHiddenTreasures() {
        return this.nHiddenTreasures;
    }
    
    //Devuelve true cuando el mal rollo que tiene que cumplir el jugador está vacío, eso
    //significa que el conjunto de atributos del mal rollo indican que no hay mal rollo que
    //cumplir.
    @Override
    public boolean isEmpty() {
        boolean empty = false;
        if (this.nHiddenTreasures == 0 && this.nVisibleTreasures == 0)
            empty = true;
        return empty;
    }
    
    @Override
    public void substractVisibleTreasure(Treasure t) {
        if(this.nVisibleTreasures > 0)
            this.nVisibleTreasures--;
    }
    
    @Override
    public void substractHiddenTreasure(Treasure t) {
        if(this.nHiddenTreasures > 0)
            this.nHiddenTreasures--;
    }
    
    @Override
    public BadConsequence adjustToFitTreasureList(ArrayList<Treasure> v, ArrayList<Treasure> h) {
        int nV = (v.size() >= nVisibleTreasures ? nVisibleTreasures : v.size());
        int nH = (h.size() >= nHiddenTreasures ? nHiddenTreasures : h.size());
        BadConsequence bC = new NumericBadConsequence(this.text, this.levels, nV, nH);
        
        return bC;
    }
    
    @Override
    public String toString() {
        String malrollo = "Mal rollo numérico: \n" + "Nombre: " + this.text + "\n";
        if (this.levels != 0)
            malrollo += "Niveles perdidos: " + this.levels + "\n";
        if(this.nVisibleTreasures != 0)
            malrollo += "Tesoros visibles perdidos: " + this.nVisibleTreasures + "\n";
        if(this.nHiddenTreasures != 0)
            malrollo += "Tesoros ocultos perdidos: " + this.nHiddenTreasures + "\n";
    
        return malrollo;
    }
}
