package net.glasslauncher.example.events.init;

import net.glasslauncher.example.custom.ExampleAchievementPage;
import net.minecraft.achievement.Achievement;
import net.minecraft.item.ItemBase;
import net.modificationstation.stationloader.api.common.achievement.AchievementPage;
import net.modificationstation.stationloader.api.common.event.achievement.AchievementRegister;

import java.util.List;

public class AchievementListener implements AchievementRegister {

    public static Achievement achievement;
    public static Achievement achievement2;

    @Override
    public void registerAchievements(List<Achievement> list) {
        System.out.println("Registering achievements");
        AchievementPage achievementPage = new ExampleAchievementPage("examplemod:examplemod");
        achievement = new Achievement(69696969, "examplemod:boned", -1, 0, ItemBase.bone, null);
        achievement2 = new Achievement(69696970, "examplemod:apple", 0, 10, ItemBase.apple, achievement);
        achievement2.setUnusual();
        list.add(achievement);
        list.add(achievement2);
        achievementPage.addAchievements(achievement, achievement2);
    }
}
