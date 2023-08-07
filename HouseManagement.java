package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HouseManagement {

     private Map<Integer,Haushalt> mapHouse;

     private Map<String,Person> mapPerson;

     private Map<Integer,Tier> mapTier;


    public HouseManagement(){
        mapHouse = new HashMap<>();

        mapPerson = new HashMap<>();

        mapTier = new HashMap<>();
    }
    public void createHouse(int houseId,int houseNum,String city,String address,int zip){

        Haushalt houseObj = new Haushalt(houseId,houseNum,city,address,zip);
        Integer key = houseId;
        mapHouse.put(key,houseObj);

    }
    public void createPerson(int houseNum,int personId,String firstname, String lastname,String birthdate){
        Person personObj = new Person(personId,firstname,lastname,birthdate);
        Haushalt houseObj = mapHouse.get(houseNum);
        Haushalt haushalt = new Haushalt(houseObj,personObj);
        String key = firstname;
        mapHouse.put(personId,haushalt);
        mapPerson.put(key,personObj);

    }
    public void createAnimal(String firstname,int animalId,String animalRace,String animalName){
        Person personObj = mapPerson.get(firstname);
        animalId = personObj.getPersonId();
        Haushalt houseObj = mapHouse.get(animalId);
        mapHouse.put(animalId,houseObj);
        System.out.println(mapHouse);
    }
    public void showHouseList(Map<Integer, Haushalt> mapHouse){
        int valuesPerRow = 5; // Number of values to print in each row

        int counter = 0;
        char ch = '-';
        String repeatedChars = String.valueOf(ch).repeat(296);
        System.out.printf(repeatedChars);
        System.out.println();
        System.out.printf("|   ");
        for (Map.Entry<Integer, Haushalt> entry : mapHouse.entrySet()) {

            System.out.printf("%-4s %-10s  |   ", entry.getValue().getHouseId());
            counter++;
            System.out.printf("%-4s %-10s  |   ", entry.getValue().getCity());
            counter++;
            System.out.printf("%-4s %-10s  |   ", entry.getValue().getAddress());
            counter++;
            System.out.printf("%-4s %-10s  |   ", entry.getValue().getHouseNum());
            counter++;
            System.out.printf("%-4s %-10s  |   ", entry.getValue().getZip());
            counter++;

            if (counter % valuesPerRow == 0) {
                System.out.println();
                System.out.printf(repeatedChars);
                System.out.println();
                System.out.printf("|   ");
            }
        }
        System.out.println();
        System.out.printf(String.valueOf(ch).repeat(233));
        System.out.println();
    }

    public Map<Integer, Haushalt> getMapHouse() {
        return mapHouse;
    }

    public void setMapHouse(Map<Integer, Haushalt> mapHouse) {
        this.mapHouse = mapHouse;
    }

    public Map<String, Person> getMapPerson() {
        return mapPerson;
    }

    public void setMapPerson(Map<String, Person> mapPerson) {
        this.mapPerson = mapPerson;
    }

    public Map<Integer, Tier> getMapTier() {
        return mapTier;
    }

    public void setMapTier(Map<Integer, Tier> mapTier) {
        this.mapTier = mapTier;
    }

    @Override
    public String toString() {
        return "HouseManagement{" +
                "mapHouse=" + mapHouse +
                ", mapPerson=" + mapPerson +
                ", mapTier=" + mapTier +
                '}';
    }
}
