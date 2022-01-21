package com.example.entity.effect;

import com.example.entity.Item;
import com.example.entity.Room;
import com.example.entity.command.ItemCommand;
import com.example.game.Game;

/**
 * Représente un effet permettant de changer de lieu
 */
public class ChangeCurrentRoomEffect extends Effect
{
    /**
     * Le lieu dans lequel l'effet doit déplacer le joueur
     */
    private Room targetRoom;
    /**
     * La partie en cours
     */
    private Game game;

    /**
     * Crée un nouvel effet
     * @param command La commande qui déclenche l'effet
     * @param item L'élément interactif qui déclenche l'effet lorsque la commande est utilisée avec
     * @param targetRoom Le lieu dans lequel l'effet doit déplacer le joueur
     * @param game La partie en cours
     */
    public ChangeCurrentRoomEffect(ItemCommand command, Item item, Room targetRoom, Game game)
    {
        super(command, item);
        this.targetRoom = targetRoom;
        this.game = game;
    }

    /**
     * Déclenche l'effet
     */
    public void trigger()
    {
        game.setCurrentRoom(targetRoom);
    }
}
