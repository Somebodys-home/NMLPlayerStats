package io.github.NoOne.nMLPlayerStats.profileSystem;

import io.github.NoOne.nMLPlayerStats.NMLPlayerStats;
import io.github.NoOne.nMLPlayerStats.statSystem.Stats;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class ProfileListener implements Listener {
    private ProfileManager profileManager;

    public ProfileListener(NMLPlayerStats nmlPlayerStats) {
        profileManager = nmlPlayerStats.getProfileManager();
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        Stats stats = profileManager.getPlayerStats(player.getUniqueId());
        
        if (stats == null) {
            profileManager.createNewbieStats(player);
        }
    }
}
