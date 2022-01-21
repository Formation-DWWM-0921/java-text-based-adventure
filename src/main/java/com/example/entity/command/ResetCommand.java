package com.example.entity.command;

import com.example.game.Game;

/**
 * Commande globale permettant de recommencer la partie à zéro
 */
public class ResetCommand implements Command
{
    /**
     * La partie en cours
     */
    private Game game;

    /**
     * Crée une nouvelle commande
     * @param game La partie en cours
     */
    public ResetCommand(Game game)
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
        if (userInput.equals("reset")) {
            game.setup();
            return true;
        }
        return false;
    }
}
