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
public class CombustionEngineItem implements CustomItem {

    private static final String SKULL = "b441088dee91b16f5fd9aee4ea50a4faa979ce44dcc90524e3d2e2a1942e8a97";
    public static @Nonnull TextComponent DISPLAY_NAME =
            Component.text("Motor", TextColor.color(95, 104, 117))
                    .decoration(TextDecoration.ITALIC, false);

    private final int cylinders;
    private final int horsepower;

    @Override
    public @Nonnull ItemStack asItemStack() {
        return Core.createItem(SKULL)
                .setDisplayName(DISPLAY_NAME)
                .setLore(NamedTextColor.GRAY, cylinders + " Zylinder", horsepower + " PS")
                .addCustomItemFlags(CustomItemFlag.PREVENT_PLACING)
                .setMaxStackSize(1)
                .build();
    }

    public static void registerRecipes() {
        // logic for registering recipes will go here
    }
}