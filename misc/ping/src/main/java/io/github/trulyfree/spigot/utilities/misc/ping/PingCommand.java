package io.github.trulyfree.spigot.utilities.misc.ping;

import io.github.trulyfree.spigot.utilities.lib.command.standard.StandardCommandExecutionArguments;
import io.github.trulyfree.spigot.utilities.lib.command.standard.StandardCommandExecutor;
import io.github.trulyfree.spigot.utilities.plugin.UtilitiesPlugin;

public class PingCommand extends StandardCommandExecutor {
    static {
        UtilitiesPlugin.submit(new PingCommand());
    }

    @Override
    public void useStandardFactories() {
        this.setCommandHandlers(
                new PingCommandExecutionFactory(),
                StandardCommandExecutionArguments::new
        );
    }
}
