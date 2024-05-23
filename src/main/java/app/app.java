package app;
import DeliverymanUser.Deliveryman;
import Director.CRUDUtilsForDirector;
import Director.Director;
import Zavkhoz.Zavkhoz;
import Zavkhoz.CRUDUtils;

import java.util.Scanner;

public class app {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("To run the program, please enter your account type: \n Zavkhoz \n Deliveryman \n Director");
        String type = scan.next();
        scan.nextLine();
        while (!(type.equals("Zavkhoz") || type.equals("Deliveryman") || type.equals("Director"))) {
            System.out.println("Sorry, but we did not find this type of account, please try again.");
            System.out.println("To run the program, please enter your account type: \n Zavkhoz \n Deliveryman \n Director");
            type = scan.next();
        }
        System.out.println("Enter your username:");
        String username = scan.nextLine();
        System.out.println("Enter your password: ");
        String password = scan.nextLine();
        int userChoice = 0;

        if (type.equals("Zavkhoz")) {
            String zavkhozPassword = CRUDUtils.zavkhozPassword(username);
            if (password.equals(zavkhozPassword)) {
                System.out.println("Greetings dear, Caretaker!\n");
                while (userChoice != 7) {
                    Zavkhoz.menu();
                    userChoice = scan.nextInt();
                    scan.nextLine();
                    if (userChoice == 7) {
                        System.out.println("The program is completed, we will be glad to see you back!");
                        System.exit(0);
                    }
                    while (userChoice > 7 || userChoice < 1) {
                        System.out.println("Enter command only from 1 to 7");
                        userChoice = scan.nextInt();
                        scan.nextLine();
                    }
                    Zavkhoz.zavkhozActions(userChoice);

                }
            } else {
                System.out.println("Incorrect password.");
            }
        } else if (type.equals("Deliveryman")) {
            String deliverymanPassword = DeliverymanUser.CRUDUtils.deliverymanPassword(username);
            if (password.equals(deliverymanPassword)) {
                System.out.println("Greetings dear Delivery Man!\n");
                while (userChoice != 7) {
                    Deliveryman.menu();
                    userChoice = scan.nextInt();
                    scan.nextLine();
                    if (userChoice == 7) {
                        System.out.println("The program is completed, we will be glad to see you back!");
                        System.exit(0);
                    }
                    while (userChoice > 7 || userChoice < 1) {
                        System.out.println("Enter command only from 1 to 7");
                        userChoice = scan.nextInt();
                        scan.nextLine();
                    }
                    Deliveryman.deliverymanActions(userChoice);
                }
            } else {
                System.out.println("Incorrect password.");
            }
        } else if (type.equals("Director")) {
            String directorPassword = CRUDUtilsForDirector.directorPassword(username);
            if (password.equals(directorPassword)) {
                System.out.println("Greetings dear Director!\n");
                while (userChoice != 6) {
                    Director.menu();
                    userChoice = scan.nextInt();
                    scan.nextLine();
                    if (userChoice == 6) {
                        System.out.println("The program is completed, we will be glad to see you back!");
                        System.exit(0);
                    }
                    while (userChoice > 6 || userChoice < 1) {
                        System.out.println("Enter command only from 1 to 6");
                        userChoice = scan.nextInt();
                        scan.nextLine();
                    }
                    Director.directorActions(userChoice);
                }
            } else {
                System.out.println("Incorrect password.");
            }
        }
    }
}