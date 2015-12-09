# encoding: utf-8

# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

#última

require 'singleton'
require_relative 'napakalaki'
require_relative 'command'

module Test

class GameTester

  include Singleton
 
  public
  def play(a_game, number_of_players)
    
    @game = a_game
    names = get_player_names(number_of_players)
    @game.init_game(names) 
    
    begin #Mientras dure la partida
      current_player=@game.current_player()
      begin #Mientras el jugador se decide a conocer al monstruo
        puts "******* ******* ******* ******* ******* ******* *******"
        puts "\n\n Turno de: " + current_player.to_s() 
        command = get_command_before_knowing_monster()
        command = process_command(command, current_player)        
      end while (command != Command::Exit && command != Command::ShowMonster)
      if (command == Command::ShowMonster) then
        begin #Mientras el jugador se decida a combatir 
          puts "******* ******* ******* ******* ******* ******* *******"
          puts "\n\n Turno de: " + current_player.to_s()
          command = get_command_before_fighting()
          command = process_command(command, current_player)
        end while (command != Command::Exit && command != Command::Combat)
        if (command == Command::Combat) then
          combat_result = @game.develop_combat()
          case combat_result
            when Napakalaki::CombatResult::WINGAME then 
              puts "\n\n       " + current_player.get_name()
              puts "\n\n HAS GANADO LA PARTIDA"
              #break está implícito            
            when Napakalaki::CombatResult::WIN then
              puts "\n\n Ganaste el combate"
            when Napakalaki::CombatResult::LOSE then
              puts "\n\n Has perdido el combate, te toca cumplir el mal rollo"
           end #case
           if (combat_result != Napakalaki::CombatResult::WINGAME) then
            begin #Hasta que se avance de turno 
              puts "******* ******* ******* ******* ******* ******* *******"
              puts "\n\n Turno de: " + current_player.to_s()
              if current_player.can_i_steal then
                command = get_command_after_fighting()
              else
                command = get_command_after_fighting_no_steal()
              end
              command = process_command(command, current_player)
            end while (command != Command::Exit && command != Command::NextTurnAllowed)
          else 
            command = Command::Exit;
          end #if WINANDWINGAME  
        end #if COMBAT
      end #if SHOWMOnSTER
    end while (command != Command::Exit) #mientras dure la partida

  end
  
  private
  
  def get_command_after_fighting()
      commands = [Command::ShowMonster, Command::ShowVisibleTreasure, Command::ShowHiddenTreasure, 
      Command::DiscardVisibleTreasure, Command::DiscardHiddenTreasure, Command::DiscardAll,
      Command::MakeTreasureVisible, Command::StealTreasure, Command::NextTurn, Command::Exit]
      manage_menu("Opciones antes de pasar turno", commands)
  end
  
  def get_command_after_fighting_no_steal()
      commands = [Command::ShowMonster, Command::ShowVisibleTreasure, Command::ShowHiddenTreasure, 
      Command::DiscardVisibleTreasure, Command::DiscardHiddenTreasure, Command::DiscardAll,
      Command::MakeTreasureVisible, Command::NextTurn, Command::Exit]
      manage_menu("Opciones antes de pasar turno", commands)
  end
  
  def get_command_before_fighting ()
      commands = [Command::ShowMonster, Command::ShowVisibleTreasure, Command::ShowHiddenTreasure, 
      Command::Combat, Command::Exit]
      manage_menu("Opciones antes de combatir", commands)
  end
  
  def get_command_before_knowing_monster () 
      commands = [Command::ShowMonster,Command::ShowVisibleTreasure, Command::ShowHiddenTreasure, 
      Command::MakeTreasureVisible,  Command::Exit]      
      manage_menu("Opciones antes de conocer al monstruo", commands)
  end
  
  def get_player_names (number_of_players) 
    names = Array.new
    for i in 1..number_of_players
      puts "Escribe el nombre del jugador #{i}: "
      names << gets.chomp
    end
    names
  end

  def get_treasure (how_many) 
    
    valid_input = true
    option = Command::GoBack.menu
    puts "\n Elige un tesoro: "
    capture = gets.chomp
    
    begin #tratar la excepcion
      option = Integer(capture)
      if (option < Command::GoBack.menu || option > how_many) then #no se ha escrito un entero en el rango permitido
        valid_input = false
      end
    rescue Exception => e  
      valid_input = false
    end
    
    if (! valid_input) then
      input_error_message() 
      return -2  # Muestra de nuevo el menu y pide otra entrada
    end
    option
  end
  
  def input_error_message () 
    puts "\n\n ERROR !!! \n\n Selección errónea. Inténtalo de nuevo.\n\n"
  end
    
  def manage_discard_treasures (visible, a_player)
     
    begin #Se descartan tesoros hasta que se vuelve al menÃº anterior
      if visible then
        how_many = show_treasures("Elige tesoros visibles para descartar", a_player.visible_treasures(), true)
      else 
        how_many = show_treasures("Elige tesoros ocultos para descartar", a_player.hidden_treasures(), true)
      end
      option = get_treasure (how_many)
      if (option > -1) then 
        if visible then
          @game.discard_visible_treasures ([a_player.visible_treasures.at(option)])
        else
          @game.discard_hidden_treasures ([a_player.hidden_treasures.at(option)])          
        end
      end
    end while (option != -1)  
  end
  
  def manage_make_treasure_visible (a_player)
       
    begin #Se hacen tesoros visibles hasta que se vuelve al menÃº anterior
      how_many = show_treasures("Elige tesoros para intentar hacerlos visibles", a_player.hidden_treasures, true)
      option = get_treasure (how_many);
      if (option > -1) then
        a_player.make_treasure_visible(a_player.hidden_treasures.at(option))
      end
    end while (option != -1)
  end
  
  def manage_menu (message, menu) 
    menu_check = Hash.new #Para comprobar que se hace una selecciÃ³n vÃ¡lida
    menu.each do |c|
      menu_check [c.menu] = c
    end    
    begin #Hasta que se hace una selecciÃ³n vÃ¡lida
      valid_input = true
      option = Command::GoBack.menu
      puts ("\n\n------- ------ ------ ------ ------ ------ ------")
      puts "**** " + message + " ****\n"
      menu.each do |c| #se muestran las opciones del menÃº
        puts "#{c.menu}" + " : " + c.text
      end
      puts "\n Elige una opción: "
      capture = gets.chomp
      begin
        option = Integer(capture)
        if (! menu_check.has_key?(option)) #No es un entero entre los vÃ¡lidos
          valid_input = false
        end
      rescue Exception => e  #No se ha introducido un entero
        valid_input = false
      end  
      
      if (! valid_input) then
        input_error_message()
      end
    end while (! valid_input)
    menu_check[option]    
  end
    
  def process_command (command, a_player) 
    case command 
      when Command::Exit then 
        puts "exit"
      when Command::Combat then
        puts "combat"
