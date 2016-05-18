package me.Niels098.SystemReport.commands;

import me.Niels098.SystemReport.Main;
import me.Niels098.SystemReport.events.join_events;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class report implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        try {
                if (sender.hasPermission("report.use")) {
                    if (args.length == 0) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.pl.getConfig().getString("messages.usage")));
                        return true;
                    }
                    Player localPlayer = Bukkit.getPlayer(args[0]);
                    if (localPlayer == null) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.pl.getConfig().getString("messages.offlineplayer")));
                        return true;
                    }
                    if (args.length < 2) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.pl.getConfig().getString("messages.noreason")));
                        return true;
                    }
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.pl.getConfig().getString("messages.reportsucces").replaceAll("%reason%", reason(args)).replaceAll("%player%", localPlayer.getName())));
                        for (Player player : join_events.staff_members) {
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.pl.getConfig().getString("messages.newreport").replaceAll("%reason%", reason(args)).replaceAll("%reporter%", sender.getName()).replaceAll("%player%", localPlayer.getName())));
                            return true;

                        }  if (!sender.hasPermission("report.see" +
                            "")) {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.pl.getConfig().getString("messages.nopermissions")));
                        }
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public String reason(String[] paramArrayOfString)
    {
        StringBuilder localStringBuilder = new StringBuilder();
        for (int i = 1; i < paramArrayOfString.length; i++)
        {
            localStringBuilder.append(paramArrayOfString[i]);
            localStringBuilder.append(" ");
        }
        return localStringBuilder.toString().trim();
    }
}
