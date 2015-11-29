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


public class Napakalaki {
    //Atributos
    private static final Napakalaki instance = null;
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
        this.players = new ArrayList();
        for(String name : names) {
            Player playeract = new Player(name);
            this.players.add(playeract);
        }
        nextPlayer(); //Para rellenar currentPlayer
    }
    
    private Player nextPlayer() {
        int tamplayers = this.players.size();
        int indice; //Índice del siguiente jugador.
        //Si no hay un jugador actual, es la primera jugada.
        if (this.currentPlayer == null) {
            Random random = new Random();
            //Aleatorio = número entre 0 y (tamplayers - 1)
            indice = random.nextInt(tamplayers);
        }
        else {
            indice = this.players.indexOf(this.currentPlayer);
            //Aplicamos el índice módulo tamplayers para que se limite al array de jugadores que tenemos.
            indice = (indice + 1) % tamplayers;
        }
        
        return this.players.get(indice);
    }
    
    private boolean nextTurnAllowed() {
        boolean allow = false;
        
        //Si es la primera jugada, también se permite el turno.
        if (this.currentPlayer == null || this.currentPlayer.validState())
            allow = true;
        return allow;
    }
    
    private void setEnemies(){
        int tamplayers = this.players.size();
        Random random = new Random();
        Player enemy, playeract;
        //Recorremos todo el ArrayList
        for (Player player : this.players) {
            int i = this.players.indexOf(player);
            int j;
            do {
                //j= número aleatorio entre 0 y tamaño de players(excluido)
                j = random.nextInt(this.players.size());
            }while(j==i); //Comprueba que el jugador actual no sea el mismo que su enemigo.
            
            this.players.get(i).setEnemy(this.players.get(j));
        }
    }
    
    public CombatResult developCombat() {
        Monster m = this.currentMonster;
        CombatResult combatResult = this.currentPlayer.combat(m);
        this.dealer.giveMonsterBack(m);
        
        
        return combatResult;
    }
    
    public void discardVisibleTreasures(ArrayList<Treasure> treasures) {
        for(Treasure treasure : treasures) {
            this.currentPlayer.discardVisibleTreasure(treasure);
            this.dealer.giveTreasureBack(treasure);
        }
    }
    
    public void discardHiddenTreasures(ArrayList<Treasure> treasures) {
        for(Treasure treasure : treasures) {
            this.currentPlayer.discardHiddenTreasure(treasure);
            this.dealer.giveTreasureBack(treasure);
        }
    }
    
    public void makeTreasuresVisible(ArrayList<Treasure> treasures) {
        
    }
    
    public void initGame(ArrayList<String> players) {
        this.initPlayers(players);
        this.setEnemies();
        this.dealer.initCards();
        this.nextTurn();
    }
    
    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }
    
    public Monster getCurrentMonster() {
        return this.currentMonster;
    }
    
    public boolean nextTurn() {
        boolean stateOK = this.nextTurnAllowed();
        if(stateOK) {
            this.currentMonster = this.dealer.nextMonster();
            this.currentPlayer = this.nextPlayer();
            boolean dead = this.currentPlayer.isDead();
            if(dead){
                this.currentPlayer.initTreasures();
            }
        }
        
        return stateOK;
    }
    
    //Compara result con el valor WINGAME del enumerado
    //Devuelve true si result == WINGAME, false en caso contrario
    public boolean endOfGame(CombatResult result) {
        return result == CombatResult.WINGAME;
    }
}
