package io.github.trulyfree.spigot.utilities.lib;

import lombok.NonNull;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public interface Utility {
    void onEnable(@NonNull @NotNull JavaPlugin plugin);

    void onDisable(@NonNull @NotNull JavaPlugin plugin);

    String getName();
}