#        puts "pulsa enter para seguir"
#        gets
      when  Command::ShowMonster then 
        puts "\n------- ------- ------- ------- ------- ------- ------- "
        puts "El monstruo actual es:\n\n" + @game.current_monster().to_s()
#        puts "pulsa enter para seguir"
#        gets
      when Command::ShowVisibleTreasure then
        show_treasures("Esta es tu lista de tesoros visibles", a_player.visible_treasures, false)
#        puts "pulsa enter para seguir"
#        gets
      when Command::ShowHiddenTreasure then
        show_treasures("Esta es tu lista de tesoros ocultos", a_player.hidden_treasures, false)
#        puts "pulsa enter para seguir"
#        gets
      when Command::MakeTreasureVisible then
        manage_make_treasure_visible (a_player)
#        puts "pulsa enter para seguir"
#        gets
      when Command::DiscardVisibleTreasure then
        manage_discard_treasures(true, a_player)
#        puts "pulsa enter para seguir"
#        gets
      when Command::DiscardHiddenTreasure then
        manage_discard_treasures(false, a_player)
#        puts "pulsa enter para seguir"
#        gets
      when Command::DiscardAll then
        a_player.discard_all_treasures
      when Command::StealTreasure then
        a_treasure = a_player.steal_treasure;
        if a_treasure == nil
          puts "\n\n No has podido robar nada \n\n"
        else
          puts "\n\n Has robado este tesoro: \n\n #{a_treasure.to_s}"
        end
      when Command::NextTurn then
        if ! @game.next_turn() then
          puts "\n\n ERROR \n"
          puts "No cumples las condiciones para pasar de turno."
          puts "O bien tienes más de 4 tesoros ocultos"
          puts "O bien te queda mal rollo por cumplir"
        else 
          command = Command::NextTurnAllowed
        end
#        puts "pulsa enter para seguir"
#        gets
    end
    command
  end
  
  def show_treasures (message, treasures, menu)
    option_menu = Command::GoBack.menu

    puts "\n------- ------- ------- ------- ------- ------- -------"
    puts message 
    if menu then
      puts "\n #{Command::GoBack.menu} : " + Command::GoBack.text
    end
    treasures.each do |t|
      option_menu = option_menu + 1
      if (menu)
         puts "\n" + option_menu.to_s() + ":" + t.to_s()
      else 
         puts "\n" + t.to_s()
      end
     
    end
    option_menu
  end
 
 end #clase
end #modulo
