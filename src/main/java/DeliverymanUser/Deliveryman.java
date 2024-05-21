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
        System.out.println("1. Show a list of equipment for delivery (Shows a list of equipment for delivery from the \"Ordered Equipment\" file)\n" +
                "2. Show delivered equipment (Shows a list of delivered equipment from the \"Delivered Equipment\" file)\n" +
                "3. Deliver equipment\n" +
                "   What equipment was delivered? Enter the name of the equipment or its serial number\n" +
                "   (The name or serial number of the equipment that was written by the delivery person is entered into the file and at the same time the record of this equipment is deleted from the \"Ordered Equipment\" file)\n" +
                "4. Show the number of delivered equipment (Shows the number of delivered equipment from the \"Delivered Equipment\" file)\n" +
                "5. Show the number of equipment ordered (Shows the number of equipment for delivery from \"Ordered Equipment\" file)\n" +
                "6. Show my earnings (Shows how much was received for each equipment from the \"Delivered Equipment\" file, the delivery rate can be set at your discretion)\n" +
                "7. Exit (Exits the program)\n");
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
            System.out.println(CRUDUtils.saveDeliveredEquipment(equipmentIdentifier));
        } else if (deliverymanChoise == 2) {
            System.out.println(CRUDUtils.getDeliveredEquipmentData());
        } else if (deliverymanChoise == 1) {
            System.out.println(CRUDUtils.getOrederedEquipmentNameList());
        }
    }
}
