package org.example;


import java.sql.SQLException;
import java.util.Scanner;

public class HouseManagement {



    HaushaltDaoImplementation houseDao = new HaushaltDaoImplementation();
    PersonDaoImplementation personsDao = new PersonDaoImplementation();
    TierDaoImplementation petsDao = new TierDaoImplementation();

    public void createHouse() throws SQLException {
        Scanner sc = new Scanner(System.in);


        System.out.println("Enter a house number");
        int houseNum = sc.nextInt();

        System.out.println("Enter city");
        sc.nextLine();
        String city = sc.nextLine();
        System.out.println("Enter address");
        String address = sc.nextLine();
        System.out.println("Enter zip code");
        int zip = sc.nextInt();
        Haushalt houseObj = new Haushalt(houseNum,city,address,zip);
        //mapHouse.put(0,houseObj);
        houseDao.add(houseObj);
        System.out.println("You added new House with values: "+houseObj.getHouseNum()+","+houseObj.getCity()+","+houseObj.getAddress()+"," +houseObj.getZip());
    }
    public void createPerson() throws SQLException {
        Scanner sc = new Scanner(System.in);

        System.out.println("In which House live this person");
        int houseId = sc.nextInt();
        System.out.println("Enter first name");
        sc.nextLine();
        String firstName = sc.nextLine();
        System.out.println("Enter last name");
        String lastName = sc.nextLine();
        System.out.println("Enter birth date ");
        String birthDate = sc.nextLine();

        Person personObj = new Person(firstName,lastName,birthDate,houseId);

        personsDao.addPerson(personObj,houseId);
        System.out.println("You added new Person with values: "+personObj.getFirstName()+","+personObj.getLastName()+","+personObj.getBirthDate()+"," +personObj.getHouseId());

    }
    public void createPet() throws SQLException {
        Scanner sc = new Scanner(System.in);


        System.out.println("Who does this pet belong to?");
        int personId = sc.nextInt();
        System.out.println("Enter pet's race");
        sc.nextLine();
        String tierRace = sc.nextLine();
        System.out.println("Enter name for this pet ");
        String tierName = sc.nextLine();
        Tier tierObj = new Tier(tierRace,tierName,personId);
        //mapTier.put(0,tierObj);
        petsDao.addPet(tierObj,personId);
        System.out.println("You added new Pet with values: "+tierObj.getRace()+","+tierObj.getTierName()+","+tierObj.getPersonId());

    }
    public void findHouse() throws SQLException {
        Scanner sc = new Scanner(System.in);
        char ch = '-';
        String repeatedChars = String.valueOf(ch).repeat(73);
        System.out.printf(repeatedChars);
        System.out.println();
        System.out.println("Enter House ID which you want to be shown");
        int houseId = sc.nextInt();
        Haushalt house = houseDao.getHaushalt(houseId);
        System.out.printf("%-4s | %-10s | %-10s | %-30s | %-10s%n", "id", "houseNum", "city", "address", "zip");
        System.out.println();
        System.out.printf(repeatedChars);
        System.out.println();
        System.out.printf("%-4s | %-10s | %-10s | %-30s | %-10s%n", house.getHouseId(), house.getHouseNum(), house.getCity(), house.getAddress(), house.getZip());
        System.out.println();
        System.out.printf(repeatedChars);
        System.out.println();

    }
    public void findPerson() throws SQLException {
        Scanner sc = new Scanner(System.in);
        char ch = '-';
        String repeatedChars = String.valueOf(ch).repeat(73);
        System.out.printf(repeatedChars);
        System.out.println();

        System.out.println("Enter Person ID which you want to be shown");
        int personId = sc.nextInt();
        Person person = personsDao.getPerson(personId);
        System.out.printf("%-4s | %-10s | %-10s | %-30s | %-10s%n", "id", "First Name", "Last Name", "Birth Date", "Living at");
        System.out.println();
        System.out.printf(repeatedChars);
        System.out.println();
        System.out.printf("%-4s | %-10s | %-10s | %-30s | %-10s%n", person.getPersonId(), person.getFirstName(), person.getLastName(), person.getBirthDate(), person.getHouseId());
        System.out.println();
        System.out.printf(repeatedChars);
        System.out.println();
    }
    public void findPet() throws SQLException {
        Scanner sc = new Scanner(System.in);
        char ch = '-';
        String repeatedChars = String.valueOf(ch).repeat(73);
        System.out.printf(repeatedChars);
        System.out.println();

        System.out.println("Enter Pet ID which you want to be shown");
        int petId = sc.nextInt();
        Tier pet = petsDao.getPet(petId);

        System.out.printf("%-4s | %-15s | %-15s |  %-10s%n", "id", "Race", "Pet's Name", "Owner");
        System.out.println();
        System.out.printf(repeatedChars);
        System.out.println();
        System.out.printf("%-4s | %-15s | %-15s |  %-10s%n", pet.getTier_id(), pet.getRace(), pet.getTierName(), pet.getPersonId());
        System.out.println();
        System.out.printf(repeatedChars);
        System.out.println();
    }
    public void updateHouse() throws SQLException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter House ID which you want to update");
        int houseId = sc.nextInt();
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
        System.out.printf("You updated Houses with new values :   "+house.getHouseId()+", "+house.getZip()+", "+house.getCity()+", "+house.getAddress()+", "+house.getHouseNum());
        System.out.println();

    }
    public void updatePerson() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Person ID which you want to update");

        int personId = sc.nextInt();
        Person person = personsDao.getPerson(personId);
        person.setPersonId(personId);
        System.out.println("Enter first name");
        sc.nextLine();
        person.setFirstName(sc.nextLine());
        System.out.println("Enter last name");
        person.setLastName(sc.nextLine());
        System.out.println("Enter birth date ");
        person.setBirthDate(sc.nextLine());
        System.out.println("In which House live this person");
        person.setHouseId(sc.nextInt());

        personsDao.updatePerson(person);
        System.out.printf("You updated Persons with new values :   "+person.getPersonId()+", "+person.getFirstName()+", "+person.getLastName()+", "+person.getBirthDate()+", "+person.getHouseId());
        System.out.println();
    }
    public void updatePet() throws SQLException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Pet ID which you want to update");
        int petId = sc.nextInt();

        Tier pet = petsDao.getPet(petId);
        pet.setTierId(petId);
        System.out.println("Enter pet race");
        sc.nextLine();
        pet.setRace(sc.nextLine());
        System.out.println("Enter pet name");
        pet.setTierName(sc.nextLine());
        System.out.println("Who does this pet belong to?");
        pet.setPersonId(sc.nextInt());

        petsDao.updatePet(pet);
        System.out.printf("You updated Pets with new values :   "+pet.getTierId()+", "+pet.getRace()+", "+pet.getTierName()+", "+pet.getPersonId());
        System.out.println();
    }
    public void deleteHouse() throws SQLException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter House ID which you want to delete");
        int houseId = sc.nextInt();
        houseDao.delete(houseId);
    }
    public void deletePerson() throws SQLException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Person ID which you want to delete");
        int personId = sc.nextInt();
        personsDao.delete(personId);
    }
    public void deletePet() throws SQLException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Pet ID which you want to delete");
        int petId = sc.nextInt();
        petsDao.delete(petId);
    }
    public void showAllHouses() throws SQLException {
        houseDao.getAllHaushalt();
    }
    public void showAllPersons() throws SQLException {
        personsDao.getAllPersons();
    }
    public void showAllPets() throws SQLException {
        petsDao.showAllPets();
    }


}
