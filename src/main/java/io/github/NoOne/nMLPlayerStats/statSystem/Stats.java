package io.github.NoOne.nMLPlayerStats.statSystem;

import java.util.*;

import static io.github.NoOne.nMLPlayerStats.statSystem.PlayerStat.*;

public class Stats {
    private LinkedHashMap<PlayerStat, Double> playerStats;

    public Stats(int attributePoints, int constitution, int strength, int dexterity, int intelligence, int charisma,
                 double health, double maxHealth, double overhealth, double maxOverhealth, double currentEnergy, double maxEnergy,
                 int elementalDamage, int physicalDamage, int fireDamage, int coldDamage, int earthDamage, int lightningDamage, int airDamage, int radiantDamage,
                 int necroticDamage, int pureDamage,
                 double critChance, int critDamage,
                 int evasion, int defense, int guard, int physicalResist, int fireResist, int coldResist, int earthResist, int lightningResist, int airResist,
                 int radiantResist, int necroticResist,
                 int yield, int harvest, int acre,
                 int speed) {

        playerStats = new LinkedHashMap<>(){{
            put(ATTRIBUTE_POINTS, (double) attributePoints);
            put(CONSTITUTION, (double) constitution);
            put(STRENGTH, (double) strength);
            put(DEXTERITY, (double) dexterity);
            put(INTELLIGENCE, (double) intelligence);
            put(CHARISMA, (double) charisma);

            put(HEALTH, health);
            put(MAX_HEALTH, maxHealth);
            put(OVERHEALTH, overhealth);
            put(MAX_OVERHEALTH, maxOverhealth);
            put(CURRENT_ENERGY, currentEnergy);
            put(MAX_ENERGY, maxEnergy);

            put(ELEMENTAL_DAMAGE, (double) elementalDamage);
            put(PHYSICAL_DAMAGE, (double) physicalDamage);
            put(FIRE_DAMAGE, (double) fireDamage);
            put(COLD_DAMAGE, (double) coldDamage);
            put(EARTH_DAMAGE, (double) earthDamage);
            put(LIGHTNING_DAMAGE, (double) lightningDamage);
            put(AIR_DAMAGE, (double) airDamage);
            put(RADIANT_DAMAGE, (double) radiantDamage);
            put(NECROTIC_DAMAGE, (double) necroticDamage);
            put(PURE_DAMAGE, (double) pureDamage);
            put(CRIT_CHANCE, critChance);
            put(CRIT_DAMAGE, (double) critDamage);

            put(EVASION, (double) evasion);
            put(DEFENSE, (double) defense);
            put(GUARD, (double) guard);
            put(PHYSICAL_RESIST, (double) physicalResist);
            put(FIRE_RESIST, (double) fireResist);
            put(COLD_RESIST, (double) coldResist);
            put(EARTH_RESIST, (double) earthResist);
            put(LIGHTNING_RESIST, (double) lightningResist);
            put(AIR_RESIST, (double) airResist);
            put(RADIANT_RESIST, (double) radiantResist);
            put(NECROTIC_RESIST, (double) necroticResist);

            put(YIELD, (double) yield);
            put(HARVEST, (double) harvest);
            put(ACRE, (double) acre);

            put(SPEED, (double) speed);
        }};
    }

    public static Stats generateNewbieStats() {
        return new Stats(0, 1, 1, 1, 1, 1,
                20, 20, 0, 0, 100, 100,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                10, 150,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 10,
                100);
    }

    public void addToStat(PlayerStat playerStat, double amount) {
        switch (playerStat) {
            case CURRENT_ENERGY -> playerStats.put(playerStat, Math.min(playerStats.get(MAX_ENERGY), playerStats.get(playerStat) + amount));
            case OVERHEALTH -> playerStats.put(playerStat, Math.min(playerStats.get(MAX_OVERHEALTH), playerStats.get(playerStat) + amount));
            case HEALTH -> playerStats.put(playerStat, Math.min(playerStats.get(MAX_HEALTH), playerStats.get(playerStat) + amount));
            default -> playerStats.put(playerStat, playerStats.get(playerStat) + amount);
        }
    }

    public void removeFromStat(PlayerStat playerStat, double amount) {
        switch (playerStat) {
            case CURRENT_ENERGY -> playerStats.put(playerStat, Math.max(0, playerStats.get(playerStat) - amount));
            default -> playerStats.put(playerStat, playerStats.get(playerStat) - amount);
        }
    }

    public void resetStats() {
        playerStats = generateNewbieStats().playerStats;
    }

