package org.example;

import java.util.HashMap;
import java.util.Map;

public class Person {

    private Integer personId;

    private String firstName;

    private String lastName;

    private String birthDate;

    private Haushalt haushalt;

    private Map<Integer,Tier> tiere;

    public Person(int personId,String firstName,String lastName,String birthDate){
        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.tiere = new HashMap<>();
    }
    public Person(Person person, Map<Integer, Tier> tiere){
        this(person.getPersonId(), person.getFirstName(), person.getLastName(), person.getBirthDate());
        this.tiere = tiere;
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

    public Haushalt getHaushalt() {
        return haushalt;
    }

    public void setHaushalt(Haushalt haushalt) {
        this.haushalt = haushalt;
    }

    public Map<Integer, Tier> getTiere() {
        return tiere;
    }

    public void setTiere(Map<Integer, Tier> tiere) {
        this.tiere = tiere;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", tier=" + tiere +
                '}';
    }
}
