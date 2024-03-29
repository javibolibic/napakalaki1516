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

public class Monster {
    //Atributos
    private String name;
    private int combatLevel;
    
    private BadConsequence badConsequence;
    private Prize prize;
    
    private int levelChangeAgainstCultistPlayer;
    
    //Constructores
    public Monster(String n, int l, BadConsequence b, Prize p) {
        this.name = n;
        this.combatLevel = l;
        this.badConsequence = b;
        this.prize = p;
        this.levelChangeAgainstCultistPlayer = 0;
    }
    
    public Monster(String n, int l, BadConsequence badConsequence, Prize p, int lC) {
        this.name = n;
        this.combatLevel = l;
        this.badConsequence = badConsequence;
        this.prize = p;
        this.levelChangeAgainstCultistPlayer = lC;
    }
    
    //Métodos
    public String getName () {
        return this.name;
    }
    
    public int getCombatLevel () {
        return this.combatLevel;
    }
    
    public BadConsequence getBadConsequence() {
        return this.badConsequence;
    }
    
    //Devuelve el número de niveles ganados proporcionados por su buen rollo.
    public int getLevelsGained() {
        return this.prize.getLevel();
    }
    
    //Devuelve el número de tesoros ganados proporcionados por su buen rollo.
    public int getTreasuresGained() {
        return this.prize.getTreasures();
    }

    public int getCombatLevelAgainstCultistPlayer() {
        return this.getCombatLevel() + this.levelChangeAgainstCultistPlayer;
    }
    
    
    
    @Override
    public String toString() {
        return "Nombre = " + this.name + "\nNivel de combate = " + Integer.toString(this.combatLevel);
    }
}
