package io.github.trulyfree.spigot.utilities.lib.command;

import lombok.NonNull;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.Contract;

@SuppressWarnings("NullableProblems")
public interface CommandExecutionArguments {
    @Contract("!null, !null, !null, !null, !null -> _")
    static CommandExecutionArguments fill(CommandExecutionArguments commandExecutionArguments,
                                          CommandSender sender,
                                          Command command,
                                          String label,
                                          String[] args) {
        return commandExecutionArguments.setSender(sender).setCommand(command).setLabel(label).setArgs(args);
    }

    @NonNull
    CommandSender getSender();

    @Contract("null -> fail; !null -> _")
    CommandExecutionArguments setSender(@NonNull CommandSender sender);

    @NonNull
    Command getCommand();

    @Contract("null -> fail; !null -> _")
    CommandExecutionArguments setCommand(@NonNull Command command);

    @NonNull
    String getLabel();

    @Contract("null -> fail; !null -> _")
    CommandExecutionArguments setLabel(@NonNull String label);

    @NonNull
    String[] getArgs();

    @Contract("null -> fail; !null -> _")
    CommandExecutionArguments setArgs(@NonNull String[] args);
}
