package com.example.entity.command;

import com.example.game.Game;

/**
 * Commande globale permettant d'arrêter la partie en cours
 */
public class ExitCommand implements Command
{
    /**
     * La partie en cours
     */
    private Game game;

    /**
     * Crée une nouvelle commande
     * @param game La partie en cours
     */
    public ExitCommand(Game game)
    {
        this.game = game;
    }

    /**
     * Tente de traiter une saisie utilisateur
     * @param userInput La saisie utilisateur à traiter
     * @return Vrai si la commande a réussi à traiter la saisie, faux sinon
     */
    public boolean process(String userInput)
    {
        if (userInput.equals("exit")) {
            game.terminate();
            return true;
        }
        return false;
    }
}
