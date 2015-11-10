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

require_relative 'treasure_kind'

class BadConsequence
  @@MAXTREASURES = 10
  
  def initialize(t, l, nVisible, nHidden, v, h, death)
    @text = t
    @levels = l
    @nVisibleTreasures = nVisible
    @nHiddenTreasures = nHidden
    @specificVisibleTreasures = v
    @specificHiddenTreasures = h
    @death = death
  end
  
  #Devuelve true cuando el mal rollo que tiene que cumplir el jugador está vacío, eso
  #significa que el conjunto de atributos del mal rollo indican que no hay mal rollo que
  #cumplir
  def is_empty
    empty = false
    empty = true if (@specificHiddenTreasures.empty? && @specificVisibleTreasures.empty? && @nHiddenTreasures == 0 && @nVisibleTreasures == 0)
    return empty
  end
  
  attr_reader :levels, :nVisibleTreasures, :nHiddenTreasures, :specificVisibleTreasures, :specificHiddenTreasures
  
  def substract_visible_treasure(t)
    
  end
  
  def substract_hidden_treasure(t)
    
  end
  
  #Los tres métodos siguientes sobrecargan el único constructor que se puede definir en Ruby.
  def self.new_level_number_of_treasures(t, l, nVisible, nHidden)
    new(t, l, nVisible, nHidden, Array.new, Array.new, false)
  end
  
  def self.new_level_specific_treasures(t, l, v, h)
    new(t, l, 0, 0, v, h, false)
  end
  
  def self.new_death(t, death)
    new(t, 0, 0, 0, Array.new, Array.new, death)
  end
  
  def adjust_to_fit_treasure_lists(v, h)
    
  end
  
  def to_s
    "Mal rollo: #{@text} \n Niveles: #{@levels} \n Muerte: #{@death}"
  end
end
