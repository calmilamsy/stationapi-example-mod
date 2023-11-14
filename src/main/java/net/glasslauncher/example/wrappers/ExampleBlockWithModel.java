package net.glasslauncher.example.wrappers;

import net.minecraft.block.Material;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

public class ExampleBlockWithModel extends TemplateBlock {

    public ExampleBlockWithModel(Identifier identifier, Material material) {
        super(identifier, material);
    }

    @Override
    public boolean isOpaque() {
        return false;
    }
}
