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

module Napakalaki
  class Monster
    def initialize(n, l, p, b)
      @name = n
      @combat_level = l
      @bad_consequence = b
      @prize = p
    end

    attr_reader :name, :combat_level, :bad_consequence

    #Devuelve el número de niveles ganados proporcionados por su buen rollo.
    def get_levels_gained
      return @prize.levels
    end

    #Devuelve el número de tesoros ganados proporcionados por su buen rollo.
    def get_treasures_gained
      return @prize.treasures
    end

    def to_s
      "Nombre: #{@name} \n Nivel de combate: #{@combat_level}"
    end
  end
end
