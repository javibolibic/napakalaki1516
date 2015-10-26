# encoding: utf-8

=begin
********************************************************************
** Creado por Javier Bolívar Valverde <javibolivar@correo.ugr.es> **
** Programación y Diseño Orientado a Objetos                      **
** Grado en Ingeniería Informática                                **
********************************************************************
=end

class Prize
  def initialize(treasures, level)
    @treasures = treasures
    @level = level
  end
  
  attr_reader :treasures, :level
  
  def to_s
    "Tesoros ganados: #{@treasures} \n Niveles ganados: #{@levels}"
  end
end
