package eu.minevalley.itemcommons.technology.vehicles;

import eu.minevalley.core.api.item.CustomItemFlag;
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
public class AirbagItem implements CustomItem {

    public static final ItemStack AIRBAG_ITEM = ItemCommons.core().createItem(Material.LIGHT_GRAY_WOOL)
            .setDisplayName("Airbag", NamedTextColor.WHITE)
            .addCustomItemFlags(CustomItemFlag.PREVENT_PLACING)
            .setMaxStackSize(16)
            .build();

    @Override
    public @Nonnull ItemStack asItemStack() {
        return AIRBAG_ITEM.clone();
    }

    public static void registerRecipe() {
        final CustomShapedRecipe recipe = Crafting.createCustomRecipe(AIRBAG_ITEM.asQuantity(4), new String[]{"WWW", "WTW", "WWW"}, 0);
        recipe.mapIngredient('W', new RecipeIngredient(Material.WHITE_WOOL));
        recipe.mapIngredient('T', new RecipeIngredient(Material.TNT));
        recipe.register();
    }
}
