package io.github.trulyfree.spigot.utilities.lib.command;

import lombok.NonNull;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public interface CommandExecutionArguments {
    @NonNull
    @NotNull
    CommandSender getSender();

    @Contract("null -> fail; !null -> _")
    CommandExecutionArguments setSender(@NonNull @NotNull CommandSender sender);

    @NonNull
    @NotNull
    Command getCommand();

    @Contract("null -> fail; !null -> _")
    CommandExecutionArguments setCommand(@NonNull @NotNull Command command);

    @NonNull
    @NotNull
    String getLabel();

    @Contract("null -> fail; !null -> _")
    CommandExecutionArguments setLabel(@NonNull @NotNull String label);

    @NonNull
    @NotNull
    String[] getArgs();

    @Contract("null -> fail; !null -> _")
    CommandExecutionArguments setArgs(@NonNull @NotNull String[] args);

    @Contract("!null, !null, !null, !null, !null -> _")
    static CommandExecutionArguments fill(@NonNull @NotNull CommandExecutionArguments commandExecutionArguments,
                                          @NonNull @NotNull CommandSender sender,
                                          @NonNull @NotNull Command command,
                                          @NonNull @NotNull String label,
                                          @NonNull @NotNull String[] args) {
        return commandExecutionArguments.setSender(sender).setCommand(command).setLabel(label).setArgs(args);
    }
}
