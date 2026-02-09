package minevalley.lib.itemcommons.gadgets;

import lombok.RequiredArgsConstructor;
import minevalley.core.api.Core;
import minevalley.core.api.utils.CustomItemFlag;
import minevalley.lib.itemcommons.abstracts.CustomModelDataItem;
import minevalley.lib.itemcommons.abstracts.NonSkullItem;
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
public class WalletItem implements NonSkullItem, CustomModelDataItem {

    public static @Nonnull Material MATERIAL = Material.NETHER_STAR;
    public static @Nonnull TextComponent DISPLAY_NAME =
            Component.text("Geldbeutel", TextColor.color(158, 95, 49))
                    .decoration(TextDecoration.ITALIC, false);
    public static @Nonnull TextComponent[] LORE = new TextComponent[]{
            Component.text("Zur sicheren Aufbewahrung deiner Bankkarten", NamedTextColor.GRAY)
                    .decoration(TextDecoration.ITALIC, false),
            Component.text("Wenn du stirbst, können andere Spieler", NamedTextColor.RED)
                    .decoration(TextDecoration.ITALIC, false),
            Component.text("Teile deines Bargelds stehlen!", NamedTextColor.RED)
                    .decoration(TextDecoration.ITALIC, false)
    };
    public static final int CUSTOM_MODEL_DATA_OPEN = 11;
    public static final int CUSTOM_MODEL_DATA_CLOSED = 12;

    private final boolean open;

    @Override
    public @Nonnull Material material() {
        return MATERIAL;
    }

    @Override
    public @Nonnull TextComponent displayName() {
        return DISPLAY_NAME;
    }

    @Override
    public @Nonnull TextComponent[] lore() {
        return LORE;
    }

    @Override
    public int customModelData() {
        return open ? CUSTOM_MODEL_DATA_OPEN : CUSTOM_MODEL_DATA_CLOSED;
    }

    @Override
    public @Nonnull ItemStack asItemStack() {
        return Core.createItem(material())
                .setDisplayName(DISPLAY_NAME)
                .setLore(LORE)
                .addItemFlags(ItemFlag.HIDE_ADDITIONAL_TOOLTIP)
                .addCustomItemFlags(CustomItemFlag.KEEP_IN_INVENTORY, CustomItemFlag.PREVENT_DROPPING)
                .setCustomModelData(customModelData())
                .setMaxStackSize(1)
                .setTooltipStyle(new NamespacedKey("minecraft", "wallet"))
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