    public void setStat(PlayerStat playerStat, double amount) {
        playerStats.put(playerStat, PlayerStat.getDoubleStats().contains(playerStat) ? amount : (int) amount);
    }

    public boolean hasStat(PlayerStat playerStat) {
        return playerStats.containsKey(playerStat);
    }

    public HashMap<PlayerStat, Integer> getAllDamages() {
        HashMap<PlayerStat, Integer> damages = new HashMap<>() {{
            List<PlayerStat> damageStats = List.of(PHYSICAL_DAMAGE, FIRE_DAMAGE, COLD_DAMAGE, EARTH_DAMAGE, LIGHTNING_DAMAGE, AIR_DAMAGE, RADIANT_DAMAGE, NECROTIC_DAMAGE, PURE_DAMAGE);

            for (PlayerStat damageStat : damageStats) {
                put(damageStat, playerStats.get(damageStat).intValue());
            }
        }};

        damages.entrySet().removeIf(entry -> entry.getValue() <= 0);
        return damages;
    }

    public Map.Entry<PlayerStat, Integer> getHighestElementalDamage() {
        List<Map.Entry<PlayerStat, Integer>> highest = new ArrayList<>(getAllDamages().entrySet()); // convert damage map to arraylist for sorting

        highest.sort((a, b) -> b.getValue().compareTo(a.getValue())); // sort by highest
        return highest.getFirst();
    }

    public HashMap<String, Integer> getAllResists() {
        HashMap<String, Integer> resists = new HashMap<>(){{
            List<PlayerStat> resistStats = List.of(PHYSICAL_RESIST, FIRE_RESIST, COLD_RESIST, EARTH_RESIST, LIGHTNING_RESIST, AIR_RESIST, RADIANT_RESIST, NECROTIC_RESIST);

            for (PlayerStat damageStat : resistStats) {
                put(damageStat.toString(), playerStats.get(damageStat).intValue());
            }
        }};

        resists.entrySet().removeIf(entry -> entry.getValue() <= 0);
        return resists;
    }

    public HashMap<PlayerStat, Double> getPlayerStats() {
        return playerStats;
    }

    // returns either the actual value or Integer.MIN_VALUE if that stat is stored as an int in the stat map
    public int getIntStatValue(PlayerStat playerStat) {
        return !PlayerStat.getDoubleStats().contains(playerStat) ? playerStats.get(playerStat).intValue() : Integer.MIN_VALUE;
    }

