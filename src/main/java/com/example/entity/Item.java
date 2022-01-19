package com.example.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * Représente un élément de l'univers de jeu, avec lequel le joueur pourra interagir.
 */
public class Item
{
    /**
     * Le lieu dans lequel se trouve l'élément interactif
     */
    private Room room;
    /**
     * Le nom de l'élément interactif
     */
    private String name;
    /**
     * L'élément interactif est-il visible et utilisable?
     */
    private boolean visible;
    /**
     * La liste qui associe à chaque commande possible l'effet à réaliser lorsqu'elle est utilisée sur cet élément
     */
    private Map<Command, String> effects;

    /**
     * Crée un nouvel élément interactif visible
     * @param room Le lieu dans lequel se trouve l'élément interactif
     * @param name Le nom de l'élément interactif
     */
    public Item(Room room, String name)
    {
        this.room = room;
        this.name = name;
        this.visible = true;
        // Ajoute le nouvel élément interactif à la liste de tous les éléments présents dans le lieu qui lui a été assigné
        room.addItem(this);
        effects = new HashMap<>();
    }

    /**
     * Crée un nouvel élément interactif
     * @param room Le lieu dans lequel se trouve l'élément interactif
     * @param name Le nom de l'élément interactif
     * @param visible L'élément interactif est-il visible et utilisable?
     */
    public Item(Room room, String name, boolean visible)
    {
        this.room = room;
        this.name = name;
        this.visible = visible;
        // Ajoute le nouvel élément interactif à la liste de tous les éléments présents dans le lieu qui lui a été assigné
        room.addItem(this);
        effects = new HashMap<>();
    }

    /**
     * @return Le lieu dans lequel se trouve l'élément interactif
     */
    public Room getRoom() {
        return room;
    }

    /**
     * @return Le nom de l'élément interactif
     */
    public String getName() {
        return name;
    }

    /**
     * @return L'élément interactif est-il visible et utilisable?
     */
    public boolean isVisible() {
        return visible;
    }

    /**
     * @param command La commande à réaliser
     * @return L'effet à réaliser lorsque l'on utilise une commande sur cet élément
     */
    public String getEffect(Command command)
    {
        return effects.get(command);
    }

    /**
     * Associe un effet à une commande lorsqu'elle est utilisée sut cet élément
     * @param command La commande à utiliser
     * @param message Le message à afficher
     */
    public void addEffect(Command command, String message)
    {
        effects.put(command, message);
    }
}
