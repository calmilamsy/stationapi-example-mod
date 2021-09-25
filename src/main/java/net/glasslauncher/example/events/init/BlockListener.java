package net.glasslauncher.example.events.init;

import net.glasslauncher.example.wrappers.ExampleBlockWithModel;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.BlockBase;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.event.registry.BlockRegistryEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.registry.ModID;
import net.modificationstation.stationapi.api.template.block.TemplateBlockBase;
import net.modificationstation.stationapi.api.util.Null;

public class BlockListener {

    public static BlockBase exampleBlock;
    public static BlockBase exampleBlock2;

    @Entrypoint.ModID
    public static final ModID MOD_ID = Null.get();

    @EventListener
    public void registerBlocks(BlockRegistryEvent event) {
        System.out.println(MOD_ID);
        exampleBlock = new TemplateBlockBase(Identifier.of(MOD_ID, "test"), Material.DIRT).setTranslationKey(MOD_ID, "test");
        exampleBlock2 = new ExampleBlockWithModel(Identifier.of(MOD_ID, "test2"), Material.DIRT).setTranslationKey(MOD_ID, "test2");
    }
}
