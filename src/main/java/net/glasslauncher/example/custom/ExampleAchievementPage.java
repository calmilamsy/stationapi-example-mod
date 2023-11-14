package net.glasslauncher.example.custom;

import net.minecraft.block.Block;
import net.modificationstation.stationapi.api.client.gui.screen.achievement.AchievementPage;
import net.modificationstation.stationapi.api.util.Namespace;

import java.util.Random;

public class ExampleAchievementPage extends AchievementPage {

    public ExampleAchievementPage(Namespace namespace, String pageName) {
        super(namespace, pageName);
    }

    @Override
    public int getBackgroundTexture(Random random, int column, int row, int randomizedRow, int currentTexture) {
        int k = Block.SAND.textureId;
        int l = random.nextInt(1 + row) + row / 2;
        if (l <= 37 && row != 35) {
            if (l == 22) {
                k = random.nextInt(2) != 0 ? Block.REDSTONE_ORE.textureId : Block.DIAMOND_ORE.textureId;
            } else if (l == 10) {
                k = Block.PLANKS.textureId;
            } else if (l == 8) {
                k = Block.REDSTONE_ORE.textureId;
            } else if (l > 4) {
                k = Block.STONE.textureId;
            } else if (l > 0) {
                k = Block.DIRT.textureId;
            }
        } else {
            k = Block.BEDROCK.textureId;
        }

        return k;
    }
}
