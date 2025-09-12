package io.github.NoOne.nMLPlayerStats.statSystem;

import io.github.NoOne.nMLPlayerStats.NMLPlayerStats;
import io.github.NoOne.nMLPlayerStats.profileSystem.ProfileManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class StatListener implements Listener {
    private ProfileManager profileManager;

    public StatListener(NMLPlayerStats nmlPlayerStats) {
        profileManager = nmlPlayerStats.getProfileManager();
    }

    @EventHandler
    public void resetStats(ResetStatsEvent event) {
        Player player = event.getPlayer();
        profileManager.saveAProfileToConfig(player);
    }

    @EventHandler
    public void updateStatsOnPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        double bonusHealth = profileManager.getPlayerProfile(player.getUniqueId()).getStats().getBonusHealth();

        player.setMaxHealth(20 + bonusHealth);
    }

    @EventHandler
    public void updateStatsWhenChanged(StatChangeEvent event) {
        Player player = event.getPlayer();
        if (event.getStat().equals("bonushealth")) {
            double bonusHealth = profileManager.getPlayerProfile(player.getUniqueId()).getStats().getBonusHealth();

            player.setMaxHealth(20 + bonusHealth);
        }
    }
}
