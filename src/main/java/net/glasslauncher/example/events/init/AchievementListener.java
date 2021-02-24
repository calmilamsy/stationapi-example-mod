package net.glasslauncher.example.events.init;

import net.glasslauncher.example.custom.ExampleAchievementPage;
import net.minecraft.achievement.Achievement;
import net.minecraft.item.ItemBase;
import net.modificationstation.stationapi.api.client.gui.screen.menu.AchievementPage;
import net.modificationstation.stationapi.api.common.event.EventListener;
import net.modificationstation.stationapi.api.common.event.achievement.AchievementRegister;
import net.modificationstation.stationapi.api.common.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.common.registry.ModID;

import java.util.List;

public class AchievementListener {

    public static Achievement achievement;
    public static Achievement achievement2;

    @Entrypoint.ModID
    private ModID modID;

    @EventListener
    public void registerAchievements(AchievementRegister event) {
        List<Achievement> list = event.achievements;
        AchievementPage achievementPage = new ExampleAchievementPage(modID, "examplemod");
        achievement = new Achievement(69696969, "examplemod.boned", -1, 0, ItemBase.bone, null);
        achievement2 = new Achievement(69696970, "examplemod.apple", 0, 10, ItemBase.apple, achievement);
        achievement2.setUnusual();
        list.add(achievement);
        list.add(achievement2);
        achievementPage.addAchievements(achievement, achievement2);
    }
}
