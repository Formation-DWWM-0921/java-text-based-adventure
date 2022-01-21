package com.example.entity.effect;

import com.example.entity.Item;
import com.example.entity.command.ItemCommand;
import com.example.game.Game;

/**
 * Représente un effet permettant de terminer la partie en cours
 */
public class EndGameEffect extends Effect
{
    /**
     * La partie en cours
     */
    private Game game;

    /**
     * Crée un nouvel effet
     * @param command La commande qui déclenche l'effet
     * @param item L'élément interactif qui déclenche l'effet lorsque la commande est utilisée avec
     */
    public EndGameEffect(ItemCommand command, Item item, Game game)
    {
        super(command, item);
        this.game = game;
    }

    /**
     * Déclenche l'effet
     */
    public void trigger()
    {
        game.terminate();
    }
}
