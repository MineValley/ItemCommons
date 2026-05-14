package eu.minevalley.itemcommons.technology.vehicles;

import eu.minevalley.core.api.item.CustomItemFlag;
import eu.minevalley.crafting.api.Crafting;
import eu.minevalley.crafting.api.ingredient.RecipeIngredient;
import eu.minevalley.crafting.api.recipe.CustomShapedRecipe;
import eu.minevalley.itemcommons.CustomItem;
import eu.minevalley.itemcommons.ItemCommons;
import eu.minevalley.itemcommons.technology.ScrewItem;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public class CarRimItem implements CustomItem {

    public static final ItemStack CAR_RIM_ITEM = ItemCommons.core().createItem("d70752fc4c37d3a39ee68d88372789ed13192d9785a67fa580143aa81ba0c2a3")
            .setDisplayName("Felge", NamedTextColor.WHITE)
            .addCustomItemFlags(CustomItemFlag.PREVENT_PLACING)
            .setMaxStackSize(4)
            .build();

    @Override
    public @Nonnull ItemStack asItemStack() {
        return CAR_RIM_ITEM.clone();
    }

    public static void registerRecipe() {
        final CustomShapedRecipe recipe = Crafting.createCustomRecipe(CAR_RIM_ITEM, new String[]{" S ", "SBS", " S "}, 4_000);
        recipe.mapIngredient('B', new RecipeIngredient(Material.NETHER_BRICK));
        recipe.mapIngredient('S', new RecipeIngredient(ScrewItem.SCREW_ITEM));
        recipe.register();
    }
}
