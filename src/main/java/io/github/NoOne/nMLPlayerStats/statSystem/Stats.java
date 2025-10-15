package io.github.NoOne.nMLPlayerStats.statSystem;

import org.bukkit.entity.Player;
import java.util.HashMap;
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
    private int fireDamage;
    private int coldDamage;
    private int earthDamage;
    private int lightningDamage;
    private int airDamage;
    private int radiantDamage;
    private int necroticDamage;
    private int pureDamage;
    private int critChance;
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

    public Stats(int attributePoints, int vitality, int strength, int deft, int arcane,
                 double maxHealth, double currentOverhealth, double maxOverhealth, double currentEnergy, double maxEnergy,
                 int physicalDamage, int fireDamage, int coldDamage, int earthDamage, int lightningDamage, int airDamage, int radiantDamage, int necroticDamage, int pureDamage,
                 int critChance, int critDamage,
                 int evasion, int defense, int guard, int physicalResist, int fireResist, int coldResist, int earthResist, int lightningResist, int airResist, int radiantResist, int necroticResist) {

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
    }

    public static Stats generateNewbieStats() {
        return new Stats(0, 0, 0, 0, 0,
                0, 0, 0, 100, 100,
                0, 0, 0, 0, 0, 0, 0, 0, 0,
                10, 150,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    }

    public void add2Stat(Player player, String stat, double amount) {
        switch (stat.toLowerCase()) {
            case "attributepoints" -> attributePoints += (int) amount;
            case "vitality" -> vitality += (int) amount;
            case "strength" -> strength += (int) amount;
            case "deft" -> deft += (int) amount;
            case "arcane" -> arcane += (int) amount;

            case "maxhealth" -> maxHealth += amount;
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

            case "physicaldamage" -> physicalDamage += (int) amount;
            case "firedamage" -> fireDamage += (int) amount;
            case "colddamage" -> coldDamage += (int) amount;
            case "earthdamage" -> earthDamage += (int) amount;
            case "lightningdamage" -> lightningDamage += (int) amount;
            case "airdamage" -> airDamage += (int) amount;
            case "radiantdamage" -> radiantDamage += (int) amount;
            case "necroticdamage" -> necroticDamage += (int) amount;
            case "puredamage" -> pureDamage += (int) amount;
            case "critchance" -> critChance += (int) amount;
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
        }
    }

    public void removeFromStat(Player player, String stat, double amount) {
        switch (stat.toLowerCase()) {
            case "attributepoints" -> attributePoints -= (int) amount;
            case "vitality" -> vitality -= (int) amount;
            case "strength" -> strength -= (int) amount;
            case "deft" -> deft -= (int) amount;
            case "arcane" -> arcane -= (int) amount;

            case "maxhealth" -> maxHealth -= amount;
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

            case "physicaldamage" -> physicalDamage -= (int) amount;
            case "firedamage" -> fireDamage -= (int) amount;
            case "colddamage" -> coldDamage -= (int) amount;
            case "earthdamage" -> earthDamage -= (int) amount;
            case "lightningdamage" -> lightningDamage -= (int) amount;
            case "airdamage" -> airDamage -= (int) amount;
            case "radiantdamage" -> radiantDamage -= (int) amount;
            case "necroticdamage" -> necroticDamage -= (int) amount;
            case "puredamage" -> pureDamage -= (int) amount;
            case "critchance" -> critChance -= (int) amount;
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
        }
    }

    public HashMap<String, Integer> getAllDamages() {
        HashMap<String, Integer> damages = new HashMap<>();

        damages.put("physicaldamage", physicalDamage);
        damages.put("firedamage", fireDamage);
        damages.put("colddamage", coldDamage);
        damages.put("earthdamage", earthDamage);
        damages.put("lightningdamage", lightningDamage);
        damages.put("airdamage", airDamage);
        damages.put("radiantdamage", radiantDamage);
        damages.put("necroticdamage", necroticDamage);
        damages.put("puredamage", pureDamage);

        for (Map.Entry<String, Integer> damageEntry : damages.entrySet()) {
            if (damageEntry.getValue() <= 0) {
                damages.remove(damageEntry.getKey());
            }
        }

        return damages;
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

        for (Map.Entry<String, Integer> reistEntry : resists.entrySet()) {
            if (reistEntry.getValue() <= 0) {
                resists.remove(reistEntry.getKey());
            }
        }

        return resists;
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

    public int getCritChance() {
        return critChance;
    }

    public void setCritChance(int critChance) {
        this.critChance = critChance;
    }

    public int getCritDamage() {
        return critDamage;
    }

    public void setCritDamage(int critDamage) {
        this.critDamage = critDamage;
    }
}