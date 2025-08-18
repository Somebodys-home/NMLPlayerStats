package io.github.NoOne.nMLPlayerStats.profileSystem;

import io.github.NoOne.menuSystem.Menu;
import io.github.NoOne.menuSystem.PlayerMenuUtility;
import io.github.NoOne.nMLPlayerStats.NMLPlayerStats;
import io.github.NoOne.nMLPlayerStats.statSystem.Stats;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class ProfileMenu extends Menu {
    private Player player;
    private Stats stats;
    private ItemStack playerPic;
    private ItemStack levelBar1;
    private ItemStack levelBar2;
    private ItemStack levelBar3;
    private ItemStack levelBar4;
    private ItemStack levelBar5;
    private ItemStack levelBar6;
    private ItemStack levelBar7;
    private ItemStack levelBar8;
    private ItemStack levelBar9;

    public ProfileMenu(PlayerMenuUtility playerMenuUtility, NMLPlayerStats nmlPlayerStats) {
        super(playerMenuUtility);

        player = playerMenuUtility.getOwner();
        stats = nmlPlayerStats.getProfileManager().getPlayerProfile(player.getUniqueId()).getStats();
        int exPercent = stats.getExp() / stats.getExp2LvlUp();

        playerPic = new ItemStack(Material.PURPLE_STAINED_GLASS_PANE);
        ItemMeta meta = playerPic.getItemMeta();
        meta.setDisplayName("§f(Imagine This Is You)");
        playerPic.setItemMeta(meta);

        levelBar1 = new ItemStack(Material.RED_CONCRETE);
        meta = levelBar1.getItemMeta();
        meta.setDisplayName("§fLv. §b§l" + stats.getLevel());
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§d" + stats.getExp() + " §5/ " + stats.getExp2LvlUp() + " §d(" + exPercent + "%) §5exp");
        meta.setLore(lore);
        levelBar1.setItemMeta(meta);

        levelBar2 = new ItemStack(Material.RED_CONCRETE);
        meta = levelBar2.getItemMeta();
        meta.setDisplayName("§fLv. §b§l" + stats.getLevel());
        levelBar2.setItemMeta(meta);

        levelBar3 = new ItemStack(Material.RED_CONCRETE);
        meta = levelBar3.getItemMeta();
        meta.setDisplayName("§fLv. §b§l" + stats.getLevel());
        levelBar3.setItemMeta(meta);

        levelBar4 = new ItemStack(Material.RED_CONCRETE);
        meta = levelBar4.getItemMeta();
        meta.setDisplayName("§fLv. §b§l" + stats.getLevel());
        levelBar4.setItemMeta(meta);

        levelBar5 = new ItemStack(Material.RED_CONCRETE);
        meta = levelBar5.getItemMeta();
        meta.setDisplayName("§fLv. §b§l" + stats.getLevel());
        levelBar5.setItemMeta(meta);

        levelBar6 = new ItemStack(Material.RED_CONCRETE);
        meta = levelBar6.getItemMeta();
        meta.setDisplayName("§fLv. §b§l" + stats.getLevel());
        levelBar6.setItemMeta(meta);

        levelBar7 = new ItemStack(Material.RED_CONCRETE);
        meta = levelBar7.getItemMeta();
        meta.setDisplayName("§fLv. §b§l" + stats.getLevel());
        levelBar7.setItemMeta(meta);

        levelBar8 = new ItemStack(Material.RED_CONCRETE);
        meta = levelBar8.getItemMeta();
        meta.setDisplayName("§fLv. §b§l" + stats.getLevel());
        levelBar8.setItemMeta(meta);

        levelBar9 = new ItemStack(Material.RED_CONCRETE);
        meta = levelBar9.getItemMeta();
        meta.setDisplayName("§fLv. §b§l" + stats.getLevel());
        levelBar9.setItemMeta(meta);
    }

    @Override
    public String getMenuName() {
        return player.getDisplayName();
    }

    @Override
    public int getSlots() {
        return 9 * 6;
    }

    @Override
    public void handleMenu(InventoryClickEvent event) {
        event.setCancelled(true);
    }

    @Override
    public void handlePlayerMenu(InventoryClickEvent event) {
        event.setCancelled(true);
    }

    @Override
    public void setMenuItems() {
        updateLevelBar();

        inventory.setItem(0, levelBar1);
        inventory.setItem(1, levelBar2);
        inventory.setItem(2, levelBar3);
        inventory.setItem(3, levelBar4);
        inventory.setItem(4, levelBar5);
        inventory.setItem(5, levelBar6);
        inventory.setItem(6, levelBar7);
        inventory.setItem(7, levelBar8);
        inventory.setItem(8, levelBar9);
        inventory.setItem(19, playerPic);
        inventory.setItem(20, playerPic);
        inventory.setItem(21, playerPic);
        inventory.setItem(28, playerPic);
        inventory.setItem(29, playerPic);
        inventory.setItem(30, playerPic);
        inventory.setItem(37, playerPic);
        inventory.setItem(38, playerPic);
        inventory.setItem(39, playerPic);
    }

    public void updateLevelBar() {
        int exp = stats.getExp();
        int exp2LvlUp = stats.getExp2LvlUp();
        int barFilled = 0;

        player.sendMessage("exp: " + exp);
        // logic 2 get barFilled
        int numerator = exp * 9;
        barFilled = numerator / exp2LvlUp;

        switch (barFilled) {
            case 1 -> levelBar1.setType(Material.GREEN_CONCRETE);
            case 2 -> {
                levelBar1.setType(Material.GREEN_CONCRETE);
                levelBar2.setType(Material.GREEN_CONCRETE);
            }
            case 3 -> {
                levelBar1.setType(Material.GREEN_CONCRETE);
                levelBar2.setType(Material.GREEN_CONCRETE);
                levelBar3.setType(Material.GREEN_CONCRETE);
            }
            case 4 -> {
                levelBar1.setType(Material.GREEN_CONCRETE);
                levelBar2.setType(Material.GREEN_CONCRETE);
                levelBar3.setType(Material.GREEN_CONCRETE);
                levelBar4.setType(Material.GREEN_CONCRETE);
            }
            case 5 -> {
                levelBar1.setType(Material.GREEN_CONCRETE);
                levelBar2.setType(Material.GREEN_CONCRETE);
                levelBar3.setType(Material.GREEN_CONCRETE);
                levelBar4.setType(Material.GREEN_CONCRETE);
                levelBar5.setType(Material.GREEN_CONCRETE);
            }
            case 6 -> {
                levelBar1.setType(Material.GREEN_CONCRETE);
                levelBar2.setType(Material.GREEN_CONCRETE);
                levelBar3.setType(Material.GREEN_CONCRETE);
                levelBar4.setType(Material.GREEN_CONCRETE);
                levelBar5.setType(Material.GREEN_CONCRETE);
                levelBar6.setType(Material.GREEN_CONCRETE);
            }
            case 7 -> {
                levelBar1.setType(Material.GREEN_CONCRETE);
                levelBar2.setType(Material.GREEN_CONCRETE);
                levelBar3.setType(Material.GREEN_CONCRETE);
                levelBar4.setType(Material.GREEN_CONCRETE);
                levelBar5.setType(Material.GREEN_CONCRETE);
                levelBar6.setType(Material.GREEN_CONCRETE);
                levelBar7.setType(Material.GREEN_CONCRETE);
            }
            case 8 -> {
                levelBar1.setType(Material.GREEN_CONCRETE);
                levelBar2.setType(Material.GREEN_CONCRETE);
                levelBar3.setType(Material.GREEN_CONCRETE);
                levelBar4.setType(Material.GREEN_CONCRETE);
                levelBar5.setType(Material.GREEN_CONCRETE);
                levelBar6.setType(Material.GREEN_CONCRETE);
                levelBar7.setType(Material.GREEN_CONCRETE);
                levelBar8.setType(Material.GREEN_CONCRETE);
            }
            case 9 -> {
                levelBar1.setType(Material.GREEN_CONCRETE);
                levelBar2.setType(Material.GREEN_CONCRETE);
                levelBar3.setType(Material.GREEN_CONCRETE);
                levelBar4.setType(Material.GREEN_CONCRETE);
                levelBar5.setType(Material.GREEN_CONCRETE);
                levelBar6.setType(Material.GREEN_CONCRETE);
                levelBar7.setType(Material.GREEN_CONCRETE);
                levelBar8.setType(Material.GREEN_CONCRETE);
                levelBar9.setType(Material.GREEN_CONCRETE);
            }
        }
    }
}
