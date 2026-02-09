package minevalley.lib.itemcommons.technology.engines;

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
public class SparkPlugItem implements CustomItem {

    public static final ItemStack SPARK_PLUG_ITEM = Core.createItem(Material.STONE)
            .setDisplayName("Zündkerze", NamedTextColor.WHITE)
            .setMaxStackSize(4)
            .build();

    @Override
    public @Nonnull ItemStack asItemStack() {
        return SPARK_PLUG_ITEM.clone();
    }

    public static void registerRecipe() {
        final CustomRecipe recipe = Crafting.createCustomRecipe(SPARK_PLUG_ITEM.asQuantity(4), new String[]{"F", "I", "C"}, 0);
        recipe.mapIngredient('F', new RecipeIngredient(Material.FLINT));
        recipe.mapIngredient('I', new RecipeIngredient(Material.IRON_INGOT));
        recipe.mapIngredient('C', new RecipeIngredient(Material.COPPER_INGOT));
        recipe.register();
    }
}