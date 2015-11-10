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

require_relative 'monster'
require_relative 'player'
require_relative 'card_dealer'
require 'singleton'

class Napakalaki
  include Singleton
  
  attr_accessor :currentPlayer, :players, :currentMonster, :dealer
  
  private
  def init_players(names)
    
  end
  
  def next_player()
    
  end
  
  def next_turn_allowed
    
  end
  
  def set_enemies
    
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
    
  end
  
end
