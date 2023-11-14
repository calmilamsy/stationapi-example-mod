package net.glasslauncher.example.events.init;

import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.modificationstation.stationapi.api.event.recipe.RecipeRegisterEvent;
import net.modificationstation.stationapi.api.recipe.CraftingRegistry;
import net.modificationstation.stationapi.api.recipe.SmeltingRegistry;
import net.modificationstation.stationapi.api.util.Identifier;

public class RecipeListener {

    @EventListener
    public void registerRecipes(RecipeRegisterEvent event) {

        Identifier type = event.recipeId;
        if (type == RecipeRegisterEvent.Vanilla.CRAFTING_SHAPED.type()) {
            CraftingRegistry.addShapedRecipe(new ItemStack(ItemListener.coolItem, 1), "XXX", "X X", "X X", 'X', Block.DIRT);
        }
        if (type == RecipeRegisterEvent.Vanilla.SMELTING.type()) {
            SmeltingRegistry.addSmeltingRecipe(new ItemStack(Item.APPLE, 1), new ItemStack(Block.WOOL));
        }
        if (type == RecipeRegisterEvent.Vanilla.CRAFTING_SHAPELESS.type()) {
            CraftingRegistry.addShapelessRecipe(new ItemStack(BlockListener.exampleBlock, 1), new ItemStack(Block.DIRT));
            CraftingRegistry.addShapelessRecipe(new ItemStack(BlockListener.exampleBlock2, 1), new ItemStack(Block.DIRT), new ItemStack(Block.DIRT));
        }
    }
}
