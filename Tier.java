package org.example;

public class Tier {

    private Integer tierId;
    private String race;
    private String tierName;

    private Person owner;

    public Tier(int tier_id,String race,String tierName){
        this.tierId = tier_id;
        this.race = race;
        this.tierName = tierName;
    }
    public Tier(Tier animal,Person owner){
        this(animal.tierId, animal.race, animal.tierName);
    }

    public int getTier_id() {
        return tierId;
    }

    public void setTier_id(int tier_id) {
        this.tierId = tier_id;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getTierName() {
        return tierName;
    }

    public void setTierName(String tierName) {
        this.tierName = tierName;
    }

    @Override
    public String toString() {
        return "Tier{" +
                "tier_id=" + tierId +
                ", race='" + race + '\'' +
                ", tierName='" + tierName + '\'' +
                '}';
    }
}
