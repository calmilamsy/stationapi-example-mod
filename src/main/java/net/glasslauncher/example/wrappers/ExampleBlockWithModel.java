package net.glasslauncher.example.wrappers;

import net.glasslauncher.example.events.init.ModelListener;
import net.minecraft.block.material.Material;
import net.minecraft.level.Level;
import net.modificationstation.stationapi.api.client.model.BlockModelProvider;
import net.modificationstation.stationapi.api.client.model.CustomModel;
import net.modificationstation.stationapi.api.common.registry.Identifier;
import net.modificationstation.stationapi.template.common.block.BlockBase;

public class ExampleBlockWithModel extends BlockBase implements BlockModelProvider {

    public ExampleBlockWithModel(Identifier identifier, Material material) {
        super(identifier, material);
    }

    @Override
    public boolean isFullOpaque() {
        return false;
    }

    @Override
    public CustomModel getCustomWorldModel(Level level, int x, int y, int z, int meta) {
        return ModelListener.CUSTOM_MODEL;
    }

    @Override
    public CustomModel getCustomInventoryModel(int meta) {
        return ModelListener.CUSTOM_MODEL;
    }
}
