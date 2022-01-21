package com.example.entity.command;

import java.util.ArrayList;
import java.util.List;

import com.example.entity.Item;
import com.example.entity.Room;
import com.example.entity.RoomConnection;
import com.example.game.Game;

/**
 * Commande globale permettant d'afficher la description du lieu dans lequel le joueur se trouve actuellement
 */
public class LookCommand implements Command
{
    /**
     * La partie en cours
     */
    private Game game;

    /**
     * Crée une nouvelle commande
     * @param game La partie en cours
     */
    public LookCommand(Game game)
    {
        this.game = game;
    }

    /**
     * Exécute la commande
     */
    public void execute()
    {
        // Récupère le lieu dans lequel le joueur se trouve actuellement
        Room currentRoom = game.getCurrentRoom();
        // Affiche la description du lieu
        System.out.println(String.format("You are in the %s.", currentRoom.getName()));
        System.out.println(currentRoom.getDescription());
        // Affiche la liste des éléments interactifs présents dans le lieu
        if (currentRoom.getItems().isEmpty()) {
            System.out.println("No available items.");
        } else {
            System.out.print("Available items: ");
            List<String> itemNames = new ArrayList<>();
            for (Item item : currentRoom.getItems()) {
                itemNames.add(item.getName());
            }
            System.out.println(String.join(", ", itemNames) + ".");
        }
        // Affiche la liste des directions disponibles à partir du lieu
        System.out.print("Available directions: ");
        List<String> directionsNames2 = new ArrayList<>();
        for (RoomConnection connection : currentRoom.getConnectionsFrom()) {
            directionsNames2.add(connection.getDirection().getName());
        }
        System.out.println(String.join(", ", directionsNames2) + ".");
        return;
    }

    /**
     * Tente de traiter une saisie utilisateur
     * @param userInput La saisie utilisateur à traiter
     * @return Vrai si la commande a réussi à traiter la saisie, faux sinon
     */
    public boolean process(String userInput)
    {
        if (userInput.equals("look")) {
            execute();
            return true;
        }
        return false;
    }
}
