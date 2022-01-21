package com.example.game;

import java.util.Scanner;

import com.example.entity.Item;
import com.example.entity.Room;
import com.example.entity.RoomConnection;
import com.example.entity.command.Command;
import com.example.entity.command.DirectionCommand;
import com.example.entity.command.ExitCommand;
import com.example.entity.command.ItemCommand;
import com.example.entity.command.LookCommand;
import com.example.entity.command.ResetCommand;
import com.example.entity.effect.ChangeCurrentRoomEffect;
import com.example.entity.effect.EndGameEffect;
import com.example.entity.effect.MessageEffect;

/**
 * Représente une partie jouée par le joueur.
 */
public class Game
{
    /**
     * Le gestionnaire qui surveille les saisies dans la console
     */
    private Scanner scanner;
    /**
     * La liste de toutes les commandes existantes
     */
    private Command[] commands;
    /**
     * Le jeu est-il en cours d'exécution?
     */
    private boolean isRunning;
    /**
     * Le lieu dans lequel le joueur se trouve actuellement
     */
    private Room currentRoom;
    /**
     * La commande permettant d'afficher la description du lieu actuel
     */
    private LookCommand lookCommand;

    /**
     * Crée une nouvelle partie
     */
    public Game()
    {
        scanner = new Scanner(System.in);
    }

    /**
     * Initialise la partie en créant les objets de l'univers
     */
    public void setup()
    {
        // Définit que la partie est en cours d'exécution
        isRunning = true;

        // Crée les commandes globales
        lookCommand = new LookCommand(this);
        ExitCommand exitCommand = new ExitCommand(this);
        ResetCommand resetCommand = new ResetCommand(this);
        // Crée les commandes interactives
        ItemCommand use = new ItemCommand(this, "use", "You have no idea how to use that.");
        ItemCommand open = new ItemCommand(this, "open", "This doesn't seem to open.");
        ItemCommand eat = new ItemCommand(this, "eat", "This doesn't seem edible.");
        // Crée les commandes de direction
        DirectionCommand east = new DirectionCommand(this, "east");
        DirectionCommand south = new DirectionCommand(this, "south");
        DirectionCommand west = new DirectionCommand(this, "west");
        DirectionCommand north = new DirectionCommand(this, "north");
        commands = new Command[] { lookCommand, exitCommand, resetCommand, east, south, west, north, use, open, eat };
        // Crée les lieux
        Room bedroom = new Room("bedroom", "This is where you usually sleep. It's quite small, but at least the bed is comfy.");
        Room bathroom = new Room("bathroom", "This is the bathroom. There's no windows in there, so it tends to get easily dank.");
        Room kitchen = new Room("kitchen", "This is the kitchen. It still smells of yesterday's dinner.");
        Room attic = new Room("attic", "Dusty.");
        // Crée les passages entre les lieux
        new RoomConnection(bedroom, bathroom, east);
        new RoomConnection(bathroom, bedroom, west);
        new RoomConnection(bedroom, kitchen, north);
        new RoomConnection(kitchen, bedroom, south);
        // Crée les éléments interactifs
        Item bed = new Item(bedroom, "bed");
        Item curtains = new Item(bedroom, "curtains");
        new Item(bathroom, "shower");
        new Item(bathroom, "toothbrush");
        Item cookie = new Item(kitchen, "cookie");
        new Item(kitchen, "faucet");
        Item liftInBedroom = new Item(bedroom, "lift");
        Item liftInAttic = new Item(attic, "lift");
        // Crée les effets des commandes sur les éléments interactifs
        new MessageEffect(use, bed, "You take a quick nap. You feel refreshed!");
        new MessageEffect(open, curtains, "You open the curtains and take a look outside.");
        new EndGameEffect(eat, cookie, this);
        new ChangeCurrentRoomEffect(use, liftInBedroom, attic, this);
        new ChangeCurrentRoomEffect(use, liftInAttic, bedroom, this);

        // Définit le lieu de départ du joueur
        setCurrentRoom(bedroom);
    }

    /**
     * Décrit un cycle d'exécution de la partie
     */
    public void update()
    {
        System.out.println("");

        // Attend une saisie utilisateur
        String userInput = scanner.nextLine();
        
        // Pour chaque commande possible, peu importe son type réel (commande globale, direction, interaction…)
        for (Command command : commands) {
            // Demande à la commande de traiter la saisie utilisateur. Si la commande correspond à la saisie utilisateur, elle réalise l'effet de la commande par elle-même, et la boucle est interrompue. Sinon, rien ne se passe.
            if (command.process(userInput)) {
                return;
            }
        }

        // Si aucune commande ne correspond à la saisie utilisateur
        System.out.println("This command doesn't exist!");
    }

    /**
     * Permet de savoir si la partie est en cours
     * @return
     */
    public boolean isRunning()
    {
        return isRunning;
    }

    /**
     * Arrête la partie
     */
    public void terminate()
    {
        isRunning = false;
    }

    /**
     * @return Le lieu dans lequel le joueur se trouve actuellement
     */
    public Room getCurrentRoom()
    {
        return currentRoom;
    }

    /**
     * Modifie le lieu dans lequel le joueur se trouve actuellement
     * @param room Le nouveau lieu
     */
    public void setCurrentRoom(Room room)
    {
        this.currentRoom = room;
        lookCommand.execute();
    }
}
