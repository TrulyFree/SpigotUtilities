package io.github.trulyfree.spigot.utilities.plugin;

import io.github.trulyfree.spigot.utilities.lib.command.TestableCommandExecutor;
import junit.framework.TestCase;
import lombok.SneakyThrows;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class UtilitiesPlugin extends JavaPlugin {
    private static final ArrayList<TestableCommandExecutor> utilities = new ArrayList<>();

    @Override
    public void onLoad() {
        super.onLoad();
    }

    @SneakyThrows
    private void loadClasses() {
        String pathToJar = this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
        JarFile jarFile = new JarFile(pathToJar);
        Enumeration<JarEntry> e = jarFile.entries();
        URL[] urls = {new URL("jar:file:" + pathToJar + "!/")};
        URLClassLoader cl = URLClassLoader.newInstance(urls);
        while (e.hasMoreElements()) {
            JarEntry je = e.nextElement();
            if (je.isDirectory() || !je.getName().endsWith(".class")) {
                continue;
            }
            String className = je.getName().substring(
                    0,
                    je.getName().length() - 6
            );
            className = className.replace(
                    '/',
                    '.'
            );
            Class<?> clazz = cl.loadClass(className);
            if (TestableCommandExecutor.class.isAssignableFrom(clazz)) {
                try {
                    utilities.add((TestableCommandExecutor) clazz.newInstance());
                } catch (InstantiationException | IllegalAccessException e1) {
                    getLogger().warning("Couldn't instantiate utility " + clazz.getSimpleName());
                    e1.printStackTrace();
                }
            }
        }
    }

    @Override
    public void onEnable() {
        super.onEnable();
        utilities.forEach(testableCommandExecutor -> {
            testableCommandExecutor.useStandardFactories();
            this.getServer().getPluginManager().registerEvents(
                    testableCommandExecutor,
                    this
            );
            getLogger().info(String.format(
                    "Registered utility of type %s",
                    testableCommandExecutor.getClass().getSimpleName()
            ));
        });
        getLogger().info("Successfully enabled.");
    }

    @Override
    public void onDisable() {
        super.onDisable();
        HandlerList.unregisterAll(this);
        getLogger().info("Successfully disabled.");
    }
}
