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

public class CardDealer {
    //Atributos
    private static final CardDealer instance= new CardDealer();
    
    private ArrayList<Monster> usedMonsters;
    private ArrayList<Monster> unusedMonsters;
    private ArrayList<Treasure> usedTreasures;
    private ArrayList<Treasure> unusedTreasures;
    
    //Métodos
    private CardDealer(){
        this.usedMonsters = new ArrayList();
        this.unusedMonsters = new ArrayList();
        this.usedTreasures = new ArrayList();
        this.unusedTreasures = new ArrayList();
    }
    
    private void initTreasureCardDeck() {
        
    }
    
    private void initMonsterCardDeck() {
    
    }
    
    private void shuffleTreasures() {
        
    }
    
    private void shuffleMonsters() {
    
    }
    
    public static CardDealer getInstance() {
        return instance;
    }
    
    public Treasure nextTreasure() {
    
    }
    
    public Monster nextMonster() {
    
    }
    
    public void giveTreasureBack(Treasure t) {
    
    }
    
    public void giveMonsterBack(Monster m) {
        
    }
    
    public void initCards() {
        
    }
}
