package net.glasslauncher.example.custom;

import net.minecraft.achievement.Achievement;
import net.minecraft.block.BlockBase;
import net.modificationstation.stationloader.api.common.achievement.AchievementPage;
import net.modificationstation.stationloader.api.common.achievement.AchievementPageManager;

import java.util.*;

public class ExampleAchievementPage implements AchievementPage {

    private final ArrayList<Integer> achievements = new ArrayList<>();
    private final String name;

    public ExampleAchievementPage(String pageName) {
        name = pageName;
        AchievementPageManager.INSTANCE.addPage(this);
    }

    @Override
    public int getBackgroundTexture(Random random, int column, int row) {
        int k = BlockBase.SAND.texture;
        int l = random.nextInt(1 + row) + row / 2;
        if (l <= 37 && row != 35) {
            if (l == 22) {
                k = random.nextInt(2) != 0 ? BlockBase.REDSTONE_ORE.texture : BlockBase.DIAMOND_ORE.texture;
            } else if (l == 10) {
                k = BlockBase.WOOD.texture;
            } else if (l == 8) {
                k = BlockBase.REDSTONE_ORE.texture;
            } else if (l > 4) {
                k = BlockBase.STONE.texture;
            } else if (l > 0) {
                k = BlockBase.DIRT.texture;
            }
        } else {
            k = BlockBase.BEDROCK.texture;
        }

        return k;
    }

    @Override
    public void addAchievements(Achievement... achievements) {
        for (Achievement achievement : achievements)
            this.achievements.add(achievement.ID);
    }

    @Override
    public ArrayList<Integer> getAchievementIds() {
        return achievements;
    }

    @Override
    public String getName() {
        return name;
    }
}
