package io.github.trulyfree.spigot.utilities.plugin;

import io.github.trulyfree.spigot.utilities.lib.command.TestableCommandExecutor;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class UtilitiesPlugin extends JavaPlugin {
    private static final AtomicBoolean openForSubmission = new AtomicBoolean(true);
    private static final ArrayList<TestableCommandExecutor> utilities = new ArrayList<>();

    public synchronized static boolean submit(TestableCommandExecutor utility) {
        return openForSubmission.get() && utilities.add(utility);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        openForSubmission.set(false);
    }

    @Override
    public void onEnable() {
        super.onEnable();
        utilities.forEach(testableCommandExecutor -> this.getServer().getPluginManager().registerEvents(
                testableCommandExecutor,
                this
        ));
    }

    @Override
    public void onDisable() {
        super.onDisable();
        HandlerList.unregisterAll(this);
    }
}
