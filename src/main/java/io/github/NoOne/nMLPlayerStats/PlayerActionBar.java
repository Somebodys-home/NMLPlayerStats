package io.github.NoOne.nMLPlayerStats;

import io.github.NoOne.nMLPlayerStats.profileSystem.ProfileManager;
import io.github.NoOne.nMLPlayerStats.statSystem.PlayerStat;
import io.github.NoOne.nMLPlayerStats.statSystem.Stats;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerActionBar {
    private static NMLPlayerStats nmlPlayerStats = NMLPlayerStats.getInstance();
    private static ProfileManager profileManager = nmlPlayerStats.getProfileManager();

    public static void startActionBarsTask() {
        new BukkitRunnable() {
            public void run() {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    String[] actionBar = setPlayerActionBarParts(player);

                    player.sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(actionBar[0] + "       " + actionBar[1]));
                }
            }
        }.runTaskTimer(nmlPlayerStats, 0, 5);
    }

    private static String[] setPlayerActionBarParts(Player player) {
        Stats stats = profileManager.getStats(player.getUniqueId());
        int currentEnergy = (int) stats.getStatValue(PlayerStat.CURRENT_ENERGY);
        int maxEnergy = (int) stats.getStatValue(PlayerStat.MAX_ENERGY);
        double overhealth = player.getAbsorptionAmount();
        int totalHealth = (int) (player.getHealth() + overhealth);
        String healthColor;

        if (overhealth > 0) {
            healthColor = PlayerStat.OVERHEALTH.toItemStat().toChatColor();
        } else {
            healthColor = PlayerStat.HEALTH.toItemStat().toChatColor();
        }

        String health = healthColor + "❤ " + totalHealth + " / " + (int) stats.getStatValue(PlayerStat.MAX_HEALTH)  + " ❤";
        String energy = "§6⚡ " + currentEnergy + " / " + maxEnergy + " ⚡";

        return new String[]{health, energy};
    }
}
