package minevalley.lib.itemcommons.technology.vehicles;

import minevalley.core.api.Core;
import minevalley.crafting.api.Crafting;
import minevalley.crafting.api.ingredient.RecipeIngredient;
import minevalley.crafting.api.recipe.CustomRecipe;
import minevalley.lib.itemcommons.CustomItem;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@SuppressWarnings("unused")
public class CarWheelItem implements CustomItem {

    private static final Material MATERIAL = Material.SHEARS;

    public static final ItemStack CAR_WHEEL_NORMAL_ITEM = Core.createItem(MATERIAL)
            .setCustomModelData(1)
            .setDisplayName("Autorad", NamedTextColor.WHITE)
            .setLore(NamedTextColor.GRAY, "Allwetter-Bereifung")
            .setMaxStackSize(4)
            .build();

    public static final ItemStack CAR_WHEEL_SPEED_ITEM = Core.createItem(MATERIAL)
            .setCustomModelData(1)
            .setDisplayName("Autorad", NamedTextColor.WHITE)
            .setLore(NamedTextColor.GRAY, "Racing-Bereifung", "+10% Geschwindigkeit", "+20% Verschleiß")
            .setMaxStackSize(4)
            .build();

    public static final ItemStack CAR_WHEEL_HANDLING_ITEM = Core.createItem(MATERIAL)
            .setCustomModelData(1)
            .setDisplayName("Autorad", NamedTextColor.WHITE)
            .setLore(NamedTextColor.GRAY, "Offroad-Bereifung", "+20% Handling", "-20% Geschwindigkeit")
            .setMaxStackSize(4)
            .build();

    @Override
    public @Nonnull ItemStack asItemStack() {
        return CAR_WHEEL_SPEED_ITEM.clone();
    }

    private static void registerRecipes() {
        final CustomRecipe normal = Crafting.createCustomRecipe(CAR_WHEEL_NORMAL_ITEM, new String[]{"AAA", "ABA", "AAA"}, 1_000);
        normal.mapIngredient('A', new RecipeIngredient(Material.SLIME_BALL));
        normal.mapIngredient('B', new RecipeIngredient(CarRimItem.CAR_RIM_ITEM));
        normal.register();

        final CustomRecipe repairNormal = Crafting.createCustomRecipe(CAR_WHEEL_NORMAL_ITEM, new String[]{"AAA", "ABA", "AAA"}, 1_000);
        repairNormal.mapIngredient('A', new RecipeIngredient(Material.SLIME_BALL));
        repairNormal.mapIngredient('B', new RecipeIngredient(CarWheelItem::isCarWheel));
        repairNormal.register();

        final CustomRecipe repairSpeed = Crafting.createCustomRecipe(CAR_WHEEL_SPEED_ITEM, new String[]{"AAA", "ABA", "AAA"}, 1_000);
        repairSpeed.mapIngredient('A', new RecipeIngredient(Material.FLINT));
        repairSpeed.mapIngredient('B', new RecipeIngredient(itemStack -> itemStack.getType() == MATERIAL
                && itemStack.hasItemMeta() && itemStack.getItemMeta().getCustomModelData() == 1));
        repairSpeed.register();

        final CustomRecipe repairHandling = Crafting.createCustomRecipe(CAR_WHEEL_HANDLING_ITEM, new String[]{"ABA", "BCB", "ABA"}, 1_000);
        repairHandling.mapIngredient('A', new RecipeIngredient(Material.SLIME_BALL));
        repairHandling.mapIngredient('B', new RecipeIngredient(Material.FLINT));
        repairHandling.mapIngredient('C', new RecipeIngredient(CarWheelItem::isCarWheel));
        repairHandling.register();
    }

    @Contract(value = "null -> false", pure = true)
    public static boolean isCarWheel(@Nullable ItemStack itemStack) throws IllegalArgumentException {
        if (itemStack == null) return false;
        return itemStack.getType() == MATERIAL
                && itemStack.hasItemMeta() && itemStack.getItemMeta().getCustomModelData() == 1;
    }
}
