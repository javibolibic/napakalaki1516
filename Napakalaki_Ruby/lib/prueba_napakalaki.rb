# encoding utf-8

=begin
********************************************************************
** Creado por Javier Bolívar Valverde <javibolivar@correo.ugr.es> **
** Programación y Diseño Orientado a Objetos                      **
** Grado en Ingeniería Informática                                **
********************************************************************
=end

require_relative 'bad_consequence'
require_relative 'monster'
require_relative 'treasure_kind'
require_relative 'prize'

# Devuelve los monstruos cuyo nivel de combate es superior a 10
def lvl_exceeding_10(monstruos)
  for monstruo in monstruos
    monsters::monstruo if (monstruo.combatLevel > 10)
  end
  return monsters
end

# Devuelve los monstruos cuyo mal rollo implique sólo pérdida de niveles.
def loss_level(monstruos, bc)
  for monstruo in monstruos
    monsters::monstruo if bc.levels != 0
  end
  return monsters
end

# Devuelve los monstruos cuyo buen rollo indica ganancia de niveles superior a 1
def prize_is_upper_1(monstruos, prize)
  for monstruo in monstruos
    monsters::monstruo if prize.level > 1
  end
  return monsters
end

# Devuelve los monstruos cuyo mal rollo supone la pérdida de algún tipo determinado de tesoros
def any_bc(monstruos, bc)
  for monstruo in monstruos
    monsters::monstruo if (bc.specificHiddenTreasures != nil || bc.specificVisibleTreasures != nil)
  end
  return monsters
end

monsters = Array.new

# Monstruo 1: 3 Byakhees de bonanza
prize = Prize.new(2, 1)
bad_consequence = BadConsequence.newLevelSpecificTreasures('Pierdes tu armadura visible y otra oculta.', 0, [TreasureKind::ARMOR], [TreasureKind::ARMOR])
monsters << Monster.new('2 Byakhees de bonanza', 8, prize, badConsequence)

# Monstruo 2: Chibithulhu
prize = Prize.new(1, 1)
bad_consequence = BadConsequence.newLevelSpecificTreasures('Embobados con el lindo primigenio te descargas de tu casco visible.', 0, [TreasureKind::HELMET], nil)
monsters << Monster.new('Chibithulhu', 2, prize, badConsequence)

# Monstruo 3: El sopor de Dunwich
prize = Prize.new(1, 1)
bad_consequence = BadConsequence.newLevelSpecificTreasures('El primordial bostezo contagioso. Pierdes el calzado visible.', 0, [TreasureKind::SHOES], nil)
monsters << Monster.new('El sopor de Dunwich', 2, prize, badConsequence)

# Monstruo 4: Ángeles de la noche ibicenca
prize = Prize.new(4, 1)
bad_consequence = BadConsequence.newLevelSpecificTreasures('Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta.', 0, [TreasureKind::ONEHAND], [TreasureKind::ONEHAND])
monsters << Monster.new('Ángeles de la noche ibicenca', 14, prize, badConsequence)

# Monstruo 5: El gorrón en el umbral
prize = Prize.new(3, 1)
bad_consequence = BadConsequence.newLevelSpecificTreasures('Pierdes todos tus tesoros visibles.', 0, [TreasureKind::ONEHAND, TreasureKind::BOTHHANDS, TreasureKind::ARMOR, TreasureKind::HELMET, TreasureKind::SHOES], nil)
monsters << Monster.new('El gorrón en el umbral', 10, prize, badConsequence)

# Monstruo 6: H.P. Munchcraft
prize = Prize.new(2, 1)
bad_consequence = BadConsequence.newLevelSpecificTreasures('Pierdes la armadura visible.', 0, [TreasureKind::ARMOR], nil)
monsters << Monster.new('H.P. Munchcraft', 6, prize, badConsequence)

# Monstruo 7: Bichgooth
prize = Prize.new(1, 1)
bad_consequence = BadConsequence.newLevelSpecificTreasures('Sientes bichos bajo la ropa. Descarga la armadura visible.', 0, [TreasureKind::ARMOR], nil)
monsters << Monster.new('Bichgooth', 2, prize, badConsequence)

# Monstruo 8: El rey de rosa
price = Prize.new(4, 2)
bad_consequence = BadConsequence.newLevelNumberOfTreasures('Pierdes 5 niveles y 3 tesoros visibles.', 5, 3, 0)
monsters << Monster.new('El rey de rosa', 13, prize, badConsequence)

# Monstruo 9: La que redacta en las tinieblas.
price = Prize.new(1, 1)
bad_consequence = BadConsequence.newLevelNumberOfTreasures('Toses los pulmones y pierdes 2 niveles.', 2, 0, 0)
monsters << Monster.new('La que redacta en las tinieblas', 2, prize, badConsequence)

# Monstruo 10: Los hondos
prize = Prize.new(2, 1)
bad_consequence = BadConsequence.newDeath('Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estás muerto.')
monsters << Monster.new('Los hondos', 8, prize, badConsequence)

# Monstruo 11: Semillas Cthulhu
price = Prize.new(2, 1)
bad_consequence = BadConsequence.newLevelNumberOfTreasures('Pierdes 2 niveles y 2 tesoros ocultos.', 2, 0, 2)
monsters << Monster.new('Semillas Cthulhu', 4, prize, badConsequence)

# Monstruo 12: Dameargo
prize = Prize.new(2, 1)
bad_consequence = BadConsequence.newLevelSpecificTreasures('Te intentas escaquear. Pierdes una mano visible.', 0, [TreasureKind::ONEHAND], nil)
monsters << Monster.new('Dameargo', 1, prize, badConsequence)

# Monstruo 13: Pollipólipo volante
price = Prize.new(1, 1)
bad_consequence = BadConsequence.newLevelNumberOfTreasures('Da mucho asquito. Pierdes 3 niveles.', 3, 0, 0)
monsters << Monster.new('Pollipólipo volante', 3, prize, badConsequence)

# Monstruo 14: Yskhtihyssg-Goth
prize = Prize.new(3, 1)
bad_consequence = BadConsequence.newDeath('No le hace gracia que pronuncien mal su nombre. Estás muerto.')
monsters << Monster.new('Yskhtihyssg-Goth', 12, prize, badConsequence)
        
# Monstruo 15: Familia feliz
prize = Prize.new(4, 1)
bad_consequence = BadConsequence.newLDeath('La familia te atrapa. Estás muerto.')
monsters << Monster.new('Familia feliz', 1, prize, badConsequence)

# Monstruo 16: Roboggoth
prize = Prize.new(2, 1)
bad_consequence = BadConsequence.newLevelSpecificTreasures('La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visible.', 2, [TreasureKind::BOTHHANDS], nil)
monsters << Monster.new('Roboggoth', 8, prize, badConsequence)

# Monstruo 17: El espía
prize = Prize.new(1, 1)
bad_consequence = BadConsequence.newLevelSpecificTreasures('Te asusta en la noche. Pierdes un casco visible.', 0, [TreasureKind::HELMET], nil)
monsters << Monster.new("El espía", 5, prize, badConsequence)
        
# Monstruo 18: El Lenguas
price = Prize.new(1, 1)
bad_consequence = BadConsequence.newLevelNumberOfTreasures('Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles.', 2, 5, 0)
monsters << Monster.new('El Lenguas', 20, prize, badConsequence)

# Monstruo 19: Bicéfalo
prize = Prize.new(1, 1)
bad_consequence = BadConsequence.newLevelSpecificTreasures('Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos.', 3, [TreasureKind::BOTHHANDS], nil)
monsters << Monster.new('Bicéfalo', 20, prize, badConsequence)
