package com.example.entity.command;

import com.example.entity.Room;
import com.example.game.Game;

/**
 * Représente une direction que le joueur peut emprunter pour se déplacer d'un lieu à l'autre.
 */
public class DirectionCommand implements Command
{
    /**
     * La partie en cours
     */
    private Game game;
    /**
     * Le nom de la direction
     */
    private String name;

    /**
     * Crée une nouvelle direction
     * @param name Le nom de la direction
     */
    public DirectionCommand(Game game, String name)
    {
        this.game = game;
        this.name = name;
    }

    /**
     * Exécute la commande
     */
    public void execute()
    {
        // Demande au lieu actuel de trouver le lieu d'arrivée lorsqu'on emprunte cette direction
        Room room = game.getCurrentRoom().getRoomInDirection(this);
        // Si ce lieu n'existe pas
        if (room == null) {
            System.out.println("You cannot go in that direction!");
            return;
        }
        // Si ce lieu existe, change le lieu actuel pour le nouveau lieu
        game.setCurrentRoom(room);;
        return;
    }

    /**
     * Tente de traiter une saisie utilisateur
     * @param userInput La saisie utilisateur à traiter
     * @return Vrai si la commande a réussi à traiter la saisie, faux sinon
     */
    public boolean process(String userInput)
    {
        if (userInput.equals(name)) {
            execute();
            return true;
        }
        return false;
    }

    /**
     * @return Le nom de la direction
     */
    public String getName()
    {
        return name;
    }
}
