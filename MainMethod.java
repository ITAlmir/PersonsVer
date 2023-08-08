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
            System.out.println("Enter a house id");
            houseId = sc.nextInt();
            System.out.println("Enter a house number");
            houseNum = sc.nextInt();

            System.out.println("Enter city");
            sc.nextLine();
            city = sc.nextLine();
            System.out.println("Enter address");
            address = sc.nextLine();
            System.out.println("Enter zip code");
            zip = sc.nextInt();

            houseManagement.createHouse(houseId, houseNum, city, address, zip);
            break;
        case 2:
            System.out.println("In which House live this person");
            houseId = sc.nextInt();
            System.out.println("Enter personID");
            personId = sc.nextInt();
            System.out.println("Enter first name");
            sc.nextLine();
            firstName = sc.nextLine();
            System.out.println("Enter last name");
            lastName = sc.nextLine();
            System.out.println("Enter birth date ");
            birthDate = sc.nextLine();

            houseManagement.createPerson(houseId, personId, firstName, lastName, birthDate,houseId);
            break;
        case 3:
            System.out.println("Enter id for this pet");
            petId = sc.nextInt();
            System.out.println("Who does this pet belong to?");
            personId = sc.nextInt();
            System.out.println("Enter pet's race");
            sc.nextLine();
            tierRace = sc.nextLine();
            System.out.println("Enter name for this pet ");
            tierName = sc.nextLine();
            houseManagement.createPet(petId,tierRace,tierName,personId);
            break;
        case 4:
            System.out.println("Enter house ID");
            houseId = sc.nextInt();
            houseManagement.findHouse(houseId);
            break;
        case 5:
            System.out.println("Enter person ID");
            sc.nextLine();
            personId = sc.nextInt();
            houseManagement.findPerson(personId);
            break;
        case 6:
            System.out.println("Enter pet ID");
            petId = sc.nextInt();
            houseManagement.findPet(petId);
            break;
        case 7:
            System.out.println("Enter house ID which you want to update");
            houseId = sc.nextInt();
            houseManagement.updateHouse(houseId);
            break;
        case 8:

            break;
        case 9:

            break;
        case 10:

            break;
        case 11:

            break;
        case 12:

            break;
        default:
            System.out.println("Invalid choice");
    }


}
    }
}
