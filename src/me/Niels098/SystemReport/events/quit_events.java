package me.Niels098.SystemReport.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class quit_events implements Listener {

    @EventHandler
    public void onQtuit(PlayerQuitEvent event) {
        if(event.getPlayer().hasPermission("report.see")) {
            join_events.staff_members.remove(event.getPlayer());
        }
    }
}
