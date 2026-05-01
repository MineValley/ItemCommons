package eu.minevalley.itemcommons.technology.engines;

import eu.minevalley.crafting.api.Crafting;
import eu.minevalley.crafting.api.ingredient.RecipeIngredient;
import eu.minevalley.crafting.api.recipe.CustomShapedRecipe;
import eu.minevalley.itemcommons.CustomItem;
import eu.minevalley.proxima.api.Proxima;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public class SparkPlugItem implements CustomItem {

    public static final ItemStack SPARK_PLUG_ITEM = Proxima.createItem(Material.STONE)
            .setDisplayName("Zündkerze", NamedTextColor.WHITE)
            .setMaxStackSize(4)
            .build();

    @Override
    public @Nonnull ItemStack asItemStack() {
        return SPARK_PLUG_ITEM.clone();
    }

    public static void registerRecipe() {
        final CustomShapedRecipe recipe = Crafting.createCustomRecipe(SPARK_PLUG_ITEM.asQuantity(4), new String[]{"F", "I", "C"}, 0);
        recipe.mapIngredient('F', new RecipeIngredient(Material.FLINT));
        recipe.mapIngredient('I', new RecipeIngredient(Material.IRON_INGOT));
        recipe.mapIngredient('C', new RecipeIngredient(Material.COPPER_INGOT));
        recipe.register();
    }
}