package io.github.NoOne.nMLPlayerStats.statSystem;

import io.github.NoOne.nMLItems.enums.ItemStat;

import java.util.List;

public enum PlayerStat {
    // attribute stats
    ATTRIBUTE_POINTS,
    CONSTITUTION,
    STRENGTH,
    DEXTERITY,
    INTELLIGENCE,
    CHARISMA,

    // action bar stats
    MAX_HEALTH,
    OVERHEALTH,
    MAX_OVERHEALTH,
    CURRENT_ENERGY,
    MAX_ENERGY,

    // damage stats
    ELEMENTAL_DAMAGE,
    PHYSICAL_DAMAGE,
    FIRE_DAMAGE,
    COLD_DAMAGE,
    EARTH_DAMAGE,
    LIGHTNING_DAMAGE,
    AIR_DAMAGE,
    RADIANT_DAMAGE,
    NECROTIC_DAMAGE,
    PURE_DAMAGE,
    CRIT_CHANCE,
    CRIT_DAMAGE,

    // defense stats
    EVASION,
    DEFENSE,
    GUARD,
    PHYSICAL_RESIST,
    FIRE_RESIST,
    COLD_RESIST,
    EARTH_RESIST,
    LIGHTNING_RESIST,
    AIR_RESIST,
    RADIANT_RESIST,
    NECROTIC_RESIST,

    // farming stats
    YIELD,
    HARVEST,
    ACRE,

    // misc. stats
    SPEED;

    @Override
    public String toString() {
        return switch (this) {
            case ATTRIBUTE_POINTS -> "attributePoints";
            case CONSTITUTION -> "constitution";
            case STRENGTH -> "strength";
            case DEXTERITY -> "dexterity";
            case INTELLIGENCE -> "intelligence";
            case CHARISMA -> "charisma";

            case MAX_HEALTH -> "maxHealth";
            case OVERHEALTH -> "overhealth";
            case MAX_OVERHEALTH -> "maxOverhealth";
            case CURRENT_ENERGY -> "currentEnergy";
            case MAX_ENERGY -> "maxEnergy";

            case ELEMENTAL_DAMAGE -> "elementalDamage";
            case PHYSICAL_DAMAGE -> "physicalDamage";
            case FIRE_DAMAGE -> "fireDamage";
            case COLD_DAMAGE -> "coldDamage";
            case EARTH_DAMAGE -> "earthDamage";
            case LIGHTNING_DAMAGE -> "lightningDamage";
            case AIR_DAMAGE -> "airDamage";
            case RADIANT_DAMAGE -> "radiantDamage";
            case NECROTIC_DAMAGE -> "necroticDamage";
            case PURE_DAMAGE -> "pureDamage";
            case CRIT_CHANCE -> "critChance";
            case CRIT_DAMAGE -> "critDamage";

            case EVASION -> "evasion";
            case DEFENSE -> "defense";
            case GUARD -> "guard";
            case PHYSICAL_RESIST -> "physicalResist";
            case FIRE_RESIST -> "fireResist";
            case COLD_RESIST -> "coldResist";
            case EARTH_RESIST -> "earthResist";
            case LIGHTNING_RESIST -> "lightResist";
            case AIR_RESIST -> "airResist";
            case RADIANT_RESIST -> "radResist";
            case NECROTIC_RESIST -> "necroResist";

            case YIELD -> "yield";
            case HARVEST -> "harvest";
            case ACRE -> "acre";

            case SPEED -> "speed";
        };
    }

