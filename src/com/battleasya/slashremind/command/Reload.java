package com.battleasya.slashremind.command;

import com.battleasya.slashremind.SlashRemind;
import com.battleasya.slashremind.handler.Util;
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

        if (!sender.hasPermission(plugin.config.reloadPermission)) {
            Util.sendMessage(sender, plugin.config.noPermission);
            return true;
        }

        if (args.length == 0) {
            plugin.reloadConfig();
            plugin.config.fetchConfig();
            Util.sendMessage(sender, plugin.config.reloadConfig);
        } else {
            Util.sendMessage(sender, plugin.config.reloadSyntax);
        }

        return true;

    }

}
