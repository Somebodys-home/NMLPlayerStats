package io.github.NoOne.nMLPlayerStats;

import io.github.NoOne.nMLPlayerStats.profileSystem.ProfileConfig;
import io.github.NoOne.nMLPlayerStats.profileSystem.ProfileListener;
import io.github.NoOne.nMLPlayerStats.profileSystem.ProfileManager;
import io.github.NoOne.nMLPlayerStats.profileSystem.ResetStatsCommand;
import io.github.NoOne.nMLPlayerStats.statSystem.ViewStatsCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class NMLPlayerStats extends JavaPlugin {
    private NMLPlayerStats instance;
    private ProfileManager profileManager;
    private ProfileConfig profileConfig;
    private PlayerActionBar playerActionBar;

    @Override
    public void onEnable() {
        instance = this;

        profileConfig = new ProfileConfig(this, "profiles");
        profileConfig.loadConfig();

        profileManager = new ProfileManager(this);
        profileManager.loadProfilesFromConfig();

        playerActionBar = new PlayerActionBar(this);
        playerActionBar.actionBarsTask();

        getCommand("viewStats").setExecutor(new ViewStatsCommand(this));
        getCommand("resetStats").setExecutor(new ResetStatsCommand(this));

        getServer().getPluginManager().registerEvents(new ProfileListener(this), this);
    }

    @Override
    public void onDisable() {
        // DO NOT CHANGE THE ORDER OF THIS, THAT SHIT EXPLODES
        profileManager.saveProfilesToConfig();
        profileConfig.saveConfig();
    }

    public NMLPlayerStats getInstance() {
        return instance;
    }

    public ProfileManager getProfileManager() {
        return profileManager;
    }

    public ProfileConfig getProfileConfig() {
        return profileConfig;
    }
}
