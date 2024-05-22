package Zavkhoz;
import equipments.OrderedSchoolEquipment;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Scanner;

public class Zavkhoz {
    private int id;
    private String zavkhozUsername;
    private String zavkhozPassword;

    public Zavkhoz() {
    }

    public Zavkhoz(int id, String zavkhozUsername, String zavkhozPassword) {
        this.id = id;
        this.zavkhozUsername = zavkhozUsername;
        this.zavkhozPassword = zavkhozPassword;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getZavkhozUsername() {
        return zavkhozUsername;
    }

    public void setZavkhozUsername(String zavkhozUsername) {
        this.zavkhozUsername = zavkhozUsername;
    }

    public String getZavkhozPassword() {
        return zavkhozPassword;
    }

    public void setZavkhozPassword(String zavkhozPassword) {
        this.zavkhozPassword = zavkhozPassword;
    }

    @Override
    public String toString() {
        return "Zavkhoz{" +
                "id=" + id +
                ", zavkhozUsername='" + zavkhozUsername + '\'' +
                ", zavkhozPassword='" + zavkhozPassword + '\'' +
                '}';
    }
    public static void menu() {
        System.out.println("Please dial the menu number to work with the program, if you are finished, then dial 7:\n" +
                "1.\tShow the entire list of school equipment\n" +
                "2.\tSearch equipment:\n" +
                "•\tBy serial number\n" +
                "\n" +
                "•\tBy name\n" +
                "3.\tShow equipment report\n" +
                "4.\tPlace an order for equipment:\n" +
                "•\tPlease write what equipment you would like to order:\n" +
                "5.\tView the list of ordered equipment\n" +
                "6.\tDelete order:\n" +
                "7.\tExit\n");
    }

    public static void zavkhozActions(int zavkhozChoise) {
        Scanner scan = new Scanner(System.in);

        if (zavkhozChoise == 6) {
            System.out.println("What equipment would you like to remove?");
            String equipment = scan.next();
            System.out.println(CRUDUtils.deleteEquipment(equipment));

        } else if (zavkhozChoise == 5) {
            System.out.println("Ordered School Equipment Details:\n" + CRUDUtils.getOrderedEquipmentData());
        } else if (zavkhozChoise == 4) {
            System.out.println("Please write what equipment you would like to order");
            System.out.print("Enter serial number: ");
            String serialNumber = scan.nextLine();

            System.out.print("Enter equipment name: ");
            String equipmentName = scan.nextLine();

            System.out.print("Enter category: ");
            String category = scan.nextLine();

            System.out.print("Enter quantity: ");
            int quantity = scan.nextInt();

            System.out.print("Enter price: ");
            BigDecimal price = BigDecimal.valueOf(scan.nextDouble());

            System.out.print("Enter delivery rate: ");
            BigDecimal deliveryRate = BigDecimal.valueOf(scan.nextDouble());

            System.out.print("Enter total price: ");
            BigDecimal totalPrice = BigDecimal.valueOf(scan.nextDouble());

            System.out.print("Enter ordered date (yyyy-mm-dd): ");
            String orderedDateString = scan.next();
            Date orderedDate = Date.valueOf(orderedDateString);

            OrderedSchoolEquipment equipment = new OrderedSchoolEquipment();
            equipment.setSerialNumber(serialNumber);
            equipment.setEquipmentName(equipmentName);
            equipment.setCategory(category);
            equipment.setQuantity(quantity);
            equipment.setPrice(price);
            equipment.setDeliveryRate(deliveryRate);
            equipment.setTotalPrice(totalPrice);
            equipment.setOrderedDate(orderedDate);
            System.out.println(CRUDUtils.saveOrderedEquipment(equipment));
        } else if (zavkhozChoise == 3) {
            System.out.println("Equipment report:\n" + CRUDUtils.allEquipmentData());
        } else if (zavkhozChoise == 2) {
            System.out.println("1.\tBy serial number\n" + "2.\tBy name");
            int subChoice = scan.nextInt();
            while(subChoice>2||subChoice<1)
            {
                System.out.println("Enter command only 1 or 2");
                subChoice = scan.nextInt();
                scan.nextLine();
            }
            if(subChoice == 1){
                System.out.println("Enter your serial number to search:");
                scan.nextLine();
                String serialNumber = scan.nextLine();
                System.out.println(CRUDUtils.getSearchedEquipmentBySerialNumber(serialNumber));
            } else if (subChoice == 2) {
                System.out.println("Write the name of the equipment to search:");
                scan.nextLine();
                String equipmentName = scan.nextLine();
                System.out.println(CRUDUtils.getSearchedEquipmentByName(equipmentName));
            }
        } else if (zavkhozChoise == 1) {
            System.out.println("The entire list of school equipment\n" + CRUDUtils.listOfEquipment());
            }
        }
    }
