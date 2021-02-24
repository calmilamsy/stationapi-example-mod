package net.glasslauncher.example.events.init;

import net.minecraft.block.BlockBase;
import net.minecraft.item.ItemBase;
import net.minecraft.item.ItemInstance;
import net.modificationstation.stationapi.api.common.event.EventListener;
import net.modificationstation.stationapi.api.common.event.recipe.RecipeRegister;
import net.modificationstation.stationapi.api.common.recipe.CraftingRegistry;
import net.modificationstation.stationapi.api.common.recipe.SmeltingRegistry;
import net.modificationstation.stationapi.api.common.registry.Identifier;

public class RecipeListener {

    @EventListener
    public void registerRecipes(RecipeRegister event) {

        Identifier type = event.recipeId;
        if (type == RecipeRegister.Vanilla.CRAFTING_SHAPED.type()) {
            CraftingRegistry.addShapedRecipe(new ItemInstance(ItemListener.coolItem, 1), "XXX", "X X", "X X", 'X', BlockBase.DIRT);
        }
        if (type == RecipeRegister.Vanilla.SMELTING.type()) {
            SmeltingRegistry.addSmeltingRecipe(new ItemInstance(ItemBase.apple, 1), new ItemInstance(BlockBase.WOOL));
        }
        if (type == RecipeRegister.Vanilla.CRAFTING_SHAPELESS.type()) {
            CraftingRegistry.addShapelessRecipe(new ItemInstance(BlockListener.exampleBlock, 1), new ItemInstance(BlockBase.DIRT));
            CraftingRegistry.addShapelessRecipe(new ItemInstance(BlockListener.exampleBlock2, 1), new ItemInstance(BlockBase.DIRT), new ItemInstance(BlockBase.DIRT));
        }
    }
}
