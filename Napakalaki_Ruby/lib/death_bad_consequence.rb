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

require_relative 'numeric_bad_consequence'

class DeathBadConsequence < NumericBadConsequence

  def initialize(t, death)
    super(t, Player.MAXLEVEL, BadConsequence.MAXTREASURES, BadConsequence.MAXTREASURES)
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

  attr_reader :death
  
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
    if(@death == true)
      malrollo += "Estás muerto.\n"
    end
    
    return malrollo
  end
end
