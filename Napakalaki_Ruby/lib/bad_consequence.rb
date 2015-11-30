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


class BadConsequence
  @@MAXTREASURES = 10
  
  def initialize(t, l, n_visible, n_hidden, v, h, death)
    @text = t
    @levels = l
    @n_visible_treasures = nVisible
    @n_hidden_treasures = nHidden
    @specific_visible_treasures = v
    @specific_hidden_treasures = h
    @death = death
  end
  
  #Devuelve true cuando el mal rollo que tiene que cumplir el jugador está vacío, eso
  #significa que el conjunto de atributos del mal rollo indican que no hay mal rollo que
  #cumplir
  def is_empty
    empty = false
    empty = true if (@specific_hidden_treasures.empty? && @specific_visible_treasures.empty? && @n_hidden_treasures == 0 && @n_visible_treasures == 0)
    return empty
  end
  
  attr_reader :levels, :n_visible_treasures, :n_hidden_treasures, :specific_visible_treasures, :specific_hidden_treasures
  
  def substract_visible_treasure(t)
    if (t.type == nil)
      if (t.bonus != 0)
        @n_visible_treasures -= 1
      end
    else
      @specific_visible_treasures.delete(t.type)
    end
  end
  
  def substract_hidden_treasure(t)
    if (t.type == nil)
      if (t.bonus != nil)
        @n_hidden_treasures -= 1
      end
    else
      @specific_hidden_treasures.delete(t.type)
    end
  end
  
  #Los tres métodos siguientes sobrecargan el único constructor que se puede definir en Ruby.
  def self.new_level_number_of_treasures(t, l, n_visible, n_hidden)
    new(t, l, n_visible, n_hidden, Array.new, Array.new, false)
  end
  
  def self.new_level_specific_treasures(t, l, v, h)
    new(t, l, 0, 0, v, h, false)
  end
  
  def self.new_death(t, death)
    new(t, 0, 0, 0, Array.new, Array.new, death)
  end
  
  def adjust_to_fit_treasure_lists(v, h)
    t = @text
    l = @levels, result_n_visible_treasures = 0, result_n_hidden_treasures = 0
    result_specific_visible_treasures = Array.new, result_specific_hidden_treasures = Array.new
    
    if(@n_visible_treasures > 0 || @n_hidden_treasures > 0)
      result_n_visible_treasures = (v.size - @n_visible_treasures) % v.size
      result_n_hidden_treasures = (h.size - @n_hidden_treasures) % h.size
      b_c = BadConsequence.new(t, l, result_n_visible_treasures, result_n_hidden_treasures)
      
    elsif(!@specific_visible_treasures.empty? || !@specific_hidden_treasures.empty?)
      @specific_visible_treasures.each do m_v_treasure
        v.each do |p_v_treasure|
          if(m_v_treasure == p_v_treasure.type)
            result_specific_visible_treasures << m_v_treasure
            v.delete(p_v_treasure)
            break
          end
        end
      end
      
      @specific_hidden_treasures.each do m_h_treasure
        h.each do |p_h_treasure|
          if(m_h_treasure == p_h_treasure.type)
            result_specific_hidden_treasures << m_h_treasure
            h.delete(p_h_treasure)
            break
          end
        end
      end
      
      b_c = BadConsequence.new(t, l, result_specific_visible_treasures, result_specific_hidden_treasures)
      
    else
      b_c = BadConsequence.new(t, l, 0, 0)
    end
    
    b_c
  end
  
  def to_s
    "Mal rollo: #{@text} \n Niveles: #{@levels} \n Muerte: #{@death}"
  end
end
