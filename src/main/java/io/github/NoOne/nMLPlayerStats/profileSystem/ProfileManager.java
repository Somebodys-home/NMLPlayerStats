package io.github.NoOne.nMLPlayerStats.profileSystem;

import io.github.NoOne.nMLPlayerStats.NMLPlayerStats;
import io.github.NoOne.nMLPlayerStats.statSystem.ResetStatsEvent;
import io.github.NoOne.nMLPlayerStats.statSystem.Stats;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ProfileManager {
    private NMLPlayerStats nmlPlayerStats;
    private static Map<UUID, Profile> profileMap = new HashMap<>(); // hashmap of all the profiles of all the players online atm
    private FileConfiguration config;
    private ProfileConfig profileConfig;

    public ProfileManager(NMLPlayerStats nmlPlayerStats) {
        this.nmlPlayerStats = nmlPlayerStats;
        profileConfig = nmlPlayerStats.getProfileConfig();
        config = profileConfig.getConfig();
    }

    public Profile createNewbieProfile(Player player) {
        Profile profile = new Profile(Stats.generateNewbieStats());

        profileMap.put(player.getUniqueId(), profile);
        Bukkit.getPluginManager().callEvent(new ResetStatsEvent(player));

        return profile;
    }

    public Profile getPlayerProfile(UUID uuid) {
        return profileMap.get(uuid);
    }

    public void loadProfilesFromConfig() {
        for (String id : config.getConfigurationSection("").getKeys(false)) {
            UUID uuid = UUID.fromString(id);
            int level = config.getInt(id + ".stats.level");
            int exp = config.getInt(id + ".stats.exp");
            int attributePoints = config.getInt(id + ".stats.attributePoints");
            int vitality = config.getInt(id + ".stats.vitality");
            int strength = config.getInt(id + ".stats.strength");
            int deft = config.getInt(id + ".stats.deft");
            int arcane = config.getInt(id + ".stats.arcane");
            double bonusHealth = config.getDouble(id + ".stats.bonusHealth");
            double currentEnergy = config.getDouble(id + ".stats.currentEnergy");
            double maxEnergy = config.getDouble(id + ".stats.maxEnergy");
            double currentOverhealth = config.getDouble(id + ".stats.currentOverhealth");
            double maxOverhealth = config.getDouble(id + ".stats.maxOverhealth");
            int evasion = config.getInt(id + ".stats.evasion");
            int physicalDamage = config.getInt(id + "stats.physicalDamage");
            int fireDamage = config.getInt(id + "stats.fireDamage");
            int coldDamage = config.getInt(id + "stats.coldDamage");
            int earthDamage = config.getInt(id + "stats.earthDamage");
            int lightningDamage = config.getInt(id + "stats.lightningDamage");
            int airDamage = config.getInt(id + "stats.airDamage");
            int lightDamage = config.getInt(id + "stats.lightDamage");
            int darkDamage = config.getInt(id + "stats.darkDamage");
            int pureDamage = config.getInt(id + "stats.pureDamage");
            Stats stats = new Stats(level, exp, attributePoints, vitality, strength, deft, arcane, bonusHealth, currentOverhealth, maxOverhealth, currentEnergy, maxEnergy,
                                    evasion, physicalDamage, fireDamage, coldDamage, earthDamage, lightningDamage, airDamage, lightDamage, darkDamage, pureDamage);
            Profile profile = new Profile(stats);

            profileMap.put(uuid, profile);
        }
    }

    public void saveProfilesToConfig() {
        for (UUID uuid : profileMap.keySet()) {
            String id = uuid.toString();
            Profile profile = profileMap.get(uuid);
            Stats stats = profile.getStats();

            config.set(id + ".stats.level", stats.getLevel());
            config.set(id + ".stats.exp", stats.getExp());
            config.set(id + ".stats.attributePoints", stats.getAttributePoints());
            config.set(id + ".stats.vitality", stats.getVitality());
            config.set(id + ".stats.strength", stats.getStrength());
            config.set(id + ".stats.deft", stats.getDeft());
            config.set(id + ".stats.arcane", stats.getArcane());
            config.set(id + ".stats.bonusHealth", stats.getBonusHealth());
            config.set(id + ".stats.currentEnergy", stats.getCurrentEnergy());
            config.set(id + ".stats.maxEnergy", stats.getMaxEnergy());
            config.set(id + ".stats.currentOverhealth", stats.getCurrentOverhealth());
            config.set(id + ".stats.maxOverhealth", stats.getMaxOverhealth());
            config.set(id + ".stats.evasion", stats.getEvasion());
            config.set(id + ".stats.physicalDamage", stats.getPhysicalDamage());
            config.set(id + ".stats.fireDamage", stats.getFireDamage());
            config.set(id + ".stats.coldDamage", stats.getColdDamage());
            config.set(id + ".stats.earthDamage", stats.getEarthDamage());
            config.set(id + ".stats.lightningDamage", stats.getLightningDamage());
            config.set(id + ".stats.airDamage", stats.getAirDamage());
            config.set(id + ".stats.lightDamage", stats.getLightDamage());
            config.set(id + ".stats.darkDamage", stats.getDarkDamage());
            config.set(id + ".stats.pureDamage", stats.getPureDamage());
        }
    }

    public void saveAProfileToConfig(Player player) {
        String id = player.getUniqueId().toString();
        Profile profile = profileMap.get(player.getUniqueId());
        Stats stats = profile.getStats();

        config.set(id + ".stats.level", stats.getLevel());
        config.set(id + ".stats.exp", stats.getExp());
        config.set(id + ".stats.attributePoints", stats.getAttributePoints());
        config.set(id + ".stats.vitality", stats.getVitality());
        config.set(id + ".stats.strength", stats.getStrength());
        config.set(id + ".stats.deft", stats.getDeft());
        config.set(id + ".stats.arcane", stats.getArcane());
        config.set(id + ".stats.bonusHealth", stats.getBonusHealth());
        config.set(id + ".stats.currentEnergy", stats.getCurrentEnergy());
        config.set(id + ".stats.maxEnergy", stats.getMaxEnergy());
        config.set(id + ".stats.currentOverhealth", stats.getCurrentOverhealth());
        config.set(id + ".stats.maxOverhealth", stats.getMaxOverhealth());
        config.set(id + ".stats.evasion", stats.getEvasion());
        config.set(id + ".stats.physicalDamage", stats.getPhysicalDamage());
        config.set(id + ".stats.fireDamage", stats.getFireDamage());
        config.set(id + ".stats.coldDamage", stats.getColdDamage());
        config.set(id + ".stats.earthDamage", stats.getEarthDamage());
        config.set(id + ".stats.lightningDamage", stats.getLightningDamage());
        config.set(id + ".stats.airDamage", stats.getAirDamage());
        config.set(id + ".stats.lightDamage", stats.getLightDamage());
        config.set(id + ".stats.darkDamage", stats.getDarkDamage());
        config.set(id + ".stats.pureDamage", stats.getPureDamage());
    }
}
