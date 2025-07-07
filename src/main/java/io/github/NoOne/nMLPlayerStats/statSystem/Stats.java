package io.github.NoOne.nMLPlayerStats.statSystem;

public class Stats {
    // CORE STATS: stats that are saved to profiles.yml
    private int level;
    private int exp;
    private int exp2NextLevel;

    private int attributePoints;
    private int vitality;
    private int strength;
    private int deft;
    private int arcane;

    private double currentEnergy;
    private double maxEnergy;
    private double currentOverhealth;
    private double maxOverhealth;

    // todo: implement attribute bonuses

    public Stats(int level, int exp,
                 int vitality, int strength, int deft, int arcane,
                 double currentEnergy, double maxEnergy, double currentOverhealth, double maxOverhealth) {
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
        this.currentOverhealth = currentOverhealth;
        this.maxOverhealth = maxOverhealth;
    }

    public static Stats generateNewbieStats() {
        return new Stats(1, 0, 0, 0, 0, 0, 100, 100,0,0);
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
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
}
