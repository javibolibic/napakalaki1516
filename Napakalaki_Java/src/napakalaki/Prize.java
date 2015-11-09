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

public class Prize {
    //Atributos
    private int treasures;
    private int level;
    
    //Métodos
    public Prize(int t, int l){
        this.treasures = t;
        this.level = l;
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
