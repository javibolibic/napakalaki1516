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

public class SpecificBadConsequence extends BadConsequence {
    //Atributos
    protected ArrayList<TreasureKind> specificHiddenTreasures = new ArrayList();
    protected ArrayList<TreasureKind> specificVisibleTreasures = new ArrayList();
    
    //Métodos
    public SpecificBadConsequence(String t, int l, ArrayList<TreasureKind> v, ArrayList<TreasureKind> h) {
        super(t, l);
        this.specificVisibleTreasures = v;
        this.specificHiddenTreasures = h;
    }
    
    @Override
    public ArrayList<TreasureKind> getSpecificVisibleTreasures() {
        return this.specificVisibleTreasures;
    }
    
    @Override
    public ArrayList<TreasureKind> getSpecificHiddenTreasures() {
        return this.specificHiddenTreasures;
    }
    
    //Devuelve true cuando el mal rollo que tiene que cumplir el jugador está vacío, eso
    //significa que el conjunto de atributos del mal rollo indican que no hay mal rollo que
    //cumplir.
    @Override
    public boolean isEmpty() {
        boolean empty = false;
        if (this.specificHiddenTreasures.isEmpty() && this.specificVisibleTreasures.isEmpty())
            empty = true;
        return empty;
    }
    
    @Override
    public void substractVisibleTreasure(Treasure t) {
        if(!this.specificVisibleTreasures.isEmpty())
            this.specificVisibleTreasures.remove(t.getType());
    }
    
    @Override
    public void substractHiddenTreasure(Treasure t) {
        if(!this.specificHiddenTreasures.isEmpty())
            this.specificHiddenTreasures.remove(t.getType());
    }
    
    @Override
    public BadConsequence adjustToFitTreasureList(ArrayList<Treasure> v, ArrayList<Treasure> h) {
        String t = this.text;
        int l = this.levels;
        ArrayList<TreasureKind> resultSpecificVisibleTreasures = new ArrayList();
        ArrayList<TreasureKind> resultSpecificHiddenTreasures = new ArrayList();
        BadConsequence bC;
        
        if(!this.specificVisibleTreasures.isEmpty() || !this.specificHiddenTreasures.isEmpty()) {
            for(TreasureKind mVTreasure : this.specificVisibleTreasures) {
                if(v.contains(mVTreasure))
                    resultSpecificVisibleTreasures.add(mVTreasure);
            }
            for(TreasureKind mHTreasure : this.specificHiddenTreasures) {
                if(h.contains(mHTreasure))
                    resultSpecificHiddenTreasures.add(mHTreasure);
            }
            bC = new SpecificBadConsequence(t, l, resultSpecificVisibleTreasures, resultSpecificHiddenTreasures);
        }
        else
            bC = new SpecificBadConsequence(t, l, new ArrayList(), new ArrayList());
        
        return bC;
    }
    
    @Override
    public String toString() {
        String malrollo = "Mal rollo específico: \n" + "Nombre: " + this.text + "\n";
        if (this.levels != 0)
            malrollo += "Niveles perdidos: " + this.levels + "\n";
        if(!this.specificVisibleTreasures.isEmpty())
            malrollo += "Tesoros visibles perdidos: " + this.specificVisibleTreasures.toString() + "\n";
        if(!this.specificHiddenTreasures.isEmpty())
            malrollo += "Tesoros ocultos perdidos: " + this.specificHiddenTreasures.toString() + "\n";
    
        return malrollo;
    }
}
