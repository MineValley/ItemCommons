package eu.minevalley.itemcommons.gadgets.phone;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.NamespacedKey;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@SuppressWarnings("unused")
public enum PhoneScreen {
    OFF(new NamespacedKey("minevalley", "smartphone/off")),
    HOME(new NamespacedKey("minevalley","smartphone/menu")),
    INCOMING_CALL(new NamespacedKey("minevalley","smartphone/call")),
    ACTIVE_CALL(new NamespacedKey("minevalley","smartphone/call_active"));

    private final NamespacedKey itemModel;
}
