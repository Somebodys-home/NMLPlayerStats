package io.github.NoOne.nMLPlayerStats.statSystem;

import io.github.NoOne.menuSystem.Menu;
import io.github.NoOne.menuSystem.PlayerMenuUtility;
import io.github.NoOne.nMLPlayerStats.NMLPlayerStats;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

public class StatsMenu extends Menu {
    private Player player;
    private Stats stats;

    private ItemStack offenseStats;
    private ItemStack defenseStats;
    private ItemStack gatheringStats;

    public StatsMenu(PlayerMenuUtility playerMenuUtility, NMLPlayerStats nmlPlayerStats) {
        super(playerMenuUtility);

        player = playerMenuUtility.getOwner();
        stats = nmlPlayerStats.getProfileManager().getPlayerProfile(player.getUniqueId()).getStats();
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
        setOffenseItem();
        setDefenseItem();
        setGatheringItem();

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

    public void setOffenseItem() {
        offenseStats = new ItemStack(Material.NETHERITE_SWORD);

        ItemMeta meta = offenseStats.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        String damageLine = "";
        List<Map.Entry<String, Integer>> damageMap = new ArrayList<>(getDamageStats().entrySet());
        int elementalDamage = stats.getElementalDamage();
        boolean elementalBonusApplied = false;
        boolean hasElementalDamage = false;

        meta.setDisplayName("§4§lDamage Stats:");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        damageMap.sort((a, b) -> b.getValue().compareTo(a.getValue())); // highest to lowest

        for (int i = 0; i < damageMap.size(); i++) {
            Map.Entry<String, Integer> entry = damageMap.get(i);
            String key = entry.getKey();
            int value = entry.getValue();
            boolean isElemental = key.equals("fire") ||
                                    key.equals("cold") ||
                                    key.equals("earth") ||
                                    key.equals("lightning") ||
                                    key.equals("air") ||
                                    key.equals("radiant") ||
                                    key.equals("necrotic");

            if (isElemental) hasElementalDamage = true;
            if (isElemental && !elementalBonusApplied && elementalDamage > 0) {
                switch (key) {
                    case "fire" -> damageLine += "§c" + value + "§d+" + elementalDamage + " §c🔥§d✰";
                    case "cold" -> damageLine += "§b" + value + "§d+" + elementalDamage + " ❄§d✰";
                    case "earth" -> damageLine += "§2" + value + "§d+" + elementalDamage + " 🪨§d✰";
                    case "lightning" -> damageLine += "§e" + value + "§d+" + elementalDamage + " 🗲§d✰";
                    case "air" -> damageLine += "§7" + value + "§d+" + elementalDamage + " ☁§d✰";
                    case "radiant" -> damageLine += "§f" + value + "§d+" + elementalDamage + " ✦§d✰";
                    case "necrotic" -> damageLine += "§5" + value + "§d+" + elementalDamage + " 🌀§d✰";
                }

                elementalBonusApplied = true;
            } else {
                switch (key) {
                    case "physical" -> damageLine += "§4" + value + " ⚔";
                    case "fire" -> damageLine += "§c" + value + " 🔥";
                    case "cold" -> damageLine += "§b" + value + " ❄";
                    case "earth" -> damageLine += "§2" + value + " 🪨";
                    case "lightning" -> damageLine += "§e" + value + " 🗲";
                    case "air" -> damageLine += "§7" + value + " ☁";
                    case "radiant" -> damageLine += "§f" + value + " ✦";
                    case "necrotic" -> damageLine += "§5" + value + " 🌀";
                    case "pure" -> damageLine += "§f" + value + " 💢";
                }
            }

            if (i != damageMap.size() - 1) damageLine += "  ";
        }

        if (!hasElementalDamage && elementalDamage > 0) {
            if (!damageLine.isEmpty()) damageLine += "  ";

            damageLine += "§d" + elementalDamage + " ✰";
        }

        if (damageLine.isEmpty()) {
            lore.add("§7Damn, you ain't s§khit§r§7.");
        } else {
            lore.add(damageLine);
        }

        lore.add("§7────────────────");
        lore.add("§cMax Energy: §6" + (int) stats.getMaxEnergy() + " ⚡");
        lore.add("§cCrit Chance: §9" + stats.getCritChance() + " ☠");
        lore.add("§cCrit Damage: §9" + stats.getCritDamage() + " ☠");

        meta.setLore(lore);
        offenseStats.setItemMeta(meta);

    }

    public void setDefenseItem() {
        defenseStats = new ItemStack(Material.IRON_CHESTPLATE);
        ItemMeta meta = defenseStats.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();

        meta.setDisplayName("§a§lDefense Stats:");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        String line = "";
        List<Map.Entry<String, Integer>> defenseMap = new ArrayList<>(getDefenseStats().entrySet());
        defenseMap.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        for (int i = 0; i < defenseMap.size(); i++) {
            Map.Entry<String, Integer> defenseEntry = defenseMap.get(i);

            switch (defenseEntry.getKey()) {
                case "defense" -> line += "§a" + defenseEntry.getValue() + " \uD83D\uDEE1";
                case "evasion" -> line += "§f" + defenseEntry.getValue() + " \uD83D\uDCA8";
                case "physical" -> line += "§4" + defenseEntry.getValue() + " ⚔";
                case "fire" -> line += "§c" + defenseEntry.getValue() + " \uD83D\uDD25";
                case "cold" -> line += "§b" + defenseEntry.getValue() + " ❄";
                case "earth" -> line += "§2" + defenseEntry.getValue() + " \uD83E\uDEA8";
                case "lightning" -> line += "§e" + defenseEntry.getValue() + " \uD83D\uDDF2";
                case "air" -> line += "§7" + defenseEntry.getValue() + " ☁";
                case "radiant" -> line += "§f" + defenseEntry.getValue() + " ✦";
                case "necrotic" -> line += "§5" + defenseEntry.getValue() + " \uD83C\uDF00";
            }

            if (i != defenseMap.size() - 1) line += "  ";
        }

        if (line.isEmpty()) {
            lore.add("§7A mosquito bite kills you. Pathetic.");
        } else {
            lore.add(line);
        }

        lore.add("§7────────────────");
        lore.add("§2Max Health: §c" + (int) player.getMaxHealth() + " ❤");
        lore.add("§2Max Overhealth: §1" + (int) stats.getMaxOverhealth() + " \uD83D\uDC99");
        lore.add("§2Guard: §f" + stats.getGuard() + " ⛨");

        meta.setLore(lore);
        defenseStats.setItemMeta(meta);
    }

    public void setGatheringItem() {
        gatheringStats = new ItemStack(Material.DIAMOND_PICKAXE);
        ItemMeta gatheringMeta = gatheringStats.getItemMeta();
        ArrayList<String> gatheringLore = new ArrayList<>();

        gatheringMeta.setDisplayName("§b§lGathering Stats:");
        gatheringMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        gatheringMeta.setLore(gatheringLore);
        gatheringStats.setItemMeta(gatheringMeta);
    }

    public HashMap<String, Integer> getDamageStats() {
        HashMap<String, Integer> damageStats = new HashMap<>();

        if (stats.getPhysicalDamage() != 0) damageStats.put("physical", stats.getPhysicalDamage());
        if (stats.getFireDamage() != 0) damageStats.put("fire", stats.getFireDamage());
        if (stats.getColdDamage() != 0) damageStats.put("cold", stats.getColdDamage());
        if (stats.getEarthDamage() != 0) damageStats.put("earth", stats.getEarthDamage());
        if (stats.getLightningDamage() != 0) damageStats.put("lightning", stats.getLightningDamage());
        if (stats.getAirDamage() != 0) damageStats.put("air", stats.getAirDamage());
        if (stats.getRadiantDamage() != 0) damageStats.put("radiant", stats.getRadiantDamage());
        if (stats.getNecroticDamage() != 0) damageStats.put("necrotic", stats.getNecroticDamage());
        if (stats.getPureDamage() != 0) damageStats.put("pure", stats.getPureDamage());

        return damageStats;
    }

    public HashMap<String, Integer> getDefenseStats() {
        HashMap<String, Integer> defenseStats = new HashMap<>();
        
        if (stats.getDefense() != 0) defenseStats.put("defense", stats.getDefense());
        if (stats.getEvasion() != 0) defenseStats.put("evasion", stats.getEvasion());
        if (stats.getPhysicalResist() != 0) defenseStats.put("physical", stats.getPhysicalResist());
        if (stats.getFireResist() != 0) defenseStats.put("fire", stats.getFireResist());
        if (stats.getColdResist() != 0) defenseStats.put("cold", stats.getColdResist());
        if (stats.getEarthResist() != 0) defenseStats.put("earth", stats.getEarthResist());
        if (stats.getLightningResist() != 0) defenseStats.put("lightning", stats.getLightningResist());
        if (stats.getAirResist() != 0) defenseStats.put("air", stats.getAirResist());
        if (stats.getRadiantResist() != 0) defenseStats.put("radiant", stats.getRadiantResist());
        if (stats.getNecroticResist() != 0) defenseStats.put("necrotic", stats.getNecroticResist());

        return defenseStats;
    }
}