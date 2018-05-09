package io.github.trulyfree.spigot.utilities.misc.ping;

import io.github.trulyfree.spigot.utilities.lib.command.CommandExecutionArguments;
import io.github.trulyfree.spigot.utilities.lib.prov.Factory;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PingCommandExecutionFactory implements Factory<Boolean, CommandExecutionArguments> {
    @Override
    public Boolean create(final CommandExecutionArguments arguments) {
        if (arguments.getCommand().getName().equals("ping")) {
            switch (arguments.getArgs().length) {
                case 0:
                    pingSelf(arguments);
                    break;
                case 1:
                    pingOther(arguments);
                    break;
                default:
                    arguments.getSender().sendMessage(String.format(
                            "Usage: /%s [target]",
                            arguments.getLabel()
                    ));
                    return false;
            }
            return true;
        } else {
            return false;
        }
    }

    private void pingSelf(final CommandExecutionArguments arguments) {
        int ourPing = getPing(arguments.getSender());
        if (ourPing != -1) {
            arguments.getSender().sendMessage(String.format(
                    "Pong! Ping took %d ms.",
                    getPing(arguments.getSender())
            ));
        } else {
            arguments.getSender().sendMessage("Looks like something went wrong while pinging! Try again.");
        }
    }

    private void pingOther(final CommandExecutionArguments arguments) {
        Player other = arguments.getSender().getServer().getPlayer(arguments.getArgs()[0]);
        if (other == null) {
            arguments.getSender().sendMessage("Uh oh. Looks like there's no player by that name online.");
        } else if (other.equals(arguments.getSender())) {
            pingSelf(arguments);
        } else {
            int otherPing = getPing(other), ourPing = getPing(arguments.getSender());
            if (otherPing != -1 && ourPing != -1) {
                arguments.getSender().sendMessage(String.format(
                        "Pong! Ping of %s took %d ms, meaning that the latency between you and them is %d ms.",
                        arguments.getArgs()[0],
                        otherPing,
                        otherPing + ourPing
                ));
            } else {
                arguments.getSender().sendMessage("Looks like something went wrong while pinging! Try again.");
            }
        }
    }

    private int getPing(final CommandSender player) {
        if (player instanceof Player) {
            try {
                Object entityPlayer = player.getClass().getMethod("getHandle").invoke(player);
                return (int) entityPlayer.getClass().getField("ping").get(entityPlayer);
            } catch (Throwable e) {
                e.printStackTrace();
            }
        } else {
            return 0;
        }
        return -1;
    }
}
