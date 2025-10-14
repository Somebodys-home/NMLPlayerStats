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
            profileManager.getPlayerProfile(player.getUniqueId()).getStats().removeFromStat(player, event.getStat(), event.getChange());
        } else {
            profileManager.getPlayerProfile(player.getUniqueId()).getStats().add2Stat(player, event.getStat(), event.getChange());
        }
    }

    @EventHandler
    public void resetStats(ResetStatsEvent event) {
        Player player = event.getPlayer();
        profileManager.saveAProfileToConfig(player);
    }

    @EventHandler
    public void updateBonusHealthOnPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        double bonusHealth = profileManager.getPlayerProfile(player.getUniqueId()).getStats().getmaxHealth();

        player.setMaxHealth(20 + bonusHealth);
    }

    @EventHandler
    public void updateBonusHealthChanges(StatChangeEvent event) {
        Player player = event.getPlayer();

        if (event.getStat().equals("maxhealth")) player.setMaxHealth(20 + event.getChange());
    }
}
