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
public class SteeringWheelItem implements CustomItem {

    public static final ItemStack STEERING_WHEEL_ITEM = Core.createItem(Material.STONE)
            .setDisplayName("Lenkrad", NamedTextColor.WHITE)
            .setMaxStackSize(16)
            .build();

    @Override
    public @Nonnull ItemStack asItemStack() {
        return STEERING_WHEEL_ITEM.clone();
    }

    public static void registerRecipe() {
        final CustomShapedRecipe recipe = Crafting.createCustomRecipe(STEERING_WHEEL_ITEM.asQuantity(4), new String[]{"RPR", "HAH", "RSR"}, 0);
        recipe.mapIngredient('A', new RecipeIngredient(AirbagItem.AIRBAG_ITEM));
        recipe.mapIngredient('P', new RecipeIngredient(Material.STONE_PRESSURE_PLATE));
        recipe.mapIngredient('S', new RecipeIngredient(Material.BREEZE_ROD));
        recipe.mapIngredient('H', new RecipeIngredient(HornItem.HORN_ITEM));
        recipe.mapIngredient('R', new RecipeIngredient(Material.SLIME_BALL));
        recipe.register();
    }
}
