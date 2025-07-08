package io.github.NoOne.nMLPlayerStats.statSystem;

import org.bukkit.Bukkit;

public class Stats {
    // player stats
    private int level;
    private int exp;
    private int exp2NextLevel;

    private int attributePoints;
    private int vitality;
    private int strength;
    private int deft;
    private int arcane;

    private double bonusHealth;
    private double currentOverhealth;
    private double maxOverhealth;
    private double currentEnergy;
    private double maxEnergy;

    public Stats(int level, int exp, int attributePoints,
                 int vitality, int strength, int deft, int arcane,
                 double bonusHealth, double currentOverhealth, double maxOverhealth,
                 double currentEnergy, double maxEnergy) {
        this.level = level;
        this.exp = exp;
        exp2NextLevel = 100; // todo: come up with a formula for xp requirements

        this.attributePoints = attributePoints;
        this.vitality = vitality;
        this.strength = strength;
        this.deft = deft;
        this.arcane = arcane;

        this.bonusHealth = bonusHealth;
        this.currentOverhealth = currentOverhealth;
        this.maxOverhealth = maxOverhealth;
        this.currentEnergy = currentEnergy;
        this.maxEnergy = maxEnergy;
    }

    public static Stats generateNewbieStats() {
        return new Stats(1, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 100, 100);
    }

    public void add2Stat(String stat, double amount) {
        switch (stat.toLowerCase()) {
            case "level" -> {
                level += (int) amount;
                attributePoints += (int) amount;
            }
            case "exp" -> exp += (int) amount;
            case "exp2nextlevel" -> exp2NextLevel += (int) amount;
            case "attributepoints" -> attributePoints += (int) amount;
            case "vitality" -> vitality += (int) amount;
            case "strength" -> strength += (int) amount;
            case "deft" -> deft += (int) amount;
            case "arcane" -> arcane += (int) amount;
            case "bonushealth" -> bonusHealth += amount;
            case "currentoverhealth" -> {
                currentOverhealth += amount;

                if (currentOverhealth > maxOverhealth) {
                    currentOverhealth = maxOverhealth;
                }
            }
            case "maxoverhealth" -> maxOverhealth += amount;
            case "currentenergy" -> {
                currentEnergy += amount;

                if (currentEnergy > maxEnergy) {
                    currentEnergy = maxEnergy;
                }
            }
            case "maxenergy" -> maxEnergy += amount;
        }
    }

    public void removeFromStat(String stat, double amount) {
        switch (stat.toLowerCase()) {
            case "level" -> level -= (int) amount;
            case "exp" -> exp -= (int) amount;
            case "exp2nextlevel" -> exp2NextLevel -= (int) amount;
            case "attributepoints" -> attributePoints -= (int) amount;
            case "vitality" -> vitality -= (int) amount;
            case "strength" -> strength -= (int) amount;
            case "deft" -> deft -= (int) amount;
            case "arcane" -> arcane -= (int) amount;
            case "bonushealth" -> bonusHealth -= amount;
            case "currentoverhealth" -> currentOverhealth -= amount;
            case "maxoverhealth" -> {
                maxOverhealth -= amount;

                if (maxOverhealth < 0) {
                    maxOverhealth = 0;
                }
                if (currentOverhealth > maxOverhealth) {
                    currentOverhealth = maxOverhealth;
                }
            }
            case "currentenergy" -> {
                currentEnergy -= amount;

                if (currentEnergy < 0) {
                    currentEnergy = 0;
                }
            }
            case "maxenergy" -> {
                maxEnergy -= amount;

                if (currentEnergy > maxEnergy) {
                    currentEnergy = maxEnergy;
                }
            }
        }
    }


    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        if (level > this.level) {
            int gainedLevels = level - this.level;
            attributePoints += gainedLevels;
        }
        this.level = level;
    }

    public int getExp2NextLevel() {
        return exp2NextLevel;
    }

    public void setExp2NextLevel(int exp2NextLevel) {
        this.exp2NextLevel = exp2NextLevel;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
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

    public double getBonusHealth() {
        return bonusHealth;
    }

    public void setBonusHealth(double bonusHealth) {
        this.bonusHealth = bonusHealth;
    }
}
