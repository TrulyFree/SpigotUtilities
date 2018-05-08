package io.github.trulyfree.spigot.utilities.lib.prov;

public interface Factory<T, V> {
    T create(V arguments);
}
