package io.github.NoOne.nMLPlayerStats.statSystem;

import io.github.NoOne.nMLPlayerStats.NMLPlayerStats;
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

        if (change == 0) {
            event.setCancelled(true);
        } else if (change < 0) {
            profileManager.getPlayerStats(player.getUniqueId()).removeFromStat(event.getStat(), Math.abs(change));
        } else {
            profileManager.getPlayerStats(player.getUniqueId()).add2Stat(event.getStat(), change);
        }

        if (event.getStat().equals("maxhealth")) player.setMaxHealth(player.getMaxHealth() + event.getChange());
    }

    @EventHandler
    public void resetStats(ResetStatsEvent event) {
        Player player = event.getPlayer();

        profileManager.addPlayerStats(player.getUniqueId(), Stats.generateNewbieStats());
        profileManager.saveAProfileToConfig(player);
        player.setMaxHealth(20);
    }

    @EventHandler
    public void updateMaxHealthOnPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        double maxHealth = profileManager.getPlayerStats(player.getUniqueId()).getmaxHealth();

        player.setMaxHealth(20 + maxHealth);
    }
}
