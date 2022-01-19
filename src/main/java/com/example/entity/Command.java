package com.example.entity;

/**
 * Une action que le joueur peut utiliser sur un élément interactif
 */
public class Command
{
    /**
     * Le nom de la commande
     */
    private String name;
    /**
     * Le message par défaut à afficher lorsque la commande est utilisée avec un élément interactif non prévu pour
     */
    private String defaultMessage;

    /**
     * Crée une nouvelle commande
     * @param name Le nom de la commande
     * @param defaultMessage Le message par défaut à afficher lorsque la commande est utilisée avec un élément interactif non prévu pour
     */
    public Command(String name, String defaultMessage)
    {
        this.name = name;
        this.defaultMessage = defaultMessage;
    }

    /**
     * @return Le nom de la commande
     */
    public String getName()
    {
        return name;
    }

    /**
     * @return Le message par défaut à afficher lorsque la commande est utilisée avec un élément interactif non prévu pour
     */
    public String getDefaultMessage()
    {
        return defaultMessage;
    }
}
