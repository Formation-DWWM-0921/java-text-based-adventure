package com.example.entity;

import java.util.ArrayList;
import java.util.List;

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
     * Crée un nouveau lieu
     * @param name Le nom du lieu
     * @param description La description du lieu
     */
    public Room(String name, String description)
    {
        this.name = name;
        this.description = description;
        items = new ArrayList<>();
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
}
