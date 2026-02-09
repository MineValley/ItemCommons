package minevalley.lib.itemcommons.technology;

import lombok.RequiredArgsConstructor;
import minevalley.core.api.Core;
import minevalley.core.api.utils.CustomItemFlag;
import minevalley.crafting.api.Crafting;
import minevalley.crafting.api.ingredient.RecipeIngredient;
import minevalley.crafting.api.recipe.CustomRecipe;
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

@RequiredArgsConstructor
@SuppressWarnings("unused")
public class CopperCoilItem implements CustomItem {

    private static final String SKULL = "b3652284921a2dba440060f2f63aa3ba2b0df62c9c36bf7883acedc336df911b";
    public static @Nonnull TextComponent DISPLAY_NAME =
            Component.text("Kupferspule", TextColor.color(95, 104, 117))
                    .decoration(TextDecoration.ITALIC, false);

    private final int level;

    @Override
    public @Nonnull ItemStack asItemStack() {
        return Core.createItem(SKULL)
                .setDisplayName(DISPLAY_NAME)
                .setLore(NamedTextColor.GRAY, 64 * level + " Windungen")
                .addCustomItemFlags(CustomItemFlag.PREVENT_PLACING)
                .setMaxStackSize(16)
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
        return new CopperCoilItem(level).asItemStack();
    }

    public static void registerRecipes() {
        final CustomRecipe recipe = Crafting.createCustomRecipe(getLevel1(),
                new String[]{"CCC", "CIC", "CCC"}, 0);
        recipe.mapIngredient('C', new RecipeIngredient(Material.COPPER_INGOT));
        recipe.mapIngredient('I', new RecipeIngredient(Material.IRON_BLOCK));
        recipe.register();

        for (int i = 1; i < 16; i++) {
            final CustomRecipe current = Crafting.createCustomRecipe(getByLevel(i + 1),
                    new String[]{"CCC", "CIC", "CCC"}, 0);
            current.mapIngredient('C', new RecipeIngredient(Material.COPPER_INGOT));
            current.mapIngredient('I', new RecipeIngredient(new CopperCoilItem(i).asItemStack()));
            current.register();
        }
    }
}
