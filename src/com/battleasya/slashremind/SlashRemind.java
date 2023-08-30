package com.battleasya.slashremind;

import com.battleasya.slashremind.Cmd.Remind;
import com.battleasya.slashremind.Cmd.Reload;
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
