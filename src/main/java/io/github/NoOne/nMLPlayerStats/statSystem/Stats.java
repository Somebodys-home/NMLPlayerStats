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

    // no need to do health, minecraft does that already
    private double currentEnergy;
    private double maxEnergy;
    private double bonusEnergy;
    private double currentOverhealth;
    private double maxOverhealth;
    private double bonusOverhealth;
    private double bonusHealth;

    public Stats(int level, int exp,
                 int vitality, int strength, int deft, int arcane,
                 double currentEnergy, double maxEnergy, double bonusEnergy,
                 double currentOverhealth, double maxOverhealth, double bonusOverhealth, double bonusHealth) {
        this.level = level;
        this.exp = exp;
        exp2NextLevel = 100; // todo: come up with a formula for xp requirements

        attributePoints = level - 1;
        this.vitality = vitality;
        this.strength = strength;
        this.deft = deft;
        this.arcane = arcane;

        this.currentEnergy = currentEnergy;
        this.maxEnergy = maxEnergy;
        this.bonusEnergy = bonusEnergy;

        this.currentOverhealth = currentOverhealth;
        this.maxOverhealth = maxOverhealth;
        this.bonusOverhealth = bonusOverhealth;
        this.bonusHealth = bonusHealth;
    }

    public static Stats generateNewbieStats() {
        return new Stats(1, 0, 0, 0, 0, 0, 100, 100, 0, 0,0,
                0, 0);
    }

    public void add2Stat(String stat, double amount) {
        switch (stat.toLowerCase()) {
            case "level" -> this.level += (int) amount;
            case "exp" -> this.exp += (int) amount;
            case "exp2nextlevel" -> this.exp2NextLevel += (int) amount;
            case "attributepoints" -> this.attributePoints += (int) amount;
            case "vitality" -> this.vitality += (int) amount;
            case "strength" -> this.strength += (int) amount;
            case "deft" -> this.deft += (int) amount;
            case "arcane" -> this.arcane += (int) amount;
            case "currentenergy" -> {
                this.currentEnergy += amount;

                if (currentEnergy > maxEnergy) {
                    currentEnergy = maxEnergy;
                }
            }
            case "maxenergy" -> this.maxEnergy += amount;
            case "bonusenergy" -> this.bonusEnergy += amount;
            case "currentoverhealth" -> this.currentOverhealth += amount;
            case "maxoverhealth" -> this.maxOverhealth += amount;
            case "bonusoverhealth" -> this.bonusOverhealth += amount;
            case "bonushealth" -> this.bonusHealth += amount;
        }
    }

    public void removeFromStat(String stat, double amount) {
        switch (stat.toLowerCase()) {
            case "level" -> this.level -= (int) amount;
            case "exp" -> this.exp -= (int) amount;
            case "exp2nextlevel" -> this.exp2NextLevel -= (int) amount;
            case "attributepoints" -> this.attributePoints -= Math.max(0, (int) amount);
            case "vitality" -> this.vitality -= Math.max(0, (int) amount);
            case "strength" -> this.strength -= Math.max(0, (int) amount);
            case "deft" -> this.deft -= Math.max(0, (int) amount);
            case "arcane" -> this.arcane -= Math.max(0, (int) amount);
            case "currentenergy" -> {
                this.currentEnergy -= amount;

                if (currentEnergy < 0) {
                    currentEnergy = 0;
                }
            }
            case "maxenergy" -> {
                this.maxEnergy -= amount;

                if (maxEnergy < 0) {
                    maxEnergy = 0;
                }
            }
            case "bonusenergy" -> this.bonusEnergy -= amount;
            case "currentoverhealth" -> this.currentOverhealth -= Math.max(0, (int) amount);
            case "maxoverhealth" -> this.maxOverhealth -= Math.max(0, (int) amount);
            case "bonusoverhealth" -> this.bonusOverhealth -= amount;
            case "bonushealth" -> this.bonusHealth -= amount;
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

    public void setMaxOverhealth(double maxOverhealth) {
        this.maxOverhealth = maxOverhealth;

        if (currentOverhealth > maxOverhealth) {
            currentOverhealth = maxOverhealth;
        }
    }

    public double getBonusEnergy() {
        return bonusEnergy;
    }

    public void setBonusEnergy(double bonusEnergy) {
        this.bonusEnergy = bonusEnergy;
    }

    public double getBonusOverhealth() {
        return bonusOverhealth;
    }

    public void setBonusOverhealth(double bonusOverhealth) {
        this.bonusOverhealth = bonusOverhealth;
    }

    public double getBonusHealth() {
        return bonusHealth;
    }

    public void setBonusHealth(double bonusHealth) {
        this.bonusHealth = bonusHealth;
    }
}
