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

public class Dice {
    private static final Dice instance = null;
    
    private Dice() {
        
    }
    
    public static Dice getInstance() {
        return instance;
    }
    
    //Genera un número aleatorio entre 1 y 6 (ambos incluidos).
    public int nextNumber() {
        Random random = new Random();
        
        //El método nextInt excluye al 6, lo que nos devolverá un número entre 0 y 5, por eso se suma 1.
        return random.nextInt(6) +1;
    }
}
