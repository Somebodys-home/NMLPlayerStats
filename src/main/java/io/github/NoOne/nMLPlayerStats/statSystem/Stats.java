package io.github.NoOne.nMLPlayerStats.statSystem;

public class Stats {

    // level stats
    private int level;
    private double exp;
    private int exp2LvlUp;

    // attribute stats
    private int attributePoints;
    private int vitality;
    private int strength;
    private int deft;
    private int arcane;

    // hotbar stats
    private double bonusHealth;
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
    private int lightDamage;
    private int darkDamage;
    private int pureDamage;

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
    private int lightResist;
    private int darkResist;

    public Stats(int level, double exp,
                 int attributePoints, int vitality, int strength, int deft, int arcane,
                 double bonusHealth, double currentOverhealth, double maxOverhealth, double currentEnergy, double maxEnergy,
                 int physicalDamage, int fireDamage, int coldDamage, int earthDamage, int lightningDamage, int airDamage, int lightDamage, int darkDamage, int pureDamage,
                 int evasion, int defense, int guard, int physicalResist, int fireResist, int coldResist, int earthResist, int lightningResist, int airResist, int lightResist, int darkResist) {
        this.level = level;
        this.exp = exp;
        exp2LvlUp = 100; // todo: come up with a formula for xp requirements

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

        this.physicalDamage = physicalDamage;
        this.fireDamage = fireDamage;
        this.coldDamage = coldDamage;
        this.earthDamage = earthDamage;
        this.lightningDamage = lightningDamage;
        this.airDamage = airDamage;
        this.lightDamage = lightDamage;
        this.darkDamage = darkDamage;
        this.pureDamage = pureDamage;

        this.evasion = evasion;
        this.defense = defense;
        this.guard = guard;
        this.physicalResist = physicalResist;
        this.fireResist = fireResist;
        this.coldResist = coldResist;
        this.earthResist = earthResist;
        this.lightningResist = lightningResist;
        this.airResist = airResist;
        this.lightResist = lightResist;
        this.darkResist = darkResist;
    }

    public static Stats generateNewbieStats() {
        return new Stats(1, 0,
                0, 0, 0, 0, 0,
                0, 0, 0, 100, 100,
                0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    }

    public void add2Stat(String stat, double amount) {
        switch (stat.toLowerCase()) {
            case "level" -> {
                level += (int) amount;
                attributePoints += (int) amount;
            }
            case "exp" -> exp += amount;
            case "exp2lvlup" -> exp2LvlUp += (int) amount;

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

            case "physicaldamage" -> physicalDamage += (int) amount;
            case "firedamage" -> fireDamage += (int) amount;
            case "colddamage" -> coldDamage += (int) amount;
            case "earthdamage" -> earthDamage += (int) amount;
            case "lightningdamage" -> lightningDamage += (int) amount;
            case "airdamage" -> airDamage += (int) amount;
            case "lightdamage" -> lightDamage += (int) amount;
            case "darkdamage" -> darkDamage += (int) amount;
            case "puredamage" -> pureDamage += (int) amount;

            case "evasion" -> evasion += (int) amount;
            case "defense" -> defense += (int) amount;
            case "guard" -> guard += (int) amount;
            case "physicalresist" -> physicalResist += (int) amount;
            case "fireresist" -> fireResist += (int) amount;
            case "coldresist" -> coldResist += (int) amount;
            case "earthresist" -> earthResist += (int) amount;
            case "lightningresist" -> lightningResist += (int) amount;
            case "airresist" -> airResist += (int) amount;
            case "lightresist" -> lightResist += (int) amount;
            case "darkresist" -> darkResist += (int) amount;
        }
    }

    public void removeFromStat(String stat, double amount) {
        switch (stat.toLowerCase()) {
            case "level" -> level -= (int) amount;
            case "exp" -> exp -= amount;
            case "exp2lvlup" -> exp2LvlUp -= (int) amount;

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

            case "physicaldamage" -> physicalDamage -= (int) amount;
            case "firedamage" -> fireDamage -= (int) amount;
            case "colddamage" -> coldDamage -= (int) amount;
            case "earthdamage" -> earthDamage -= (int) amount;
            case "lightningdamage" -> lightningDamage -= (int) amount;
            case "airdamage" -> airDamage -= (int) amount;
            case "lightdamage" -> lightDamage -= (int) amount;
            case "darkdamage" -> darkDamage -= (int) amount;
            case "puredamage" -> pureDamage -= (int) amount;

            case "evasion" -> evasion -= (int) amount;
            case "defense" -> defense -= (int) amount;
            case "guard" -> guard -= (int) amount;
            case "physicalresist" -> physicalResist -= (int) amount;
            case "fireresist" -> fireResist -= (int) amount;
            case "coldresist" -> coldResist -= (int) amount;
            case "earthresist" -> earthResist -= (int) amount;
            case "lightningresist" -> lightningResist -= (int) amount;
            case "airresist" -> airResist -= (int) amount;
            case "lightresist" -> lightResist -= (int) amount;
            case "darkresist" -> darkResist -= (int) amount;
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

    public int getExp2LvlUp() {
        return exp2LvlUp;
    }

    public void setExp2LvlUp(int exp2LvlUp) {
        this.exp2LvlUp = exp2LvlUp;
    }

    public double getExp() {
        return exp;
    }

    public void setExp(double exp) {
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

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getDarkResist() {
        return darkResist;
    }

    public void setDarkResist(int darkResist) {
        this.darkResist = darkResist;
    }

    public int getLightResist() {
        return lightResist;
    }

    public void setLightResist(int lightResist) {
        this.lightResist = lightResist;
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
}
