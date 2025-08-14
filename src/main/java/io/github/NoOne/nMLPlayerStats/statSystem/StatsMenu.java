package io.github.NoOne.nMLPlayerStats.statSystem;

import io.github.NoOne.menuSystem.Menu;
import io.github.NoOne.menuSystem.PlayerMenuUtility;
import io.github.NoOne.nMLPlayerStats.NMLPlayerStats;
import org.bukkit.ChatColor;
import org.bukkit.event.inventory.InventoryClickEvent;

public class StatsMenu extends Menu { // todo: finalize menu when all the stats are finalized

    public StatsMenu(PlayerMenuUtility playerMenuUtility, NMLPlayerStats nmlPlayerStats) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return ChatColor.translateAlternateColorCodes('&', "&4&lYOUR STATS");
    }

    @Override
    public int getSlots() {
        return 9 * 3;
    }

    @Override
    public void handleMenu(InventoryClickEvent event) {
    }

    @Override
    public void handlePlayerMenu(InventoryClickEvent inventoryClickEvent) {

    }

    @Override
    public void setMenuItems() {
        underConstruction();
    }
}
