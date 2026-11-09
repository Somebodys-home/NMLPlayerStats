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
        statMap.put(player.getUniqueId(), Stats.generateNewbieStats());
        Bukkit.getPluginManager().callEvent(new ResetStatsEvent(player));
    }

    public Stats getStats(UUID uuid) {
        return statMap.get(uuid);
    }

    public void loadStatsFromConfig() {
        for (String id : config.getConfigurationSection("").getKeys(false)) {
            UUID uuid = UUID.fromString(id);

            int attributePoints = config.getInt(id + ".stats." + PlayerStat.ATTRIBUTE_POINTS);
            int constitution = config.getInt(id + ".stats." + PlayerStat.CONSTITUTION);
            int strength = config.getInt(id + ".stats." + PlayerStat.STRENGTH);
            int dexterity = config.getInt(id + ".stats." + PlayerStat.DEXTERITY);
            int intelligence = config.getInt(id + ".stats." + PlayerStat.INTELLIGENCE);
            int charisma = config.getInt(id + ".stats." + PlayerStat.CHARISMA);

            double maxHealth = config.getDouble(id + ".stats." + PlayerStat.MAX_HEALTH);
            double currentEnergy = config.getDouble(id + ".stats." + PlayerStat.CURRENT_ENERGY);
            double maxEnergy = config.getDouble(id + ".stats." + PlayerStat.MAX_ENERGY);
            double overhealth = config.getDouble(id + ".stats." + PlayerStat.OVERHEALTH);
            double maxOverhealth = config.getDouble(id + ".stats." + PlayerStat.MAX_OVERHEALTH);

            int physicalDamage = config.getInt(id + ".stats." + PlayerStat.PHYSICAL_DAMAGE);
            int elementalDamage = config.getInt(id + ".stats." + PlayerStat.ELEMENTAL_DAMAGE);
            int fireDamage = config.getInt(id + ".stats." + PlayerStat.FIRE_DAMAGE);
            int coldDamage = config.getInt(id + ".stats." + PlayerStat.COLD_DAMAGE);
            int earthDamage = config.getInt(id + ".stats." + PlayerStat.EARTH_DAMAGE);
            int lightningDamage = config.getInt(id + ".stats." + PlayerStat.LIGHTNING_DAMAGE);
            int airDamage = config.getInt(id + ".stats." + PlayerStat.AIR_DAMAGE);
            int radiantDamage = config.getInt(id + ".stats." + PlayerStat.RADIANT_DAMAGE);
            int necroticDamage = config.getInt(id + ".stats." + PlayerStat.NECROTIC_DAMAGE);
            int pureDamage = config.getInt(id + ".stats." + PlayerStat.PURE_DAMAGE);
            double critChance = config.getDouble(id + ".stats." + PlayerStat.CRIT_CHANCE);
            int critDamage = config.getInt(id + ".stats." + PlayerStat.CRIT_DAMAGE);

            int evasion = config.getInt(id + ".stats." + PlayerStat.EVASION);
            int defense = config.getInt(id + ".stats." + PlayerStat.DEFENSE);
            int guard = config.getInt(id + ".stats." + PlayerStat.GUARD);
            int physicalResist = config.getInt(id + ".stats." + PlayerStat.PHYSICAL_RESIST);
            int fireResist = config.getInt(id + ".stats." + PlayerStat.FIRE_RESIST);
            int coldResist = config.getInt(id + ".stats." + PlayerStat.COLD_RESIST);
            int earthResist = config.getInt(id + ".stats." + PlayerStat.EARTH_RESIST);
            int lightningResist = config.getInt(id + ".stats." + PlayerStat.LIGHTNING_RESIST);
            int airResist = config.getInt(id + ".stats." + PlayerStat.AIR_RESIST);
            int radiantResist = config.getInt(id + ".stats." + PlayerStat.RADIANT_RESIST);
            int necroticResist = config.getInt(id + ".stats." + PlayerStat.NECROTIC_RESIST);

            int yield = config.getInt(id + ".stats." + PlayerStat.YIELD);
            int harvest = config.getInt(id + ".stats." + PlayerStat.HARVEST);
            int acre = config.getInt(id + ".stats." + PlayerStat.ACRE);

            int speed = config.getInt(id + ".stats." + PlayerStat.SPEED);

            Stats stats = new Stats(
                    attributePoints, constitution, strength, dexterity, intelligence, charisma,
                    maxHealth, overhealth, maxOverhealth, currentEnergy, maxEnergy,
                    elementalDamage, physicalDamage, fireDamage, coldDamage, earthDamage, lightningDamage, airDamage, radiantDamage, necroticDamage, pureDamage,
                    critChance, critDamage,
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