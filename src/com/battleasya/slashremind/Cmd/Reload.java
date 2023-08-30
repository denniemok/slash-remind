package com.battleasya.slashremind.Cmd;

import com.battleasya.slashremind.SlashRemind;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Reload implements CommandExecutor {

    private final SlashRemind plugin;

    public Reload(SlashRemind plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if (sender.hasPermission("remind.reload")) {
            plugin.reloadConfig();
            plugin.config.fetchConfig();
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.config.reloadConfig));
        } else {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.config.noPermission));
        }

        return true;

    }

}
