package eu.minevalley.itemcommons.technology.engines;

import eu.minevalley.crafting.api.Crafting;
import eu.minevalley.crafting.api.ingredient.RecipeIngredient;
import eu.minevalley.crafting.api.recipe.CustomShapedRecipe;
import eu.minevalley.itemcommons.CustomItem;
import eu.minevalley.proxima.api.Proxima;
import eu.minevalley.proxima.api.item.CustomItemFlag;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public class CylinderItem implements CustomItem {

    public static final ItemStack CYLINDER_ITEM = Proxima.createItem("139ac257f4e04adc6ab3e46fd3b28749e866faa9ce6a1d6d526e0e3864d9222")
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
