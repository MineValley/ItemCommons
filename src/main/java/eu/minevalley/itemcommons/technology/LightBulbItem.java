package eu.minevalley.itemcommons.technology;

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
public class LightBulbItem implements CustomItem {

    public static final ItemStack LIGHT_BULB_ITEM = ItemCommons.core().createItem(Material.STONE)
            .setDisplayName("Glühbirne", NamedTextColor.WHITE)
            .setMaxStackSize(16)
            .build();

    @Override
    public @Nonnull ItemStack asItemStack() {
        return LIGHT_BULB_ITEM.clone();
    }

    public static void registerRecipe() {
        final CustomShapedRecipe recipe = Crafting.createCustomRecipe(LIGHT_BULB_ITEM.asQuantity(4), new String[]{" G ", "GCG", " I "}, 0);
        recipe.mapIngredient('G', new RecipeIngredient(Material.GLASS_PANE));
        recipe.mapIngredient('C', new RecipeIngredient(CopperCoilItem.getLevel1()));
        recipe.mapIngredient('I', new RecipeIngredient(Material.IRON_INGOT));
        recipe.register();
    }
}
