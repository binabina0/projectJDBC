package Director;

import java.math.BigDecimal;
import java.sql.Date;

public class SchoolEquipmentQuantity {
    private int id;
    private String serialNumber;
    private String equipmentName;
    private String category;
    private int quantity;

    public SchoolEquipmentQuantity() {
    }

    public SchoolEquipmentQuantity(int id, String serialNumber, String equipmentName, String category, int quantity) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.equipmentName = equipmentName;
        this.category = category;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
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
        return id + '\t' +
                serialNumber + '\t' +
                equipmentName + '\t' +
                category + '\t' +
                quantity + '\n';
    }
}
