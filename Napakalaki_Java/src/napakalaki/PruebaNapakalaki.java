/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author jnb
 */
public class PruebaNapakalaki {

    /**
     * @param args the command line arguments
     */
    
    public ArrayList<Monster> lvlExceeding10(ArrayList<Monster> monstruos){
        ArrayList<Monster> monsters = new ArrayList();
        for(Monster monstruo : monstruos){
            if(monstruo.getCombatLevel()>10)
                monsters.add(monstruo);
        }
        return monsters;
    }
    
    public ArrayList<Monster> lossLevel(ArrayList<Monster> monstruos, BadConsequence bc){ //Devuelve los monstruos cuyo mal rollo implique sólo pérdida de niveles.
        ArrayList<Monster> monsters = new ArrayList();
        for(Monster monstruo : monstruos){
            if(bc.getLevels()!=0) //Ahora mismo sólo comprueba que se pierden niveles, pero no comprueba otros parámetros. ¿Es correcto?
                monsters.add(monstruo);
        }
        return monsters;
    }
    
    public ArrayList<Monster> prizeIsUpper1(ArrayList<Monster> monstruos, Prize prize){ //Devuelve los monstruos cuyo buen rollo indica ganancia de niveles superior a 1
        ArrayList<Monster> monsters = new ArrayList();
        for(Monster monstruo : monstruos){
            if(prize.getLevel()>1)
                monsters.add(monstruo);
        }
        return monsters;
    }
    
    public ArrayList<Monster> anyBC(ArrayList<Monster> monstruos, BadConsequence bc){ //Devuelve los monstruos cuyo mal rollo supone la pérdida de algún tipo determinado de tesoros
        ArrayList<Monster> monsters = new ArrayList();
        for(Monster monstruo : monstruos){
            if(bc.getSpecificHiddenTreasures()!=null || bc.getSpecificVisibleTreasures()!=null)
                monsters.add(monstruo);
        }
        return monsters;
    }
    
    public static void main(String[] args) {
        ArrayList<Monster> monstruos = new ArrayList();
        Prize prize; //Parámetros: tesoros, niveles
        BadConsequence badConsequence; //Parámetros: texto, niveles, visible, oculto
        
        //Monstruo 1: 3 Byakhees de bonanza
        badConsequence = new BadConsequence("Pierdes tu armadura visible y otra oculta", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        prize = new Prize(2,1);
        monstruos.add(new Monster("3 Byakhees de bonanza", 8, badConsequence, prize));
        
        //Monstruo 2: Chibithulhu
        badConsequence = new BadConsequence("Embobados con el lindo primigenio te descartas de tu casco visible.", 0, new ArrayList(Arrays.asList(TreasureKind.HELMET)), null);
        prize = new Prize(1, 1);
        monstruos.add(new Monster("Chibithulhu", 2, badConsequence, prize));
        
        //Monstruo 3: El sopor de Dunwich
        badConsequence = new BadConsequence("El primordial bostezo contagioso. Pierdes el calzado visible.", 0, new ArrayList(Arrays.asList(TreasureKind.SHOES)), null);
        prize = new Prize(1, 1);
        monstruos.add(new Monster("El sopor de Dunwich", 2, badConsequence, prize));
        
        //Monstruo 4: Ángeles de la noche ibicenca
        badConsequence = new BadConsequence("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y descarta 1 oculta", 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        prize = new Prize(4, 1);
        monstruos.add(new Monster("Angeles de la noche ibicenca", 14, badConsequence, prize));
        
        //Monstruo 5: El gorrón en el umbral
        badConsequence = new BadConsequence("Pierdes todos tus tesoros visibles", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR, TreasureKind.BOTHHANDS, TreasureKind.HELMET, TreasureKind.ONEHAND, TreasureKind.SHOES)), null);
        prize = new Prize(3, 1);
        monstruos.add(new Monster("El gorrón en el umbral", 10, badConsequence, prize));
        
        //Monstruo 6: H.P. Munchcraft
        badConsequence = new BadConsequence("Pierdes la armadura visible.", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), null);
        prize = new Prize(2, 1);
        monstruos.add(new Monster("H.P. Munchcraft", 6, badConsequence, prize));
        
