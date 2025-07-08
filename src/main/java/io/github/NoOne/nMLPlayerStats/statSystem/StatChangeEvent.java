package io.github.NoOne.nMLPlayerStats.statSystem;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class StatChangeEvent extends Event {
    private String stat;

    public StatChangeEvent(String stat) {
        this.stat = stat;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return null;
    }

    public String getStat() {
        return stat;
    }
}
