package io.github.NoOne.nMLPlayerStats.statSystem;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class StatChangeEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private final Player player;
    private final String stat;

    public StatChangeEvent(@NotNull Player player, String stat) {
        this.player = player;
        this.stat = stat;
    }

    @Override
    public HandlerList getHandlers() { return handlers; }

    public static HandlerList getHandlerList() { return handlers; } // deleting this breaks things, apparently

    public Player getPlayer() { return player; }

    public String getStat() {
        return stat;
    }
}
