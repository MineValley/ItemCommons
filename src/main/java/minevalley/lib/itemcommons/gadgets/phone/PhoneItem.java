package minevalley.lib.itemcommons.gadgets.phone;

import lombok.RequiredArgsConstructor;
import minevalley.core.api.Core;
import minevalley.lib.itemcommons.abstracts.CustomModelDataItem;
import minevalley.lib.itemcommons.abstracts.NonSkullItem;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkEffectMeta;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
@RequiredArgsConstructor
public class PhoneItem implements NonSkullItem, CustomModelDataItem {

    public static @Nonnull Material MATERIAL = Material.FIREWORK_STAR;
    public static @Nonnull TextComponent DISPLAY_NAME =
            Component.text("Handy", TextColor.color(135, 184, 199))
                    .decoration(TextDecoration.ITALIC, false);
    public static @Nonnull TextComponent[] LORE = new TextComponent[]{
            Component.text("Installiere dir Apps und kommuniziere mit Freunden", NamedTextColor.GRAY)
                    .decoration(TextDecoration.ITALIC, false)
    };
    private final PhoneScreen screen;
    private final Color color;

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
    public @Nonnull ItemStack asItemStack() {
        final ItemStack item = Core.createItem(MATERIAL)
                .setDisplayName(DISPLAY_NAME)
                .setLore(LORE)
                .setCustomModelData(customModelData())
                .addItemFlags(ItemFlag.HIDE_DYE)
                .setMaxStackSize(1)
                .build();
        final FireworkEffectMeta meta = (FireworkEffectMeta) item.getItemMeta();
        meta.setEffect(FireworkEffect.builder().withColor(color).build());
        item.setItemMeta(meta);
        return item;
    }

    @Override
    public int customModelData() {
        return screen.getCustomModelData();
    }
}
