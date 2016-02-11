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

class NumericBadConsequence < BadConsequence

  def initialize(t, l, n_visible, n_hidden)
    super(t, l)
    @n_visible_treasures = n_visible
    @n_hidden_treasures = n_hidden
  end
  
  attr_reader :n_visible_treasures, :n_hidden_treasures

  #Devuelve true cuando el mal rollo que tiene que cumplir el jugador está vacío, eso
  #significa que el conjunto de atributos del mal rollo indican que no hay mal rollo que
  #cumplir
  def is_empty
    empty = false    
    empty = true if (@n_hidden_treasures == 0 && @n_visible_treasures == 0)
    return empty
  end



  def substract_visible_treasure(t)
    if(@n_visible_treasures > 0)
      @n_visible_treasures -= 1
    end
  end

  def substract_hidden_treasure(t)
    if(@n_hidden_treasures > 0)
      @n_hidden_treasures -= 1
    end
  end

  def adjust_to_fit_treasure_lists(v, h)
    n_v = [v.size, @n_visible_treasures].min
    n_h = [h.size, @n_hidden_treasures].min
  end

  def to_s
    malrollo = "Mal rollo: \n" + "Nombre: " + @text + "\n"
    if(@levels != 0)
      malrollo += "Niveles perdidos: " + @levels.to_s + "\n"
    end
    if(@n_visible_treasures != 0)
      malrollo += "Tesoros visibles perdidos: " + @n_visible_treasures.to_s + "\n";
    end
    if(@n_hidden_treasures != 0)
      malrollo += "Tesoros ocultos perdidos: " + @n_visible_treasures.to_s + "\n";
    end
    
    return malrollo
  end
end
