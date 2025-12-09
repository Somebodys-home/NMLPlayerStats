package io.github.NoOne.nMLPlayerStats.statSystem;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Stats {
    // attribute stats
    private int attributePoints;
    private int vitality;
    private int strength;
    private int deft;
    private int arcane;

    // hotbar stats
    private double maxHealth;
    private double currentOverhealth;
    private double maxOverhealth;
    private double currentEnergy;
    private double maxEnergy;

    // damage stats
    private int physicalDamage;
    private int elementalDamage;
    private int fireDamage;
    private int coldDamage;
    private int earthDamage;
    private int lightningDamage;
    private int airDamage;
    private int radiantDamage;
    private int necroticDamage;
    private int pureDamage;
    private double critChance;
    private int critDamage;

    // defense stats
    private int evasion;
    private int defense;
    private int guard;
    private int physicalResist;
    private int fireResist;
    private int coldResist;
    private int earthResist;
    private int lightningResist;
    private int airResist;
    private int radiantResist;
    private int necroticResist;

    // skill stats
    private int harvest;
    private int yield;
    private int acre;

    public Stats(int attributePoints, int vitality, int strength, int deft, int arcane,
                 double maxHealth, double currentOverhealth, double maxOverhealth, double currentEnergy, double maxEnergy,
                 int elementalDamage, int physicalDamage, int fireDamage, int coldDamage, int earthDamage, int lightningDamage, int airDamage, int radiantDamage,
                 int necroticDamage, int pureDamage,
                 double critChance, int critDamage,
                 int evasion, int defense, int guard, int physicalResist, int fireResist, int coldResist, int earthResist, int lightningResist, int airResist,
                 int radiantResist, int necroticResist,
                 int harvest, int yield, int acre) {

        this.attributePoints = attributePoints;
        this.vitality = vitality;
        this.strength = strength;
        this.deft = deft;
        this.arcane = arcane;

        this.maxHealth = maxHealth;
        this.currentOverhealth = currentOverhealth;
        this.maxOverhealth = maxOverhealth;
        this.currentEnergy = currentEnergy;
        this.maxEnergy = maxEnergy;

        this.elementalDamage = elementalDamage;
        this.physicalDamage = physicalDamage;
        this.fireDamage = fireDamage;
        this.coldDamage = coldDamage;
        this.earthDamage = earthDamage;
        this.lightningDamage = lightningDamage;
        this.airDamage = airDamage;
        this.radiantDamage = radiantDamage;
        this.necroticDamage = necroticDamage;
        this.pureDamage = pureDamage;
        this.critChance = critChance;
        this.critDamage = critDamage;

        this.evasion = evasion;
        this.defense = defense;
        this.guard = guard;
        this.physicalResist = physicalResist;
        this.fireResist = fireResist;
        this.coldResist = coldResist;
        this.earthResist = earthResist;
        this.lightningResist = lightningResist;
        this.airResist = airResist;
        this.radiantResist = radiantResist;
        this.necroticResist = necroticResist;

        this.harvest = harvest;
        this.yield = yield;
        this.acre = acre;
    }

    public static Stats generateNewbieStats() {
        return new Stats(0, 0, 0, 0, 0,
                0, 0, 0, 100, 100,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                10, 150,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0);
    }

    public void add2Stat(String stat, double amount) {
        switch (stat.toLowerCase()) {
            case "attributepoints" -> attributePoints += (int) amount;
            case "vitality" -> vitality += (int) amount;
            case "strength" -> strength += (int) amount;
            case "deft" -> deft += (int) amount;
            case "arcane" -> arcane += (int) amount;
            case "currentoverhealth" -> {
                currentOverhealth += amount;
                if (currentOverhealth > maxOverhealth) currentOverhealth = maxOverhealth;
            }
            case "maxoverhealth" -> maxOverhealth += amount;
            case "currentenergy" -> {
                currentEnergy += amount;
                if (currentEnergy > maxEnergy) currentEnergy = maxEnergy;
            }
            case "maxenergy" -> maxEnergy += amount;
            case "elementaldamage" -> elementalDamage += (int) amount;
            case "physicaldamage" -> physicalDamage += (int) amount;
            case "firedamage" -> fireDamage += (int) amount;
            case "colddamage" -> coldDamage += (int) amount;
            case "earthdamage" -> earthDamage += (int) amount;
            case "lightningdamage" -> lightningDamage += (int) amount;
            case "airdamage" -> airDamage += (int) amount;
            case "radiantdamage" -> radiantDamage += (int) amount;
            case "necroticdamage" -> necroticDamage += (int) amount;
            case "puredamage" -> pureDamage += (int) amount;
            case "critchance" -> critChance += amount;
            case "critdamage" -> critDamage += (int) amount;
            case "evasion" -> evasion += (int) amount;
            case "defense" -> defense += (int) amount;
            case "guard" -> guard += (int) amount;
            case "physicalresist" -> physicalResist += (int) amount;
            case "fireresist" -> fireResist += (int) amount;
            case "coldresist" -> coldResist += (int) amount;
            case "earthresist" -> earthResist += (int) amount;
            case "lightningresist" -> lightningResist += (int) amount;
            case "airresist" -> airResist += (int) amount;
            case "radiantresist" -> radiantResist += (int) amount;
            case "necroticresist" -> necroticResist += (int) amount;
            case "harvest" -> harvest += (int) amount;
            case "yield" -> yield += (int) amount;
            case "acre" -> acre += (int) amount;
        }
    }

    public void removeFromStat(String stat, double amount) {
        switch (stat.toLowerCase()) {
            case "attributepoints" -> attributePoints -= (int) amount;
            case "vitality" -> vitality -= (int) amount;
            case "strength" -> strength -= (int) amount;
            case "deft" -> deft -= (int) amount;
            case "arcane" -> arcane -= (int) amount;
            case "currentoverhealth" -> currentOverhealth -= amount;
            case "maxoverhealth" -> {
                maxOverhealth -= amount;
                if (maxOverhealth < 0) maxOverhealth = 0;
                if (currentOverhealth > maxOverhealth) currentOverhealth = maxOverhealth;
            }
            case "currentenergy" -> {
                currentEnergy -= amount;
                if (currentEnergy < 0) currentEnergy = 0;
            }
            case "maxenergy" -> {
                maxEnergy -= amount;
                if (currentEnergy > maxEnergy) currentEnergy = maxEnergy;
            }
            case "elementaldamage" -> elementalDamage -= (int) amount;
            case "physicaldamage" -> physicalDamage -= (int) amount;
            case "firedamage" -> fireDamage -= (int) amount;
            case "colddamage" -> coldDamage -= (int) amount;
            case "earthdamage" -> earthDamage -= (int) amount;
            case "lightningdamage" -> lightningDamage -= (int) amount;
            case "airdamage" -> airDamage -= (int) amount;
            case "radiantdamage" -> radiantDamage -= (int) amount;
            case "necroticdamage" -> necroticDamage -= (int) amount;
            case "puredamage" -> pureDamage -= (int) amount;
            case "critchance" -> critChance -= amount;
            case "critdamage" -> critDamage -= (int) amount;
            case "evasion" -> evasion -= (int) amount;
            case "defense" -> defense -= (int) amount;
            case "guard" -> guard -= (int) amount;
            case "physicalresist" -> physicalResist -= (int) amount;
            case "fireresist" -> fireResist -= (int) amount;
            case "coldresist" -> coldResist -= (int) amount;
            case "earthresist" -> earthResist -= (int) amount;
            case "lightningresist" -> lightningResist -= (int) amount;
            case "airresist" -> airResist -= (int) amount;
            case "radiantresist" -> radiantResist -= (int) amount;
            case "necroticresist" -> necroticResist -= (int) amount;
            case "harvest" -> harvest -= (int) amount;
            case "yield" -> yield -= (int) amount;
            case "acre" -> acre -= (int) amount;
        }
    }

    public void changeMaxHealth(Player player, double change) {
        Bukkit.getPluginManager().callEvent(new StatChangeEvent(player, "maxhealth", change));
    }

    public HashMap<String, Integer> getAllDamages() {
        HashMap<String, Integer> damages = new HashMap<>() {{
            put("physicaldamage", physicalDamage);
            put("firedamage", fireDamage);
            put("colddamage", coldDamage);
            put("earthdamage", earthDamage);
            put("lightningdamage", lightningDamage);
            put("airdamage", airDamage);
            put("radiantdamage", radiantDamage);
            put("necroticdamage", necroticDamage);
            put("puredamage", pureDamage);
        }};

        damages.entrySet().removeIf(entry -> entry.getValue() <= 0);

        return damages;
    }

    public HashMap<String, Integer> getHighestElementalDamage() {
        HashMap<String, Integer> damages = new HashMap<>() {{
            put("firedamage", fireDamage);
            put("colddamage", coldDamage);
            put("earthdamage", earthDamage);
            put("lightningdamage", lightningDamage);
            put("airdamage", airDamage);
            put("radiantdamage", radiantDamage);
            put("necroticdamage", necroticDamage);
        }};

        damages.entrySet().removeIf(entry -> entry.getValue() <= 0); // removes all 0 damages

        List<Map.Entry<String, Integer>> highest = new ArrayList<>(damages.entrySet()); // create variable of damages
        HashMap<String, Integer> highestHash = new HashMap<>();

        highest.sort((a, b) -> b.getValue().compareTo(a.getValue())); // sort by highest

        if (!highest.isEmpty()) {
            highestHash.put(highest.getFirst().getKey(), highest.getFirst().getValue());
        }

        return highestHash;
    }

    public HashMap<String, Integer> getAllResists() {
        HashMap<String, Integer> resists = new HashMap<>();

        resists.put("physicalresist", physicalResist);
        resists.put("fireresist", fireResist);
        resists.put("coldresist", coldResist);
        resists.put("earthresist", earthResist);
        resists.put("lightningresist", lightningResist);
        resists.put("airresist", airResist);
        resists.put("radiantresist", radiantResist);
        resists.put("necroticresist", necroticResist);

        resists.entrySet().removeIf(entry -> entry.getValue() <= 0);
        return resists;
    }

    public double getStatValue(String stat) {
        double value = 0;

        switch (stat.toLowerCase()) {
            case "attributepoints" -> value = attributePoints;
            case "vitality" -> value = vitality;
            case "strength" -> value = strength;
            case "deft" -> value = deft;
            case "arcane" -> value = arcane;
            case "maxhealth" -> value = maxHealth;
            case "currentoverhealth" -> value = currentOverhealth;
            case "maxoverhealth" -> value = maxOverhealth;
            case "currentenergy" -> value = currentEnergy;
            case "maxenergy" -> value = maxEnergy;
            case "physicaldamage" -> value = physicalDamage;
            case "elementaldamage" -> value = elementalDamage;
            case "firedamage" -> value = fireDamage;
            case "colddamage" -> value = coldDamage;
            case "earthdamage" -> value = earthDamage;
            case "lightningdamage" -> value = lightningDamage;
            case "airdamage" -> value = airDamage;
            case "radiantdamage" -> value = radiantDamage;
            case "necroticdamage" -> value = necroticDamage;
            case "puredamage" -> value = pureDamage;
            case "critchance" -> value = critChance;
            case "critdamage" -> value = critDamage;
            case "evasion" -> value = evasion;
            case "defense" -> value = defense;
            case "guard" -> value = guard;
            case "physicalresist" -> value = physicalResist;
            case "fireresist" -> value = fireResist;
            case "coldresist" -> value = coldResist;
            case "earthresist" -> value = earthResist;
            case "lightningresist" -> value = lightningResist;
            case "airresist" -> value = airResist;
            case "radiantresist" -> value = radiantResist;
            case "necroticresist" -> value = necroticResist;
            case "harvest" -> value = harvest;
            case "yield" -> value = yield;
            case "acre" -> value = acre;
        }

        return value;
    }

    public int getAttributePoints() {
        return attributePoints;
    }

    public void setAttributePoints(int attributePoints) {
        this.attributePoints = attributePoints;
    }

    public int getVitality() {
        return vitality;
    }

    public void setVitality(int vitality) {
        this.vitality = vitality;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDeft() {
        return deft;
    }

    public void setDeft(int deft) {
        this.deft = deft;
    }

    public int getArcane() {
        return arcane;
    }

    public void setArcane(int arcane) {
        this.arcane = arcane;
    }

    public double getCurrentEnergy() {
        return currentEnergy;
    }

    public void setCurrentEnergy(double currentEnergy) {
        this.currentEnergy = currentEnergy;
    }

    public double getMaxEnergy() {
        return maxEnergy;
    }

    public void setMaxEnergy(double maxEnergy) {
        this.maxEnergy = maxEnergy;
    }

    public double getCurrentOverhealth() {
        return currentOverhealth;
    }

    public void setCurrentOverhealth(double currentOverhealth) {
        this.currentOverhealth = currentOverhealth;
    }

    public double getMaxOverhealth() {
        return maxOverhealth;
    }

    public double getmaxHealth() {
        return maxHealth;
    }

    public void setmaxHealth(double maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void setMaxOverhealth(double maxOverhealth) {
        this.maxOverhealth = maxOverhealth;
    }

    public int getEvasion() {
        return evasion;
    }

    public void setEvasion(int evasion) {
        this.evasion = evasion;
    }

    public int getPhysicalDamage() {
        return physicalDamage;
    }

    public void setPhysicalDamage(int physicalDamage) {
        this.physicalDamage = physicalDamage;
    }

    public int getFireDamage() {
        return fireDamage;
    }

    public void setFireDamage(int fireDamage) {
        this.fireDamage = fireDamage;
    }

    public int getColdDamage() {
        return coldDamage;
    }

    public void setColdDamage(int coldDamage) {
        this.coldDamage = coldDamage;
    }

    public int getEarthDamage() {
        return earthDamage;
    }

    public void setEarthDamage(int earthDamage) {
        this.earthDamage = earthDamage;
    }

    public int getAirDamage() {
        return airDamage;
    }

    public void setAirDamage(int airDamage) {
        this.airDamage = airDamage;
    }

    public int getPureDamage() {
        return pureDamage;
    }

    public void setPureDamage(int pureDamage) {
        this.pureDamage = pureDamage;
    }

    public int getNecroticDamage() {
        return necroticDamage;
    }

    public void setNecroticDamage(int necroticDamage) {
        this.necroticDamage = necroticDamage;
    }

    public int getRadiantDamage() {
        return radiantDamage;
    }

    public void setRadiantDamage(int radiantDamage) {
        this.radiantDamage = radiantDamage;
    }

    public int getLightningDamage() {
        return lightningDamage;
    }

    public void setLightningDamage(int lightningDamage) {
        this.lightningDamage = lightningDamage;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getNecroticResist() {
        return necroticResist;
    }

    public void setNecroticResist(int necroticResist) {
        this.necroticResist = necroticResist;
    }

    public int getRadiantResist() {
        return radiantResist;
    }

    public void setRadiantResist(int radiantResist) {
        this.radiantResist = radiantResist;
    }

    public int getLightningResist() {
        return lightningResist;
    }

    public void setLightningResist(int lightningResist) {
        this.lightningResist = lightningResist;
    }

    public int getAirResist() {
        return airResist;
    }

    public void setAirResist(int airResist) {
        this.airResist = airResist;
    }

    public int getEarthResist() {
        return earthResist;
    }

    public void setEarthResist(int earthResist) {
        this.earthResist = earthResist;
    }

    public int getColdResist() {
        return coldResist;
    }

    public void setColdResist(int coldResist) {
        this.coldResist = coldResist;
    }

    public int getFireResist() {
        return fireResist;
    }

    public void setFireResist(int fireResist) {
        this.fireResist = fireResist;
    }

    public int getPhysicalResist() {
        return physicalResist;
    }

    public void setPhysicalResist(int physicalResist) {
        this.physicalResist = physicalResist;
    }

    public int getGuard() {
        return guard;
    }

    public void setGuard(int guard) {
        this.guard = guard;
    }

    public double getCritChance() {
        return critChance;
    }

    public void setCritChance(double critChance) {
        this.critChance = critChance;
    }

    public int getCritDamage() {
        return critDamage;
    }

    public void setCritDamage(int critDamage) {
        this.critDamage = critDamage;
    }

    public int getElementalDamage() {
        return elementalDamage;
    }

    public void setElementalDamage(int elementalDamage) {
        this.elementalDamage = elementalDamage;
    }

    public int getHarvest() {
        return harvest;
    }

    public void setHarvest(int harvest) {
        this.harvest = harvest;
    }

    public int getYield() {
        return yield;
    }

    public void setYield(int yield) {
        this.yield = yield;
    }

    public int getAcre() {
        return acre;
    }

    public void setAcre(int acre) {
        this.acre = acre;
    }
}