package eu.minevalley.itemcommons.technology.vehicles;

import eu.minevalley.itemcommons.CustomItem;
import eu.minevalley.itemcommons.technology.LightBulbItem;
import minevalley.core.api.Core;
import minevalley.crafting.api.Crafting;
import minevalley.crafting.api.ingredient.RecipeIngredient;
import minevalley.crafting.api.recipe.CustomShapedRecipe;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public class BlueLightItem implements CustomItem {

    public static final ItemStack BLUE_LIGHT_ITEM = Core.createItem(Material.NETHER_STAR)
            .setCustomModelData(20)
            .setDisplayName("Blaulicht", NamedTextColor.WHITE)
            .setMaxStackSize(16)
            .build();

    @Override
    public @Nonnull ItemStack asItemStack() {
        return BLUE_LIGHT_ITEM.clone();
    }

    public static void registerRecipe() {
        final CustomShapedRecipe recipe = Crafting.createCustomRecipe(BLUE_LIGHT_ITEM, new String[]{"GGG", "BBB", "ICI"}, 0);
        recipe.mapIngredient('G', new RecipeIngredient(Material.BLUE_STAINED_GLASS));
        recipe.mapIngredient('B', new RecipeIngredient(LightBulbItem.LIGHT_BULB_ITEM));
        recipe.mapIngredient('I', new RecipeIngredient(Material.IRON_BLOCK));
        recipe.mapIngredient('C', new RecipeIngredient(Material.COPPER_BLOCK));
        recipe.register();
    }
}
