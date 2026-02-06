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

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
@RequiredArgsConstructor
public class Wallet implements NonSkullItem, CustomModelDataItem {

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
}