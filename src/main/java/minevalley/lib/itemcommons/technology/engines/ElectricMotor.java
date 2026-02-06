package minevalley.lib.itemcommons.technology.engines;

import minevalley.core.api.Core;
import minevalley.lib.itemcommons.abstracts.SkullItem;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public enum ElectricMotor implements SkullItem {
    ;

    @Override
    public @Nonnull String skullTexture() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public @Nonnull TextComponent displayName() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public @Nonnull TextComponent[] lore() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public @Nonnull ItemStack asItemStack() {
        return Core.createItem(skullTexture()).setDisplayName(displayName()).setLore(lore()).build();
    }

    public static void registerRecipes() {
        // logic for registering recipes will go here
    }
}