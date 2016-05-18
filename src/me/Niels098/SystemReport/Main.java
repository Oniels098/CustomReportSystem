package me.Niels098.SystemReport;

import me.Niels098.SystemReport.commands.report;
import me.Niels098.SystemReport.events.join_events;
import me.Niels098.SystemReport.events.quit_events;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

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
        registerEvents();
        new BukkitRunnable() {

            public void run() {

                for (Player player : Bukkit.getOnlinePlayers()) {
                    if (!player.hasPermission("report.see")) {
                        join_events.staff_members.add(player);
                    }
                }
            }
        }.runTaskTimer(this, 2, 989999);

    }

    @Override
    public void onDisable() {
        saveConfig();
    }

    public void registerEvents() {
        PluginManager pluginManager = getServer().getPluginManager();
        pluginManager.registerEvents(new join_events(), (this));
        pluginManager.registerEvents(new quit_events(), (this));

    }

    public void registerCommands() {
        getCommand("report").setExecutor(new report());
    }
}
