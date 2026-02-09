package minevalley.lib.itemcommons.technology;

import minevalley.crafting.api.Crafting;
import minevalley.crafting.api.ingredient.RecipeIngredient;
import minevalley.crafting.api.recipe.CustomRecipe;
import minevalley.lib.itemcommons.CustomItem;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public class SteelRodItem implements CustomItem {

    public static final ItemStack STEEL_ROD_ITEM = new ItemStack(Material.BREEZE_ROD);

    @Override
    public @Nonnull ItemStack asItemStack() {
        return STEEL_ROD_ITEM.clone();
    }

    public static void registerRecipe() {
        final CustomRecipe recipe = Crafting.createCustomRecipe(STEEL_ROD_ITEM, new String[]{"I ", " I"}, 0);
        recipe.mapIngredient('I', new RecipeIngredient(Material.IRON_INGOT));
        recipe.register();
    }
}
