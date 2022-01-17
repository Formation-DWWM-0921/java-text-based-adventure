package com.example.entity;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ItemTest
{
    @Test
    public void testConstructors()
    {
        Room room = new Room("truc", "bidule");
        Item item;
        item = new Item(room, "machin");
        assertEquals(room, item.getRoom());
        assertEquals("machin", item.getName());
        assertEquals(true, item.isVisible());

        item = new Item(room, "machin", false);
        assertEquals(room, item.getRoom());
        assertEquals("machin", item.getName());
        assertEquals(false, item.isVisible());
    }
}
