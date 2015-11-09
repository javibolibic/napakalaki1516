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


public class Napakalaki {
    //Atributos
    private static final Napakalaki instance = new Napakalaki();
    private Monster currentMonster;
    private CardDealer dealer;
    private ArrayList<Player> players;
    private Player currentPlayer;
    
    //Métodos
    private Napakalaki(){
    
    }
    
    public static Napakalaki getInstance() {
        return instance;
    }
    
    private void initPlayers(ArrayList<String> names) {
        
    }
    
    private Player nextPlayer() {
        
    }
    
    private boolean nextTurnAllowed() {
        
    }
    
    private void setEnemies(){
        
    }
    
    public CombatResult developCombat() {
        
    }
    
    public void discardVisibleTreasures(ArrayList<Treasure> treasures) {
    
    }
    
    public void discardHiddenTreasures(ArrayList<Treasure> treasures) {
    
    }
    
    public void makeTreasuresVisible(ArrayList<Treasure> treasures) {
        
    }
    
    public void initGame(ArrayList<String> players) {
    
    }
    
    public Player getCurrentPlayer() {
        
    }
    
    public Monster getCurrentMonster() {
        
    }
    
    public boolean nextTurn() {
        
    }
    
    public boolean endOfGame(CombatResult result) {
        
    }
}
