package com.example.entity;

/**
 * Représente un passage entre deux lieux.
 */
public class RoomConnection
{
    /**
     * Le lieu de départ
     */
    private Room fromRoom;
    /**
     * Le lieu d'arrivée
     */
    private Room toRoom;
    /**
     * La direction à emprunter
     */
    private Direction direction;

    /**
     * Crée un nouveau passage entre deux lieux
     * @param fromRoom Le lieu de départ
     * @param toRoom Le lieu d'arrivée
     * @param direction La direction à emprunter
     */
    public RoomConnection(Room fromRoom, Room toRoom, Direction direction)
    {
        this.fromRoom = fromRoom;
        this.toRoom = toRoom;
        this.direction = direction;
        // Ajoute ce passage à liste de toues les passages partant du lieu concerné
        fromRoom.addConnectionFrom(this);
    }

    /**
     * @return Le lieu de départ
     */
    public Room getFromRoom() {
        return fromRoom;
    }
    
    /**
     * @return Le lieu d'arrivée
     */
    public Room getToRoom() {
        return toRoom;
    }
    
    /**
     * @return La direction à emprunter
     */
    public Direction getDirection() {
        return direction;
    }
}
