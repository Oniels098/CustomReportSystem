package me.Niels098.SystemReport;

import me.Niels098.SystemReport.commands.report;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by kids on 18-05-16.
 */
public class Main extends JavaPlugin {

    public static Plugin pl;

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults(true);
        saveConfig();
        pl = this;
        registerCommands();

    }

    @Override
    public void onDisable() {
        saveConfig();
    }

    public void registerCommands() {
        getCommand("report").setExecutor(new report());
    }
}
