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
import java.util.Random;

public class Player {
    //Atributos
    static final int MAXLEVEL = 10;
    private String name;
    private int level;
    private boolean dead = true;
    private boolean canISteal = true;
    
    private Player enemy;
    private ArrayList<Treasure> hiddenTreasures;
    private ArrayList<Treasure> visibleTreasures;
    private BadConsequence pendingBadConsequence;
    
    //Métodos
    public Player(String name) {
        this.name = name;
        this.level = 1;
    }
    
    //Devuelve el nombre del jugador.
    public String getName() {
        return this.name;
    }
    
    //Devuelve la vida al jugador, modificando el atributo correspondiente.
    private void bringToLife() {
        this.dead = false;
    }
    
    //Devuelve el nivel de combate del jugador, que viene dado por su nivel más los bonus
    //que le proporcionan los tesoros que tenga equipados, según las reglas del juego
    private int getCombatLevel() {
        int combatlevel = this.level;
        for (Treasure t : visibleTreasures)
            combatlevel += t.getBonus();
        return combatlevel;
    }
    
    //Incrementa el nivel del jugador en i niveles, teniendo en cuenta las reglas del juego.
    private void incrementLevels(int i) {
        this.level += i;
    }
    
    //Decrementa el nivel del jugador en i niveles, teniendo en cuenta las reglas del juego.
    private void decrementLeveles(int i) {
        this.level -= i;
    }
    
    //Asigna el mal rollo al jugador, dándole valor a su atributo pendingBadConsequence.
    private void setPendingBadConsequence(BadConsequence b) {
        this.pendingBadConsequence = b;
    }
    
    private void applyPrize(Monster m) {
        
    }
    
    //Antes de cada combate, y antes de conocer el monstruo con el que se enfrentará, el jugador puede
    //equiparse los tesoros que desee siempre que cumpla las reglas sobre la cantidad y tipos de tesoros
    //que se pueden tener equipados. Equipar un tesoro implica quitarlo del conjunto de los ocultos y
    //pasarlo al de los equipados.
    private boolean canMakeTreasureVisible(Treasure t) {
        int ntreasuresonehand = 0;
        boolean treasurebothhands = false, output = false, mismotipo=false;
        if (this.visibleTreasures.size()<4){
            for(Treasure tesoro : this.visibleTreasures) {
                if (tesoro.getType() == TreasureKind.ONEHAND)
                    ntreasuresonehand++;
                else if (tesoro.getType() == TreasureKind.BOTHHANDS)
                    treasurebothhands = true;
                else if (t.getType() == tesoro.getType())     
                    mismotipo = true;
            }
            if (ntreasuresonehand < 3 && t.getType() == TreasureKind.ONEHAND)
                output = true;
            else if (ntreasuresonehand == 0 && treasurebothhands == true)
                output = true;
            else if (mismotipo == false)
                output = true;
        }
        
        return output;
    }
    
    //Devuelve el número de tesoros visibles de tipo tKind que tiene el jugador.
    private int howManyVisibleTreasures(TreasureKind tKind) {
        int counter = 0;
        for (Treasure treasure : this.visibleTreasures)
            if (treasure.getType() == tKind)
                counter++;
        return counter;
    }
    
    //Cambia el estado de jugador a muerto, modificando el correspondiente atributo.
    //Esto ocurre cuando el jugador, por algún motivo, ha perdido todos sus tesoros.
    private void dieIfNoTreasures() {
        if (hiddenTreasures.isEmpty() && visibleTreasures.isEmpty())
            this.dead = true;
    }
    
    //Devuelve true si el jugador está muerto, false en caso contrario.
    public boolean isDead() {
        return this.dead;
    }
    
    public ArrayList<Treasure> getHiddenTreasures() {
        return this.hiddenTreasures;
    }
    
    public ArrayList<Treasure> getVisibleTreasures() {
        return this.visibleTreasures;
    }
    
    public CombatResult combat(Monster m) {
        return null;
    }
    
    public void makeTreasureVisible(Treasure t) {
        
    }
    
    public void discardVisibleTreasure(Treasure t) {
        
    }
    
    public void discardHiddenTreasure(Treasure t) {
        
    }
    
    //Devuelve true cuando el jugador no tiene ningún mal rollo que cumplir y no tiene
    //más de 4 tesoros ocultos, y false en caso contrario.
    public boolean validState() {
        boolean v = false;
        if (this.pendingBadConsequence.isEmpty() && this.hiddenTreasures.size() <= 4)
            v = true;
        return v;
    }
    
    public void initTreasures() {
        
    }
    
    //Devuelve el nivel del jugador.
    public int getLevels() {
        return this.level;
    }
    
    public Treasure stealTreasure() {
        return null;
    }
    
    //Asigna valor al atributo que referencia al enemigo del jugador.
    public void setEnemy(Player enemy) {
        this.enemy = enemy;
    }
    
    //Devuelve un tesoro elegido al azar de entre los tesoros ocultos del jugador.
    private Treasure giveMeATreasure() {
        Random random = new Random();
        int index;
        index = random.nextInt(this.hiddenTreasures.size());
        return this.hiddenTreasures.get(index);
    }
    
    //Devuelve true si el jugador no ha robado ningún tesoro a su enemigo y false en
    //caso contrario.
    public boolean canISteal() {
        return this.canISteal;
    }
    
    //Devuelve true si el jugador tiene tesoros para ser robados por otro jugador y false
    //en caso contrario.
    private boolean canYouGiveMeATreasure() {
        boolean youcan = false;
        if (!this.hiddenTreasures.isEmpty() || !this.visibleTreasures.isEmpty())
            youcan = true;
        return youcan;
    }
    
    //Cambia el atributo canISteal a false cuando el jugador roba un tesoro.
    private void haveStolen() {
        this.canISteal = false;
    }
    
    public void discardAllTreasures() {
        
    }
}
