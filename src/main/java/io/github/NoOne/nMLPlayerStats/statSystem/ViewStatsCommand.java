package io.github.NoOne.nMLPlayerStats.statSystem;

import io.github.Gabriel.menuSystem.MenuSystem;
import io.github.NoOne.nMLPlayerStats.NMLPlayerStats;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ViewStatsCommand implements CommandExecutor {
    private NMLPlayerStats nmlPlayerStats;

    public ViewStatsCommand(NMLPlayerStats nmlAttributes) {
        this.nmlPlayerStats = nmlAttributes.getInstance();
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player player) {
            // todo: make the actual menu eventuall
            //new StatsMenu(MenuSystem.getPlayerMenuUtility(player), nmlPlayerStats).open();
            Stats stats = nmlPlayerStats.getProfileManager().getPlayerProfile(player.getUniqueId()).getStats();

            player.sendMessage(ChatColor.GOLD + "YOUR STATS:");
            player.sendMessage("defense: " + stats.getDefense());
            player.sendMessage("evasion: " + stats.getEvasion());
            player.sendMessage("block: " + stats.getBlock());
            player.sendMessage("max overhealth: " + stats.getMaxOverhealth());
            player.sendMessage("physical resist: " + stats.getPhysicalResist());
            player.sendMessage("fire resist: " + stats.getFireResist());
            player.sendMessage("cold resist: " + stats.getColdResist());
            player.sendMessage("earth resist: " + stats.getEarthResist());
            player.sendMessage("lightning resist: " + stats.getLightningResist());
            player.sendMessage("air resist: " + stats.getAirResist());
            player.sendMessage("light resist: " + stats.getLightResist());
            player.sendMessage("dark resist: " + stats.getDarkResist());
//            player.sendMessage("level: " + stats.getLevel());
//            player.sendMessage("exp: " + stats.getExp());
//            player.sendMessage("current overhealth: " + stats.getCurrentOverhealth());
//            player.sendMessage("max overhealth: " + stats.getMaxOverhealth());
//            player.sendMessage("bonus health: " + stats.getBonusHealth());
//            player.sendMessage("attribute points: " + stats.getAttributePoints());
//            player.sendMessage("vitality: " + stats.getVitality());
//            player.sendMessage("strength: " + stats.getStrength());
//            player.sendMessage("deft: " + stats.getDeft());
//            player.sendMessage("arcane: " + stats.getArcane());
//            player.sendMessage("evasion: " + stats.getEvasion());
//            player.sendMessage("physical damage: " + stats.getPhysicalDamage());
//            player.sendMessage("fire damage: " + stats.getFireDamage());
//            player.sendMessage("cold damage: " + stats.getColdDamage());
//            player.sendMessage("earth damage: " + stats.getEarthDamage());
//            player.sendMessage("lightning damage: " + stats.getLightningDamage());
//            player.sendMessage("air damage: " + stats.getAirDamage());
//            player.sendMessage("light damage: " + stats.getLightDamage());
//            player.sendMessage("dark damage: " + stats.getDarkDamage());
//            player.sendMessage("pure damage: " + stats.getPureDamage());
        }

        return true;
    }
}
