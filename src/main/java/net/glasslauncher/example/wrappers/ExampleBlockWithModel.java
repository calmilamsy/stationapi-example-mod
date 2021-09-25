package net.glasslauncher.example.wrappers;

import net.glasslauncher.example.events.init.ModelListener;
import net.minecraft.block.material.Material;
import net.minecraft.level.BlockView;
import net.modificationstation.stationapi.api.client.model.Model;
import net.modificationstation.stationapi.api.client.model.block.BlockInventoryModelProvider;
import net.modificationstation.stationapi.api.client.model.block.BlockWorldModelProvider;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.block.TemplateBlockBase;

public class ExampleBlockWithModel extends TemplateBlockBase implements BlockWorldModelProvider, BlockInventoryModelProvider {

    public ExampleBlockWithModel(Identifier identifier, Material material) {
        super(identifier, material);
    }

    @Override
    public boolean isFullOpaque() {
        return false;
    }

    @Override
    public Model getInventoryModel(int meta) {
        return ModelListener.CUSTOM_MODEL;
    }

    @Override
    public Model getCustomWorldModel(BlockView blockView, int x, int y, int z) {
        return ModelListener.CUSTOM_MODEL;
    }
}
