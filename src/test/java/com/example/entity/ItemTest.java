package com.example.entity;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ItemTest
{
    @Test
    public void testConstructors()
    {
        Room room;
        Item item;
        room = new Room("truc", "bidule");
        item = new Item(room, "machin");
        assertEquals(room, item.getRoom());
        assertEquals("machin", item.getName());
        assertEquals(true, item.isVisible());
        assertEquals(room.getItems().size(), 1);
        assertEquals(room.getItems().get(0), item);

        room = new Room("truc", "bidule");
        item = new Item(room, "machin", false);
        assertEquals(room, item.getRoom());
        assertEquals("machin", item.getName());
        assertEquals(false, item.isVisible());
        assertEquals(room.getItems().size(), 1);
        assertEquals(room.getItems().get(0), item);
    }
}
