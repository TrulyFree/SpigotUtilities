package io.github.trulyfree.spigot.utilities.lib.command.standard;

import io.github.trulyfree.spigot.utilities.lib.command.CommandExecutionArguments;
import io.github.trulyfree.spigot.utilities.lib.util.NullabilityUtil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

@NoArgsConstructor
public final class StandardCommandExecutionArguments implements CommandExecutionArguments {
    @Getter @NonNull CommandSender sender;
    @Getter @NonNull Command command;
    @Getter @NonNull String label;
    @Getter @NonNull String[] args;

    @Override
    public CommandExecutionArguments setSender(@NonNull @NotNull final CommandSender sender) {
        this.sender = Objects.requireNonNull(sender);
        return this;
    }

    @Override
    public CommandExecutionArguments setCommand(@NonNull @NotNull final Command command) {
        this.command = Objects.requireNonNull(command);
        return this;
    }

    @Override
    public CommandExecutionArguments setLabel(@NonNull @NotNull final String label) {
        this.label = Objects.requireNonNull(label);
        return this;
    }

    @Override
    public CommandExecutionArguments setArgs(@NonNull @NotNull final String[] args) {
        this.args = NullabilityUtil.requireNoNulls(args);
        return this;
    }
}
