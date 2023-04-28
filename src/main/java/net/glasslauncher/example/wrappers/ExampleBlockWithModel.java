package net.glasslauncher.example.wrappers;

import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.block.TemplateBlockBase;

public class ExampleBlockWithModel extends TemplateBlockBase {

    public ExampleBlockWithModel(Identifier identifier, Material material) {
        super(identifier, material);
    }

    @Override
    public boolean isFullOpaque() {
        return false;
    }
}
