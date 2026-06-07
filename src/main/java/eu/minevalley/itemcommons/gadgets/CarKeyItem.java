package eu.minevalley.itemcommons.gadgets;

import eu.minevalley.core.api.item.CustomItemFlag;
import eu.minevalley.itemcommons.CustomItem;
import eu.minevalley.itemcommons.ItemCommons;
import lombok.Getter;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

@SuppressWarnings("unused")
public class CarKeyItem implements CustomItem {

    public static @Nonnull Material MATERIAL = Material.NETHER_STAR;
    public static final NamespacedKey ITEM_MODEL = NamespacedKey.fromString("minevalley:vehicle/tool/car_key");
    public static final NamespacedKey KEY_LICENCE_PLATE = new NamespacedKey("minevalley", "licence_plate");
    public static final NamespacedKey KEY_KEY_INDEX = new NamespacedKey("minevalley", "key_index");

    private final @Nonnull Component displayName;
    private final @Nonnull List<Component> lore;
    private final @Nonnull String licencePlate;
    private final @Getter int keyIndex;

    public CarKeyItem(@Nonnull ItemStack item) throws IllegalArgumentException {
        if (item == null) throw new IllegalArgumentException("Item cannot be null");
        final ItemMeta meta = item.getItemMeta();
        if (meta == null) throw new IllegalArgumentException("Item meta cannot be null");
        final Component foreignDisplayName = meta.displayName();
        if (foreignDisplayName == null) throw new IllegalArgumentException("Item meta must have a display name");
        this.displayName = foreignDisplayName;
        final List<Component> foreignLore = meta.lore();
        if (foreignLore == null) throw new IllegalArgumentException("Item meta must have lore");
        this.lore = foreignLore;

        final PersistentDataContainer pdc = meta.getPersistentDataContainer();
        final String plate = pdc.get(KEY_LICENCE_PLATE, PersistentDataType.STRING);
        if (plate == null) throw new IllegalArgumentException("Item is not a valid car key: missing licence plate");
        this.licencePlate = plate;
        final Integer index = pdc.get(KEY_KEY_INDEX, PersistentDataType.INTEGER);
        if (index == null) throw new IllegalArgumentException("Item is not a valid car key: missing key index");
        this.keyIndex = index;
    }

    public CarKeyItem(@Nonnull String vehicleType, @Nonnull String vehicleName, @Nonnull String manufacturer,
                      @Nonnull String licencePlate, int keyIndex) {
        this.displayName = Component.text(vehicleType + "schlüssel » ", NamedTextColor.GRAY)
                .decoration(TextDecoration.ITALIC, false)
                .append(Component.text(vehicleName, NamedTextColor.YELLOW)
                        .decoration(TextDecoration.ITALIC, false));
        this.lore = List.of(
                Component.text(" ├ ", NamedTextColor.DARK_GRAY)
                        .append(Component.text("Hersteller: ", NamedTextColor.GRAY)
                                .decoration(TextDecoration.ITALIC, false))
                        .append(Component.text(manufacturer, NamedTextColor.WHITE)
                                .decoration(TextDecoration.ITALIC, false)),
                Component.text(" └ ", NamedTextColor.DARK_GRAY)
                        .append(Component.text("Kennzeichen: ", NamedTextColor.GRAY)
                                .decoration(TextDecoration.ITALIC, false))
                        .append(Component.text(licencePlate, NamedTextColor.WHITE)
                                .decoration(TextDecoration.ITALIC, false)));
        this.licencePlate = licencePlate;
        this.keyIndex = keyIndex;
    }

    @Override
    public @Nonnull ItemStack asItemStack() {
        final ItemStack item = ItemCommons.core().createItem(MATERIAL)
                .setDisplayName(displayName)
                .setLore(lore)
                .addItemFlags(ItemFlag.HIDE_ADDITIONAL_TOOLTIP)
                .addCustomItemFlags(CustomItemFlag.PREVENT_KEY_DROPPING, CustomItemFlag.PREVENT_CRAFTING)
                .setItemModel(ITEM_MODEL)
                .setMaxStackSize(1)
                .build();
        final ItemMeta meta = item.getItemMeta();
        meta.getPersistentDataContainer().set(KEY_LICENCE_PLATE, PersistentDataType.STRING, licencePlate);
        meta.getPersistentDataContainer().set(KEY_KEY_INDEX, PersistentDataType.INTEGER, keyIndex);
        item.setItemMeta(meta);
        return item;
    }

    public @Nonnull String getLicencePlate() {
        return licencePlate;
    }

    @Contract(value = "null -> false", pure = true)
    public static boolean isCarKey(@Nullable ItemStack stack) {
        if (stack == null) return false;
        try {
            new CarKeyItem(stack);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}