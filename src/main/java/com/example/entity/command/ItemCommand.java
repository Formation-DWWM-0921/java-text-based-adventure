package com.example.entity.command;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.entity.Item;
import com.example.entity.effect.Effect;
import com.example.game.Game;

/**
 * Une action que le joueur peut utiliser sur un élément interactif
 */
public class ItemCommand implements Command
{
    /**
     * La partie en cours
     */
    private Game game;
    /**
     * Le nom de la commande
     */
    private String name;
    /**
     * Le message par défaut à afficher lorsque la commande est utilisée avec un élément interactif non prévu pour
     */
    private String defaultMessage;
    /**
     * La liste de tous les effets que cette commande peut produire
     */
    private List<Effect> effects;

    /**
     * Crée une nouvelle commande
     * @param name Le nom de la commande
     * @param defaultMessage Le message par défaut à afficher lorsque la commande est utilisée avec un élément interactif non prévu pour
     */
    public ItemCommand(Game game, String name, String defaultMessage)
    {
        this.game = game;
        this.name = name;
        this.defaultMessage = defaultMessage;
        effects = new ArrayList<>();
    }

    /**
     * Tente de traiter une saisie utilisateur
     * @param userInput La saisie utilisateur à traiter
     * @return Vrai si la commande a réussi à traiter la saisie, faux sinon
     */
    public boolean process(String userInput)
    {
        // Vérifie si la saisie utilisateur contient le nom de la commande suivi d'un nom d'objet
        Pattern pattern = Pattern.compile("^" + name + "\\s+(.+)$");
        Matcher matcher = pattern.matcher(userInput);
        // Si la saisie utilisateur correspond à cette commande
        if (matcher.matches()) {
            // Récupère le nom de l'élément interactif qui suit la commande
            String itemName = matcher.group(1);
            // Cherche si le nom fourni correspond à un objet présent dans le lieu actuel
            for (Item item : game.getCurrentRoom().getItems()) {
                // Si le nom fourni correspond à cet élément interactif
                if (itemName.equals(item.getName())) {
                    // Récupère l'effet prévu lorsque l'on utilise cette commande sur cet élément
                    Effect effect = item.getEffect(this);
                    // S'il n'est pas possible d'utiliser cette commande sur cet élément interactif
                    if (effect == null) {
                        // Affiche le message par défaut de la commande
                        System.out.println(defaultMessage);
                        return true;
                    }
                    // Sinon, déclenche l'effet
                    effect.trigger();
                    return true;
                }
            }
            // Si le nom fourni ne correspond à aucun élémént interactif présent dans le lieu actuel
            System.out.println("There is no such item here!");
            return true;
        }
        return false;
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

    /**
     * @return La liste de tous les effets que cette commande peut produire
     */
    public List<Effect> getEffects()
    {
        return effects;
    }

    /**
     * Ajoute un effet à la liste de tous les effets que peut produire cette commande
     * @param effect L'effet à ajouter
     */
    public void addEffect(Effect effect)
    {
        effects.add(effect);
    }
}
