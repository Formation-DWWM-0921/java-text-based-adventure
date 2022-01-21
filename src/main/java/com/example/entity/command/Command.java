package com.example.entity.command;

/**
 * Représente une commande que l'utilisateur peut écrire dans la console
 */
public interface Command
{
    /**
     * Tente de traiter une saisie utilisateur
     * @param userInput La saisie utilisateur à traiter
     * @return Vrai si la commande a réussi à traiter la saisie, faux sinon
     */
    public boolean process(String userInput);
}
