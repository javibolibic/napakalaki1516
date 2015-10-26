/*
********************************************************************
** Creado por Javier Bolívar Valverde <javibolivar@correo.ugr.es> **
** Programación y Diseño Orientado a Objetos                      **
** Grado en Ingeniería Informática                                **
********************************************************************
 */
package napakalaki;

public class Monster {
    private String name;
    private int combatLevel;
    
    private BadConsequence bc;
    private Prize prize;
    
    public Monster(String name, int level, BadConsequence bc, Prize price) {
        this.name = name;
        this.combatLevel = level;
        this.bc = bc;
        this.prize = price;
    }
    
    
    public String getName () {
        return this.name;
    }
    
    public int getCombatLevel () {
        return this.combatLevel;
    }
    
    @Override
    public String toString() {
        return "Nombre = " + this.name + "\nNivel de combate = " + Integer.toString(this.combatLevel);
    }
}
