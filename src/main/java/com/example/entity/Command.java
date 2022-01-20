package com.example.entity;

import java.util.ArrayList;
import java.util.List;

import com.example.entity.effect.MessageEffect;

/**
 * Une action que le joueur peut utiliser sur un élément interactif
 */
public class Command
{
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
    private List<MessageEffect> effects;

    /**
     * Crée une nouvelle commande
     * @param name Le nom de la commande
     * @param defaultMessage Le message par défaut à afficher lorsque la commande est utilisée avec un élément interactif non prévu pour
     */
    public Command(String name, String defaultMessage)
    {
        this.name = name;
        this.defaultMessage = defaultMessage;
        effects = new ArrayList<>();
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
    public List<MessageEffect> getEffects()
    {
        return effects;
    }

    /**
     * Ajoute un effet à la liste de tous les effets que peut produire cette commande
     * @param effect L'effet à ajouter
     */
    public void addEffect(MessageEffect effect)
    {
        effects.add(effect);
    }
}
