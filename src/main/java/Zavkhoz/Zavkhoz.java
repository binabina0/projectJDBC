package Zavkhoz;

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