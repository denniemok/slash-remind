package com.battleasya.Cmd;

import com.battleasya.SlashRemind;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class remindreload implements CommandExecutor {

    private final SlashRemind plugin;

    public remindreload(SlashRemind plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if (sender.hasPermission(plugin.config.remindPermission)) {
            plugin.reloadConfig();
            plugin.config.fetchConfig();
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.config.reloadConfig));
        } else {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.config.noPermission));
        }

        return true;

    }

}
