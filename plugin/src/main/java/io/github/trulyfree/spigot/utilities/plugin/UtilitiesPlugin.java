package io.github.trulyfree.spigot.utilities.plugin;

import io.github.trulyfree.spigot.utilities.lib.Utility;
import lombok.SneakyThrows;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class UtilitiesPlugin extends JavaPlugin {
    private static final ArrayList<Utility> utilities = new ArrayList<>();

    @Override
    public void onDisable() {
        super.onDisable();
        utilities.forEach(utility -> {
            utility.onDisable();
            getLogger().info(String.format(
                    "Disabled utility %s.",
                    utility.getName()
            ));
        });
        getLogger().info("Successfully disabled.");
    }

    @Override
    public void onEnable() {
        super.onEnable();
        loadClasses();
        utilities.forEach(utility -> {
            utility.onEnable(this);
            getLogger().info(String.format(
                    "Enabled utility %s.",
                    utility.getName()
            ));
        });
        getLogger().info("Successfully enabled.");
    }

    @SneakyThrows
    private void loadClasses() {
        String pathToJar = this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
        JarFile jarFile = new JarFile(pathToJar);
        Enumeration<JarEntry> e = jarFile.entries();
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
            Class<?> clazz = getClassLoader().loadClass(className);
            if (Utility.class.isAssignableFrom(clazz) && !clazz.isAssignableFrom(Utility.class)) {
                try {
                    utilities.add((Utility) clazz.newInstance());
                } catch (InstantiationException | IllegalAccessException e1) {
                    getLogger().warning(String.format(
                            "Couldn't instantiate utility %s.",
                            clazz.getSimpleName()
                    ));
                    e1.printStackTrace();
                }
            }
        }
    }
}
