package minevalley.lib.itemcommons.technology;

import lombok.RequiredArgsConstructor;
import minevalley.core.api.Core;
import minevalley.crafting.api.Crafting;
import minevalley.crafting.api.ingredient.RecipeIngredient;
import minevalley.crafting.api.recipe.CustomShapedRecipe;
import minevalley.lib.itemcommons.CustomItem;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
@RequiredArgsConstructor
public class BatteryItem implements CustomItem {

    private static final String SKULL = "d0200b44dd74289044304c26fd7ade4069d7e62c4e9dc5bc14f4c6459e5f8";
    public static @Nonnull TextComponent DISPLAY_NAME =
            Component.text("Akku", TextColor.color(212, 101, 93))
                    .decoration(TextDecoration.ITALIC, false);

    private final int level;

    @Override
    public @Nonnull ItemStack asItemStack() {
        return Core.createItem(SKULL)
                .setDisplayName(DISPLAY_NAME)
                .setLore(NamedTextColor.GRAY, "Kapazität: " + (5 * level) + " kWh")
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
        return new BatteryItem(level).asItemStack();
    }

    public static void registerRecipes() {
        final CustomShapedRecipe recipe = Crafting.createCustomRecipe(getLevel1(),
                new String[]{"BCB", "BAB", "BAB"}, 0);
        recipe.mapIngredient('B', new RecipeIngredient(Material.IRON_BARS));
        recipe.mapIngredient('C', new RecipeIngredient(Material.COPPER_INGOT));
        recipe.mapIngredient('A', new RecipeIngredient(Material.AMETHYST_SHARD));
        recipe.register();

        for (int i = 1; i < 16; i++) {
            final CustomShapedRecipe current = Crafting.createCustomRecipe(getByLevel(i + 1),
                    new String[]{"AAA", "ABA", "AAA"}, 0);
            current.mapIngredient('A', new RecipeIngredient(Material.AMETHYST_SHARD));
            current.mapIngredient('B', new RecipeIngredient(new BatteryItem(i).asItemStack()));
            current.register();
        }
    }
}
