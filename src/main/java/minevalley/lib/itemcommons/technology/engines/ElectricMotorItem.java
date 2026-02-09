package minevalley.lib.itemcommons.technology.engines;

import lombok.RequiredArgsConstructor;
import minevalley.core.api.Core;
import minevalley.core.api.utils.CustomItemFlag;
import minevalley.lib.itemcommons.CustomItem;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
@RequiredArgsConstructor
public class ElectricMotorItem implements CustomItem {

    private static final String SKULL = "fb9051485e15700418022e38a5db28a049a2e627c5ffa56fd313bcdead406a8e";
    public static @Nonnull TextComponent DISPLAY_NAME =
            Component.text("Elektromotor", TextColor.color(95, 104, 117))
                    .decoration(TextDecoration.ITALIC, false);

    private final int level;
    private final int horsepower;

    @Override
    public @Nonnull ItemStack asItemStack() {
        return Core.createItem(SKULL)
                .setDisplayName(DISPLAY_NAME)
                .setLore(NamedTextColor.GRAY, level + ". Stufe", horsepower + " PS")
                .addCustomItemFlags(CustomItemFlag.PREVENT_PLACING)
                .setMaxStackSize(1)
                .build();
    }

    public static void registerRecipes() {
        // logic for registering recipes will go here
    }
}