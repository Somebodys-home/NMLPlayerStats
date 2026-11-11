package io.github.NoOne.nMLPlayerStats.statSystem;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class StatChangeEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private Player player;
    private PlayerStat playerStat;
    private double change;
    private boolean cancelled;

    public StatChangeEvent(@NotNull Player player, PlayerStat playerStat, double change) {
        this.player = player;
        this.playerStat = playerStat;
        this.change = change;
        cancelled = false;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    // deleting this breaks things, apparently
    public static HandlerList getHandlerList() {
        return handlers;
    }

    public Player getPlayer() {
        return player;
    }

    public PlayerStat getPlayerStat() {
        return playerStat;
    }

    public double getChange() {
        return change;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
}