    public double getStatValue(PlayerStat playerStat) {
        return playerStats.get(playerStat);
    }

//    public int getAttributePoints() {
//        return attributePoints;
//    }
//
//    public void setAttributePoints(int attributePoints) {
//        this.attributePoints = attributePoints;
//    }
//
//    public int getConstitution() {
//        return constitution;
//    }
//
//    public void setConstitution(int constitution) {
//        this.constitution = constitution;
//    }
//
//    public int getStrength() {
//        return strength;
//    }
//
//    public void setStrength(int strength) {
//        this.strength = strength;
//    }
//
//    public int getDexterity() {
//        return dexterity;
//    }
//
//    public void setDexterity(int dexterity) {
//        this.dexterity = dexterity;
//    }
//
//    public int getIntelligence() {
//        return intelligence;
//    }
//
//    public void setIntelligence(int intelligence) {
//        this.intelligence = intelligence;
//    }
//
//    public double getCurrentEnergy() {
//        return currentEnergy;
//    }
//
//    public void setCurrentEnergy(double currentEnergy) {
//        this.currentEnergy = currentEnergy;
//    }
//
//    public double getMaxEnergy() {
//        return maxEnergy;
//    }
//
//    public void setMaxEnergy(double maxEnergy) {
//        this.maxEnergy = maxEnergy;
//    }
//
//    public double getOverhealth() {
//        return overhealth;
//    }
//
//    public void setOverhealth(double overhealth) {
//        this.overhealth = getOverhealth();
//    }
//
//    public double getMaxOverhealth() {
//        return maxOverhealth;
//    }
//
//    public double getMaxHealth() {
//        return maxHealth;
//    }
//
//    public void setMaxHealth(double maxHealth) {
//        this.maxHealth = maxHealth;
//    }
//
//    public void setMaxOverhealth(double maxOverhealth) {
//        this.maxOverhealth = maxOverhealth;
//    }
//
//    public int getEvasion() {
//        return evasion;
//    }
//
//    public void setEvasion(int evasion) {
//        this.evasion = evasion;
//    }
//
//    public int getPhysicalDamage() {
//        return physicalDamage;
//    }
//
//    public void setPhysicalDamage(int physicalDamage) {
//        this.physicalDamage = physicalDamage;
//    }
//
//    public int getFireDamage() {
//        return fireDamage;
//    }
//
//    public void setFireDamage(int fireDamage) {
//        this.fireDamage = fireDamage;
//    }
//
//    public int getColdDamage() {
//        return coldDamage;
//    }
//
//    public void setColdDamage(int coldDamage) {
//        this.coldDamage = coldDamage;
//    }
//
//    public int getEarthDamage() {
//        return earthDamage;
//    }
//
//    public void setEarthDamage(int earthDamage) {
//        this.earthDamage = earthDamage;
//    }
//
//    public int getAirDamage() {
//        return airDamage;
//    }
//
//    public void setAirDamage(int airDamage) {
//        this.airDamage = airDamage;
//    }
//
//    public int getPureDamage() {
//        return pureDamage;
//    }
//
//    public void setPureDamage(int pureDamage) {
//        this.pureDamage = pureDamage;
//    }
//
//    public int getNecroticDamage() {
//        return necroticDamage;
//    }
//
//    public void setNecroticDamage(int necroticDamage) {
//        this.necroticDamage = necroticDamage;
//    }
//
//    public int getRadiantDamage() {
//        return radiantDamage;
//    }
//
//    public void setRadiantDamage(int radiantDamage) {
//        this.radiantDamage = radiantDamage;
//    }
//
//    public int getLightningDamage() {
//        return lightningDamage;
//    }
//
//    public void setLightningDamage(int lightningDamage) {
//        this.lightningDamage = lightningDamage;
//    }
//
//    public int getDefense() {
//        return defense;
//    }
//
//    public void setDefense(int defense) {
//        this.defense = defense;
//    }
//
//    public int getNecroticResist() {
//        return necroticResist;
//    }
//
//    public void setNecroticResist(int necroticResist) {
//        this.necroticResist = necroticResist;
//    }
//
//    public int getRadiantResist() {
//        return radiantResist;
//    }
//
//    public void setRadiantResist(int radiantResist) {
//        this.radiantResist = radiantResist;
//    }
//
//    public int getLightningResist() {
//        return lightningResist;
//    }
//
//    public void setLightningResist(int lightningResist) {
//        this.lightningResist = lightningResist;
//    }
//
//    public int getAirResist() {
//        return airResist;
//    }
//
//    public void setAirResist(int airResist) {
//        this.airResist = airResist;
//    }
//
//    public int getEarthResist() {
//        return earthResist;
//    }
//
//    public void setEarthResist(int earthResist) {
//        this.earthResist = earthResist;
//    }
//
//    public int getColdResist() {
//        return coldResist;
//    }
//
//    public void setColdResist(int coldResist) {
//        this.coldResist = coldResist;
//    }
//
//    public int getFireResist() {
//        return fireResist;
//    }
//
//    public void setFireResist(int fireResist) {
//        this.fireResist = fireResist;
//    }
//
//    public int getPhysicalResist() {
//        return physicalResist;
//    }
//
//    public void setPhysicalResist(int physicalResist) {
//        this.physicalResist = physicalResist;
//    }
//
//    public int getGuard() {
//        return guard;
//    }
//
//    public void setGuard(int guard) {
//        this.guard = guard;
//    }
//
//    public double getCritChance() {
//        return critChance;
//    }
//
//    public void setCritChance(double critChance) {
//        this.critChance = critChance;
//    }
//
//    public int getCritDamage() {
//        return critDamage;
//    }
//
//    public void setCritDamage(int critDamage) {
//        this.critDamage = critDamage;
//    }
//
//    public int getElementalDamage() {
//        return elementalDamage;
//    }
//
//    public void setElementalDamage(int elementalDamage) {
//        this.elementalDamage = elementalDamage;
//    }
//
//    public int getYield() {
//        return yield;
//    }
//
//    public void setYield(int yield) {
//        this.yield = yield;
//    }
//
//    public int getHarvest() {
//        return harvest;
//    }
//
//    public void setHarvest(int harvest) {
//        this.harvest = harvest;
//    }
//
//    public int getAcre() {
//        return acre;
//    }
//
//    public void setAcre(int acre) {
//        this.acre = acre;
//    }
//
//    public int getSpeed() {
//        return speed;
//    }
//
//    public void setSpeed(int speed) {
//        this.speed = speed;
//    }
//
//    public int getCharisma() {
//        return charisma;
//    }
//
//    public void setCharisma(int charisma) {
//        this.charisma = charisma;
//    }
}