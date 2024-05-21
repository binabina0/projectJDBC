package app;
import DeliverymanUser.Deliveryman;
import Zavkhoz.Zavkhoz;
import Zavkhoz.CRUDUtils;

import java.util.Scanner;

public class app {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("To run the program, please enter your account type: \n Zavkhoz \n Deliveryman \n Director");
        String type = scan.next();
        scan.nextLine();
        while (!(type.equals("Zavkhoz") || type.equals("DeliverymanUser") || type.equals("Director"))) {
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
                System.out.println("Greetings dear, Caretaker!\n" +
                        "Please dial the menu number to work with the program, if you are finished, then dial 7:");
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
                System.out.println("Greetings dear Delivery Man!\n" +
                        "Please dial the menu number to work with the program, if you are finished, then dial 7.");
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
        }
    }
}
//        else if(role == 3)
//        {
//            String studentPassword = getStudentPassword(username);
//            int student_id = getStudentIdAccordingToStudentsUsername(username);
//            if(password.equals(studentPassword))
//            {
//                System.out.println("Dear student welcome to the grading system!\nChoose what do you want to do and enter the number of the command:");
//                while(quit.equals("no"))
//                {
//                    student.menu();
//                    int studentChoise = scan.nextInt();
//                    scan.nextLine();
//                    student.executeActionAccordingToStudentsChoise(studentChoise,student_id);
//                    System.out.println("Do you want to quit?(yes/no)");
//                    quit = scan.nextLine();
//                    if(quit.equals("yes"))
//                    {
//                        System.out.println("Goodbye");
//                        System.exit(0);
//                    }
//
//                }
//
//            }
//        }
//        else if(role == 4)
//        {
//            String parentPassword = getParentPassword(username);
//            if(password.equals(parentPassword))
//            {
//                System.out.println("Dear parent welcome to the grading system!\nChoose what do you want to do and enter the number of the command:");
//                while (quit.equals("no"))
//                {
//                    parent.menu();
//                    int parentChoise = scan.nextInt();
//                    scan.nextLine();
//                    int child_id = getChildIdAccordingToParentUserName(username);
//                    parent.executeActionAccordingToParentsChoise(parentChoise,child_id); quit = scan.nextLine();
//                    if(quit.equals("yes"))
//                    {
//                        System.out.println("Goodbye");
//                        System.exit(0);
//                    }
//                }
//
//            }
//        }
//
//    }
//
//    public static String getZavkhozPassword(String username)
//    {
//        String password = null;
//
//        String SELECT_ZAVKHOZ_PASSWORD = "SELECT * FROM Zavkhoz WHERE zavkhoz_username = ?";
//
//
//        try (Connection connection = (Connection) DBUtils.getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ZAVKHOZ_PASSWORD))
//        {
//            preparedStatement.setString(1, username);
//            ResultSet rs = preparedStatement.executeQuery();
//
//            rs.next();
//            password = rs.getString("admin_password");
//        }catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return password;
//    }