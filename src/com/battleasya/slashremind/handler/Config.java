package com.battleasya.slashremind.handler;

import com.battleasya.slashremind.SlashRemind;
import org.bukkit.configuration.file.FileConfiguration;

public class Config {

    private final SlashRemind plugin;

    public Config(SlashRemind plugin) {
        this.plugin = plugin;
    }

    public String remindMessage;

    public String remindFailed;

    public String remindPermission;

    public String reloadPermission;

    public String remindSyntax;

    public String reloadSyntax;

    public String noPermission;

    public String reloadConfig;

    public void fetchConfig() {

        FileConfiguration config = plugin.getConfig();

        remindMessage = config.getString("remind-message");
        remindFailed = config.getString("remind-failed");

        remindPermission = config.getString("remind-permission");
        reloadPermission = config.getString("reload-permission");

        remindSyntax = config.getString("remind-syntax");
        reloadSyntax = config.getString("reload-syntax");

        noPermission = config.getString("no-permission");

        reloadConfig = config.getString("reload-config");

    }

}
