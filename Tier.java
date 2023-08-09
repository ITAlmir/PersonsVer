package org.example;

public class Tier {

    private int tierId;
    private String race;
    private String tierName;
    private int personId;
    public Tier(){}

    public Tier(int tier_id,String race,String tierName,int personId){
        this.tierId = tier_id;
        this.race = race;
        this.tierName = tierName;
        this.personId = personId;
    }
    public Tier(String race,String tierName,int personId){
        this.race = race;
        this.tierName = tierName;
        this.personId = personId;
    }

    public int getTier_id() {
        return tierId;
    }

    public Integer getTierId() {
        return tierId;
    }

    public void setTierId(Integer tierId) {
        this.tierId = tierId;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public void setTier_id(int tier_id) {
        this.tierId = tier_id;
    }

    public String getRace() {
        return race;
    }

    public void setTierId(int tierId) {
        this.tierId = tierId;
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
                "tierId=" + tierId +
                ", race='" + race + '\'' +
                ", tierName='" + tierName + '\'' +
                ", personId=" + personId +
                '}';
    }
}
