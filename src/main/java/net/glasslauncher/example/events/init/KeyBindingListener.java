package net.glasslauncher.example.events.init;

import net.minecraft.client.options.KeyBinding;
import net.modificationstation.stationapi.api.client.event.option.KeyBindingRegister;
import net.modificationstation.stationapi.api.common.event.EventListener;

import java.util.List;

public class KeyBindingListener {

    public static KeyBinding keyBinding;
    public static KeyBinding keyBinding2;
    public static KeyBinding keyBinding3;

    @EventListener
    public void registerKeyBindings(KeyBindingRegister event) {
        List<KeyBinding> list = event.keyBindings;
        keyBinding = new KeyBinding("key.examplemod.test", 21);
        keyBinding2 = new KeyBinding("key.examplemod.test2", 22);
        keyBinding3 = new KeyBinding("key.examplemod.hurtme", 23);
        list.add(keyBinding);
        list.add(keyBinding2);
        list.add(keyBinding3);
    }
}
