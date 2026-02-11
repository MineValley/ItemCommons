package minevalley.lib.itemcommons.technology.vehicles;

import minevalley.core.api.Core;
import minevalley.crafting.api.Crafting;
import minevalley.crafting.api.ingredient.RecipeIngredient;
import minevalley.crafting.api.recipe.CustomShapedRecipe;
import minevalley.lib.itemcommons.CustomItem;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public class HornItem implements CustomItem {

    public static final ItemStack HORN_ITEM = Core.createItem(Material.NETHER_STAR)
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
