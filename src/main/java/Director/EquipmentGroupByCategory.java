package Director;

public class EquipmentGroupByCategory {
    private String category;
    private int quantity;

    public EquipmentGroupByCategory() {
    }

    public EquipmentGroupByCategory(String category, int quantity) {
        this.category = category;
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return  category + '\t' +
                quantity + '\n';
    }
}
