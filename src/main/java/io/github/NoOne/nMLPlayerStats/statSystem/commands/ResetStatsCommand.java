package io.github.NoOne.nMLPlayerStats.statSystem.commands;

import io.github.NoOne.nMLPlayerStats.statSystem.ResetStatsEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ResetStatsCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player) {
            Bukkit.getPluginManager().callEvent(new ResetStatsEvent(player));
            player.sendMessage(ChatColor.GREEN + "Your stats have been reset.");
        }

        return true;
    }
}
