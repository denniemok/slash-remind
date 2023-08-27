package com.battleasya.Cmd;

import com.battleasya.SlashRemind;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class remind implements CommandExecutor {

    private final SlashRemind plugin;

    public remind(SlashRemind plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if(!sender.hasPermission(plugin.config.remindPermission)) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.config.noPermission));
            return true;
        }

        if (args.length >= 2) {

            Player p = Bukkit.getPlayer(args[0]);

            if (p != null) {

                StringBuilder str = new StringBuilder();

                for (int i = 1; i < args.length; i++) {
                    str.append(args[i]).append(" ");
                }

                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',plugin.config.remindMessage.replaceAll("%name%", p.getName()).replaceAll("%message%", str.toString())));
                return true;

            }

        }

        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.config.remindSyntax));
        return true;

    }

}
