package minevalley.lib.itemcommons.gadgets.phone;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum PhoneScreen {
    OFF(1),
    HOME(2),
    INCOMING_CALL(3),
    ACTIVE_CALL(4);

    private final int customModelData;
}
