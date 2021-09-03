package net.glasslauncher.example;

import net.glasslauncher.example.events.init.AchievementListener;
import net.modificationstation.stationloader.api.common.event.achievement.AchievementRegister;
import net.modificationstation.stationloader.api.common.mod.StationMod;

public class ExampleMod implements StationMod {

    @Override
    public void preInit() {
        AchievementRegister.EVENT.register(new AchievementListener());
    }
}
