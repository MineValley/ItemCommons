package eu.minevalley.itemcommons.gadgets.phone;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.NamespacedKey;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@SuppressWarnings("unused")
public enum PhoneScreen {
    OFF(NamespacedKey.fromString("minevalley:smartphone/off")),
    HOME(NamespacedKey.fromString("minevalley:smartphone/menu")),
    INCOMING_CALL(NamespacedKey.fromString("minevalley:smartphone/call")),
    ACTIVE_CALL(NamespacedKey.fromString("minevalley:smartphone/call_active"));

    private final NamespacedKey itemModel;
}
