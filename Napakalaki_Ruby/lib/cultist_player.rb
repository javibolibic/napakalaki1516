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

class CultistPlayer < Player

  @@total_cultist_players = 0

  def initialize(p, c)
    super(p)
    @my_cultist_card = c
    @@total_cultist_players += 1
  end

  attr_accessor :my_cultist_card

  protected
  def get_combat_level
    total = (super.level * 1.2) + (@my_cultist_card.get_gained_levels + @@total_cultist_players)
    return total
  end

  def get_oponent_level(m)
    return m.get_combat_level_against_cultist_player
  end

  def should_convert
    return false
  end

  private
  def give_me_a_treasure
    index = rand(@visible_treasures.size)
    return @visible_treasures.at(index)
  end

  def can_you_give_me_a_treasure
    can = true
    if(@visible_treasures.empty?)
      can = false
    end
    return can
  end

  public
  def get_total_cultist_players
    return @@total_cultist_players
  end
end


