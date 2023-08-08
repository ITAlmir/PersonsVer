package org.example;

import java.util.HashMap;
import java.util.Map;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class HouseManagement {

     private Map<Integer,Haushalt> mapHouse;

     private Map<Integer,Person> mapPerson;

     private Map<Integer,Tier> mapTier;

    HaushaltDaoImplementation houseDao = new HaushaltDaoImplementation();
    PersonDaoImplementation personsDao = new PersonDaoImplementation();
    TierDaoImplementation petsDao = new TierDaoImplementation();
    public HouseManagement(){
        mapHouse = new HashMap<>();

        mapPerson = new HashMap<>();

        mapTier = new HashMap<>();
    }
    public void createHouse(int houseId,int houseNum,String city,String address,int zip) throws SQLException {

        Haushalt houseObj = new Haushalt(houseId,houseNum,city,address,zip);
        Integer key = houseId;
        mapHouse.put(key,houseObj);
        System.out.println(mapHouse);
        houseDao.add(houseObj);
    }
    public void createPerson(int houseNum,int personId,String firstname, String lastname,String birthdate,int houseId) throws SQLException {
        Person personObj = new Person(personId,firstname,lastname,birthdate,houseId);
        int key = personId;
        mapPerson.put(key,personObj);
        System.out.println(mapPerson);
        personsDao.addPerson(personObj,houseId);

    }
    public void createPet( int petId, String petRace, String petName,int personId) throws SQLException {
        Tier tierObj = new Tier(petId,petRace,petName,personId);
        mapTier.put(petId,tierObj);
        System.out.println(mapTier);
        petsDao.addPet(tierObj,personId);
    }
    public void findHouse(int houseId) throws SQLException {
        Haushalt house = houseDao.getHaushalt(houseId);
        System.out.println(house.getHouseId());
        System.out.println(house.getZip());
        System.out.println(house.getCity());
        System.out.println(house.getAddress());
        System.out.println(house.getHouseNum());
    }
    public void findPerson(int personId) throws SQLException {
        personsDao.getPerson(personId);
    }
    public void findPet(int petId) throws SQLException {
        petsDao.getPet(petId);
    }
    public void updateHouse(int houseId) throws SQLException {
        Scanner sc = new Scanner(System.in);

        Haushalt house = houseDao.getHaushalt(houseId);
        house.setHouseId(houseId);
        System.out.println("Enter a house number");
        house.setHouseNum(sc.nextInt()) ;
        System.out.println("Enter city");
        sc.nextLine();
        house.setCity(sc.nextLine());
        System.out.println("Enter address");
        house.setAddress(sc.nextLine());
        System.out.println("Enter zip code");
        house.setZip(sc.nextInt());
        houseDao.update(house);
        System.out.printf("New values are:   ");
        System.out.println(house.getHouseId());
        System.out.println(house.getZip());
        System.out.println(house.getCity());
        System.out.println(house.getAddress());
        System.out.println(house.getHouseNum());
    }
    public Map<Integer, Haushalt> getMapHouse() {
        return mapHouse;
    }

    public void setMapHouse(Map<Integer, Haushalt> mapHouse) {
        this.mapHouse = mapHouse;
    }

    public Map<Integer, Person> getMapPerson() {
        return mapPerson;
    }

    public void setMapPerson(Map<Integer, Person> mapPerson) {
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
