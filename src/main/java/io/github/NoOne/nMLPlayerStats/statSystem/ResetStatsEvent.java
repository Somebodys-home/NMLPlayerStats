package io.github.NoOne.nMLPlayerStats.statSystem;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class ResetStatsEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private final Player player;

    public ResetStatsEvent(@NotNull Player player) {
        this.player = player;
    }

    @Override
    public HandlerList getHandlers() { return handlers; }

    public static HandlerList getHandlerList() { return handlers; } // deleting this breaks things, apparently

    public Player getPlayer() { return player; }
}