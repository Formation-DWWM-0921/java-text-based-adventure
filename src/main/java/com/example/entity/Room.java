package com.example.entity;

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
     * Crée un nouveau lieu
     * @param name Le nom du lieu
     * @param description La description du lieu
     */
    public Room(String name, String description)
    {
        this.name = name;
        this.description = description;
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
}
