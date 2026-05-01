package eu.minevalley.itemcommons.gadgets;

import eu.minevalley.itemcommons.CustomItem;
import eu.minevalley.proxima.api.Proxima;
import eu.minevalley.proxima.api.item.CustomItemFlag;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

@SuppressWarnings("unused")
public class CarKey implements CustomItem {

    public static @Nonnull Material MATERIAL = Material.NETHER_STAR;
    public static @Nonnull TextComponent[] LORE = new TextComponent[]{
            Component.text("Zur sicheren Aufbewahrung deiner Bankkarten", NamedTextColor.GRAY)
                    .decoration(TextDecoration.ITALIC, false),
            Component.text("Wenn du stirbst, können andere Spieler", TextColor.color(171, 90, 79))
                    .decoration(TextDecoration.ITALIC, false),
            Component.text("Teile deines Bargelds stehlen!", TextColor.color(171, 90, 79))
                    .decoration(TextDecoration.ITALIC, false)
    };
    public static final NamespacedKey ITEM_MODEL = NamespacedKey.fromString("minevalley:vehicle/tool/car_key");

    private final @Nonnull Component displayName;
    private final @Nonnull List<Component> lore;
    private final @Nonnull String licencePlate;
    private final int keyIndex;

    public CarKey(@Nonnull ItemStack item) throws IllegalArgumentException {
        if (item == null) throw new IllegalArgumentException("Item cannot be null");
        final ItemMeta meta = item.getItemMeta();
        if (meta == null) throw new IllegalArgumentException("Item meta cannot be null");
        final Component foreignDisplayName = meta.displayName();
        if (foreignDisplayName == null) throw new IllegalArgumentException("Item meta must have a display name");
        this.displayName = foreignDisplayName;
        final List<Component> foreignLore = meta.lore();
        if (foreignLore == null) throw new IllegalArgumentException("Item meta must have lore");
        this.lore = foreignLore;

        // TODO 16.4.2026: CarKey() (CarKey)
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public CarKey(@Nonnull String vehicleType, @Nonnull String vehicleName, @Nonnull String licencePlate, int keyIndex) {
        this.displayName = Component.text(vehicleType + "schlüssel » ", NamedTextColor.GRAY)
                .append(Component.text(vehicleName, NamedTextColor.YELLOW));
        this.lore = List.of(Component.text(" └ ", NamedTextColor.DARK_GRAY)
                .append(Component.text("Kennzeichen: ", NamedTextColor.GRAY))
                .append(Component.text(licencePlate, NamedTextColor.WHITE)));
        this.licencePlate = licencePlate;
        this.keyIndex = keyIndex;
    }

    @Override
    public @Nonnull ItemStack asItemStack() {
        return Proxima.createItem(MATERIAL)
                .setDisplayName(displayName)
                .setLore(lore)
                .addItemFlags(ItemFlag.HIDE_ADDITIONAL_TOOLTIP)
                .addCustomItemFlags(CustomItemFlag.PREVENT_KEY_DROPPING, CustomItemFlag.PREVENT_CRAFTING)
                // TODO 16.4.2026: add persistent data container for storing important data (licence plate, key index) (CarKey)
                .setItemModel(ITEM_MODEL)
                .setMaxStackSize(1)
                .build();
    }

    @Contract(value = "null -> false", pure = true)
    public static boolean isCarKey(@Nullable ItemStack stack) {
        if (stack == null) return false;
        try {
            new CarKey(stack);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}