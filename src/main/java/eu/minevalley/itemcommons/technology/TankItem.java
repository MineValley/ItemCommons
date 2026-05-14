package eu.minevalley.itemcommons.technology;

import eu.minevalley.crafting.api.Crafting;
import eu.minevalley.crafting.api.ingredient.RecipeIngredient;
import eu.minevalley.crafting.api.recipe.CustomShapedRecipe;
import eu.minevalley.itemcommons.CustomItem;
import eu.minevalley.itemcommons.ItemCommons;
import lombok.RequiredArgsConstructor;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
@RequiredArgsConstructor
public class TankItem implements CustomItem {

    private static final Material MATERIAL = Material.BARREL;

    private final int level;

    @Override
    public @Nonnull ItemStack asItemStack() {
        return ItemCommons.core().createItem(MATERIAL)
                .setDisplayName("Tank", NamedTextColor.WHITE)
                .setLore(NamedTextColor.GRAY, "Kapazität: " + (level * 5) + " Liter")
                .setMaxStackSize(4)
                .build();
    }

    @Nonnull
    @Contract(pure = true)
    public static ItemStack getLevel1() {
        return getByLevel(1);
    }

    @Nonnull
    @Contract(pure = true)
    public static ItemStack getByLevel(int level) {
        return new TankItem(level).asItemStack();
    }

    public static void registerRecipes() {
        final CustomShapedRecipe recipe = Crafting.createCustomRecipe(getLevel1(), new String[]{"III", "IBI", "III"}, 0);
        recipe.mapIngredient('I', new RecipeIngredient(Material.IRON_INGOT));
        recipe.mapIngredient('B', new RecipeIngredient(Material.BARREL));
        recipe.register();

        for (int i = 1; i <= 16; i++) {
            final CustomShapedRecipe upgradeRecipe = Crafting.createCustomRecipe(new TankItem(i + 1).asItemStack(), new String[]{"III", "ITI", "III"}, 0);
            upgradeRecipe.mapIngredient('I', new RecipeIngredient(Material.IRON_INGOT));
            upgradeRecipe.mapIngredient('T', new RecipeIngredient(new TankItem(i).asItemStack()));
            upgradeRecipe.register();
        }
    }
}
