package tutorial;

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


    public static void zavkhozActions(int zavkhozChoise) {
        Scanner scan = new Scanner(System.in);

        if (zavkhozChoise == 6) {
            System.out.println("What equipment would you like to remove?");
            String equipment = scan.next();
            System.out.println(Zavkhoz.CRUDUtils.deleteEquipment(equipment));

        } else if (zavkhozChoise == 5) {
            System.out.println("Ordered School Equipment Details:\n" + Zavkhoz.CRUDUtils.getOrderedEquipmentData());
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
            System.out.println(Zavkhoz.CRUDUtils.saveOrderedEquipment(equipment));
        } else if (zavkhozChoise == 3) {
            System.out.println("Equipment report:\n" + Zavkhoz.CRUDUtils.allEquipmentData());
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
                System.out.println(Zavkhoz.CRUDUtils.getSearchedEquipmentBySerialNumber(serialNumber));
            } else if (subChoice == 2) {
                System.out.println("Write the name of the equipment to search:");
                scan.nextLine();
                String equipmentName = scan.nextLine();
                System.out.println(Zavkhoz.CRUDUtils.getSearchedEquipmentByName(equipmentName));
            }
        } else if (zavkhozChoise == 1) {
            System.out.println("The entire list of school equipment\n" + CRUDUtils.listOfEquipment());
        }
    }
}
