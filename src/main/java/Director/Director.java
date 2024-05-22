package Director;

import DeliverymanUser.CRUDUtils;

import java.util.Scanner;

public class Director {
    private int id;
    private String directorUsername;
    private String directorPassword;

    public Director() {
    }

    public Director(int id, String directorUsername, String directorPassword) {
        this.id = id;
        this.directorUsername = directorUsername;
        this.directorPassword = directorPassword;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDirectorUsername() {
        return directorUsername;
    }

    public void setDirectorUsername(String directorUsername) {
        this.directorUsername = directorUsername;
    }

    public String getDirectorPassword() {
        return directorPassword;
    }

    public void setDirectorPassword(String directorPassword) {
        this.directorPassword = directorPassword;
    }

    @Override
    public String toString() {
        return id + '\t' +
                directorUsername + '\t' +
                directorPassword + '\n';
    }

    public static void menu() {
        System.out.println("Please dial the menu number to work with the program, if you are finished, then dial 6:\n" +
                "1. Show a list of equipment (Shows a list of equipment thatis in the educational center)\n" +
                "2. Show the number of equipment (Shows the number ofequipment by category)\n" +
                "3. Show equipment with the maximum quantity\n" +
                "4. Show equipment with the minimum quantity\n" +
                "5. Show purchasing report about equipment\n" +
                "6. Exit (Exits the program)");
    }

    public static void directorActions(int directorChoise) {
        Scanner scan = new Scanner(System.in);

        if (directorChoise == 5) {
            System.out.println("Report about equipment:\n" + Zavkhoz.CRUDUtils.allEquipmentData());
        } else if (directorChoise == 4) {
            System.out.println("Equipment with the minimum quantity\n" + CRUDUtilsForDirector.minEquipmentQuantity());
        }else if (directorChoise == 3) {
            System.out.println("The Equipment with the minimum quantity\n" + CRUDUtilsForDirector.maxEquipmentQuantity());
        } else if (directorChoise == 2) {
            System.out.println("The number of equipment" + CRUDUtilsForDirector.listOfEquipmentQuantity());
        } else if (directorChoise == 1) {
            System.out.println("A list of equipment:\n" + Zavkhoz.CRUDUtils.listOfEquipment());
        }
    }
}
