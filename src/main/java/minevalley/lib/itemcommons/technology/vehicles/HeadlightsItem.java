package minevalley.lib.itemcommons.technology.vehicles;

import minevalley.core.api.Core;
import minevalley.core.api.utils.CustomItemFlag;
import minevalley.crafting.api.Crafting;
import minevalley.crafting.api.ingredient.RecipeIngredient;
import minevalley.crafting.api.recipe.CustomShapedRecipe;
import minevalley.lib.itemcommons.CustomItem;
import minevalley.lib.itemcommons.technology.LightBulbItem;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public class HeadlightsItem implements CustomItem {

    public static final ItemStack HEADLIGHTS_ITEM = Core.createItem("b43f9854fe0d9e69302565305fcc6de2ab2b8a39c9a4d6f69f3f68d5b292e7fd")
            .setDisplayName("Scheinwerfer", NamedTextColor.WHITE)
            .addCustomItemFlags(CustomItemFlag.PREVENT_PLACING)
            .setMaxStackSize(16)
            .build();

    @Override
    public @Nonnull ItemStack asItemStack() {
        return HEADLIGHTS_ITEM.clone();
    }

    public static void registerRecipe() {
        final CustomShapedRecipe recipe = Crafting.createCustomRecipe(HEADLIGHTS_ITEM, new String[]{"GGG", "BBB", "ICI"}, 0);
        recipe.mapIngredient('G', new RecipeIngredient(Material.GLASS));
        recipe.mapIngredient('B', new RecipeIngredient(LightBulbItem.LIGHT_BULB_ITEM));
        recipe.mapIngredient('I', new RecipeIngredient(Material.IRON_INGOT));
        recipe.mapIngredient('C', new RecipeIngredient(Material.COPPER_INGOT));
        recipe.register();
    }
}
