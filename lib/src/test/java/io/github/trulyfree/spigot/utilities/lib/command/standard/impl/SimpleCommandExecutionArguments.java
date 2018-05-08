package io.github.trulyfree.spigot.utilities.lib.command.standard.impl;

import io.github.trulyfree.spigot.utilities.lib.command.CommandExecutionArguments;
import lombok.Getter;
import lombok.NonNull;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

@SuppressWarnings({
                          "Contract",
                          "NullableProblems"
                  })
public class SimpleCommandExecutionArguments implements CommandExecutionArguments {
    @Getter @NonNull CommandSender sender;
    @Getter @NonNull Command command;
    @Getter @NonNull String label;
    @Getter @NonNull String[] args;

    @Override
    public CommandExecutionArguments setSender(final CommandSender sender) {
        this.sender = sender;
        return this;
    }

    @Override
    public CommandExecutionArguments setCommand(final Command command) {
        this.command = command;
        return this;
    }

    @Override
    public CommandExecutionArguments setLabel(final String label) {
        this.label = label;
        return this;
    }

    @Override
    public CommandExecutionArguments setArgs(final String[] args) {
        this.args = args;
        return this;
    }
}