        //Monstruo 7: Bichgooth
        badConsequence = new BadConsequence("Sientes bichos bajo la ropa. Descarta la armadura visible.", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), null);
        prize = new Prize(1, 1);
        monstruos.add(new Monster("Bichgooth", 2, badConsequence, prize));
        
        //Monstruo 8: El rey de rosa
        badConsequence = new BadConsequence("Pierdes 5 niveles y 3 tesoros visibles", 5, 3, 0);
        prize = new Prize(4, 2);
        monstruos.add(new Monster("El rey de rosa", 13, badConsequence, prize));
        
        //Monstruo 9: La que redacta en las tinieblas.
        badConsequence = new BadConsequence("Toses los pulmones y pierdes 2 niveles.", 2, 0, 0);
        prize = new Prize(1, 1);
        monstruos.add(new Monster("La que redacta en las tinieblas", 2, badConsequence, prize));
        
        //Monstruo 10: Los hondos
        badConsequence = new BadConsequence("Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estas muerto.", true);
        prize = new Prize(2, 1);
        monstruos.add(new Monster("Los hondos", 8, badConsequence, prize));
        
        //Monstruo 11: Semillas Cthulhu
        badConsequence = new BadConsequence("Pierdes 2 niveles y 2 tesoros ocultos", 2, 0, 2);
        prize = new Prize(2, 1);
        monstruos.add(new Monster("Semillas Cthulhu", 4, badConsequence, prize));
        
        //Monstruo 12: Dameargo
        badConsequence = new BadConsequence("Te intentas escaquear. Pierdes una mano visible.", 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), null);
        prize = new Prize(2, 1);
        monstruos.add(new Monster("Dameargo", 1, badConsequence, prize));
        
        //Monstruo 13: Pollipólipo volante
        badConsequence = new BadConsequence("Da mucho asquito. Pierdes 3 niveles.", 3, 0, 0);
        prize = new Prize(1, 1);
        monstruos.add(new Monster("Pollipólipo volante", 3, badConsequence, prize));
        
        //Monstruo 14: Yskhtihyssg-Goth
        badConsequence = new BadConsequence("No le hace gracia que pronuncien mal su nombre. Estás muerto.", true);
        prize = new Prize(3, 1);
        monstruos.add(new Monster("Yskhtihyssg-Goth", 12, badConsequence, prize));
        
        //Monstruo 15: Familia feliz
        badConsequence = new BadConsequence("La familia te atrapa. Estás muerto.", true);
        prize = new Prize(4, 1);
        monstruos.add(new Monster("Familia feliz", 1, badConsequence, prize));
        
        //Monstruo 16: Roboggoth
        badConsequence = new BadConsequence("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visible.", 2, new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)), null);
        prize = new Prize(2, 1);
        monstruos.add(new Monster("Roboggoth", 8, badConsequence, prize));
        
        //Monstruo 17: El espía
        badConsequence = new BadConsequence("Te asusta en la noche. Pierdes un casco visible.", 0, new ArrayList(Arrays.asList(TreasureKind.HELMET)), null);
        prize = new Prize(1, 1);
        monstruos.add(new Monster("El espía", 5, badConsequence, prize));
        
        //Monstruo 18: El Lenguas
        badConsequence = new BadConsequence("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles.", 2, 5, 0);
        prize = new Prize(1, 1);
        monstruos.add(new Monster("El Lenguas", 20, badConsequence, prize));
        
        //Monstruo 19: Bicéfalo
        badConsequence = new BadConsequence("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos.", 3, new ArrayList(Arrays.asList(TreasureKind.ONEHAND, TreasureKind.ONEHAND, TreasureKind.BOTHHANDS)), null);
        prize = new Prize(1, 1);
        monstruos.add(new Monster("Bicéfalo", 20, badConsequence, prize));
        
    }
    
}
