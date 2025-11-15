package io.github.NoOne.nMLPlayerStats;

import io.github.NoOne.nMLPlayerStats.profileSystem.ProfileManager;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerActionBar {
    private NMLPlayerStats nmlPlayerStats;
    private ProfileManager profileManager;

    public PlayerActionBar(NMLPlayerStats nmlPlayerStats) {
        this.nmlPlayerStats = nmlPlayerStats;
        profileManager = this.nmlPlayerStats.getProfileManager();
    }

    public String[] setPlayerActionBarParts(Player player) {
        double totalhealth = player.getHealth() + player.getAbsorptionAmount();
        char healthColor = 'c';
        double currentEnergy = profileManager.getPlayerStats(player.getUniqueId()).getCurrentEnergy();
        double maxEnergy = profileManager.getPlayerStats(player.getUniqueId()).getMaxEnergy();

        if (player.getAbsorptionAmount() > 0) {
            healthColor = '9';
        }

        String health = (ChatColor.translateAlternateColorCodes('&', "&" + healthColor + "❤ " + (int) totalhealth + " / " + (int) player.getMaxHealth() + " ❤"));
        String energy = (ChatColor.translateAlternateColorCodes('&', "&6⚡ " +  (int) currentEnergy + " / " + (int) maxEnergy) + " ⚡");

        return new String[]{health, energy};
    }

    public void actionBarsTask() {
        new BukkitRunnable() {
            public void run() {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    String[] actionBar = setPlayerActionBarParts(player);

                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(actionBar[0] + "       " + actionBar[1]));
                }
            }
        }.runTaskTimer(nmlPlayerStats, 0, 5L);
    }
}
