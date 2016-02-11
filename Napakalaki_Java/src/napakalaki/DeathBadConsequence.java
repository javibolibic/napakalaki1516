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

public class DeathBadConsequence extends NumericBadConsequence {
    //Atributos
    protected boolean death;
 
    //Métodos
    public DeathBadConsequence(String t, boolean death) {
        super(t, Player.MAXLEVEL, BadConsequence.MAXTREASURES, BadConsequence.MAXTREASURES);
        this.death = death;
    }

    public boolean getDeath() {
        return this.death;
    }
    
    @Override
    public String toString() {
        String malrollo = "Mal rollo de muerte: \n" + "Nombre: " + this.text + "\n";
        if (this.levels != 0)
            malrollo += "Niveles perdidos: " + this.levels + "\n";
        if(this.nVisibleTreasures != 0)
            malrollo += "Tesoros visibles perdidos: " + this.nVisibleTreasures + "\n";
        if(this.nHiddenTreasures != 0)
            malrollo += "Pérdida de tesoros ocultos: " + this.nHiddenTreasures + "\n";
        if(this.death == true)
            malrollo += "Estás muerto.\n";
    
        return malrollo;
    }
}
