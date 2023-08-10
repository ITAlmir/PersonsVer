package org.example;

import java.sql.SQLException;
import java.util.Scanner;

public class MainMethod {
    public void mainMethod() throws SQLException {
        HouseManagement houseManagement = new HouseManagement();
        Scanner sc = new Scanner(System.in);
        boolean on = true;
        int choice = 0;
        boolean check = false;
        while (on) {
            String[][] mainMenu = {
                    {"1", "Add new Household."},
                    {"2", "Add new Person."},
                    {"3", "Add new Pet"},
                    {"4", "Find Household"},
                    {"5", "Find Person"},
                    {"6", "Find Pet"},
                    {"7", "Update Household"},
                    {"8", "Update Person"},
                    {"9", "Update Pet"},
                    {"10", "Delete Household"},
                    {"11", "Delete Person"},
                    {"12", "Delete Pet"},
                    {"0", "Quit"},

            };
            for (int i = 0; i < mainMenu.length; i++) {
                System.out.println(mainMenu[i][0] + ". " + mainMenu[i][1]);
            }
            do {
                try {
                    System.out.println("Enter a number (1-12 or 0 to quit):");
                    choice = sc.nextInt();
                    check = true;

                }catch (Exception e){
                    sc = new Scanner(System.in);
                    System.out.println("Please use only numbers");
                    check = false;
                }
            }while (!check);



            switch (choice) {
                case 1:
                    try {
                        houseManagement.createHouse();
                        houseManagement.showAllHouses();
                    } catch (Exception e) {
                        System.out.println("Can't do !!!");
                    }
                    break;
                case 2:
                    try {
                        houseManagement.showAllHouses();
                        houseManagement.createPerson();
                        houseManagement.showAllPersons();
                    } catch (Exception e) {
                        System.out.println("No Way !!!");
                    }

                    break;
                case 3:
                    try {
                        houseManagement.showAllPersons();
                        houseManagement.createPet();
                        houseManagement.showAllPets();
                    } catch (Exception e) {
                        System.out.println("Never happened !!!");
                    }
                    break;
                case 4:
                    try {
                        houseManagement.findHouse();
                    } catch (Exception e) {
                        System.out.println("Nope !");
                    }
                    break;
                case 5:
                    try {
                        houseManagement.findPerson();
                    } catch (Exception e) {
                        System.out.println("No Sir !!");
                    }
                    break;
                case 6:
                    try {
                        houseManagement.findPet();
                    } catch (Exception e) {
                        System.out.println("Nooooo !");
                    }
                    break;
                case 7:
                    try {
                        houseManagement.showAllHouses();
                        houseManagement.updateHouse();
                        houseManagement.showAllHouses();
                    } catch (Exception e) {
                        System.out.println("Wrong !");
                    }
                    break;
                case 8:
                    try {
                        houseManagement.showAllPersons();
                        houseManagement.updatePerson();
                        houseManagement.showAllPersons();
                    } catch (Exception e) {
                        System.out.println("No Mister !!");
                    }

                    break;
                case 9:
                    try {
                        houseManagement.showAllPets();
                        houseManagement.updatePet();
                        houseManagement.showAllPets();
                    } catch (Exception e) {
                        System.out.println("NO ! ");
                    }
                    break;
                case 10:
                    try {
                        houseManagement.showAllHouses();
                        houseManagement.deleteHouse();
                        houseManagement.showAllHouses();
                    } catch (Exception e) {
                        System.out.println("Goats can't fly");
                    }
                    break;
                case 11:
                    try {
                        houseManagement.showAllPersons();
                        houseManagement.deletePerson();
                        houseManagement.showAllPersons();
                    } catch (Exception e) {
                        System.out.println("No...try again !");
                    }
                    break;
                case 12:
                    try {
                        houseManagement.showAllPets();
                        houseManagement.deletePet();
                        houseManagement.showAllPets();
                    } catch (Exception e) {
                        System.out.println(" Invalid !!");
                    }
                    break;
                case 0:
                    on = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }


        }
    }
}
