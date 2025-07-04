package io.github.NoOne.nMLPlayerStats.profileSystem;

import io.github.NoOne.nMLPlayerStats.NMLPlayerStats;
import io.github.NoOne.nMLPlayerStats.statSystem.Stats;
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

    public Profile createnewProfile(Player player) {
        Profile profile = new Profile(Stats.generateNewbieStats());

        profileMap.put(player.getUniqueId(), profile);

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
            Stats stats = new Stats(level, exp);
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
        }
    }

    public void saveAProfileToConfig(Player player) {
        String id = player.getUniqueId().toString();
        Profile profile = profileMap.get(player.getUniqueId());
        Stats stats = profile.getStats();

        config.set(id + ".stats.level", stats.getLevel());
        config.set(id + ".stats.exp", stats.getExp());
        config.set(id + ".stats.exp2NextLevel", stats.getExp2NextLevel());
    }
}
