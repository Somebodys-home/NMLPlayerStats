package io.github.NoOne.nMLPlayerStats.commands;

import io.github.NoOne.nMLPlayerStats.NMLPlayerStats;
import io.github.NoOne.nMLPlayerStats.statSystem.PlayerStat;
import io.github.NoOne.nMLPlayerStats.statSystem.Stats;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class SetStatCommand implements CommandExecutor, TabCompleter {
    private NMLPlayerStats nmlPlayerStats;

    public SetStatCommand(NMLPlayerStats nmlPlayerStats) {
        this.nmlPlayerStats = nmlPlayerStats;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
        if (sender instanceof Player player) {
            String stat = args[0];
            double value = Double.parseDouble(args[1]);
            Stats stats = nmlPlayerStats.getProfileManager().getStats(player.getUniqueId());

            if (PlayerStat.fromString(stat) == null) {
                player.sendMessage("§c" + stat + " is not a stat.");
            } else {
                stats.setStat(PlayerStat.fromString(stat), value);
                player.sendMessage("§aSet " + stat + " to " + value + "!");
            }
        }

        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        return new ArrayList<>(){{
            switch (args.length) {
                case 1 -> {
                    for (PlayerStat stat : PlayerStat.values()) {
                        add(stat.toString().toLowerCase());
                    }
                }
                case 2 -> add("<value>");
            }
        }};
    }
}
