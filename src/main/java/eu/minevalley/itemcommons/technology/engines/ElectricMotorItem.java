package eu.minevalley.itemcommons.technology.engines;

import eu.minevalley.itemcommons.CustomItem;
import eu.minevalley.itemcommons.technology.CopperCoilItem;
import eu.minevalley.itemcommons.technology.ScrewItem;
import lombok.RequiredArgsConstructor;
import minevalley.core.api.Core;
import minevalley.core.api.item.CustomItemFlag;
import minevalley.crafting.api.Crafting;
import minevalley.crafting.api.ingredient.RecipeIngredient;
import minevalley.crafting.api.recipe.CustomShapedRecipe;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
@RequiredArgsConstructor
public class ElectricMotorItem implements CustomItem {

    private static final String SKULL = "fb9051485e15700418022e38a5db28a049a2e627c5ffa56fd313bcdead406a8e";
    public static final @Nonnull TextComponent DISPLAY_NAME =
            Component.text("Elektromotor", TextColor.color(95, 104, 117))
                    .decoration(TextDecoration.ITALIC, false);

    private final int kilowatts;

    @Override
    public @Nonnull ItemStack asItemStack() {
        return Core.createItem(SKULL)
                .setDisplayName(DISPLAY_NAME)
                .setLore(NamedTextColor.GRAY, kilowatts + " kW")
                .addCustomItemFlags(CustomItemFlag.PREVENT_PLACING)
                .setMaxStackSize(1)
                .build();
    }

    public static void registerRecipes() {
        for (int i = 0; i < 293; i++) {
            final CopperCoilItem coil = new CopperCoilItem(i);
            final CustomShapedRecipe current = Crafting.createCustomRecipe(new ElectricMotorItem(i + 1).asItemStack(),
                    new String[]{"SCRCS", "BAIAB", "SCTCS"}, i * 20_000);
            current.mapIngredient('S', new RecipeIngredient(ScrewItem.SCREW_ITEM));
            current.mapIngredient('C', new RecipeIngredient(CopperCoilItem.getByLevel(i + 1)));
            current.mapIngredient('R', new RecipeIngredient(Material.REPEATER));
            current.mapIngredient('B', new RecipeIngredient(Material.IRON_BARS));
            current.mapIngredient('A', new RecipeIngredient(Material.BREEZE_ROD));
            current.mapIngredient('I', new RecipeIngredient(Material.IRON_BLOCK));
            current.mapIngredient('T', new RecipeIngredient(Material.COMPARATOR));
            current.register();
        }
    }
}