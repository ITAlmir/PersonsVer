package org.example;

import java.util.Map;

public class Haushalt {

    private int houseId;
    private String city;

    private String address;

    private int houseNum;

    private int zip;

    public Haushalt(){}

    public Haushalt(int houseId,int houseNum,String city,String address,int zip){
        this.houseId = houseId;
        this.houseNum = houseNum;
        this.city = city;
        this.address = address;
        this.zip = zip;

    }
    public Haushalt(int houseNum,String city,String address,int zip){
        this.houseNum = houseNum;
        this.city = city;
        this.address = address;
        this.zip = zip;
    }

    public int getHouseId() {
        return houseId;
    }

    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getHouseNum() {
        return houseNum;
    }

    public void setHouseNum(int houseNum) {
        this.houseNum = houseNum;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }




    @Override
    public String toString() {
        return "Haushalt{" +
                "houseId=" + houseId +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", houseNum=" + houseNum +
                ", zip=" + zip +
                '}';
    }
}
