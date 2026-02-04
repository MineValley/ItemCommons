package minevalley.lib.template.gadgets;

import minevalley.lib.template.abstracts.NonSkullItem;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.Material;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public class Wallet implements NonSkullItem {

    @Override
    public @Nonnull Material material() {
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
}