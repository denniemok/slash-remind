package com.battleasya;

import com.battleasya.Cmd.remind;
import com.battleasya.Cmd.remindreload;
import org.bukkit.plugin.java.JavaPlugin;

public class SlashRemind extends JavaPlugin {

    public Config config;

    @Override
    public void onEnable() {

        saveDefaultConfig();

        config = new Config(this);
        config.fetchConfig();

        getCommand("remind").setExecutor(new remind(this));
        getCommand("remindreload").setExecutor(new remindreload(this));

    }

}
