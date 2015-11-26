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

require_relative 'treasure'
require_relative 'bad_consequence'

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
    
  end
  
  def apply_bad_consequence
    
  end
  
  def can_make_treasure_visible(t)
    n_treasures_one_hand = 0
    treasure_both_hands = false, output = false, mismo_tipo = false
    if(@visible_treasures.size < 4)
      @visible_treasures.each do |tesoro|
        if (tesoro.type == ONEHAND)
          n_treasures_one_hand+=1
        elsif (tesoro.type == BOTHHANDS)
          treasure_both_hands = true
        elsif (t.type == tesoro.type)
          mismo_tipo = true
        end
      end
      
      if (n_treasures_one_hand < 3 && t.type == ONEHAND)
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
  
  def give_me_a_treasure
    index = rand(@hidden_treasures.size)
    return @hidden_treasures.at(index)
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
  
  #Cambia el atributo canISteal a false cuando el jugador roba un tesoro.
  def have_stolen
    @can_i_steal = false
  end
  
  public  
  def combat(m)
    
  end
  
  def make_treasure_visible(t)
    
  end
  
  def discard_visible_treasure(t)
    
  end
  
  def discard_hidden_treasure(t)
    
  end
  
  #Devuelve true cuando el jugador no tiene ningún mal rollo que cumplir y no tiene
  #más de 4 tesoros ocultos, y false en caso contrario.
  def valid_state
    v = false
    v = true if (@pending_bad_consequence.isEmpty && @hidden_treasures.size <= 4)
    return v
  end
  
  def init_treasures
    
  end
  
  def steal_treasure
    
  end
  
  def discard_all_treasures
    
  end
end
