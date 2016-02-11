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
require_relative 'player'
require_relative 'card_dealer'

class Napakalaki
  include Singleton

  attr_accessor :current_player, :players, :current_monster, :dealer

  private
  def init_players(names)
    @dealer = CardDealer.instance
    @players = Array.new
    names.each do |name|
      @players << Player.new(name)
    end
    next_player
  end

  def next_player
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
      j = rand()
      loop do
        j = rand(@players.size)
        break if (j==i)
      end

      @players[i].enemy = @players[j]
    end
  end

  public
  def develop_combat
    m = @current_monster
    combat_result = @current_player.combat(m)
    @dealer.give_monster_back(m)

    combat_result
  end

  def discard_visible_treasures(treasures)
    treasures.each do |treasure|
      @current_player.discard_visible_treasure(treasure)
      @dealer.give_treasure_back(treasure)
    end
  end

  def discard_hidden_treasures(treasures)
    treasures.each do |treasure|
      @current_player.discard_hidden_treasure(treasure)
      @dealer.give_treasure_back(treasure)
    end
  end

  def make_treasures_visible(treasures)
    treasures.each do |t|
      @current_player.make_treasure_visible(t)
    end
  end

  def init_game(players)
    init_players(players)
    set_enemies
    @dealer.init_cards
    next_turn
  end

  def next_turn
    state_ok = next_turn_allowed
    if(state_ok)
      @current_monster = @dealer.next_monster
      @current_player = next_player
      dead = @current_player.dead
      if(dead)
        @current_player.init_treasures
      end
    end

    state_ok
  end

  def end_of_game(result)
    return result == WINGAME
  end
end
