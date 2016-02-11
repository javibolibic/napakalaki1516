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

require_relative 'bad_consequence'

class SpecificBadConsequence < BadConsequence

  def initialize(t, l, v, h)
    super(t, l)
    @specific_visible_treasures = v
    @specific_hidden_treasures = h
  end
  
  public_class_method :new
  
  attr_reader :specific_visible_treasures, :specific_hidden_treasures

  #Devuelve true cuando el mal rollo que tiene que cumplir el jugador está vacío, eso
  #significa que el conjunto de atributos del mal rollo indican que no hay mal rollo que
  #cumplir
  def is_empty
    empty = false    
    empty = true if (@specific_hidden_treasures.empty? && @specific_visible_treasures.empty?)
    return empty
  end

  def substract_visible_treasure(t)
    if(!@specific_visible_treasures.empty?)
      @specific_visible_treasures.delete(t.type)
    end
  end

  def substract_hidden_treasure(t)
    if(!@specific_hidden_treasures.empty?)
      @specific_hidden_treasures.delete(t.type)
    end
  end

  def adjust_to_fit_treasure_lists(v, h)
    t = @text
    l = @levels
    result_specific_visible_treasures = Array.new
    result_specific_hidden_treasures = Array.new

    if(!@specific_visible_treasures.empty? || !@specific_hidden_treasures.empty?)
      @specific_visible_treasures.each do |m_v_treasure|
        if (v.include?(m_v_treasure))
          result_specific_visible_treasures << m_v_treasure
        end
      end
      @specific_hidden_treasures.each do |m_h_treasure|
        if (h.include?(m_h_treasure))
          result_specific_hidden_treasures << m_h_treasure
        end
      end
      
      b_c = SpecificBadConsequence.new(t, l, result_specific_visible_treasures, result_specific_hidden_treasures)
    else
      b_c = SpecificBadConsequence.new(t, l, Array.new(0), Array.new(0))
    end

    return b_c
  end

  def to_s
    "Mal rollo: #{@text} \n Niveles: #{@levels} \n Muerte: #{@death}"
  end
end
