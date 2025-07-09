package io.github.NoOne.nMLPlayerStats.statSystem;

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
    private int evasion;

    private int physicalDamage;
    private int fireDamage;
    private int coldDamage;
    private int earthDamage;
    private int lightningDamage;
    private int airDamage;
    private int lightDamage;
    private int darkDamage;
    private int pureDamage;

    public Stats(int level, int exp, int attributePoints,
                 int vitality, int strength, int deft, int arcane,
                 double bonusHealth, double currentOverhealth, double maxOverhealth,
                 double currentEnergy, double maxEnergy, int evasion,
                int physicalDamage, int fireDamage, int coldDamage, int earthDamage, int lightningDamage, int airDamage, int lightDamage, int darkDamage, int pureDamage) {
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
        this.evasion = evasion;

        this.physicalDamage = physicalDamage;
        this.fireDamage = fireDamage;
        this.coldDamage = coldDamage;
        this.earthDamage = earthDamage;
        this.lightningDamage = lightningDamage;
        this.airDamage = airDamage;
        this.lightDamage = lightDamage;
        this.darkDamage = darkDamage;
        this.pureDamage = pureDamage;
    }

    public static Stats generateNewbieStats() {
        return new Stats(1, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 100, 100, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0);
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
                if (currentOverhealth > maxOverhealth) currentOverhealth = maxOverhealth;
            }
            case "maxoverhealth" -> maxOverhealth += amount;
            case "currentenergy" -> {
                currentEnergy += amount;
                if (currentEnergy > maxEnergy) currentEnergy = maxEnergy;
            }
            case "maxenergy" -> maxEnergy += amount;
            case "evasion" -> evasion += (int) amount;
            case "physicaldamage" -> physicalDamage += (int) amount;
            case "firedamage" -> fireDamage += (int) amount;
            case "colddamage" -> coldDamage += (int) amount;
            case "earthdamage" -> earthDamage += (int) amount;
            case "lightningdamage" -> lightningDamage += (int) amount;
            case "airdamage" -> airDamage += (int) amount;
            case "lightdamage" -> lightDamage += (int) amount;
            case "darkdamage" -> darkDamage += (int) amount;
            case "puredamage" -> pureDamage += (int) amount;
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
            case "evasion" -> evasion -= (int) amount;
            case "physicaldamage" -> physicalDamage -= (int) amount;
            case "firedamage" -> fireDamage -= (int) amount;
            case "colddamage" -> coldDamage -= (int) amount;
            case "earthdamage" -> earthDamage -= (int) amount;
            case "lightningdamage" -> lightningDamage -= (int) amount;
            case "airdamage" -> airDamage -= (int) amount;
            case "lightdamage" -> lightDamage -= (int) amount;
            case "darkdamage" -> darkDamage -= (int) amount;
            case "puredamage" -> pureDamage -= (int) amount;
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

    public int getDarkDamage() {
        return darkDamage;
    }

    public void setDarkDamage(int darkDamage) {
        this.darkDamage = darkDamage;
    }

    public int getLightDamage() {
        return lightDamage;
    }

    public void setLightDamage(int lightDamage) {
        this.lightDamage = lightDamage;
    }

    public int getLightningDamage() {
        return lightningDamage;
    }

    public void setLightningDamage(int lightningDamage) {
        this.lightningDamage = lightningDamage;
    }
}
