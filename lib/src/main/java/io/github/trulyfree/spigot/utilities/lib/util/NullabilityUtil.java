package io.github.trulyfree.spigot.utilities.lib.util;

import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

@UtilityClass
public class NullabilityUtil {
    public static <T> T[] requireNoNulls(@Nullable T[] array) throws
                                                              IllegalArgumentException {
        try {
            for (T value : Objects.requireNonNull(array)) {
                Objects.requireNonNull(value);
            }
        } catch (NullPointerException e) {
            throw new IllegalArgumentException(e);
        }
        return array;
    }
}
