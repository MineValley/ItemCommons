package minevalley.lib.template.abstracts;

import org.bukkit.Material;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public interface NonSkullItem extends CustomItem {

    @Nonnull
    @Contract(pure = true)
    Material material();
}
