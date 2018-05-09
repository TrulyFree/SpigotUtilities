package io.github.trulyfree.spigot.utilities.misc.ping;

import io.github.trulyfree.spigot.utilities.lib.Utility;
import io.github.trulyfree.spigot.utilities.lib.command.standard.StandardCommandExecutionArguments;
import io.github.trulyfree.spigot.utilities.lib.command.standard.StandardCommandExecutor;
import lombok.NonNull;
import org.bukkit.plugin.java.JavaPlugin;

public class PingCommand extends StandardCommandExecutor implements Utility {
    @Override
    public void onEnable(@NonNull final JavaPlugin plugin) {
        useStandardFactories();
        plugin.getCommand("ping").setExecutor(this);
    }

    @Override
    public void useStandardFactories() {
        this.setCommandHandlers(
                new PingCommandExecutionFactory(),
                StandardCommandExecutionArguments::new
        );
    }

    @Override
    public void onDisable() {
    }

    @Override
    public String getName() {
        return "Ping";
    }
}
