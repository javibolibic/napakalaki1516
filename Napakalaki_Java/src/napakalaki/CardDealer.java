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
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class CardDealer {
    //Atributos
    private static CardDealer instance = new CardDealer();
    
    private ArrayList<Monster> usedMonsters = new ArrayList();
    private ArrayList<Monster> unusedMonsters = new ArrayList();
    private ArrayList<Treasure> usedTreasures = new ArrayList();
    private ArrayList<Treasure> unusedTreasures = new ArrayList();
    
    private ArrayList<Cultist> unusedCultists = new ArrayList();
    
    //Métodos
    private CardDealer(){
    }
    
    //Inicializa el mazo de cartas de Tesoros (unusedTreasures) con todas las cartas de
    //tesoros proporcionadas en el documento de cartas de tesoros.
    private void initTreasureCardDeck() {
        Treasure t = new Treasure("¡Sí mi amo!", 4, TreasureKind.HELMET);
        unusedTreasures.add(t);
        t = new Treasure("Botas de investigación", 3, TreasureKind.SHOES);
        unusedTreasures.add(t);
        t = new Treasure("Capucha de Cthulhu", 3, TreasureKind.HELMET);
        unusedTreasures.add(t);
        t = new Treasure("A prueba de babas", 2, TreasureKind.ARMOR);
        unusedTreasures.add(t);
        t = new Treasure("Botas de lluvia ácida", 1, TreasureKind.BOTHHANDS);
        unusedTreasures.add(t);
        t = new Treasure("Casco minero", 2, TreasureKind.HELMET);
        unusedTreasures.add(t);
        t = new Treasure("Ametralladora Thompson", 4, TreasureKind.BOTHHANDS);
        unusedTreasures.add(t);
        t = new Treasure("Camiseta de la UGR", 1, TreasureKind.ARMOR);
        unusedTreasures.add(t);
        t = new Treasure("Clavo de raíl ferroviario", 3, TreasureKind.ONEHAND);
        unusedTreasures.add(t);
        t = new Treasure("Cuchillo de sushi arcano", 2, TreasureKind.ONEHAND);
        unusedTreasures.add(t);
        t = new Treasure("Fez alópodo", 3, TreasureKind.HELMET);
        unusedTreasures.add(t);
        t = new Treasure("Hacha prehistórica", 2, TreasureKind.ONEHAND);
        unusedTreasures.add(t);
        t = new Treasure("El aparato del Pr. Tesla", 4, TreasureKind.ARMOR);
        unusedTreasures.add(t);
        t = new Treasure("Gaita", 4, TreasureKind.BOTHHANDS);
        unusedTreasures.add(t);
        t = new Treasure("Insecticida", 2, TreasureKind.ONEHAND);
        unusedTreasures.add(t);
        t = new Treasure("Escopeta de 3 cañones", 4, TreasureKind.BOTHHANDS);
        unusedTreasures.add(t);
        t = new Treasure("Garabato místico", 2, TreasureKind.ONEHAND);
        unusedTreasures.add(t);
        t = new Treasure("La rebeca metálica", 2, TreasureKind.ARMOR);
        unusedTreasures.add(t);
        t = new Treasure("Lanzallamas", 4, TreasureKind.BOTHHANDS);
        unusedTreasures.add(t);
        t = new Treasure("Necrocomicón", 1, TreasureKind.ONEHAND);
        unusedTreasures.add(t);
        t = new Treasure("Necronomicón", 5, TreasureKind.BOTHHANDS);
        unusedTreasures.add(t);
        t = new Treasure("Linterna a 2 manos", 3, TreasureKind.BOTHHANDS);
        unusedTreasures.add(t);
        t = new Treasure("Necrognomicón", 2, TreasureKind.ONEHAND);
        unusedTreasures.add(t);
        t = new Treasure("Necrotelecom", 2, TreasureKind.HELMET);
        unusedTreasures.add(t);
        t = new Treasure("Mazo de los antiguos", 3, TreasureKind.ONEHAND);
        unusedTreasures.add(t);
        t = new Treasure("Necroplayboycón", 3, TreasureKind.ONEHAND);
        unusedTreasures.add(t);
        t = new Treasure("Porra preternatural", 2, TreasureKind.ONEHAND);
        unusedTreasures.add(t);
        t = new Treasure("Shogulador", 1, TreasureKind.BOTHHANDS);
        unusedTreasures.add(t);
        t = new Treasure("Varita de atizamiento", 3, TreasureKind.ONEHAND);
        unusedTreasures.add(t);
        t = new Treasure("Tentáculo de pega", 2, TreasureKind.HELMET);
        unusedTreasures.add(t);
        t = new Treasure("Zapato deja-amigos", 1, TreasureKind.SHOES);
        unusedTreasures.add(t);
    }
    
    //Inicializa el mazo de cartas de monstruos (unusedMonsters), con todas las cartas
    //de monstruos proporcionadas en el documento de cartas de monstruos.
    private void initMonsterCardDeck() {
        ArrayList<Monster> monstruos = new ArrayList();
        Prize prize; //Parámetros: tesoros, niveles
        BadConsequence badConsequence; //Parámetros: texto, niveles, visible, oculto

        
        //Monstruo 1: 3 Byakhees de bonanza
        badConsequence = new SpecificBadConsequence("Pierdes tu armadura visible y otra oculta", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        prize = new Prize(2,1);
        monstruos.add(new Monster("3 Byakhees de bonanza", 8, badConsequence, prize));
        
        //Monstruo 2: Chibithulhu
        badConsequence = new SpecificBadConsequence("Embobados con el lindo primigenio te descartas de tu casco visible.", 0, new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList());
        prize = new Prize(1, 1);
        monstruos.add(new Monster("Chibithulhu", 2, badConsequence, prize));
        
        //Monstruo 3: El sopor de Dunwich
        badConsequence = new SpecificBadConsequence("El primordial bostezo contagioso. Pierdes el calzado visible.", 0, new ArrayList(Arrays.asList(TreasureKind.SHOES)), new ArrayList());
        prize = new Prize(1, 1);
        monstruos.add(new Monster("El sopor de Dunwich", 2, badConsequence, prize));
        
        //Monstruo 4: Ángeles de la noche ibicenca
        badConsequence = new SpecificBadConsequence("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y descarta 1 oculta", 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        prize = new Prize(4, 1);
        monstruos.add(new Monster("Angeles de la noche ibicenca", 14, badConsequence, prize));
        
        //Monstruo 5: El gorrón en el umbral
        badConsequence = new SpecificBadConsequence("Pierdes todos tus tesoros visibles", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR,TreasureKind.HELMET, TreasureKind.BOTHHANDS, TreasureKind.ONEHAND, TreasureKind.ONEHAND, TreasureKind.SHOES)), new ArrayList());
        prize = new Prize(3, 1);
        monstruos.add(new Monster("El gorrón en el umbral", 10, badConsequence, prize));
        
        //Monstruo 6: H.P. Munchcraft
        badConsequence = new SpecificBadConsequence("Pierdes la armadura visible.", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList());
        prize = new Prize(2, 1);
        monstruos.add(new Monster("H.P. Munchcraft", 6, badConsequence, prize));
        
        //Monstruo 7: Bichgooth
        badConsequence = new SpecificBadConsequence("Sientes bichos bajo la ropa. Descarta la armadura visible.", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList());
        prize = new Prize(1, 1);
        monstruos.add(new Monster("Bichgooth", 2, badConsequence, prize));
        
        //Monstruo 8: El rey de rosa
        badConsequence = new NumericBadConsequence("Pierdes 5 niveles y 3 tesoros visibles", 5, 3, 0);
        prize = new Prize(4, 2);
        monstruos.add(new Monster("El rey de rosa", 13, badConsequence, prize));
        
        //Monstruo 9: La que redacta en las tinieblas.
        badConsequence = new NumericBadConsequence("Toses los pulmones y pierdes 2 niveles.", 2, 0, 0);
        prize = new Prize(1, 1);
        monstruos.add(new Monster("La que redacta en las tinieblas", 2, badConsequence, prize));
        
        //Monstruo 10: Los hondos
        badConsequence = new DeathBadConsequence("Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estás muerto.", true);
        prize = new Prize(2, 1);
        monstruos.add(new Monster("Los hondos", 8, badConsequence, prize));
        
        //Monstruo 11: Semillas Cthulhu
        badConsequence = new NumericBadConsequence("Pierdes 2 niveles y 2 tesoros ocultos", 2, 0, 2);
        prize = new Prize(2, 1);
        monstruos.add(new Monster("Semillas Cthulhu", 4, badConsequence, prize));
        
        //Monstruo 12: Dameargo
        badConsequence = new SpecificBadConsequence("Te intentas escaquear. Pierdes una mano visible.", 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList());
        prize = new Prize(2, 1);
        monstruos.add(new Monster("Dameargo", 1, badConsequence, prize));
        
        //Monstruo 13: Pollipólipo volante
        badConsequence = new NumericBadConsequence("Da mucho asquito. Pierdes 3 niveles.", 3, 0, 0);
        prize = new Prize(1, 1);
        monstruos.add(new Monster("Pollipólipo volante", 3, badConsequence, prize));
        
        //Monstruo 14: Yskhtihyssg-Goth
        badConsequence = new DeathBadConsequence("No le hace gracia que pronuncien mal su nombre. Estás muerto.", true);
        prize = new Prize(3, 1);
        monstruos.add(new Monster("Yskhtihyssg-Goth", 12, badConsequence, prize));
        
        //Monstruo 15: Familia feliz
        badConsequence = new DeathBadConsequence("La familia te atrapa. Estás muerto.", true);
        prize = new Prize(4, 1);
        monstruos.add(new Monster("Familia feliz", 1, badConsequence, prize));
        
        //Monstruo 16: Roboggoth
        badConsequence = new SpecificBadConsequence("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visible.", 2, new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)), new ArrayList());
        prize = new Prize(2, 1);
        monstruos.add(new Monster("Roboggoth", 8, badConsequence, prize));
        
        //Monstruo 17: El espía
        badConsequence = new SpecificBadConsequence("Te asusta en la noche. Pierdes un casco visible.", 0, new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList());
        prize = new Prize(1, 1);
        monstruos.add(new Monster("El espía", 5, badConsequence, prize));
        
        //Monstruo 18: El Lenguas
        badConsequence = new NumericBadConsequence("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles.", 2, 5, 0);
        prize = new Prize(1, 1);
        monstruos.add(new Monster("El Lenguas", 20, badConsequence, prize));
        
        //Monstruo 19: Bicéfalo
        badConsequence = new SpecificBadConsequence("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos.", 3, new ArrayList(Arrays.asList(TreasureKind.ONEHAND, TreasureKind.ONEHAND, TreasureKind.BOTHHANDS)), new ArrayList());
        prize = new Prize(1, 1);
        monstruos.add(new Monster("Bicéfalo", 20, badConsequence, prize));
        
        //Monstruo con sectarios 1: El mal indecible impronunciable
        badConsequence = new SpecificBadConsequence("Pierdes 1 mano visible", 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList());
        prize = new Prize(3, 1);
        monstruos.add(new Monster("El mal indecible impronunciable", 10, badConsequence, prize, -2));
        
        //Monstruo con sectarios 2: Testigos oculares
        badConsequence = new SpecificBadConsequence("Pierdes tus tesoros visibles. Ja ja ja.", 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND, TreasureKind.ONEHAND, TreasureKind.BOTHHANDS, TreasureKind.HELMET, TreasureKind.ARMOR, TreasureKind.SHOES)), new ArrayList());
        prize = new Prize(2, 1);
        monstruos.add(new Monster("Testigos oculares", 6, badConsequence, prize, 2));
        
        //Monstruo con sectarios 3: El gran cthulhu
        badConsequence = new DeathBadConsequence("Hoy no es tu día de suerte. Mueres.", true);
        prize = new Prize(2, 5);
        monstruos.add(new Monster("El gran cthulhu", 20, badConsequence, prize, 4));
        
        //Monstruo con sectarios 4: Serpiente político
        badConsequence = new NumericBadConsequence("Tu gobierno te recorta 2 niveles.", 2, 0, 0);
        prize = new Prize(2, 1);
        monstruos.add(new Monster("Serpiente político", 8, badConsequence, prize, -2));
        
        //Monstruo con sectarios 5: Felpuggoth
        badConsequence = new SpecificBadConsequence("Pierdes tu casco y tu armadura visible. Pierdes tus manos ocultas.", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR, TreasureKind.HELMET)), new ArrayList(Arrays.asList(TreasureKind.ONEHAND, TreasureKind.ONEHAND, TreasureKind.BOTHHANDS)));
        prize = new Prize(1, 1);
        monstruos.add(new Monster("Felpuggoth", 2, badConsequence, prize, 5));
        
        //Monstruo con sectarios 6: Shoggoth
        badConsequence = new NumericBadConsequence("Pierdes 2 niveles.", 2, 0, 0);
        prize = new Prize(4, 2);
        monstruos.add(new Monster("Shoggoth", 16, badConsequence, prize, -4));
        
        //Monstruo con sectarios 7: Lolitagooth
        badConsequence = new NumericBadConsequence("Pintalabios negro. Pierdes 2 niveles.", 2, 0, 0);
        prize = new Prize(1, 1);
        monstruos.add(new Monster("Lolitagooth", 2, badConsequence, prize, 3));
        
        this.unusedMonsters = monstruos;
    }
    
    //Baraja el mazo de cartas de tesoros unusedTreasures.
    private void shuffleTreasures() {
        Collections.shuffle(this.unusedTreasures);
        
    }
    
    //Baraja el mazo de cartas de monstruos unusedMonsters.
    private void shuffleMonsters() {
       Collections.shuffle(this.unusedMonsters);
    }
    
    public static CardDealer getInstance() {
        return instance;
    }
    
    public Treasure nextTreasure() {
        if (this.unusedTreasures.isEmpty()) {
            this.unusedTreasures = this.usedTreasures;
            shuffleTreasures();
            this.usedTreasures.clear();
        }
        
        Treasure t = this.unusedTreasures.get(0);
        this.unusedTreasures.remove(0);
        
        return t;
    }
    
    public Monster nextMonster() {
        if (this.unusedMonsters.isEmpty()) {
            this.unusedMonsters = this.usedMonsters;
            shuffleMonsters();
            this.usedMonsters.clear();
        }
        
        Monster m = this.unusedMonsters.get(0);
        this.unusedMonsters.remove(0);
        
        return m;
    }
    
    //Introduce en el mazo de descartes de tesoros (usedTreasures) el tesoro t.
    public void giveTreasureBack(Treasure t) {
        this.usedTreasures.add(t);
    }
    
    //Introduce en el mazo de descartes de monstruos (usedMonsters) al monstruo m.
    public void giveMonsterBack(Monster m) {
        this.usedMonsters.add(m);
    }
    
    public void initCards() {
        this.initTreasureCardDeck();
        this.initMonsterCardDeck();
        this.initCultistCardDeck();
    }
    
    private void shuffleCultists() {
        Collections.shuffle(this.unusedCultists);
    }
    
    private void initCultistCardDeck() {
        this.unusedCultists.add(new Cultist("Sectario 1", 1));
        this.unusedCultists.add(new Cultist("Sectario 2", 2));
        this.unusedCultists.add(new Cultist("Sectario 3", 1));
        this.unusedCultists.add(new Cultist("Sectario 4", 2));
        this.unusedCultists.add(new Cultist("Sectario 5", 1));
        this.unusedCultists.add(new Cultist("Sectario 6", 1));
    }
    
    public Cultist nextCultist() {
        //Si tenemos el mazo vacío lo inicializamos
        if (this.unusedCultists.isEmpty()) {
            this.initCultistCardDeck();
            this.shuffleCultists();
        }
        
        Cultist c = this.unusedCultists.get(0);
        this.unusedCultists.remove(c); //Borramos la carta escogida del mazo
        return c;
    }
}
