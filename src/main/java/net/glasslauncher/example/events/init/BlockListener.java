package net.glasslauncher.example.events.init;

import net.glasslauncher.example.wrappers.ExampleBlockWithModel;
import net.minecraft.block.BlockBase;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.common.event.EventListener;
import net.modificationstation.stationapi.api.common.event.block.BlockRegister;
import net.modificationstation.stationapi.api.common.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.common.registry.Identifier;
import net.modificationstation.stationapi.api.common.registry.ModID;
import net.modificationstation.stationapi.api.common.util.Null;

public class BlockListener {

    public static BlockBase exampleBlock;
    public static BlockBase exampleBlock2;

    @Entrypoint.ModID
    public static final ModID MOD_ID = Null.get();

    @EventListener
    public void registerBlocks(BlockRegister event) {
        System.out.println(MOD_ID);
        exampleBlock = new net.modificationstation.stationapi.template.common.block.BlockBase(Identifier.of(MOD_ID, "test"), Material.DIRT).setTranslationKey(MOD_ID, "test");
        exampleBlock2 = new ExampleBlockWithModel(Identifier.of(MOD_ID, "test2"), Material.DIRT).setTranslationKey(MOD_ID, "test2");
    }
}
