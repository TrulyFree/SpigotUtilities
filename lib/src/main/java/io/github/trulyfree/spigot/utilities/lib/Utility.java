package io.github.trulyfree.spigot.utilities.lib;

import lombok.NonNull;
import org.bukkit.plugin.java.JavaPlugin;

public interface Utility {
    void onEnable(@NonNull JavaPlugin plugin);

    void onDisable();

    String getName();
}
