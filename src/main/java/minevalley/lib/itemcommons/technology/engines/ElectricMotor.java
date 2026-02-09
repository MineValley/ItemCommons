package minevalley.lib.itemcommons.technology.engines;

import minevalley.lib.itemcommons.CustomItem;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public enum ElectricMotor implements CustomItem {
    ;

    @Override
    public @Nonnull ItemStack asItemStack() {
        throw new UnsupportedOperationException("This item is not implemented yet.");
    }

    public static void registerRecipes() {
        // logic for registering recipes will go here
    }
}