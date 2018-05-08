package io.github.trulyfree.spigot.utilities.lib.command.standard;

import io.github.trulyfree.spigot.utilities.lib.command.CommandExecutionArguments;
import io.github.trulyfree.spigot.utilities.lib.command.TestableCommandExecutor;
import io.github.trulyfree.spigot.utilities.lib.prov.Factory;
import io.github.trulyfree.spigot.utilities.lib.prov.Provider;
import lombok.NonNull;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.concurrent.atomic.AtomicReference;

import static io.github.trulyfree.spigot.utilities.lib.command.CommandExecutionArguments.fill;

public abstract class StandardCommandExecutor implements TestableCommandExecutor {
    private final AtomicReference<Factory<Boolean, CommandExecutionArguments>> commandFactory = new AtomicReference<>();
    private final AtomicReference<Provider<CommandExecutionArguments>> argumentsProvider = new AtomicReference<>();

    public boolean onCommand(final CommandSender sender,
                             final Command command,
                             final String label,
                             final String[] args) {
        return commandFactory.get().create(fill(
                argumentsProvider.get().get(),
                sender,
                command,
                label,
                args
        ));
    }

    @Override
    public void setCommandHandlers(@NonNull final Factory<Boolean, CommandExecutionArguments> commandFactory,
                                   @NonNull final Provider<CommandExecutionArguments> argumentsProvider) {
        this.commandFactory.set(commandFactory);
        this.argumentsProvider.set(argumentsProvider);
    }
}
