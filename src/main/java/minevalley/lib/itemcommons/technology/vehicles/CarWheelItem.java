package minevalley.lib.itemcommons.technology.vehicles;

import minevalley.core.api.Core;
import minevalley.core.api.utils.CustomItemFlag;
import minevalley.crafting.api.Crafting;
import minevalley.crafting.api.ingredient.RecipeIngredient;
import minevalley.crafting.api.recipe.CustomShapedRecipe;
import minevalley.lib.itemcommons.CustomItem;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Objects;

@SuppressWarnings("unused")
public class CarWheelItem implements CustomItem {

    private static final String SKULL = "ddfe5a963869415340d2cec0f82d08df73dcb168428487b514aa8d4ec19fe2c";
    private static final TextComponent DISPLAY_NAME = Component.text("Autorad").color(NamedTextColor.WHITE);

    public static final ItemStack CAR_WHEEL_NORMAL_ITEM = Core.createItem(SKULL)
            .setDisplayName(DISPLAY_NAME)
            .setLore(NamedTextColor.GRAY, "Allwetter-Bereifung")
            .addCustomItemFlags(CustomItemFlag.PREVENT_PLACING)
            .setMaxStackSize(4)
            .build();

    public static final ItemStack CAR_WHEEL_SPEED_ITEM = Core.createItem(SKULL)
            .setDisplayName(DISPLAY_NAME)
            .setLore(NamedTextColor.GRAY, "Racing-Bereifung", "+10% Geschwindigkeit", "+20% Verschleiß")
            .addCustomItemFlags(CustomItemFlag.PREVENT_PLACING)
            .setMaxStackSize(4)
            .build();

    public static final ItemStack CAR_WHEEL_HANDLING_ITEM = Core.createItem(SKULL)
            .setDisplayName(DISPLAY_NAME)
            .setLore(NamedTextColor.GRAY, "Offroad-Bereifung", "+20% Handling", "-20% Geschwindigkeit")
            .addCustomItemFlags(CustomItemFlag.PREVENT_PLACING)
            .setMaxStackSize(4)
            .build();

    @Override
    public @Nonnull ItemStack asItemStack() {
        return CAR_WHEEL_SPEED_ITEM.clone();
    }

    public static void registerRecipes() {
        final CustomShapedRecipe normal = Crafting.createCustomRecipe(CAR_WHEEL_NORMAL_ITEM, new String[]{"AAA", "ABA", "AAA"}, 1_000);
        normal.mapIngredient('A', new RecipeIngredient(Material.SLIME_BALL));
        normal.mapIngredient('B', new RecipeIngredient(CarRimItem.CAR_RIM_ITEM));
        normal.register();

        final CustomShapedRecipe repairHandling = Crafting.createCustomRecipe(CAR_WHEEL_SPEED_ITEM, new String[]{"ABA", "BCB", "ABA"}, 1_000);
        repairHandling.mapIngredient('A', new RecipeIngredient(Material.SLIME_BALL));
        repairHandling.mapIngredient('B', new RecipeIngredient(Material.FLINT));
        repairHandling.mapIngredient('C', new RecipeIngredient(CarWheelItem::isCarWheel));
        repairHandling.register();

        final CustomShapedRecipe repairSpeed = Crafting.createCustomRecipe(CAR_WHEEL_HANDLING_ITEM, new String[]{"AAA", "ABA", "AAA"}, 1_000);
        repairSpeed.mapIngredient('A', new RecipeIngredient(Material.SLIME_BALL));
        repairSpeed.mapIngredient('B', new RecipeIngredient(CarWheelItem::isCarWheel));
        repairSpeed.register();
    }

    @Contract(value = "null -> false", pure = true)
    public static boolean isCarWheel(@Nullable ItemStack itemStack) throws IllegalArgumentException {
        if (itemStack == null) return false;
        return itemStack.hasItemMeta() && itemStack.getItemMeta().hasDisplayName()
                && Objects.equals(itemStack.getItemMeta().displayName(), DISPLAY_NAME);
    }
}
