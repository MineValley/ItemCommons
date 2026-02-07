package minevalley.lib.itemcommons.gadgets;

import lombok.RequiredArgsConstructor;
import minevalley.core.api.Core;
import minevalley.lib.itemcommons.abstracts.CustomModelDataItem;
import minevalley.lib.itemcommons.abstracts.NonSkullItem;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
@RequiredArgsConstructor
public class PhoneItem implements NonSkullItem, CustomModelDataItem {

    public static @Nonnull TextComponent DISPLAY_NAME =
            Component.text("Handy", TextColor.color(135, 184, 199))
                    .decoration(TextDecoration.ITALIC, false);
    public static @Nonnull TextComponent[] LORE = new TextComponent[]{
            Component.text("Installiere dir Apps und kommuniziere mit Freunden", NamedTextColor.GRAY)
                    .decoration(TextDecoration.ITALIC, false)
    };

    @Override
    public @Nonnull Material material() {
        return Material.WOLF_ARMOR;
    }

    @Override
    public @Nonnull TextComponent displayName() {
        return null;
    }

    @Override
    public @Nonnull TextComponent[] lore() {
        return new TextComponent[0];
    }

    @Override
    public @Nonnull ItemStack asItemStack() {
        return Core.createItem(material())
                .setDisplayName(DISPLAY_NAME)
                .setLore(LORE)
                .setCustomModelData(customModelData())
                .setEquippable(null)
                .setMaxStackSize(1)
                .build();
    }

    @Override
    public int customModelData() {
        return 0;
    }
}
