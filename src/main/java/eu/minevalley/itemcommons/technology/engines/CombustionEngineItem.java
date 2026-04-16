package eu.minevalley.itemcommons.technology.engines;

import eu.minevalley.itemcommons.CustomItem;
import lombok.RequiredArgsConstructor;
import minevalley.core.api.Core;
import minevalley.core.api.item.CustomItemFlag;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
@RequiredArgsConstructor
public enum CombustionEngineItem implements CustomItem {

    COMBUSTION_01(3, 40),
    COMBUSTION_02(3, 60),
    COMBUSTION_03(4, 80),
    COMBUSTION_04(4, 100),
    COMBUSTION_05(4, 120),
    COMBUSTION_06(4, 150),
    COMBUSTION_07(5, 200),
    COMBUSTION_08(6, 250),
    COMBUSTION_09(8, 300),
    COMBUSTION_10(8, 400),
    COMBUSTION_11(12, 500);

    private static final String SKULL = "b441088dee91b16f5fd9aee4ea50a4faa979ce44dcc90524e3d2e2a1942e8a97";
    public static final @Nonnull TextComponent DISPLAY_NAME =
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