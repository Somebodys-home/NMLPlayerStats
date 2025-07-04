package io.github.NoOne.nMLPlayerStats.profileSystem;

import io.github.NoOne.nMLPlayerStats.NMLPlayerStats;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import java.io.File;
import java.io.IOException;

public class ProfileConfig {
    private NMLPlayerStats nmlPlayerStats;
    private File file;
    private String fileName;
    private FileConfiguration config = new YamlConfiguration();

    public ProfileConfig(NMLPlayerStats nmlPlayerStats, String filename) {
        this.nmlPlayerStats = nmlPlayerStats;
        this.fileName = filename;
        file = new File(nmlPlayerStats.getDataFolder(), filename + ".yml");
    }

    public void loadConfig() {
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            nmlPlayerStats.saveResource(fileName + ".yml", false);
        } try {
            config.load(file);
        } catch (IOException | InvalidConfigurationException exception) {
            exception.printStackTrace();
        }
    }

    public void saveConfig() {
        try {
            config.save(file);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public FileConfiguration getConfig() {
        return config;
    }
}
