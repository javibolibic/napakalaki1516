# encoding: utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require_relative 'prize'
require_relative 'bad_consequence'

class Monster
  def initialize(name, combatLevel, prize, badConsequence)
    @name = name
    @combatLevel = combatLevel
    @bc = badConsequence
    @prize = prize
  end
  
  attr_reader :name, :combatLevel
  
  def to_s
    "Nombre: #{@name} \n Nivel de combate: #{@combatLevel}"
  end
end
