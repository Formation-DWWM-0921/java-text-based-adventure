package com.example.entity.effect;

import com.example.entity.Command;
import com.example.entity.Item;

/**
 * Représente un effet qui se déclenche lorsque le joueur utilise une commande sur un élément interactif
 */
abstract public class Effect
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
     * Crée un nouvel effet
     * @param command La commande qui déclenche l'effet
     * @param item L'élément interactif qui déclenche l'effet lorsque la commande est utilisée avec
     */
    public Effect(Command command, Item item)
    {
        this.command = command;
        this.item = item;
        // Ajoute le nouvel effet à la liste de tous les effets produits par la commande qui lui a été assignée
        command.addEffect(this);
        // Ajoute le nouvel effet à la liste de tous les effets produits par l'élément interactif qui lui a été assigné
        item.addEffect(this);
    }

    /**
     * Déclenche l'effet
     */
    abstract public void trigger();

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
