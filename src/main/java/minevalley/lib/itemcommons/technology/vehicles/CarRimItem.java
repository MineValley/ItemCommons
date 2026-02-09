package minevalley.lib.itemcommons.technology.vehicles;

import minevalley.core.api.Core;
import minevalley.crafting.api.Crafting;
import minevalley.crafting.api.ingredient.RecipeIngredient;
import minevalley.crafting.api.recipe.CustomRecipe;
import minevalley.lib.itemcommons.CustomItem;
import minevalley.lib.itemcommons.technology.ScrewItem;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public class CarRimItem implements CustomItem {

    public static final ItemStack CAR_RIM_ITEM = Core.createItem(Material.STONE)
            .setDisplayName("Felge", NamedTextColor.WHITE)
            .setMaxStackSize(4)
            .build();

    @Override
    public @Nonnull ItemStack asItemStack() {
        return CAR_RIM_ITEM.clone();
    }

    public static void registerRecipe() {
        final CustomRecipe recipe = Crafting.createCustomRecipe(CAR_RIM_ITEM, new String[]{" S ", "SBS", " S "}, 4_000);
        recipe.mapIngredient('B', new RecipeIngredient(Material.NETHER_BRICK));
        recipe.mapIngredient('S', new RecipeIngredient(ScrewItem.SCREW_ITEM));
        recipe.register();
    }
}
