package io.github.NoOne.nMLPlayerStats;

import io.github.NoOne.menuSystem.MenuListener;
import io.github.NoOne.nMLConfig.ConfigTemplate;
import io.github.NoOne.nMLPlayerStats.commands.ResetStatsCommand;
import io.github.NoOne.nMLPlayerStats.commands.SetStatCommand;
import io.github.NoOne.nMLPlayerStats.commands.StatsCommand;
import io.github.NoOne.nMLPlayerStats.statSystem.StatsListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class NMLPlayerStats extends JavaPlugin {
    private static NMLPlayerStats instance;
    private StatConfigManager statConfigManager;
    private ConfigTemplate profileConfig;

    @Override
    public void onEnable() {
        instance = this;

        profileConfig = new ConfigTemplate(this, "stats");
        profileConfig.loadConfig();

        statConfigManager = new StatConfigManager(this);
        statConfigManager.loadStatsFromConfig();

        PlayerActionBar.startActionBarsTask();

        getCommand("resetStats").setExecutor(new ResetStatsCommand());
        getCommand("stats").setExecutor(new StatsCommand(this));
        getCommand("setStat").setExecutor(new SetStatCommand(this));
        getServer().getPluginManager().registerEvents(new StatsListener(this), this);
        getServer().getPluginManager().registerEvents(new MenuListener(), this);
    }

    @Override
    public void onDisable() {
        statConfigManager.saveProfilesToConfig();
        profileConfig.saveConfig();
    }

    public static NMLPlayerStats getInstance() {
        return instance;
    }

    public StatConfigManager getStatConfigManager() {
        return statConfigManager;
    }

    public ConfigTemplate getConfigTemplate() {
        return profileConfig;
    }
}
