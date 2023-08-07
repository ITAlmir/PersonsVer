package org.example;

import java.util.Scanner;

public class MainMethod {
    public void mainMethod(){
        HouseManagement houseManagement = new HouseManagement();
        Scanner sc = new Scanner(System.in);
        boolean on = true;
while (on) {
    String[][] mainMenu = {
            {"1", "Add new House."},
            {"2", "Add new Person."},
            {"3", "Add new Animal"},
            {"4", "Find House"},
            {"5", "Find Person"},
            {"6", "Find Animal"},
            {"7", "Update House"},
            {"8", "Update Person"},
            {"9", "Update animal"},
            {"10", "Delete House"},
            {"11", "Delete Person"},
            {"12", "Delete Animal"},


    };
    for (int i = 0; i < mainMenu.length; i++) {
        System.out.println(mainMenu[i][0] + ". " + mainMenu[i][1]);
    }
    int houseId;
    int houseNum;
    String city;
    String address;
    int zip;
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

    int personId;
    String firstName;
    String lastName;
    String birthDate;
    System.out.println("Enter a id where this Person live");
    personId = sc.nextInt();
    System.out.println("Enter first name");
    sc.nextLine();
    firstName = sc.nextLine();
    System.out.println("Enter last name");
    lastName = sc.nextLine();
    System.out.println("Enter birth date ");
    birthDate = sc.nextLine();

    houseManagement.createPerson(houseId, personId, firstName, lastName, birthDate);

    int tierId = 0;
    String tierRace;
    String tierName;
    System.out.println("Who does this animal belong to?");
    firstName = sc.nextLine();
    System.out.println("Enter animal race");
    tierRace = sc.nextLine();
    System.out.println("Enter name for this animal ");
    tierName = sc.nextLine();

    houseManagement.createAnimal(firstName, tierId, tierRace, tierName);
}
    }
}
