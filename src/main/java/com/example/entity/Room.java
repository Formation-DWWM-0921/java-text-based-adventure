package com.example.entity;

import java.util.ArrayList;
import java.util.List;

import com.example.entity.command.DirectionCommand;

/**
 * Représente un lieu de l'univers de jeu dans lequel le joueur peut se trouver.
 */
public class Room
{
    /**
     * Le nom du lieu
     */
    private String name;
    /**
     * La description du lieu
     */
    private String description;
    /**
     * La liste de tous les éléments interactifs présents dans ce lieu
     */
    private List<Item> items;
    /**
     * La liste de tous les passages qui partent de ce lieu
     */
    private List<RoomConnection> connectionsFrom;

    /**
     * Crée un nouveau lieu
     * @param name Le nom du lieu
     * @param description La description du lieu
     */
    public Room(String name, String description)
    {
        this.name = name;
        this.description = description;
        items = new ArrayList<>();
        connectionsFrom = new ArrayList<>();
    }

    /**
     * @param direction La direction à emprunter
     * @return Le lieu où l'on arrive lorsque l'on part de ce lieu
     */
    public Room getRoomInDirection(DirectionCommand direction)
    {
        // Cherche parmi tous les passages partant de ce lieu
        for (RoomConnection connection : connectionsFrom) {
            // Si ce passage emprunte la direction demandée
            if (connection.getDirection() == direction) {
                // Renvoie le lieu d'arrivée de ce passage
                return connection.getToRoom();
            }
        }
        // Si aucun passage partant de ce lieu n'emprunte la direction demandée
        return null;
    }

    /**
     * @return Le nom du lieu
     */
    public String getName()
    {
        return name;
    }

    /**
     * @return La description du lieu
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * @return La liste de tous les éléments interactifs présents dans ce lieu
     */
    public List<Item> getItems()
    {
        return items;
    }

    /**
     * Ajoute un élément interactif à la liste des éléments interactifs présents dans ce lieu
     * @param item L'élément interactif à ajouter
     */
    public void addItem(Item item)
    {
        items.add(item);
    }

    /**
     * @return La liste de tous les passages qui partent de ce lieu
     */
    public List<RoomConnection> getConnectionsFrom()
    {
        return connectionsFrom;
    }

    /**
     * Ajoute un passage partant de ce lieu à a liste de tous les passages existants
     * @param connection Le passage à rajouter
     */
    public void addConnectionFrom(RoomConnection connection)
    {
        connectionsFrom.add(connection);
    }
}
