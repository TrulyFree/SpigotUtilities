package io.github.trulyfree.spigot.utilities.lib.command;

import io.github.trulyfree.spigot.utilities.lib.prov.Factory;
import io.github.trulyfree.spigot.utilities.lib.prov.Provider;
import lombok.NonNull;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.jetbrains.annotations.Contract;

public interface TestableCommandExecutor extends CommandExecutor, Listener {
    @Contract("!null, !null -> _")
    void setCommandHandlers(@NonNull Factory<Boolean, CommandExecutionArguments> commandFactory,
                            @NonNull Provider<CommandExecutionArguments> argumentsProvider);

    void useStandardFactories();
}
