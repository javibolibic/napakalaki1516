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

import java.util.Random;


public class CultistPlayer extends Player{
    private static int totalCultistPlayers = 0;
    private Cultist myCultistCard;

    public CultistPlayer(Player p, Cultist c) {
        super(p);
        this.myCultistCard = c;
        totalCultistPlayers++;
    }
    
    @Override
    protected int getCombatLevel() {
        int total = (int)(super.getCombatLevel() * 1.2) + (this.myCultistCard.getGainedLevels() + CultistPlayer.totalCultistPlayers);
        return total;
    }
    
    @Override
    protected int getOponentLevel(Monster m) {
        return m.getCombatLevelAgainstCultistPlayer();
    }
    
    @Override
    protected boolean shouldConvert() {
        return false;
    }
    
    private Treasure giveMeATreasure() {
        Random random = new Random();
        int index = random.nextInt(this.visibleTreasures.size());
        return this.visibleTreasures.get(index);
    }
    
    private boolean canYouGiveMeATreasure() {
        boolean youcan = true;
        if (this.visibleTreasures.isEmpty())
            youcan = false;
        return youcan;
    }
    
    public int getTotalCultistPlayers() {
        return totalCultistPlayers;
    }
}
