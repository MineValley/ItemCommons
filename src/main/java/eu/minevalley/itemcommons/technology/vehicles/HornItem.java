package eu.minevalley.itemcommons.technology.vehicles;

import eu.minevalley.crafting.api.Crafting;
import eu.minevalley.crafting.api.ingredient.RecipeIngredient;
import eu.minevalley.crafting.api.recipe.CustomShapedRecipe;
import eu.minevalley.itemcommons.CustomItem;
import eu.minevalley.itemcommons.ItemCommons;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public class HornItem implements CustomItem {

    public static final ItemStack HORN_ITEM = ItemCommons.core().createItem(Material.NAUTILUS_SHELL)
            .setCustomModelData(9)
            .setDisplayName("Hupe", NamedTextColor.WHITE)
            .setMaxStackSize(16)
            .build();

    @Override
    public @Nonnull ItemStack asItemStack() {
        return HORN_ITEM.clone();
    }

    public static void registerRecipe() {
        final CustomShapedRecipe recipe = Crafting.createCustomRecipe(HORN_ITEM.asQuantity(4), new String[]{"I ", " R"}, 0);
        recipe.mapIngredient('I', new RecipeIngredient(Material.IRON_INGOT));
        recipe.mapIngredient('R', new RecipeIngredient(Material.SLIME_BALL));
        recipe.register();
    }
}
