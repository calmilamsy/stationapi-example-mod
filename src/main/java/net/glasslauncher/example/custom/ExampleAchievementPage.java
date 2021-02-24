package net.glasslauncher.example.custom;

import net.minecraft.block.BlockBase;
import net.modificationstation.stationapi.api.client.gui.screen.menu.AchievementPage;
import net.modificationstation.stationapi.api.common.registry.ModID;

import java.util.Random;

public class ExampleAchievementPage extends AchievementPage {

    public ExampleAchievementPage(ModID modID, String pageName) {
        super(modID, pageName);
    }

    @Override
    public int getBackgroundTexture(Random random, int column, int row, int randomizedRow, int currentTexture) {
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
}
