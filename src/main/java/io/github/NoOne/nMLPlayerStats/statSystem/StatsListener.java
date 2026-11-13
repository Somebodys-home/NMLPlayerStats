package io.github.NoOne.nMLPlayerStats.statSystem;

import io.github.NoOne.nMLPlayerStats.NMLPlayerStats;
import io.github.NoOne.nMLPlayerStats.profileSystem.ProfileManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;
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
        PlayerStat stat = event.getStat();
        Stats stats = profileManager.getStats(player.getUniqueId());

        if (change == 0 || event.isCancelled()) {
            return;
        } else if (change < 0) {
            stats.removeFromStat(stat, Math.abs(change));
        } else {
            stats.addToStat(stat, change);
        }

        switch (stat) {
            case HEALTH -> {
                if (change > 0) { // only wanna do this for when health changes positively, mc can handle setting the players health when it goes down
                    player.setHealth(Math.min(player.getHealth() + change, player.getMaxHealth()));
                }
            }
            case MAX_HEALTH -> player.setMaxHealth(player.getMaxHealth() + change);
            case SPEED -> player.setWalkSpeed((float) (.2 * (stats.getStatValue(PlayerStat.SPEED) / 100.0)));
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

    @EventHandler
    public void onHealthLoss(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player player) {
            Bukkit.getPluginManager().callEvent(new StatChangeEvent(player, PlayerStat.HEALTH, -event.getFinalDamage()));
        }
    }

    @EventHandler
    public void onHealthGain(EntityRegainHealthEvent event) {
        if (event.getEntity() instanceof Player player) {
                event.setCancelled(true);

//            if (event.getRegainReason() == EntityRegainHealthEvent.RegainReason.SATIATED) { todo: eventually implement a custom health regen system
//                return;
//            }

            Bukkit.getPluginManager().callEvent(new StatChangeEvent(player, PlayerStat.HEALTH, event.getAmount()));
        }
    }
}
