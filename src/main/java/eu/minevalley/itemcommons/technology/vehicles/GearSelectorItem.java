package eu.minevalley.itemcommons.technology.vehicles;

import eu.minevalley.itemcommons.CustomItem;
import eu.minevalley.itemcommons.ItemCommons;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public class GearSelectorItem implements CustomItem {

    public static final @Nonnull Material MATERIAL = Material.NAUTILUS_SHELL;
    public static final @Nonnull NamespacedKey ITEM_MODEL = new NamespacedKey("minevalley", "tool/vehicle/gear_selector");

    public static final ItemStack BLUE_LIGHT_ITEM = ItemCommons.core().createItem(MATERIAL)
            .setItemModel(ITEM_MODEL)
            .setDisplayName("Gangwahlhebel", NamedTextColor.WHITE)
            .setMaxStackSize(16)
            .build();

    @Override
    public @Nonnull ItemStack asItemStack() {
        return BLUE_LIGHT_ITEM.clone();
    }
}
