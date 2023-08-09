package org.example;

import java.sql.SQLException;
import java.util.Scanner;

public class MainMethod {
    public void mainMethod() throws SQLException {
        HouseManagement houseManagement = new HouseManagement();
        Scanner sc = new Scanner(System.in);
        boolean on = true;
while (on) {
    String[][] mainMenu = {
            {"1", "Add new House."},
            {"2", "Add new Person."},
            {"3", "Add new Pet"},
            {"4", "Find House"},
            {"5", "Find Person"},
            {"6", "Find Pet"},
            {"7", "Update House"},
            {"8", "Update Person"},
            {"9", "Update Pet"},
            {"10", "Delete House"},
            {"11", "Delete Person"},
            {"12", "Delete Pet"},


    };
    for (int i = 0; i < mainMenu.length; i++) {
        System.out.println(mainMenu[i][0] + ". " + mainMenu[i][1]);
    }int houseId;
    int houseNum;
    String city;
    String address;
    int zip;
    //-------------------------------
    int personId;
    String firstName;
    String lastName;
    String birthDate;
    //-------------------------------
    int petId = 0;
    String tierRace;
    String tierName;
    System.out.println("Enter a number (1-12):");
    int choice = sc.nextInt();

    switch (choice) {
        case 1:
            try {
                houseManagement.createHouse();
                houseManagement.showAllHouses();
            }catch (Exception e){
                System.out.println("Can't do !!!");
            }
            break;
        case 2:
            try {
                houseManagement.showAllHouses();
                houseManagement.createPerson();
                houseManagement.showAllPersons();
            }catch (Exception e){
                System.out.println("No Way !!!");
            }

            break;
        case 3:
            try {
                houseManagement.showAllPersons();
                houseManagement.createPet();
                houseManagement.showAllPets();
            }catch (Exception e){
                System.out.println("Never happened !!!");
            }
            break;
        case 4:
            try {
                houseManagement.findHouse();
            }catch (Exception e){
                System.out.println("Nope !");
            }
            break;
        case 5:
            try {
                houseManagement.findPerson();
            }catch (Exception e){
                System.out.println("No Sir !!");
            }
            break;
        case 6:
            try {
                houseManagement.findPet();
            }catch (Exception e){
                System.out.println("Nooooo !");
            }
            break;
        case 7:
            try {
                houseManagement.showAllHouses();
                houseManagement.updateHouse();
                houseManagement.showAllHouses();
            }catch (Exception e){
                System.out.println("Wrong !");
            }
            break;
        case 8:
            try {
                houseManagement.showAllPersons();
                houseManagement.updatePerson();
                houseManagement.showAllPersons();
            }catch (Exception e){
                System.out.println("Wrong !!");
            }

            break;
        case 9:
            try {
                houseManagement.showAllPets();
                houseManagement.updatePet();
                houseManagement.showAllPets();
            }catch (Exception e){
                System.out.println("Don't be stupid");
            }
            break;
        case 10:
            try {
                houseManagement.showAllHouses();
                houseManagement.deleteHouse();
                houseManagement.showAllHouses();
            }catch (Exception e){
                System.out.println("Goats can't fly");
            }
            break;
        case 11:
            try {
                houseManagement.showAllPersons();
                houseManagement.deletePerson();
                houseManagement.showAllPersons();
            }catch (Exception e){
                System.out.println("No...try again !");
            }
            break;
        case 12:
            try {
                houseManagement.showAllPets();
                houseManagement.deletePet();
                houseManagement.showAllPets();
            }catch (Exception e){
                System.out.println(" Invalid !!");
            }
            break;
        default:
            System.out.println("Invalid choice");
    }


}
    }
}
