package minevalley.lib.itemcommons;

import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public interface CustomItem {

    @Nonnull
    @Contract(pure = true)
    ItemStack asItemStack();

}