package io.github.NoOne.nMLPlayerStats.statSystem;

import io.github.NoOne.nMLPlayerStats.NMLPlayerStats;
import io.github.NoOne.nMLPlayerStats.profileSystem.Profile;
import io.github.NoOne.nMLPlayerStats.profileSystem.ProfileManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class StatsListener implements Listener {
    private ProfileManager profileManager;

    public StatsListener(NMLPlayerStats nmlPlayerStats) {
        profileManager = nmlPlayerStats.getProfileManager();
    }

    @EventHandler
    public void statChange(StatChangeEvent event) {
        Player player = event.getPlayer();
        double change = event.getChange();
        String stat = event.getStat().toLowerCase().replace(".", "").replace(" ", "");
        Stats stats = profileManager.getPlayerProfile(player.getUniqueId()).getStats();

        if (change == 0 || event.isCancelled()) {
            return;
        }

        if (change < 0) {
            stats.removeFromStat(stat, Math.abs(change));
        } else {
            stats.add2Stat(stat, change);
        }

        switch (stat) {
            case "health" -> player.setHealth(Math.min(player.getHealth() + change, player.getMaxHealth()));
            case "maxhealth" -> player.setMaxHealth(player.getMaxHealth() + change);
            case "speed" -> player.setWalkSpeed((float) (.2 * (stats.getSpeed() / 100.0)));
        }
    }

    @EventHandler
    public void resetStats(ResetStatsEvent event) {
        Player player = event.getPlayer();
        Profile profile = profileManager.getPlayerProfile(player.getUniqueId());

        profile.setStats(Stats.generateNewbieStats());
        profileManager.saveAProfileToConfig(player);
        player.setMaxHealth(20);
    }

    @EventHandler
    public void setStatEffectsOnJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        Stats stats = profileManager.getPlayerProfile(player.getUniqueId()).getStats();
        double maxHealth = stats.getMaxHealth();

        player.setMaxHealth(20 + maxHealth);
        player.setWalkSpeed((float) (.2 * (stats.getSpeed() / 100.0)));
    }
}
