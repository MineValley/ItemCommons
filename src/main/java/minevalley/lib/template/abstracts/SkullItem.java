package minevalley.lib.template.abstracts;

import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public interface SkullItem extends CustomItem {

    @Nonnull
    @Contract(pure = true)
    String skullTexture();
}