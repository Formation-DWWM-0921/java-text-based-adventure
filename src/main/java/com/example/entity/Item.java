package com.example.entity;

import java.util.ArrayList;
import java.util.List;

import com.example.entity.effect.MessageEffect;

/**
 * Représente un élément de l'univers de jeu, avec lequel le joueur pourra interagir.
 */
public class Item
{
    /**
     * Le lieu dans lequel se trouve l'élément interactif
     */
    private Room room;
    /**
     * Le nom de l'élément interactif
     */
    private String name;
    /**
     * L'élément interactif est-il visible et utilisable?
     */
    private boolean visible;
    /**
     * La liste de tous les effets que cet élément interactif peut produire
     */
    private List<MessageEffect> effects;

    /**
     * Crée un nouvel élément interactif visible
     * @param room Le lieu dans lequel se trouve l'élément interactif
     * @param name Le nom de l'élément interactif
     */
    public Item(Room room, String name)
    {
        this.room = room;
        this.name = name;
        this.visible = true;
        // Ajoute le nouvel élément interactif à la liste de tous les éléments présents dans le lieu qui lui a été assigné
        room.addItem(this);
        effects = new ArrayList<>();
    }

    /**
     * Crée un nouvel élément interactif
     * @param room Le lieu dans lequel se trouve l'élément interactif
     * @param name Le nom de l'élément interactif
     * @param visible L'élément interactif est-il visible et utilisable?
     */
    public Item(Room room, String name, boolean visible)
    {
        this.room = room;
        this.name = name;
        this.visible = visible;
        // Ajoute le nouvel élément interactif à la liste de tous les éléments présents dans le lieu qui lui a été assigné
        room.addItem(this);
        effects = new ArrayList<>();
    }

    /**
     * @return Le lieu dans lequel se trouve l'élément interactif
     */
    public Room getRoom() {
        return room;
    }

    /**
     * @return Le nom de l'élément interactif
     */
    public String getName() {
        return name;
    }

    /**
     * @return L'élément interactif est-il visible et utilisable?
     */
    public boolean isVisible() {
        return visible;
    }

    /**
     * @return La liste de tous les effets que cet élément interactif peut produire
     */
    public List<MessageEffect> getEffects()
    {
        return effects;
    }

    /**
     * @param command La commande désirée
     * @return L'effet à déclencher lorsque la commande désirée est utilisée sur cet élément interactif
     */
    public MessageEffect getEffect(Command command)
    {
        // Cherche parmi tous les effets associés à cet élément interactif
        for (MessageEffect effect : effects) {
            if (effect.getCommand() == command) {
                return effect;
            }
        }
        // Si aucun effet associé à cet élément interactif ne correspond à la commande désirée
        return null;
    }
        
    /**
     * Ajoute un effet à la liste de tous les effets que peut produire cet élément interactif
     * @param effect L'effet à ajouter
     */
    public void addEffect(MessageEffect effect)
    {
        effects.add(effect);
    }
}
