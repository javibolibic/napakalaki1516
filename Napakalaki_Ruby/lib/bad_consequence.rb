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
  def BadConsequence::maxtreasures
    @@MAXTREASURES = 10
  end

  def initialize(t, l)
    @text = t
    @levels = l
  end
  
  private_class_method :new #Clase abstracta
  
  attr_accessor :text, :levels, :n_visible_treasures, :n_hidden_treasures, :specific_visible_treasures, :specific_hidden_treasures, :MAXTREASURES

  #Devuelve true cuando el mal rollo que tiene que cumplir el jugador está vacío, eso
  #significa que el conjunto de atributos del mal rollo indican que no hay mal rollo que
  #cumplir
  def is_empty
    raise NotImplementError.new
  end

  def substract_visible_treasure(t)
    raise NotImplementError.new
  end

  def substract_hidden_treasure(t)
    raise NotImplementError.new
  end

  def adjust_to_fit_treasure_lists(v, h)
    raise NotImplementError.new
  end

  def to_s
    malrollo = "Mal rollo: \n" + "Nombre: " + @text + "\n"
    if(@levels != 0)
      malrollo += "Niveles perdidos: " + @levels.to_s + "\n"
    end
    
    return malrollo
  end
end