    public ItemStat toItemStat() {
        return switch (this) {
            case MAX_HEALTH -> ItemStat.MAX_HEALTH;
            case MAX_OVERHEALTH -> ItemStat.OVERHEALTH;
            case PHYSICAL_DAMAGE -> ItemStat.PHYSICAL_DAMAGE;
            case FIRE_DAMAGE -> ItemStat.FIRE_DAMAGE;
            case COLD_DAMAGE -> ItemStat.COLD_DAMAGE;
            case EARTH_DAMAGE -> ItemStat.EARTH_DAMAGE;
            case LIGHTNING_DAMAGE -> ItemStat.LIGHTNING_DAMAGE;
            case AIR_DAMAGE -> ItemStat.AIR_DAMAGE;
            case RADIANT_DAMAGE -> ItemStat.RADIANT_DAMAGE;
            case NECROTIC_DAMAGE -> ItemStat.NECROTIC_DAMAGE;
            case PURE_DAMAGE -> ItemStat.PURE_DAMAGE;
            case CRIT_CHANCE -> ItemStat.CRIT_CHANCE;
            case CRIT_DAMAGE -> ItemStat.CRIT_DAMAGE;
            case EVASION -> ItemStat.EVASION;
            case DEFENSE -> ItemStat.DEFENSE;
            case GUARD -> ItemStat.GUARD;
            case PHYSICAL_RESIST -> ItemStat.PHYSICAL_RESIST;
            case FIRE_RESIST -> ItemStat.FIRE_RESIST;
            case COLD_RESIST -> ItemStat.COLD_RESIST;
            case EARTH_RESIST -> ItemStat.EARTH_RESIST;
            case LIGHTNING_RESIST -> ItemStat.LIGHTNING_RESIST;
            case AIR_RESIST -> ItemStat.AIR_RESIST;
            case RADIANT_RESIST -> ItemStat.RADIANT_RESIST;
            case NECROTIC_RESIST -> ItemStat.NECROTIC_RESIST;
            case YIELD -> ItemStat.YIELD;
            case HARVEST -> ItemStat.HARVEST;
            case ACRE -> ItemStat.ACRE;
            case SPEED -> ItemStat.SPEED;
            default -> null;
        };
    }

    public static PlayerStat fromString(String stat) {
        return switch (stat.toLowerCase().replace(" ", "").toLowerCase()) {
            case "attributepoints" -> ATTRIBUTE_POINTS;
            case "constitution" -> CONSTITUTION;
            case "strength" -> STRENGTH;
            case "dexterity" -> DEXTERITY;
            case "intelligence" -> INTELLIGENCE;
            case "charisma" -> CHARISMA;

            case "maxhealth" -> MAX_HEALTH;
            case "overhealth" -> OVERHEALTH;
            case "maxoverhealth" -> MAX_OVERHEALTH;
            case "currentenergy" -> CURRENT_ENERGY;
            case "maxenergy" -> MAX_ENERGY;

            case "elementaldamage" -> ELEMENTAL_DAMAGE;
            case "physicaldamage" -> PHYSICAL_DAMAGE;
            case "firedamage" -> FIRE_DAMAGE;
            case "colddamage" -> COLD_DAMAGE;
            case "lightningdamage" -> LIGHTNING_DAMAGE;
            case "airdamage" -> AIR_DAMAGE;
            case "radiantdamage" -> RADIANT_DAMAGE;
            case "necroticdamage" -> NECROTIC_DAMAGE;
            case "puredamage" -> PURE_DAMAGE;
            case "critchance" -> CRIT_CHANCE;
            case "critdamage" -> CRIT_DAMAGE;

            case "evasion" -> EVASION;
            case "defense" -> DEFENSE;
            case "guard" -> GUARD;
            case "physicalresist" -> PHYSICAL_RESIST;
            case "fireresist" -> FIRE_RESIST;
            case "coldresist" -> COLD_RESIST;
            case "lightningresist" -> LIGHTNING_RESIST;
            case "airresist" -> AIR_RESIST;
            case "radiantresist" -> RADIANT_RESIST;
            case "necroticresist" -> NECROTIC_RESIST;

            case "yield" -> YIELD;
            case "harvest" -> HARVEST;
            case "acre" -> ACRE;

            case "speed" -> SPEED;
            default -> null;
        };
    }
    
    // returns a list of player stats that are saved as doubles
    // assume stats not on this list are integers
    public static List<PlayerStat> getDoubleStats() {
        return List.of(MAX_HEALTH, OVERHEALTH, MAX_OVERHEALTH, CURRENT_ENERGY, MAX_ENERGY);
    }
}
