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
** Grado en Ingeniería Informática                                **
********************************************************************
*/
package napakalaki;

import java.util.ArrayList;

public class Player {
    //Atributos
    static final int MAXLEVEL = 10;
    private String name;
    private boolean dead = true;
    private boolean canISteal = true;
    
    private Player enemy;
    private ArrayList<Treasure> hiddenTreasures;
    private ArrayList<Treasure> visibleTreasures;
    private BadConsequence pendingBadConsequence;
    
    //Métodos
    public Player(String name) {
    
    }
    
    public String getName() {
        return this.name;
    }
    
    private void bringToLife() {
        
    }
    
    private int getCombatLevel() {
        
    }
    
    private void incrementLevels(int l) {
    
    }
    
    private void decrementLeveles(int l) {
        
    }
    
    private void setPendingBadConsequence(BadConsequence b) {
        
    }
    
    private void applyPrize(Monster m) {
        
    }
    
    private boolean canMakeTreasureVisible(Treasure t) {
        
    }
    
    private int howManyVisibleTreasures(TreasureKind tKind) {
        
    }
    
    private void dieIfNoTreasures() {
        
    }
    
    public boolean isDead() {
        
    }
    
    public ArrayList<Treasure> getHiddenTreasures() {
        return this.hiddenTreasures;
    }
    
    public ArrayList<Treasure> getVisibleTreasures() {
        return this.visibleTreasures;
    }
    
    public CombatResult combat(Monster m) {
        
    }
    
    public void makeTreasureVisible(Treasure t) {
        
    }
    
    public void discardVisibleTreasure(Treasure t) {
        
    }
    
    public void discardHiddenTreasure(Treasure t) {
        
    }
    
    public boolean validState() {
        
    }
    
    public void initTreasures() {
        
    }
    
    public int getLevels() {
        return this.pendingBadConsequence.getLevels();
    }
    
    public Treasure stealTreasure() {
        
    }
    
    public void setEnemy(Player enemy) {
        
    }
    
    private Treasure giveMeATreasure() {
        
    }
    
    public boolean canISteal() {
        
    }
    
    private boolean canYouGiveMeATreasure() {
        
    }
    
    private void haveStolen() {
        
    }
    
    public void discardAllTreasures() {
        
    }
}
