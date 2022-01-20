package com.example.entity.effect;

import static org.junit.Assert.assertEquals;

import java.util.List;

import com.example.entity.Command;
import com.example.entity.Item;
import com.example.entity.Room;

import org.junit.Test;

public class MessageEffectTest
{
    @Test
    public void testConstructors()
    {
        Command command = new Command("use", "Default message");
        Room room = new Room("bedroom", "Bedroom description");
        Item item = new Item(room, "pouet");
        MessageEffect effect = new MessageEffect(command, item, "Pouet!");

        assertEquals(command, effect.getCommand());
        assertEquals(item, effect.getItem());
        assertEquals("Pouet!", effect.getMessage());

        List<MessageEffect> effects;
        effects = command.getEffects();
        assertEquals(1, effects.size());
        assertEquals(effect, effects.get(0));

        effects = item.getEffects();
        assertEquals(1, effects.size());
        assertEquals(effect, effects.get(0));
    }
}
