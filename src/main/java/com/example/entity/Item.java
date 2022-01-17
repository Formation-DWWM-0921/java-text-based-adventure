package com.example.entity;

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
}
