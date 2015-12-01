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

public class Treasure {
    //Atributos
    private String name;
    private int bonus;
    private TreasureKind type;
    
    //Métodos
    public Treasure(String n, int bonus, TreasureKind t) {
        this.name= n;
        this.bonus= bonus;
        this.type= t;
    }
    
    //Consultor name
    public String getName() {
        return this.name;
    }
    
    //Consultor bonus
    public int getBonus() {
        return this.bonus;
    }
    
    //Consultor type
    public TreasureKind getType() {
        return this.type;
    }
    
    @Override
    public String toString() {
        return "Nombre: " + this.name + ", Bonus: " + this.bonus + ", Tipo: " + this.type;
    }
}
