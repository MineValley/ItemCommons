package eu.minevalley.itemcommons.gadgets;

import eu.minevalley.core.api.item.CustomItemFlag;
import eu.minevalley.itemcommons.CustomItem;
import eu.minevalley.itemcommons.ItemCommons;
import lombok.RequiredArgsConstructor;
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
import java.util.Objects;

@SuppressWarnings("unused")
@RequiredArgsConstructor
public class WalletItem implements CustomItem {

    public static @Nonnull Material MATERIAL = Material.NAUTILUS_SHELL;
    public static @Nonnull TextComponent DISPLAY_NAME =
            Component.text("Geldbeutel", TextColor.color(171, 109, 63))
                    .decoration(TextDecoration.ITALIC, false);
    public static @Nonnull TextComponent[] LORE = new TextComponent[]{
            Component.text("Zur sicheren Aufbewahrung deiner Bankkarten", NamedTextColor.GRAY)
                    .decoration(TextDecoration.ITALIC, false),
            Component.text("Wenn du stirbst, können andere Spieler", TextColor.color(171, 90, 79))
                    .decoration(TextDecoration.ITALIC, false),
            Component.text("Teile deines Bargelds stehlen!", TextColor.color(171, 90, 79))
                    .decoration(TextDecoration.ITALIC, false)
    };
    public static final NamespacedKey MODEL_OPEN = NamespacedKey.fromString("minevalley:tool/wallet/open");
    public static final NamespacedKey MODEL_CLOSED = NamespacedKey.fromString("minevalley:tool/wallet/closed");

    private final boolean open;

    public NamespacedKey itemModel() {
        return open ? MODEL_OPEN : MODEL_CLOSED;
    }

    @Override
    public @Nonnull ItemStack asItemStack() {
        return ItemCommons.core().createItem(MATERIAL)
                .setDisplayName(DISPLAY_NAME)
                .setLore(LORE)
                .addItemFlags(ItemFlag.HIDE_ADDITIONAL_TOOLTIP)
                .addCustomItemFlags(CustomItemFlag.KEEP_IN_INVENTORY, CustomItemFlag.PREVENT_DROPPING,
                        CustomItemFlag.PREVENT_CRAFTING)
                .setItemModel(itemModel())
                .setMaxStackSize(1)
                .setTooltipStyle(new NamespacedKey("minevalley", "wallet"))
                .build();
    }

    @Contract(value = "null -> false", pure = true)
    public static boolean isWallet(@Nullable ItemStack stack) {
        if (stack == null) return false;
        return stack.getType() == MATERIAL
               && stack.hasItemMeta()
               && Objects.equals(stack.getItemMeta().displayName(), DISPLAY_NAME);
    }

    @Contract(value = "null -> false", pure = true)
    public static boolean isOpenWallet(@Nullable ItemStack stack) {
        if (stack == null) return false;
        return new WalletItem(true).asItemStack().isSimilar(stack);
    }

    @Contract(value = "null -> false", pure = true)
    public static boolean isClosedWallet(@Nullable ItemStack stack) {
        if (stack == null) return false;
        return new WalletItem(false).asItemStack().isSimilar(stack);
    }
}