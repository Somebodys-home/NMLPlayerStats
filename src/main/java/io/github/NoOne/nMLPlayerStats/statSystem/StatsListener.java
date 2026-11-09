package io.github.NoOne.nMLPlayerStats.statSystem;

import io.github.NoOne.nMLPlayerStats.NMLPlayerStats;
import io.github.NoOne.nMLPlayerStats.profileSystem.ProfileManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class StatsListener implements Listener {
    private ProfileManager profileManager;

    public StatsListener(NMLPlayerStats nmlPlayerStats) {
        profileManager = nmlPlayerStats.getProfileManager();
    }

    @EventHandler (priority = EventPriority.HIGHEST)
    public void statChange(StatChangeEvent event) {
        Player player = event.getPlayer();
        double change = event.getChange();
        String stat = event.getStat().toLowerCase().replace(".", "").replace(" ", "");
        Stats stats = profileManager.getStats(player.getUniqueId());

        if (change == 0 || event.isCancelled()) {
            return;
        } else if (change < 0) {
            stats.removeFromStat(PlayerStat.fromString(stat), Math.abs(change));
        } else {
            stats.addToStat(PlayerStat.fromString(stat), change);
        }

        switch (stat) {
            case "health" -> player.setHealth(Math.min(player.getHealth() + change, player.getMaxHealth()));
            case "maxhealth" -> player.setMaxHealth(player.getMaxHealth() + change);
            case "speed" -> player.setWalkSpeed((float) (.2 * (stats.getStatValue(PlayerStat.SPEED) / 100.0)));
        }
    }

    @EventHandler
    public void resetStats(ResetStatsEvent event) {
        Player player = event.getPlayer();
        Stats stats = profileManager.getStats(player.getUniqueId());

        stats.resetStats();
        profileManager.saveAProfileToConfig(player);
        player.setMaxHealth(20);
        player.setWalkSpeed((float) (.2 * (stats.getStatValue(PlayerStat.SPEED) / 100.0)));
    }

    @EventHandler
    public void setStatsOnJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        Stats stats = profileManager.getStats(player.getUniqueId());

        if (stats == null) {
            profileManager.saveNewbieStats(player);
        } else {
            player.setMaxHealth(stats.getStatValue(PlayerStat.MAX_HEALTH));
            player.setWalkSpeed((float) (.2 * (stats.getStatValue(PlayerStat.SPEED) / 100.0)));
        }
    }
}
