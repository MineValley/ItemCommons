package minevalley.lib.itemcommons.technology.vehicles;

import lombok.RequiredArgsConstructor;
import minevalley.crafting.api.Crafting;
import minevalley.crafting.api.ingredient.RecipeIngredient;
import minevalley.crafting.api.recipe.CustomRecipe;
import minevalley.lib.itemcommons.CustomItem;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
@RequiredArgsConstructor
public class SeatItem implements CustomItem {

    private final static ItemStack LEATHER_SEAT_ITEM = new ItemStack(Material.LEATHER);
    private final static ItemStack SEAT_ITEM = new ItemStack(Material.OAK_SIGN);

    private final boolean leather;

    @Override
    public @Nonnull ItemStack asItemStack() {
        return (leather ? LEATHER_SEAT_ITEM : SEAT_ITEM).clone();
    }

    public static void registerRecipes() {
        final CustomRecipe recipe = Crafting.createCustomRecipe(SEAT_ITEM, new String[]{"W    ", "S    ", "W    ", "WL   ", " HWW "}, 20_000);
        recipe.mapIngredient('W', new RecipeIngredient(itemStack -> itemStack.getType() == Material.GRAY_WOOL && itemStack.getAmount() >= 3, itemStack -> itemStack.subtract(3)));
        recipe.mapIngredient('S', new RecipeIngredient(itemStack -> itemStack.getType() == Material.BREEZE_ROD && itemStack.getAmount() >= 2, itemStack -> itemStack.subtract(2)));
        recipe.mapIngredient('L', new RecipeIngredient(Material.LEAD));
        recipe.mapIngredient('H', new RecipeIngredient(Material.TRIPWIRE_HOOK));
        recipe.register();

        final CustomRecipe leatherRecipe = Crafting.createCustomRecipe(LEATHER_SEAT_ITEM, new String[]{"W    ", "S    ", "W    ", "WL   ", " HWW "}, 20_000);
        leatherRecipe.mapIngredient('W', new RecipeIngredient(itemStack -> itemStack.getType() == Material.LEATHER && itemStack.getAmount() >= 3, itemStack -> itemStack.subtract(3)));
        leatherRecipe.mapIngredient('S', new RecipeIngredient(itemStack -> itemStack.getType() == Material.BREEZE_ROD && itemStack.getAmount() >= 2, itemStack -> itemStack.subtract(2)));
        leatherRecipe.mapIngredient('L', new RecipeIngredient(Material.LEAD));
        leatherRecipe.mapIngredient('H', new RecipeIngredient(Material.TRIPWIRE_HOOK));
        leatherRecipe.register();
    }
}
