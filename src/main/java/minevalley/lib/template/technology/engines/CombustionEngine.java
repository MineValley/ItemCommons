package minevalley.lib.template.technology.engines;

import minevalley.lib.template.abstracts.SkullItem;
import net.kyori.adventure.text.TextComponent;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public enum CombustionEngine implements SkullItem {
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
}