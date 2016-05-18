package me.Niels098.SystemReport.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.ArrayList;

/**
 * Created by kids on 18-05-16.
 */
public class join_events implements Listener {

    public static ArrayList<Player> staff_members = new ArrayList<>();

    @EventHandler
    public void onJoin(PlayerJoinEvent event)  {
        if(event.getPlayer().hasPermission("report.see")) {
            staff_members.add(event.getPlayer());
        }
     }
}
