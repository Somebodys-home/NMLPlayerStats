package io.github.NoOne.nMLPlayerStats.statSystem;

import io.github.Gabriel.menuSystem.MenuSystem;
import io.github.NoOne.nMLPlayerStats.NMLPlayerStats;
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
            //new StatsMenu(MenuSystem.getPlayerMenuUtility(player), nmlPlayerStats).open();
            Stats stats = nmlPlayerStats.getProfileManager().getPlayerProfile(player.getUniqueId()).getStats();

            player.sendMessage("level: " + stats.getLevel());
            player.sendMessage("exp: " + stats.getExp());
            player.sendMessage("current overhealth: " + stats.getCurrentOverhealth());
            player.sendMessage("max overhealth: " + stats.getMaxOverhealth());
        }

        return true;
    }
}
