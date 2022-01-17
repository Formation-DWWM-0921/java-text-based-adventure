package com.example.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.example.entity.Item;
import com.example.entity.Room;

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
     * La liste de tous les lieux existant dans l'univers du jeu
     */
    private Room[] rooms;
    /**
     * Le jeu est-il en cours d'exécution?
     */
    private boolean isRunning;

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

        // Crée les lieux
        Room bedroom = new Room("bedroom", "This is where you usually sleep. It's quite small, but at least the bed is comfy.");
        Room bathroom = new Room("bathroom", "This is the bathroom. There's no windows in there, so it tends to get easily dank.");
        Room kitchen = new Room("kitchen", "This is the kitchen. It still smells of yesterday's dinner.");
        // Crée les éléments interactifs
        new Item(bedroom, "bed");
        new Item(bedroom, "curtains");
        new Item(bathroom, "shower");
        new Item(bathroom, "toothbrush");
        new Item(kitchen, "cookie");
        new Item(kitchen, "faucet");

        // Crée une liste contenant tous les lieux
        this.rooms = new Room[] { bedroom, bathroom, kitchen };
    }

    /**
     * Décrit un cycle d'exécution de la partie
     */
    public void update()
    {
        System.out.println("");
        // Attend une saisie utilisateur
        String userInput = scanner.nextLine();

        // Cherche si la saisie utilisateur correspond à un lieu existant
        for (Room room : rooms) {
            // Si la saisie utilisateur correspond exactement au nom du lieu
            if ( userInput.equals(room.getName()) ) {
                // Affiche la description du lieu
                System.out.println(room.getDescription());
                // Affiche la liste des éléments interactifs présents dans le lieu
                if (room.getItems().isEmpty()) {
                    System.out.println("No available items.");
                } else {
                    System.out.print("Available items: ");
                    List<String> itemNames = new ArrayList<>();
                    for (Item item : room.getItems()) {
                        itemNames.add(item.getName());
                    }
                    System.out.println(String.join(", ", itemNames) + ".");
                }
                return;
            }
        }

        // Si la saisie utilisateur ne correspond à aucun lieu existant
        System.out.println("This place doesn't exist!");
    }

    /**
     * Permet de savoir si la partie est en cours
     * @return
     */
    public boolean isRunning()
    {
        return isRunning;
    }
}
