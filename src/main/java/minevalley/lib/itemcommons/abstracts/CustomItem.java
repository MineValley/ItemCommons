package minevalley.lib.itemcommons.abstracts;

import net.kyori.adventure.text.TextComponent;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public interface CustomItem {

    @Nonnull
    @Contract(pure = true)
    TextComponent displayName();

    @Nonnull
    @Contract(pure = true)
    TextComponent[] lore();

}