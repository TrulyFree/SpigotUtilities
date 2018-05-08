package io.github.trulyfree.spigot.utilities.misc.ping;

import io.github.trulyfree.spigot.utilities.lib.Utility;
import io.github.trulyfree.spigot.utilities.lib.command.standard.StandardCommandExecutionArguments;
import io.github.trulyfree.spigot.utilities.lib.command.standard.StandardCommandExecutor;
import lombok.NonNull;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class PingCommand extends StandardCommandExecutor implements Utility {
    @Override
    public void useStandardFactories() {
        this.setCommandHandlers(
                new PingCommandExecutionFactory(),
                StandardCommandExecutionArguments::new
        );
    }

    @Override
    public void onEnable(@NonNull @NotNull final JavaPlugin plugin) {
        useStandardFactories();
        plugin.getServer().getPluginManager().registerEvents(
                this,
                plugin
        );
    }

    @Override
    public void onDisable(@NonNull @NotNull final JavaPlugin plugin) {
        HandlerList.unregisterAll(this);
    }

    @Override
    public String getName() {
        return "Ping";
    }
}
