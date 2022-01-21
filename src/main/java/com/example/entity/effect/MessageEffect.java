package com.example.entity.effect;

import com.example.entity.Item;
import com.example.entity.command.ItemCommand;

/**
 * Représente un effet permettant d'afficher un message
 */
public class MessageEffect extends Effect
{
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
    public MessageEffect(ItemCommand command, Item item, String message)
    {
        // Appelle le constructeur de Effect en lui passant les données dont il a besoin
        super(command, item);
        this.message = message;
    }

    /**
     * Déclenche l'effet
     */
    public void trigger()
    {
        System.out.println(message);
    }

    /**
     * @return Le message à afficher
     */
    public String getMessage()
    {
        return message;
    }
}

