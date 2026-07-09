package eu.minevalley.itemcommons.gadgets;

import eu.minevalley.core.api.item.CustomItemFlag;
import eu.minevalley.core.api.user.OnlineUser;
import eu.minevalley.itemcommons.CustomItem;
import eu.minevalley.itemcommons.ItemCommons;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@SuppressWarnings("unused")
public class MasterKeyItem implements CustomItem {

    public static final ItemStack KEY = ItemCommons.core().createItem(Material.NAUTILUS_SHELL)
            .setDisplayName(Component.text("Universalschlüssel", TextColor.color(70, 178, 224))
                    .decoration(TextDecoration.ITALIC, false))
            .setLore(
                    Component.text("Öffnet sämtliche Spielersicherungen", NamedTextColor.GRAY).decoration(TextDecoration.ITALIC, false),
                    Component.text("Zum Entfernen, Schlüssel ", NamedTextColor.GRAY).decoration(TextDecoration.ITALIC, false)
                            .append(Component.text("droppen", NamedTextColor.RED))
                            .append(Component.text("!", NamedTextColor.GRAY)))
            .addCustomItemFlags(CustomItemFlag.KEEP_IN_INVENTORY, CustomItemFlag.PREVENT_DROPPING,
                    CustomItemFlag.PREVENT_CRAFTING, CustomItemFlag.TEMPORARY)
            .setItemModel(NamespacedKey.fromString("minevalley:tool/key"))
            .setMaxStackSize(1)
            .build();

    @Override
    public @Nonnull ItemStack asItemStack() {
        return KEY.clone();
    }

    @Contract(value = "null -> false", pure = true)
    public static boolean isMasterKey(@Nullable ItemStack stack) {
        if (stack == null) return false;
        return KEY.isSimilar(stack);
    }

    public static boolean isHoldingMasterKey(@Nonnull OnlineUser user) {
        if (!user.isTeamler()) return false;
        if (!user.team().isAllowedToUseGeneralKey()) return false;
        return isMasterKey(user.player().getInventory().getItemInMainHand());
    }
}