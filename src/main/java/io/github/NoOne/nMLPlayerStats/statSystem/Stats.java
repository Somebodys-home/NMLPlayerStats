package io.github.NoOne.nMLPlayerStats.statSystem;

public class Stats {
    private int level;
    private int exp;
    private int exp2NextLevel;

    private double currentEnergy;
    private double maxEnergy;

    public Stats(int level, int exp, double currentEnergy, double maxEnergy) {
        this.level = level;
        this.exp = exp;
        exp2NextLevel = 100; // todo: come up with a formula for xp requirements
        this.currentEnergy = currentEnergy;
        this.maxEnergy = maxEnergy;
    }

    public static Stats generateNewbieStats() {
        return new Stats(1, 0, 100, 100);
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
}
