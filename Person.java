package org.example;

import java.util.HashMap;
import java.util.Map;

public class Person {

    private int personId;

    private String firstName;

    private String lastName;

    private String birthDate;

    private int houseId;

    public Person(){}
    public Person(int personId,String firstName,String lastName,String birthDate,int houseId){
        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.houseId = houseId;
    }
    public Person(String firstName,String lastName,String birthDate,int houseId){
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.houseId = houseId;
    }

    public int getHouseId() {
        return houseId;
    }

    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }

    public Person(Person person){
        this(person.getPersonId(), person.getFirstName(), person.getLastName(), person.getBirthDate(), person.getHouseId());
    }



    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", houseId=" + houseId +
                '}';
    }
}
