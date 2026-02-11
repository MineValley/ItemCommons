package minevalley.lib.itemcommons.technology.engines;

import minevalley.core.api.Core;
import minevalley.core.api.utils.CustomItemFlag;
import minevalley.crafting.api.Crafting;
import minevalley.crafting.api.ingredient.RecipeIngredient;
import minevalley.crafting.api.recipe.CustomShapedRecipe;
import minevalley.lib.itemcommons.CustomItem;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public class CylinderItem implements CustomItem {

    public static final ItemStack CYLINDER_ITEM = Core.createItem("139ac257f4e04adc6ab3e46fd3b28749e866faa9ce6a1d6d526e0e3864d9222")
            .setDisplayName("Zylinder", NamedTextColor.WHITE)
            .addCustomItemFlags(CustomItemFlag.PREVENT_PLACING)
            .setMaxStackSize(4)
            .build();


    @Override
    public @Nonnull ItemStack asItemStack() {
        return CYLINDER_ITEM.clone();
    }

    public static void registerRecipe() {
        final CustomShapedRecipe recipe = Crafting.createCustomRecipe(CYLINDER_ITEM, new String[]{"IPI", "I I", "III"}, 8_000);
        recipe.mapIngredient('I', new RecipeIngredient(Material.IRON_BLOCK));
        recipe.mapIngredient('P', new RecipeIngredient(Material.PISTON));
        recipe.register();
    }
}
