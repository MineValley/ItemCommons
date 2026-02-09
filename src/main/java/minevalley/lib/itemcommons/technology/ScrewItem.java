package minevalley.lib.itemcommons.technology;

import minevalley.core.api.Core;
import minevalley.crafting.api.Crafting;
import minevalley.crafting.api.ingredient.RecipeIngredient;
import minevalley.crafting.api.recipe.CustomRecipe;
import minevalley.lib.itemcommons.CustomItem;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public class ScrewItem implements CustomItem {

    public static final ItemStack SCREW_ITEM = Core.createItem(Material.STONE)
            .setDisplayName("Schraube", NamedTextColor.WHITE)
            .setMaxStackSize(16)
            .build();

    @Override
    public @Nonnull ItemStack asItemStack() {
        return SCREW_ITEM.clone();
    }

    public static void registerRecipe() {
        final CustomRecipe recipe = Crafting.createCustomRecipe(SCREW_ITEM.asQuantity(4), new String[]{"B", "I"}, 0);
        recipe.mapIngredient('B', new RecipeIngredient(Material.IRON_BLOCK));
        recipe.mapIngredient('I', new RecipeIngredient(Material.IRON_INGOT));
        recipe.register();
    }
}
