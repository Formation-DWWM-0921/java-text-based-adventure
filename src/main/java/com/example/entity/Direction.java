package com.example.entity;

/**
 * Représente une direction que le joueur peut emprunter pour se déplacer d'un lieu à l'autre.
 */
public class Direction
{
    /**
     * Le nom de la direction
     */
    private String name;

    /**
     * Crée une nouvelle direction
     * @param name Le nom de la direction
     */
    public Direction(String name)
    {
        this.name = name;
    }

    /**
     * @return Le nom de la direction
     */
    public String getName()
    {
        return name;
    }
}
