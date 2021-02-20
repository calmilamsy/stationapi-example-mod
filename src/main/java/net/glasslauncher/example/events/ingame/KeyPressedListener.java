package net.glasslauncher.example.events.ingame;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.loader.FabricLoader;
import net.glasslauncher.example.events.init.AchievementListener;
import net.glasslauncher.example.events.init.KeyBindingListener;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;

public class KeyPressedListener {

    @Environment(EnvType.CLIENT)
    public void keyPressed() {
        if (Keyboard.getEventKey() == KeyBindingListener.keyBinding.key) {

            ((Minecraft) FabricLoader.INSTANCE.getGameInstance()).player.increaseStat(AchievementListener.achievement, 1);
        }
        if (Keyboard.getEventKey() == KeyBindingListener.keyBinding2.key) {

            ((Minecraft)FabricLoader.INSTANCE.getGameInstance()).player.increaseStat(AchievementListener.achievement2, 1);
        }
        if (Keyboard.getEventKey() == KeyBindingListener.keyBinding3.key) {

            ((Minecraft)FabricLoader.INSTANCE.getGameInstance()).player.damage(null, 1000000);
        }
    }
}
