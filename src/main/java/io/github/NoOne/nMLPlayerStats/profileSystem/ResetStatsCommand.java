package io.github.NoOne.nMLPlayerStats.profileSystem;

import io.github.NoOne.nMLPlayerStats.NMLPlayerStats;
import io.github.NoOne.nMLPlayerStats.statSystem.StatChangeEvent;
import io.github.NoOne.nMLPlayerStats.statSystem.Stats;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ResetStatsCommand implements CommandExecutor {
    private final ProfileManager profileManager;

    public ResetStatsCommand(NMLPlayerStats nmlPlayerStats) {
        this.profileManager = nmlPlayerStats.getProfileManager();
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player) {
            Stats stats = profileManager.getPlayerProfile(player.getUniqueId()).getStats();

            stats.setLevel(1);
            stats.setExp(0);

            stats.setAttributePoints(0);
            stats.setVitality(0);
            stats.setStrength(0);
            stats.setDeft(0);
            stats.setArcane(0);

            stats.setBonusHealth(0);
            stats.setMaxOverhealth(0);
            stats.setCurrentOverhealth(0);
            stats.setMaxEnergy(100);
            stats.setCurrentEnergy(100);

            stats.setPhysicalDamage(0);
            stats.setFireDamage(0);
            stats.setColdDamage(0);
            stats.setEarthDamage(0);
            stats.setLightningDamage(0);
            stats.setAirDamage(0);
            stats.setLightDamage(0);
            stats.setDarkDamage(0);
            stats.setPureDamage(0);

            stats.setEvasion(0);
            stats.setDefense(0);
            stats.setPhysicalResist(0);
            stats.setFireResist(0);
            stats.setColdResist(0);
            stats.setEarthResist(0);
            stats.setLightningResist(0);
            stats.setAirResist(0);
            stats.setLightResist(0);
            stats.setDarkResist(0);

            // Fire stat change events
            String[] resetStats = {
                    "level", "exp",
                    "attributepoints", "vitality", "strength", "deft", "arcane",
                    "bonushealth", "maxoverhealth", "overhealth", "maxenergy", "currentenergy",
                    "physicaldamage", "firedamage", "colddamage", "earthdamage", "lightningdamage", "airdamage", "lightdamage", "darkdamage", "puredamage",
                    "evasion", "defense", "physicalresist", "fireresist", "coldresist", "earthresist", "lightningresist", "airresist", "lightresist", "darkresist",
            };

            for (String stat : resetStats) {
                Bukkit.getPluginManager().callEvent(new StatChangeEvent(player, stat));
            }

            profileManager.saveAProfileToConfig(player);
            player.sendMessage(ChatColor.GREEN + "Your stats have been reset.");
        }

        return true;
    }
}
