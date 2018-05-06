package io.github.trulyfree.spigot.utilities.lib.prov;

public interface Factory<T, V> {
    public T create(V arguments);
}
