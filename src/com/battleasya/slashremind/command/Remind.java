package com.battleasya.slashremind.command;

import com.battleasya.slashremind.SlashRemind;
import com.battleasya.slashremind.handler.Util;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Remind implements CommandExecutor {

    private final SlashRemind plugin;

    public Remind(SlashRemind plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if(!sender.hasPermission(plugin.config.remindPermission)) {
            Util.sendMessage(sender, plugin.config.noPermission);
            return true;
        }

        if (args.length >= 2) {

            Player p = Bukkit.getPlayer(args[0]);

            if (p != null) {

                StringBuilder str = new StringBuilder();

                for (int i = 1; i < args.length; i++) {
                    str.append(args[i]).append(" ");
                }

                Util.broadcast(plugin.config.remindMessage
                        .replaceAll("%name%", p.getName())
                        .replaceAll("%message%", str.toString()));
                return true;

            } else {
                Util.sendMessage(sender, plugin.config.remindFailed);
            }

        }

        Util.sendMessage(sender, plugin.config.remindSyntax);
        return true;

    }

}
