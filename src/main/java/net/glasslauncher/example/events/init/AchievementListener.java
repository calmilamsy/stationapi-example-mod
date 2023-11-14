package net.glasslauncher.example.events.init;

import net.glasslauncher.example.custom.ExampleAchievementPage;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.achievement.Achievement;
import net.minecraft.item.Item;
import net.modificationstation.stationapi.api.client.gui.screen.achievement.AchievementPage;
import net.modificationstation.stationapi.api.event.achievement.AchievementRegisterEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.util.Namespace;

import java.util.List;

public class AchievementListener {

    public static Achievement achievement;
    public static Achievement achievement2;

    @Entrypoint.Namespace
    private Namespace namespace;

    @EventListener
    public void registerAchievements(AchievementRegisterEvent event) {
        List<Achievement> list = event.achievements;
        AchievementPage achievementPage = new ExampleAchievementPage(namespace, "examplemod");
        achievement = new Achievement(69696969, "examplemod.boned", -1, 0, Item.BONE, null);
        achievement2 = new Achievement(69696970, "examplemod.apple", 0, 10, Item.APPLE, achievement);
        achievement2.challenge();
        list.add(achievement);
        list.add(achievement2);
        achievementPage.addAchievements(achievement, achievement2);
    }
}
