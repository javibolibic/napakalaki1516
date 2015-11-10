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
    @canISteal = true
    @hiddenTreasures = Array.new
    @visibleTreasures = Array.new
    @pendingBadConsequence = nil
    @enemy = nil
  end
  
  attr_reader :name, :level, :dead, :canISteal, :hiddenTreasures, :visibleTreasures
  
  private
  def bring_to_life
    
  end
  
  def get_combat_level
    
  end
  
  def increment_levels(l)
    
  end
  
  def decrement_levels(l)
    
  end
  
  def set_pending_bad_consequence(b)
    
  end
  
  def apply_prize(m)
    
  end
  
  def apply_bad_consequence
    
  end
  
  def can_make_treasure_visible(t)
    
  end
  
  def how_many_visible_treasures(tKind)
    
  end
  
  def die_if_no_treasures
    
  end
end
