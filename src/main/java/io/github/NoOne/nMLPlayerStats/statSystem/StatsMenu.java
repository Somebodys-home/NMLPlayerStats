package io.github.NoOne.nMLPlayerStats.statSystem;

import io.github.NoOne.menuSystem.Menu;
import io.github.NoOne.nMLItems.ItemCreator;
import io.github.NoOne.nMLItems.enums.ItemStat;
import io.github.NoOne.nMLPlayerStats.NMLPlayerStats;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatsMenu extends Menu {
    private Stats stats;

    public StatsMenu(Player player, NMLPlayerStats nmlPlayerStats) {
        super(player);

        stats = nmlPlayerStats.getProfileManager().getStats(player.getUniqueId());
    }

    @Override
    public String getMenuName() {
        return "Your Stats:";
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
        ItemStack offenseStats = setOffenseItem();
        ItemStack defenseStats = setDefenseItem();
        ItemStack gatheringStats = setGatheringItem();

        inventory.setItem(0, defenseStats);
        inventory.setItem(9, defenseStats);
        inventory.setItem(10, defenseStats);
        inventory.setItem(18, defenseStats);
        inventory.setItem(19, defenseStats);
        inventory.setItem(20, defenseStats);
        inventory.setItem(27, defenseStats);
        inventory.setItem(28, defenseStats);
        inventory.setItem(29, defenseStats);
        inventory.setItem(36, defenseStats);
        inventory.setItem(37, defenseStats);
        inventory.setItem(38, defenseStats);
        inventory.setItem(39, defenseStats);
        inventory.setItem(45, defenseStats);
        inventory.setItem(46, defenseStats);
        inventory.setItem(47, defenseStats);
        inventory.setItem(48, defenseStats);
        inventory.setItem(1, offenseStats);
        inventory.setItem(2, offenseStats);
        inventory.setItem(3, offenseStats);
        inventory.setItem(4, offenseStats);
        inventory.setItem(5, offenseStats);
        inventory.setItem(6, offenseStats);
        inventory.setItem(7, offenseStats);
        inventory.setItem(11, offenseStats);
        inventory.setItem(12, offenseStats);
        inventory.setItem(13, offenseStats);
        inventory.setItem(14, offenseStats);
        inventory.setItem(15, offenseStats);
        inventory.setItem(16, offenseStats);
        inventory.setItem(21, offenseStats);
        inventory.setItem(22, offenseStats);
        inventory.setItem(23, offenseStats);
        inventory.setItem(24, offenseStats);
        inventory.setItem(30, offenseStats);
        inventory.setItem(31, offenseStats);
        inventory.setItem(32, offenseStats);
        inventory.setItem(33, offenseStats);
        inventory.setItem(40, offenseStats);
        inventory.setItem(41, offenseStats);
        inventory.setItem(49, offenseStats);
        inventory.setItem(8, gatheringStats);
        inventory.setItem(17, gatheringStats);
        inventory.setItem(25, gatheringStats);
        inventory.setItem(26, gatheringStats);
        inventory.setItem(34, gatheringStats);
        inventory.setItem(35, gatheringStats);
        inventory.setItem(42, gatheringStats);
        inventory.setItem(43, gatheringStats);
        inventory.setItem(44, gatheringStats);
        inventory.setItem(50, gatheringStats);
        inventory.setItem(51, gatheringStats);
        inventory.setItem(52, gatheringStats);
        inventory.setItem(53, gatheringStats);
    }

    private ItemStack setOffenseItem() {
        ArrayList<String> lore = new ArrayList<>();
        ArrayList<Map.Entry<PlayerStat, Integer>> damageList = new ArrayList<>(stats.getAllDamages().entrySet());
        int elementalDamage = stats.getIntStatValue(PlayerStat.ELEMENTAL_DAMAGE);
        boolean elementalBonusApplied = false; // elemental damage bonus is applied to the highest elemental damage ONLY
        String damageLine = "";

        damageList.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        // sort highest to lowest, to figure out which element should have the elemental damage bonus applied

        for (int i = 0; i < damageList.size(); i++) {
            Map.Entry<PlayerStat, Integer> entry = damageList.get(i);
            PlayerStat stat = entry.getKey();
            int value = entry.getValue();
            boolean isElemental = !stat.equals(PlayerStat.PHYSICAL_DAMAGE);
            String color = stat.toItemStat().toChatColor();
            String emoji = stat.toItemStat().toEmoji();

            if (elementalDamage > 0 && isElemental && !elementalBonusApplied) {
                String elementalColor = "§d";

                damageLine += color + value + elementalColor + "+" + elementalDamage + " " + color + emoji + elementalColor + "✰";
                elementalBonusApplied = true;
            } else {
                damageLine += color + value + " " + emoji;
            }

            if (i != damageList.size() - 1) {
                damageLine += "  ";
            }
        }

        // if the player doesnt have any elemental damage stats, then just show the raw elemental damage value
        damageList.removeIf(stringIntegerEntry -> stringIntegerEntry.getKey().equals(PlayerStat.PHYSICAL_DAMAGE.toString()));

        if (damageList.isEmpty() && elementalDamage > 0) {
            if (!damageLine.isEmpty()) damageLine += "  ";

            damageLine += "§d" + elementalDamage + " ✰";
        }

        if (damageLine.isEmpty()) {
            lore.add("§7Damn, you ain't s§khit§r§7.");
        } else {
            lore.add(damageLine);
        }

        lore.addAll(List.of(
                "§7────────────────",
                "§cMax Energy: §6" + (int) stats.getStatValue(PlayerStat.MAX_ENERGY) + " ⚡",
                "§cCrit Chance: §9" + (int) (Math.round(stats.getIntStatValue(PlayerStat.CRIT_CHANCE) * 10.0) / 10.0) + "% ☠",
                "§cCrit Damage: §9" + stats.getIntStatValue(PlayerStat.CRIT_DAMAGE) + "% ☠",
                "§cSpeed: §f" + stats.getIntStatValue(PlayerStat.SPEED) + "% ✦"
        ));

        ItemStack offenseStats = ItemCreator.createItem(Material.NETHERITE_SWORD, "§4§lOffensive Stats:", lore);

        offenseStats.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        return offenseStats;
    }

    private ItemStack setDefenseItem() {
        ArrayList<String> lore = new ArrayList<>();
        ArrayList<Map.Entry<String, Integer>> defenseMap = new ArrayList<>(getDefenseStats().entrySet());
        String line = "";

        defenseMap.sort((a, b) -> b.getValue().compareTo(a.getValue())); // sort from highest to lowest

        for (int i = 0; i < defenseMap.size(); i++) {
            Map.Entry<String, Integer> defenseEntry = defenseMap.get(i);
            ItemStat itemStat = PlayerStat.fromString(defenseEntry.getKey()).toItemStat();

            line += itemStat.toChatColor() + defenseEntry.getValue() + " " + itemStat.toEmoji();

            if (i != defenseMap.size() - 1) {
                line += "  ";
            }
        }

        if (line.isEmpty()) {
            lore.add("§7A bug bite kills you. Damn.");
        } else {
            lore.add(line);
        }

        lore.addAll(List.of(
                "§7────────────────",
                "§aMax Health: §c" + (int) player.getMaxHealth() + " ❤",
                "§aMax Overhealth: §9" + (int) stats.getStatValue(PlayerStat.MAX_OVERHEALTH) + " \uD83D\uDC99",
                "§aGuard: §f" + stats.getIntStatValue(PlayerStat.GUARD) + " ⛨"
        ));

        ItemStack defenseStats = ItemCreator.createItem(Material.IRON_CHESTPLATE, "§2§lDefense Stats:", lore);

        defenseStats.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        return defenseStats;
    }

    private ItemStack setGatheringItem() {
        ItemStack gatheringStats = ItemCreator.createItem(
                Material.DIAMOND_PICKAXE,
                "§3§lGathering Stats:",
                List.of(
                        "§7────────────────",
                        "§bYield: §a" + stats.getIntStatValue(PlayerStat.YIELD) + " \uD83E\uDD55",
                        "§bHarvest: §a" + stats.getIntStatValue(PlayerStat.HARVEST) + " \uD83E\uDEB4",
                        "§bAcre: §a" + stats.getIntStatValue(PlayerStat.ACRE) + " ⚂"
                )
        );

        gatheringStats.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        return gatheringStats;
    }

    public HashMap<String, Integer> getDefenseStats() {
        HashMap<String, Integer> defenseStats = stats.getAllResists();
        int defense = stats.getIntStatValue(PlayerStat.DEFENSE);
        int evasion = stats.getIntStatValue(PlayerStat.EVASION);

        if (defense != 0) defenseStats.put("defense", defense);
        if (evasion != 0) defenseStats.put("evasion", evasion);

        return defenseStats;
    }
}