package com.battleasya;

import org.bukkit.configuration.file.FileConfiguration;

public class Config {

    private final SlashRemind plugin;

    public Config(SlashRemind plugin) {
        this.plugin = plugin;
    }

    public String remindSyntax;

    public String noPermission;

    public String remindMessage;

    public String reloadConfig;

    public String remindPermission;

    public void fetchConfig() {

        FileConfiguration config = plugin.getConfig();

        remindSyntax = config.getString("remind-syntax");
        noPermission = config.getString("no-permission");
        remindMessage = config.getString("remind-message");
        reloadConfig = config.getString("reload-config");
        remindPermission = config.getString("remind-permission");

    }

}
