package com.battleasya.slashremind;

import com.battleasya.slashremind.command.Remind;
import com.battleasya.slashremind.command.Reload;
import com.battleasya.slashremind.handler.Config;
import org.bukkit.plugin.java.JavaPlugin;

public class SlashRemind extends JavaPlugin {

    public Config config;

    @Override
    public void onEnable() {

        saveDefaultConfig();

        config = new Config(this);
        config.fetchConfig();

        getCommand("remind").setExecutor(new Remind(this));
        getCommand("remindreload").setExecutor(new Reload(this));

    }

}
