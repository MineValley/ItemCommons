package minevalley.lib.itemcommons.gadgets.phone;

import lombok.RequiredArgsConstructor;
import minevalley.core.api.Core;
import minevalley.core.api.utils.CustomItemFlag;
import minevalley.lib.itemcommons.CustomItem;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkEffectMeta;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Objects;

@SuppressWarnings("unused")
@RequiredArgsConstructor
public class PhoneItem implements CustomItem {

    public static @Nonnull Material MATERIAL = Material.FIREWORK_STAR;
    public static @Nonnull TextComponent DISPLAY_NAME =
            Component.text("Handy", TextColor.color(135, 184, 199))
                    .decoration(TextDecoration.ITALIC, false);
    public static @Nonnull TextComponent[] LORE = new TextComponent[]{
            Component.text("Installiere dir Apps und", NamedTextColor.GRAY)
                    .decoration(TextDecoration.ITALIC, false),
            Component.text("kommuniziere mit Freunden", NamedTextColor.GRAY)
                    .decoration(TextDecoration.ITALIC, false)
    };
    private final PhoneScreen screen;
    private final Color color;

    @Override
    public @Nonnull ItemStack asItemStack() {
        final ItemStack item = Core.createItem(MATERIAL)
                .setDisplayName(DISPLAY_NAME)
                .setLore(LORE)
                .setCustomModelData(screen.getCustomModelData())
                .addItemFlags(ItemFlag.HIDE_ADDITIONAL_TOOLTIP)
                .addCustomItemFlags(CustomItemFlag.KEEP_IN_INVENTORY, CustomItemFlag.PREVENT_DROPPING)
                .setMaxStackSize(1)
                .setTooltipStyle(new NamespacedKey("minecraft", "phone"))
                .build();
        item.editMeta(FireworkEffectMeta.class,
                meta -> meta.setEffect(FireworkEffect.builder().withColor(color).build()));
        return item;
    }

    @Contract(value = "null -> false", pure = true)
    public static boolean isPhone(@Nullable ItemStack stack) {
        if (stack == null) return false;
        return stack.getType() == MATERIAL
                && stack.hasItemMeta()
                && Objects.equals(stack.getItemMeta().displayName(), DISPLAY_NAME);
    }
}
