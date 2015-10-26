# encoding: utf-8

=begin
********************************************************************
** Creado por Javier Bolívar Valverde <javibolivar@correo.ugr.es> **
** Programación y Diseño Orientado a Objetos                      **
** Grado en Ingeniería Informática                                **
********************************************************************
=end

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
