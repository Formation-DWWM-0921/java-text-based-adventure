package com.example.entity.effect;

import static org.junit.Assert.assertEquals;

import java.util.List;

import com.example.entity.Item;
import com.example.entity.Room;
import com.example.entity.command.ItemCommand;
import com.example.game.Game;

import org.junit.Test;

public class MessageEffectTest
{
    @Test
    public void testConstructors()
    {
        ItemCommand command = new ItemCommand(new Game(), "use", "Default message");
        Room room = new Room("bedroom", "Bedroom description");
        Item item = new Item(room, "pouet");
        MessageEffect effect = new MessageEffect(command, item, "Pouet!");

        assertEquals(command, effect.getCommand());
        assertEquals(item, effect.getItem());
        assertEquals("Pouet!", effect.getMessage());

        List<Effect> effects;
        effects = command.getEffects();
        assertEquals(1, effects.size());
        assertEquals(effect, effects.get(0));

        effects = item.getEffects();
        assertEquals(1, effects.size());
        assertEquals(effect, effects.get(0));
    }
}
