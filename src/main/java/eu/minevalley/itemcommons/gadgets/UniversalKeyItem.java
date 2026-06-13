package eu.minevalley.itemcommons.gadgets;

import eu.minevalley.core.api.item.CustomItemFlag;
import eu.minevalley.core.api.user.OnlineUser;
import eu.minevalley.itemcommons.CustomItem;
import eu.minevalley.itemcommons.ItemCommons;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@SuppressWarnings("unused")
public class UniversalKeyItem implements CustomItem {

    public static @Nonnull Material MATERIAL = Material.NETHER_STAR;
    public static final NamespacedKey ITEM_MODEL = NamespacedKey.fromString("minevalley:tool/key");
    public static @Nonnull TextComponent DISPLAY_NAME =
            Component.text("Universalschlüssel", TextColor.color(70, 178, 224))
                    .decoration(TextDecoration.ITALIC, false);
    public static @Nonnull TextComponent[] LORE = new TextComponent[]{
            Component.text("Öffnet sämtliche Spielersicherungen", NamedTextColor.GRAY).decoration(TextDecoration.ITALIC, false),
            Component.text("Zum Entfernen, Schlüssel ", NamedTextColor.GRAY).decoration(TextDecoration.ITALIC, false)
                    .append(Component.text("droppen", NamedTextColor.RED))
                    .append(Component.text("!", NamedTextColor.GRAY))};

    @Override
    public @Nonnull ItemStack asItemStack() {
        return ItemCommons.core().createItem(MATERIAL)
                .setDisplayName(DISPLAY_NAME)
                .setLore(LORE)
                .addItemFlags(ItemFlag.HIDE_ADDITIONAL_TOOLTIP)
                .addCustomItemFlags(CustomItemFlag.KEEP_IN_INVENTORY, CustomItemFlag.PREVENT_DROPPING,
                        CustomItemFlag.PREVENT_CRAFTING, CustomItemFlag.TEMPORARY)
                .setItemModel(ITEM_MODEL)
                .setMaxStackSize(1)
                .setTooltipStyle(new NamespacedKey("minecraft", "wallet"))
                .build();
    }

    @Contract(value = "null -> false", pure = true)
    public static boolean isUniversalKey(@Nullable ItemStack stack) {
        if (stack == null) return false;
        return new UniversalKeyItem().asItemStack().isSimilar(stack);
    }

    public static boolean isHoldingUniversalKey(@Nonnull OnlineUser user) {
        if (!user.isTeamler()) return false;
        if (!user.team().isAllowedToUseGeneralKey()) return false;
        return isUniversalKey(user.player().getActiveItem());
    }
}