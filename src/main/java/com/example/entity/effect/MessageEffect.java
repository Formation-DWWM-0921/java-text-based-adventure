package com.example.entity.effect;

import com.example.entity.Command;
import com.example.entity.Item;

/**
 * Représente un effet permettant d'afficher un message
 */
public class MessageEffect
{
    /**
     * La commande qui déclenche l'effet
     */
    private Command command;
    /**
     * L'élément interactif qui déclenche l'effet lorsque la commande est utilisée avec
     */
    private Item item;
    /**
     * Le message à afficher
     */
    private String message;

    /**
     * Crée un nouvel effet permettant d'afficher un message
     * @param command La commande qui déclenche l'effet
     * @param item L'élément interactif qui déclenche l'effet lorsque la commande est utilisée avec
     * @param message Le message à afficher
     */
    public MessageEffect(Command command, Item item, String message)
    {
        this.command = command;
        this.item = item;
        this.message = message;
        // Ajoute le nouvel effet à la liste de tous les effets produits par la commande qui lui a été assignée
        command.addEffect(this);
        // Ajoute le nouvel effet à la liste de tous les effets produits par l'élément interactif qui lui a été assigné
        item.addEffect(this);
    }

    /**
     * @return Le message à afficher
     */
    public String getMessage()
    {
        return message;
    }
    
    /**
     * @return L'élément interactif qui déclenche l'effet lorsque la commande est utilisée avec
     */
    public Item getItem()
    {
        return item;
    }

    /**
     * @return La commande qui déclenche l'effet
     */
    public Command getCommand()
    {
        return command;
    }
}

