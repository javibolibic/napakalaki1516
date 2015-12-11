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

require_relative 'dice'
require_relative 'bad_consequence'
require_relative 'combat_result'

module Napakalaki
  class Player

    @@MAXLEVEL = 10

    def initialize(name)
      @name = name
      @level = 1
      @dead = true
      @can_i_steal = true
      @hidden_treasures = Array.new
      @visible_treasures = Array.new
      @pending_bad_consequence = nil
      @enemy = nil
    end

    attr_reader :name, :level, :dead, :can_i_steal, :hidden_treasures, :visible_treasures
    attr_writer :pending_bad_consequence, :enemy

    private
    #Devuelve la vida al jugador, modificando el atributo correspondiente.
    def bring_to_life
      @dead = false
    end

    #Devuelve el nivel de combate del jugador, que viene dado por su nivel más los bonus
    #que le proporcionan los tesoros que tenga equipados, según las reglas del juego.
    def get_combat_level
      combatlevel = @level

      visible_treasures.each do |t|
        combatlevel += t.bonus
      end
      return combatlevel
    end

    #Incrementa el nivel del jugador en i niveles, teniendo en cuenta las reglas del juego.
    def increment_levels(i)
      @level += i
    end

    #Decrementa el nivel del jugador en i niveles, teniendo en cuenta las reglas del juego.
    def decrement_levels(i)
      @level -= i
    end

    def apply_prize(m)
      n_levels = m.get_levels_gained
      l = n_levels
      increment_levels(l)
      n_treasures = m.get_treasures_gained

      if(n_treasures > 0)
        dealer = CardDealer.instance

        for counter in 0..n_treasures
          treasure = dealer.next_treasure
          @hidden_treasures << treasure
        end
      end
    end

    def apply_bad_consequence(m)
      b = m.bad_consequence
      l = b.levels
      decrement_levels(l)
      v = @visible_treasures
      h = @hidden_treasures
      pending_bad = b.adjust_to_fit_treasure_lists(v, h)
      @pending_bad_consequence = pending_bad
    end

    def can_make_treasure_visible(t)
      n_treasures_one_hand = 0
      treasure_both_hands = false, output = false, mismo_tipo = false
      if(@visible_treasures.size < 4)
        @visible_treasures.each do |tesoro|
          if (tesoro.type == TreasureKind::ONEHAND)
            n_treasures_one_hand+=1
          elsif (tesoro.type == TreasureKind::BOTHHANDS)
            treasure_both_hands = true
          elsif (t.type == tesoro.type)
            mismo_tipo = true
          end
        end

        if (n_treasures_one_hand < 3 && t.type == TreasureKind::ONEHAND)
          output = true
        elsif (n_treasures_one_hand == 0 && treasure_both_hands == true)
          output = true
        elsif (mismo_tipo == false)
          output = true
        end
      end
      return output
    end

    #Devuelve el número de tesoros visibles de tipo tKind que tiene el jugador.
    def how_many_visible_treasures(tKind)
      counter = 0
      @visible_treasures.each do |t|
        counter += 1 if (t == tKind)
      end
      return counter
    end

    #Cambia el estado de jugador a muerto, modificando el correspondiente atributo.
    #Esto ocurre cuando el jugador, por algún motivo, ha perdido todos sus tesoros.
    def die_if_no_treasures
      @dead = true if (@hidden_treasures.empty? && @visible_treasures.empty?)
    end

    #Cambia el atributo canISteal a false cuando el jugador roba un tesoro.
    def have_stolen
      @can_i_steal = false
    end

    public  
    def combat(m)
      my_level = get_combat_level
      monster_level = m.combat_level
      if(my_level > monster_level)
          apply_prize(m)

          if(@level >= @@MAXLEVEL)
            combat_result = CombatResult::WINGAME
          else
            combat_result = CombatResult::WIN
          end
      else
        apply_bad_consequence(m)
        combat_result = CombatResult::LOSE
      end
    end

    def make_treasure_visible(t)
      can_i = can_make_treasure_visible(t)
      if (can_i)
        @visible_treasures << t
        @hidden_treasures.delete(t)
      end
    end

    def discard_visible_treasure(t)
      @visible_treasures.delete(t)
      if((@pending_bad_consequence != nil) && (!@pending_bad_consequence.is_empty))
        @pending_bad_consequence.substract_visible_treasure(t)
      end
      die_if_no_treasures
    end

    def discard_hidden_treasure(t)
      @visible_treasures.delete(t)
      if((@pending_bad_consequence != nil) && (!@pending_bad_consequence.is_empty))
        @pending_bad_consequence.substract_hidden_treasure(t)
      end
      die_if_no_treasures
    end

    #Devuelve true cuando el jugador no tiene ningún mal rollo que cumplir y no tiene
    #más de 4 tesoros ocultos, y false en caso contrario.
    def valid_state
      v = false
      v = true if (@pending_bad_consequence.is_empty && @hidden_treasures.size <= 4)
      return v
    end

    def init_treasures
      dealer = CardDealer.instance
      dice = Dice.instance
      bring_to_life
      treasure = dealer.next_treasure
      @hidden_treasures << treasure
      number = dice.next_number
      if(number > 1)
        treasure = dealer.next_treasure
        @hidden_treasures << treasure
      end
      if(number == 6)
        treasure = dealer.next_treasure
        @hidden_treasures << treasure
      end
    end
    
    #Devuelve true si el jugador tiene tesoros para ser robados por otro jugador y false
    #en caso contrario.
    def can_you_give_me_a_treasure
      can = false
      if(!@visible_treasures.empty? || !@hidden_treasures.empty?)
        can = true
      end
      return can
    end
    
    def give_me_a_treasure
      index = rand(@hidden_treasures.size)
      return @hidden_treasures.at(index)
    end

    def steal_treasure
      can_i = @can_i_steal
      if (can_i)
        can_you = @enemy.can_you_give_me_a_treasure
        if(can_you)
          treasure = @enemy.give_me_a_treasure
          @hidden_treasures << treasure
          have_stolen
        end
      end
      treasure
    end

    def discard_all_treasures
      @visible_treasures.each do |treasure|
        discard_visible_treasure(treasure)
      end
      @hidden_treasures.each do |treasure|
        discard_hidden_treasure(treasure)
      end
    end
    
    def to_s
      @name
    end
  end
end
