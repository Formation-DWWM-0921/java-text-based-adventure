package com.example.entity;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RoomTest
{
    @Test
    public void testConstructors()
    {
        Room room = new Room("pouet", "machin");
        assertEquals("pouet", room.getName());
        assertEquals("machin", room.getDescription());
    }
}
