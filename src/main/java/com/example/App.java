package com.example;

import com.example.game.Game;

/**
 * Hello world!
 */
public class App 
{
    public static void main( String[] args )
    {
        // Crée une nouvelle partie
        Game game = new Game();
        // Initialise la partie
        game.setup();
        // Tant que la partie est en cours d'exécution
        while (game.isRunning()) {
            // Exécute un tour de jeu
            game.update();
        }
    }
}
