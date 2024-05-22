package DeliverymanUser;

import java.util.Scanner;

public class Deliveryman {
    private int id;
    private String deliverymanUsername;
    private String deliverymanPassword;

    public Deliveryman() {
    }

    public Deliveryman(int id, String deliverymanUsername, String deliverymanPassword) {
        this.id = id;
        this.deliverymanUsername = deliverymanUsername;
        this.deliverymanPassword = deliverymanPassword;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeliverymanUsername() {
        return deliverymanUsername;
    }

    public void setDeliverymanUsername(String deliverymanUsername) {
        this.deliverymanUsername = deliverymanUsername;
    }

    public String getDeliverymanPassword() {
        return deliverymanPassword;
    }

    public void setDeliverymanPassword(String deliverymanPassword) {
        this.deliverymanPassword = deliverymanPassword;
    }

    @Override
    public String toString() {
        return "Deliveryman{" +
                "id=" + id +
                ", deliverymanUsername='" + deliverymanUsername + '\'' +
                ", deliverymanPassword='" + deliverymanPassword + '\'' +
                '}';
    }

    public static void menu() {
        System.out.println("Please dial the menu number to work with the program, if you are finished, then dial 7.\n" +
                "1. Show a list of equipment for delivery\n" +
                "2. Show delivered equipment\n" +
                "3. Deliver equipment\n" +
                "   What equipment was delivered? Enter the name of the equipment or its serial number\n" +
                "4. Show the number of delivered equipment\n" +
                "5. Show the number of equipment ordered\n" +
                "6. Show my earnings\n" +
                "7. Exit\n");
    }


    public static void deliverymanActions(int deliverymanChoise) {
        Scanner scan = new Scanner(System.in);

        if (deliverymanChoise == 6) {
            System.out.println("Earnings:\n" + CRUDUtils.getDeliverymansDeliveryRate());
        } else if (deliverymanChoise == 5) {
            System.out.println("The number of equipment ordered:\n" + CRUDUtils.getOrderedEquipmentQuantity());
        } else if (deliverymanChoise == 4) {
            System.out.println("The number of delivered equipment:\n" + CRUDUtils.getDeliveredEquipmentQuantity());
        }else if (deliverymanChoise == 3) {
            System.out.println("What equipment was delivered? Enter the name of the equipment or its serial number\n");
            String equipmentIdentifier = scan.nextLine();
            System.out.println("Delivered equipment" + CRUDUtils.saveDeliveredEquipment(equipmentIdentifier));
        } else if (deliverymanChoise == 2) {
            System.out.println("Delivered equipment" + CRUDUtils.getDeliveredEquipmentData());
        } else if (deliverymanChoise == 1) {
            System.out.println("A list of equipment for delivery\n" + CRUDUtils.getOrederedEquipmentNameList());
        }
    }
}
