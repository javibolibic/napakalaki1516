# encoding: utf-8

=begin
********************************************************************
** Creado por Javier Bolívar Valverde <javibolivar@correo.ugr.es> **
** Programación y Diseño Orientado a Objetos                      **
** Grado en Ingeniería Informática                                **
********************************************************************
=end

class BadConsequence
  def initialize(atext, someLevels, someVisibleTreasures, someHiddenTreasures, someSpecificVisibleTreasures, someSpecificHiddenTreasures, death)
    @text = atext
    @levels = someLevels
    @nVisibleTreasures = someVisibleTreasures
    @nHiddenTreasures = someHiddenTreasures
    @specificVisibleTreasures = someSpecificVisibleTreasures
    @specificHiddenTreasures = someSpecificHiddenTreasures
    @death = death
  end
  private_class_method :new
  attr_reader :text, :levels, :nVisibleTreasures, :nHiddenTreasures, :specificVisibleTreasures, :specificHiddenTreasures, :death
  
  def self.newLevelNumberOfTreasures(aText, someLevels, someVisibleTreasures, someHiddenTreasures)
    new(aText, someLevels, someVisibleTreasures, someHiddenTreasures, nil, nil, false)
  end
  
  def self.newLevelSpecificTreasures(aText, someLevels, someSpecificVisibleTreasures, someSpecificHiddenTreasures)
    new(aText, someLevels, nil, nil, someSpecificVisibleTreasures, someSpecificHiddenTreasures, false)
  end
  
  def self.newDeath(aText)
    new(aText, nil, nil, nil, nil, nil, true)
  end
  
  def to_s
    "Mal rollo: #{@text} \n Niveles: #{@levels} \n Muerte: #{@death}"
  end
end
