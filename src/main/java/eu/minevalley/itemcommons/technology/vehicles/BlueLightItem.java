package eu.minevalley.itemcommons.technology.vehicles;

import eu.minevalley.crafting.api.Crafting;
import eu.minevalley.crafting.api.ingredient.RecipeIngredient;
import eu.minevalley.crafting.api.recipe.CustomShapedRecipe;
import eu.minevalley.itemcommons.CustomItem;
import eu.minevalley.itemcommons.ItemCommons;
import eu.minevalley.itemcommons.technology.LightBulbItem;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public class BlueLightItem implements CustomItem {

    public static @Nonnull Material MATERIAL = Material.NETHER_STAR;
    public static final NamespacedKey ITEM_MODEL_OFF = NamespacedKey.fromString("minevalley:tool/vehicle/siren_off");
    public static final NamespacedKey ITEM_MODEL_ON = NamespacedKey.fromString("minevalley:tool/vehicle/siren_on");
    public static final NamespacedKey KEY_LICENCE_PLATE = new NamespacedKey("minevalley", "licence_plate");
    public static final NamespacedKey KEY_KEY_INDEX = new NamespacedKey("minevalley", "key_index");

    public static final ItemStack BLUE_LIGHT_ITEM = ItemCommons.core().createItem(MATERIAL)
            .setItemModel(ITEM_MODEL_OFF)
            .setDisplayName("Blaulicht", NamedTextColor.WHITE)
            .setMaxStackSize(16)
            .build();

    @Override
    public @Nonnull ItemStack asItemStack() {
        return BLUE_LIGHT_ITEM.clone();
    }

    public static void registerRecipe() {
        final CustomShapedRecipe recipe = Crafting.createCustomRecipe(BLUE_LIGHT_ITEM, new String[]{"GGG", "BBB", "ICI"}, 0);
        recipe.mapIngredient('G', new RecipeIngredient(Material.BLUE_STAINED_GLASS));
        recipe.mapIngredient('B', new RecipeIngredient(LightBulbItem.LIGHT_BULB_ITEM));
        recipe.mapIngredient('I', new RecipeIngredient(Material.IRON_BLOCK));
        recipe.mapIngredient('C', new RecipeIngredient(Material.COPPER_BLOCK));
        recipe.register();
    }
}
