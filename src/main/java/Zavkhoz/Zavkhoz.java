package Zavkhoz;

public class Zavkhoz extends user {
    public static void menu() {
        System.out.println("1.\tShow the entire list of school equipment\n" +
                "2.\tSearch equipment:\n" +
                "•\tBy serial number\n" +
                "•\tEnter your serial number to search:>>\n" +
                "(Then a list of equipment by serial number is displayed)\n" +
                "\n" +
                "•\tBy name\n" +
                "•\tWrite the name of the equipment to search:>>\n" +
                "(Then a list of equipment is displayed)\n" +
                "3.\tShow equipment report (Shows the entire list of equipment that is available, indicating the quantity and year it was purchased)\n" +
                "4.\tPlace an order for equipment:\n" +
                "•\tPlease write what equipment you would like to order: (The name of the equipment to be ordered is indicated here, after which this specified name of the equipment is recorded in a separate file “Ordered Equipment”)\n" +
                "5.\tView the list of ordered equipment (Shows the entire list of ordered equipment from the “Ordered Equipment” file)\n" +
                "6.\tDelete order:\n" +
                "7.\tWhat equipment would you like to remove? >>> (Deletes equipment from the Ordered Equipment file)\n" +
                "8.\tExit\n");
    }
}
