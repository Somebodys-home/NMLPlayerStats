package io.github.NoOne.nMLPlayerStats;

import io.github.NoOne.menuSystem.MenuListener;
import io.github.NoOne.nMLPlayerStats.commands.ResetStatsCommand;
import io.github.NoOne.nMLPlayerStats.commands.SetStatCommand;
import io.github.NoOne.nMLPlayerStats.commands.StatsCommand;
import io.github.NoOne.nMLPlayerStats.profileSystem.ProfileConfig;
import io.github.NoOne.nMLPlayerStats.profileSystem.ProfileManager;
import io.github.NoOne.nMLPlayerStats.statSystem.StatsListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class NMLPlayerStats extends JavaPlugin {
    private static NMLPlayerStats instance;
    private ProfileManager profileManager;
    private ProfileConfig profileConfig;

    @Override
    public void onEnable() {
        instance = this;

        profileConfig = new ProfileConfig(this, "stats");
        profileConfig.loadConfig();

        profileManager = new ProfileManager(this);
        profileManager.loadStatsFromConfig();

        PlayerActionBar.startActionBarsTask();

        getCommand("resetStats").setExecutor(new ResetStatsCommand());
        getCommand("stats").setExecutor(new StatsCommand(this));
        getCommand("setStat").setExecutor(new SetStatCommand(this));
        getServer().getPluginManager().registerEvents(new StatsListener(this), this);
        getServer().getPluginManager().registerEvents(new MenuListener(), this);
    }

    @Override
    public void onDisable() {
        // DO NOT CHANGE THE ORDER OF THIS, THAT SHIT EXPLODES
        profileManager.saveProfilesToConfig();
        profileConfig.saveConfig();
    }

    public static NMLPlayerStats getInstance() {
        return instance;
    }

    public ProfileManager getProfileManager() {
        return profileManager;
    }

    public ProfileConfig getProfileConfig() {
        return profileConfig;
    }
}
