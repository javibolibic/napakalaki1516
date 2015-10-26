/*
********************************************************************
** Creado por Javier Bolívar Valverde <javibolivar@correo.ugr.es> **
** Programación y Diseño Orientado a Objetos                      **
** Grado en Ingeniería Informática                                **
********************************************************************
*/
package napakalaki;

public class Prize {
    private int treasures;
    private int level;
    
    public Prize(int treasures, int level){
        this.treasures = treasures;
        this.level = level;
    }
    
    public int getTreasures() {
        return this.treasures;
    }
    
    public int getLevel() {
        return this.level;
    }
    
    @Override
    public String toString() {
        return "Tesoros ganados: " + Integer.toString(this.treasures) + "\nNiveles ganados: " + Integer.toString(this.level);
    }
}
