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
require_relative 'treasure'
require 'singleton'

class CardDealer
  include Singleton
  
  attr_accessor :unusedMonsters, :usedMonsters, :unusedTreasures, :usedTreasures
  
  private
  def init_treasure_card_deck
    
  end
  
  def init_monster_card_deck
    
  end
  
  def shuffle_treasures
    
  end
  
  def shuffle_monsters
    
  end
  
  public
  def next_treasure
    
  end
  
  def next_monster
    
  end
  
  def give_treasure_back(t)
    
  end
  
  def give_monster_back(m)
    
  end
  
  def init_cards
    
  end
end
