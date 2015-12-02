# encoding: utf-8

=begin
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
=end

require 'singleton'
require_relative 'treasure'
require_relative 'treasure_kind'
require_relative 'prize'
require_relative 'monster'
require_relative 'bad_consequence'

module Napakalaki
  class CardDealer
    include Singleton

    attr_accessor :unused_monsters, :used_monsters, :unused_treasures, :used_treasures
    
    private
    def initialize
      @unused_monsters = Array.new
      @used_monsters = Array.new 
      @unused_treasures = Array.new
      @used_treasures = Array.new 
    end
    #Inicializa el mazo de cartas de Tesoros (unusedTreasures) con todas las cartas de
    #tesoros proporcionadas en el documento de cartas de tesoros.
    def init_treasure_card_deck
      @unused_treasures << Treasure.new("¡Sí mi amo!", 4, TreasureKind::HELMET)
      @unused_treasures << Treasure.new("Botas de investigación", 3, TreasureKind::SHOES)
      @unused_treasures << Treasure.new("Capucha de Cthulhu", 3, TreasureKind::HELMET)
      @unused_treasures << Treasure.new("A prueba de balas", 2, TreasureKind::ARMOR)
      @unused_treasures << Treasure.new("Botas de lluvia ácida", 1, TreasureKind::BOTHHANDS)
      @unused_treasures << Treasure.new("Casco minero", 2, TreasureKind::HELMET)
      @unused_treasures << Treasure.new("Ametralladora Thompson", 4, TreasureKind::BOTHHANDS)
      @unused_treasures << Treasure.new("Camiseta de la UGR", 1, TreasureKind::ARMOR)
      @unused_treasures << Treasure.new("Clavo de rail ferroviario", 3, TreasureKind::ONEHAND)
      @unused_treasures << Treasure.new("Cuchillo de sushi arcano", 2, TreasureKind::ONEHAND)
      @unused_treasures << Treasure.new("Fez alópodo", 3, TreasureKind::HELMET)
      @unused_treasures << Treasure.new("Hacha prehistórica", 2, TreasureKind::ONEHAND)
      @unused_treasures << Treasure.new("El aparato del Pr. Tesla", 4, TreasureKind::ARMOR)
      @unused_treasures << Treasure.new("Gaita", 4, TreasureKind::BOTHHANDS)
      @unused_treasures << Treasure.new("Insecticida", 2, TreasureKind::ONEHAND)
      @unused_treasures << Treasure.new("Escopeta de 3 cañones", 4, TreasureKind::BOTHHANDS)
      @unused_treasures << Treasure.new("Garabato místico", 2, TreasureKind::ONEHAND)
      @unused_treasures << Treasure.new("La rebeca metálica", 2, TreasureKind::ARMOR)
      @unused_treasures << Treasure.new("Lanzallamas", 4, TreasureKind::BOTHHANDS)
      @unused_treasures << Treasure.new("Necrocomicón", 1, TreasureKind::ONEHAND)
      @unused_treasures << Treasure.new("Necronomicón", 5, TreasureKind::BOTHHANDS)
      @unused_treasures << Treasure.new("Linterna a 2 manos", 3, TreasureKind::BOTHHANDS)
      @unused_treasures << Treasure.new("Necrognomicón", 2, TreasureKind::ONEHAND)
      @unused_treasures << Treasure.new("Necrotelecom", 2, TreasureKind::HELMET)
      @unused_treasures << Treasure.new("Mazo de los antiguos", 3, TreasureKind::ONEHAND)
      @unused_treasures << Treasure.new("Necroplayboycón", 3, TreasureKind::ONEHAND)
      @unused_treasures << Treasure.new("Porra prenatural", 2, TreasureKind::ONEHAND)
      @unused_treasures << Treasure.new("Shogulador", 1, TreasureKind::BOTHHANDS)
      @unused_treasures << Treasure.new("Varita de atizamiento", 3, TreasureKind::ONEHAND)
      @unused_treasures << Treasure.new("Tentáculo de pega", 2, TreasureKind::HELMET)
      @unused_treasures << Treasure.new("Zapato deja-amigos", 1, TreasureKind::SHOES)
    end

    #Inicializa el mazo de cartas de monstruos (unusedMonsters), con todas las cartas
    #de monstruos proporcionadas en el documento de cartas de monstruos.
    def init_monster_card_deck
      monsters = Array.new

      # Monstruo 1: 3 Byakhees de bonanza
      prize = Prize.new(2, 1)
      bad_consequence = BadConsequence.new_level_specific_treasures('Pierdes tu armadura visible y otra oculta.', 0, [TreasureKind::ARMOR], [TreasureKind::ARMOR])
      monsters << Monster.new('2 Byakhees de bonanza', 8, prize, bad_consequence)

      # Monstruo 2: Chibithulhu
      prize = Prize.new(1, 1)
      bad_consequence = BadConsequence.new_level_specific_treasures('Embobados con el lindo primigenio te descargas de tu casco visible.', 0, [TreasureKind::HELMET], nil)
      monsters << Monster.new('Chibithulhu', 2, prize, bad_consequence)

      # Monstruo 3: El sopor de Dunwich
      prize = Prize.new(1, 1)
      bad_consequence = BadConsequence.new_level_specific_treasures('El primordial bostezo contagioso. Pierdes el calzado visible.', 0, [TreasureKind::SHOES], nil)
      monsters << Monster.new('El sopor de Dunwich', 2, prize, bad_consequence)

      # Monstruo 4: Ángeles de la noche ibicenca
      prize = Prize.new(4, 1)
      bad_consequence = BadConsequence.new_level_specific_treasures('Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta.', 0, [TreasureKind::ONEHAND], [TreasureKind::ONEHAND])
      monsters << Monster.new('Ángeles de la noche ibicenca', 14, prize, bad_consequence)

      # Monstruo 5: El gorrón en el umbral
      prize = Prize.new(3, 1)
      bad_consequence = BadConsequence.new_level_specific_treasures('Pierdes todos tus tesoros visibles.', 0, [TreasureKind::ONEHAND, TreasureKind::ONEHAND, TreasureKind::BOTHHANDS, TreasureKind::ARMOR, TreasureKind::HELMET, TreasureKind::SHOES], nil)
      monsters << Monster.new('El gorrón en el umbral', 10, prize, bad_consequence)

      # Monstruo 6: H.P. Munchcraft
      prize = Prize.new(2, 1)
      bad_consequence = BadConsequence.new_level_specific_treasures('Pierdes la armadura visible.', 0, [TreasureKind::ARMOR], nil)
      monsters << Monster.new('H.P. Munchcraft', 6, prize, bad_consequence)

      # Monstruo 7: Bichgooth
      prize = Prize.new(1, 1)
      bad_consequence = BadConsequence.new_level_specific_treasures('Sientes bichos bajo la ropa. Descarga la armadura visible.', 0, [TreasureKind::ARMOR], nil)
      monsters << Monster.new('Bichgooth', 2, prize, bad_consequence)

      # Monstruo 8: El rey de rosa
      price = Prize.new(4, 2)
      bad_consequence = BadConsequence.new_level_number_of_treasures('Pierdes 5 niveles y 3 tesoros visibles.', 5, 3, 0)
      monsters << Monster.new('El rey de rosa', 13, prize, bad_consequence)

      # Monstruo 9: La que redacta en las tinieblas.
      price = Prize.new(1, 1)
      bad_consequence = BadConsequence.new_level_number_of_treasures('Toses los pulmones y pierdes 2 niveles.', 2, 0, 0)
      monsters << Monster.new('La que redacta en las tinieblas', 2, prize, bad_consequence)

      # Monstruo 10: Los hondos
      prize = Prize.new(2, 1)
      bad_consequence = BadConsequence.new_death('Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estás muerto.')
      monsters << Monster.new('Los hondos', 8, prize, bad_consequence)

      # Monstruo 11: Semillas Cthulhu
      price = Prize.new(2, 1)
      bad_consequence = BadConsequence.new_level_number_of_treasures('Pierdes 2 niveles y 2 tesoros ocultos.', 2, 0, 2)
      monsters << Monster.new('Semillas Cthulhu', 4, prize, bad_consequence)

      # Monstruo 12: Dameargo
      prize = Prize.new(2, 1)
      bad_consequence = BadConsequence.new_level_specific_treasures('Te intentas escaquear. Pierdes una mano visible.', 0, [TreasureKind::ONEHAND], nil)
      monsters << Monster.new('Dameargo', 1, prize, bad_consequence)

      # Monstruo 13: Pollipólipo volante
      price = Prize.new(1, 1)
      bad_consequence = BadConsequence.new_level_number_of_treasures('Da mucho asquito. Pierdes 3 niveles.', 3, 0, 0)
      monsters << Monster.new('Pollipólipo volante', 3, prize, bad_consequence)

      # Monstruo 14: Yskhtihyssg-Goth
      prize = Prize.new(3, 1)
      bad_consequence = BadConsequence.new_death('No le hace gracia que pronuncien mal su nombre. Estás muerto.')
      monsters << Monster.new('Yskhtihyssg-Goth', 12, prize, bad_consequence)

      # Monstruo 15: Familia feliz
      prize = Prize.new(4, 1)
      bad_consequence = BadConsequence.new_death('La familia te atrapa. Estás muerto.')
      monsters << Monster.new('Familia feliz', 1, prize, bad_consequence)

      # Monstruo 16: Roboggoth
      prize = Prize.new(2, 1)
      bad_consequence = BadConsequence.new_level_specific_treasures('La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visible.', 2, [TreasureKind::BOTHHANDS], nil)
      monsters << Monster.new('Roboggoth', 8, prize, bad_consequence)

      # Monstruo 17: El espía
      prize = Prize.new(1, 1)
      bad_consequence = BadConsequence.new_level_specific_treasures('Te asusta en la noche. Pierdes un casco visible.', 0, [TreasureKind::HELMET], nil)
      monsters << Monster.new("El espía", 5, prize, bad_consequence)

      # Monstruo 18: El Lenguas
      price = Prize.new(1, 1)
      bad_consequence = BadConsequence.new_level_number_of_treasures('Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles.', 2, 5, 0)
      monsters << Monster.new('El Lenguas', 20, prize, bad_consequence)

      # Monstruo 19: Bicéfalo
      prize = Prize.new(1, 1)
      bad_consequence = BadConsequence.new_level_specific_treasures('Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos.', 3, [TreasureKind::BOTHHANDS], nil)
      monsters << Monster.new('Bicéfalo', 20, prize, bad_consequence)

      @unused_monsters = monsters
    end

    #Baraja el mazo de cartas de tesoros unusedTreasures.
    def shuffle_treasures
      @unused_treasures.shuffle!
    end

    #Baraja el mazo de cartas de monstruos unusedMonsters.
    def shuffle_monsters
      @unused_monsters.shuffle!
    end

    public
    def next_treasure
      if (@unused_treasures.empty?)
        @unused_treasures = @used_treasures
        shuffle_treasures
        @used_treasures.clear
      end
      t = @unused_treasures.at(0)
      @unused_treasures.delete(t)

      return t
    end

    def next_monster
      if (@unused_monsters.empty?)
        @unused_monsters = @used_monsters
        shuffle_monsters
        @used_monsters.clear
      end
      m = @unused_monsters.at(0)
      @unused_monsters.delete(m)

      return m
    end

    #Introduce en el mazo de descartes de tesoros (usedTreasures) el tesoro t.
    def give_treasure_back(t)
      @used_treasures << t
    end

    #Introduce en el mazo de descartes de monstruos (usedMonsters) al monstruo m.
    def give_monster_back(m)
      @used_monsters << m
    end

    def init_cards
      init_treasure_card_deck
      init_monster_card_deck
    end
  end
end
