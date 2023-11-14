package net.glasslauncher.example.events.ingame;

import net.fabricmc.loader.api.FabricLoader;
import net.glasslauncher.example.events.init.AchievementListener;
import net.glasslauncher.example.events.init.KeyBindingListener;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.client.Minecraft;
import net.modificationstation.stationapi.api.client.event.keyboard.KeyStateChangedEvent;
import org.lwjgl.input.Keyboard;

public class KeyPressedListener {

    @EventListener
    public void keyPressed(KeyStateChangedEvent event) {
        if (Keyboard.getEventKeyState() && Keyboard.isKeyDown(KeyBindingListener.keyBinding.code)) {
            ((Minecraft) FabricLoader.getInstance().getGameInstance()).player.increaseStat(AchievementListener.achievement, 1);
        }
        if (Keyboard.getEventKeyState() && Keyboard.isKeyDown(KeyBindingListener.keyBinding2.code)) {
            ((Minecraft)FabricLoader.getInstance().getGameInstance()).player.increaseStat(AchievementListener.achievement2, 1);
        }
        if (Keyboard.getEventKeyState() && Keyboard.isKeyDown(KeyBindingListener.keyBinding3.code)) {
            if (((Minecraft) FabricLoader.getInstance().getGameInstance()).player != null)
                ((Minecraft) FabricLoader.getInstance().getGameInstance()).player.damage(null, 1000000);
        }
    }
}
