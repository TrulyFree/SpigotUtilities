package io.github.trulyfree.spigot.utilities.misc.ping;

import io.github.trulyfree.spigot.utilities.lib.command.standard.StandardCommandExecutionArguments;
import io.github.trulyfree.spigot.utilities.lib.command.standard.StandardCommandExecutor;

public class PingCommand extends StandardCommandExecutor {
    @Override
    public void useStandardFactories() {
        this.setCommandHandlers(
                new PingCommandExecutionFactory(),
                StandardCommandExecutionArguments::new
        );
    }
}
