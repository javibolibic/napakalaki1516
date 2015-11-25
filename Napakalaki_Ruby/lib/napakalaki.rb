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

class Napakalaki
  include Singleton
  
  attr_accessor :current_player, :players, :current_monster, :dealer
  
  private
  def init_players(names)
    names.each do |name|
      playeract = Player.new(name)
      @players.add(playeract)
    end
  end
  
  def next_player()
    tamplayers = @players.size
    
    if (@current_player == nil)
      indice = rand(tamplayers)
    else
      indice = @players.index(@current_player)
      
      indice = (indice + 1) % tamplayers
    end
    return @players.at(indice)
  end
  
  def next_turn_allowed
    allow = false
    allow = true if (@current_player == nil || @current_player.valid_state)
    return allow
  end
  
  def set_enemies
    tamplayers = @players.size;
    players.each do |player|
      i = @players.index(player)
      loop do
        j = rand(@players.size)
        break if (j==i)
      end
      
      @players[i].enemy = @players[j]
    end
  end
  
  public
  def develop_combat
    
  end
  
  def discard_visible_treasures(treasures)
    
  end
  
  def discad_hidden_treasures(treasures)
    
  end
  
  def make_treasures_visible(treasures)
    
  end
  
  def init_game(players)
    
  end
  
  def next_turn
    
  end
  
  def end_of_game(result)
    return result == WINGAME
  end
  
end
