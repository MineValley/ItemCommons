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
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@SuppressWarnings("unused")
@RequiredArgsConstructor
public class WalletItem implements NonSkullItem, CustomModelDataItem {

    private final boolean open;

    @Override
    public @Nonnull Material material() {
        return Material.GOLDEN_SWORD;
    }

    @Override
    public @Nonnull TextComponent displayName() {
        return Component.text("Geldbeutel", TextColor.color(156, 77, 20));
    }

    @Override
    public @Nonnull TextComponent[] lore() {
        return new TextComponent[]{
                Component.text("Bewahre dein Bargeld und deine Bankkarten sicher auf!", NamedTextColor.GRAY),
                Component.text("Wenn du stirbst, können andere Spieler Teile deines Bargelds stehlen!", NamedTextColor.RED)
        };
    }

    @Override
    public int customModelData() {
        return open ? 11 : 12;
    }

    @Override
    public @Nonnull ItemStack asItemStack() {
        return Core.createItem(material()).setDisplayName(displayName()).setLore(lore())
                .addCustomItemFlags(CustomItemFlag.KEEP_IN_INVENTORY, CustomItemFlag.PREVENT_DROPPING).build();
    }

    @Contract(value = "null -> false", pure = true)
    public static boolean isWallet(@Nullable ItemStack stack) {
        if (stack == null) return false;
        return isOpenWallet(stack) || isClosedWallet(stack);
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