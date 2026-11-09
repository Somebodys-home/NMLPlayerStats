package io.github.NoOne.nMLPlayerStats.profileSystem;

import io.github.NoOne.nMLPlayerStats.NMLPlayerStats;
import io.github.NoOne.nMLPlayerStats.statSystem.PlayerStat;
import io.github.NoOne.nMLPlayerStats.statSystem.ResetStatsEvent;
import io.github.NoOne.nMLPlayerStats.statSystem.Stats;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ProfileManager {
    private static Map<UUID, Stats> statMap = new HashMap<>(); // map of all the stats of the players online atm
    private FileConfiguration config;
    private ProfileConfig profileConfig;

    public ProfileManager(NMLPlayerStats nmlPlayerStats) {
        profileConfig = nmlPlayerStats.getProfileConfig();
        config = profileConfig.getConfig();
    }

    public void saveNewbieStats(Player player) {
        Stats stats = Stats.generateNewbieStats();

        statMap.put(player.getUniqueId(), stats);
        Bukkit.getPluginManager().callEvent(new ResetStatsEvent(player));
    }

    public Stats getStats(UUID uuid) {
        return statMap.get(uuid);
    }

    public void loadStatsFromConfig() {
        for (String id : config.getConfigurationSection("").getKeys(false)) {
            UUID uuid = UUID.fromString(id);

            int attributePoints = config.getInt(id + ".stats." + PlayerStat.ATTRIBUTE_POINTS);
            int constitution = config.getInt(id + ".stats.constitution");
            int strength = config.getInt(id + ".stats.strength");
            int dexterity = config.getInt(id + ".stats.dexterity");
            int intelligence = config.getInt(id + ".stats.intelligence");
            int charisma = config.getInt(id + ".stats.charisma");

            double maxHealth = config.getDouble(id + ".stats.maxHealth");
            double currentEnergy = config.getDouble(id + ".stats.currentEnergy");
            double maxEnergy = config.getDouble(id + ".stats.maxEnergy");
            double overhealth = config.getDouble(id + ".stats.overhealth");
            double maxOverhealth = config.getDouble(id + ".stats.maxOverhealth");

            int physicalDamage = config.getInt(id + ".stats.physicalDamage");
            int elementalDamage = config.getInt(id + ".stats.elementalDamage");
            int fireDamage = config.getInt(id + ".stats.fireDamage");
            int coldDamage = config.getInt(id + ".stats.coldDamage");
            int earthDamage = config.getInt(id + ".stats.earthDamage");
            int lightningDamage = config.getInt(id + ".stats.lightningDamage");
            int airDamage = config.getInt(id + ".stats.airDamage");
            int radiantDamage = config.getInt(id + ".stats.radiantDamage");
            int necroticDamage = config.getInt(id + ".stats.necroticDamage");
            int pureDamage = config.getInt(id + ".stats.pureDamage");
            double critchance = config.getDouble(id + ".stats.critchance");
            int critdamage = config.getInt(id + ".stats.critdamage");

            int evasion = config.getInt(id + ".stats.evasion");
            int defense = config.getInt(id + ".stats.defense");
            int guard = config.getInt(id + ".stats.guard");
            int physicalResist = config.getInt(id + ".stats.physicalResist");
            int fireResist = config.getInt(id + ".stats.fireResist");
            int coldResist = config.getInt(id + ".stats.coldResist");
            int earthResist = config.getInt(id + ".stats.earthResist");
            int lightningResist = config.getInt(id + ".stats.lightningResist");
            int airResist = config.getInt(id + ".stats.airResist");
            int radiantResist = config.getInt(id + ".stats.radiantResist");
            int necroticResist = config.getInt(id + ".stats.necroticResist");

            int yield = config.getInt(id + ".stats.yield");
            int harvest = config.getInt(id + ".stats.harvest");
            int acre = config.getInt(id + ".stats.acre");

            int speed = config.getInt(id + ".stats.speed");

            Stats stats = new Stats(
                    attributePoints, constitution, strength, dexterity, intelligence, charisma,
                    maxHealth, overhealth, maxOverhealth, currentEnergy, maxEnergy,
                    elementalDamage, physicalDamage, fireDamage, coldDamage, earthDamage, lightningDamage, airDamage, radiantDamage, necroticDamage, pureDamage,
                    critchance, critdamage,
                    evasion, defense, guard, physicalResist, fireResist, coldResist, earthResist, lightningResist, airResist, radiantResist, necroticResist,
                    yield, harvest, acre,
                    speed
            );

            statMap.put(uuid, stats);
        }
    }

    public void saveProfilesToConfig() {
        for (UUID uuid : statMap.keySet()) {
            String id = uuid.toString();
            Stats stats = statMap.get(uuid);

            for (Map.Entry<PlayerStat, Double> entry : stats.getPlayerStats().entrySet()) {
                PlayerStat playerStat = entry.getKey();

                if (PlayerStat.getDoubleStats().contains(playerStat)) {
                    config.set(id + ".stats." + playerStat.toString(), stats.getStatValue(playerStat));
                } else {
                    config.set(id + ".stats." + playerStat.toString(), stats.getIntStatValue(playerStat));
                }
            }
        }
    }

    public void saveAProfileToConfig(Player player) {
        String id = player.getUniqueId().toString();
        Stats stats = statMap.get(player.getUniqueId());

        for (Map.Entry<PlayerStat, Double> entry : stats.getPlayerStats().entrySet()) {
            PlayerStat playerStat = entry.getKey();

            if (PlayerStat.getDoubleStats().contains(playerStat)) {
                config.set(id + ".stats." + playerStat.toString(), stats.getStatValue(playerStat));
            } else {
                config.set(id + ".stats." + playerStat.toString(), stats.getIntStatValue(playerStat));
            }
        }
    }
}