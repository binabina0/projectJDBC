package DeliverymanUser;

import java.util.Date;

public class OrderedEquipmentQuantity {
    private int id;
    private String serialNumber;
    private String equipmentName;
    private String category;
    private int quantity;
    private Date purshaseDate;

    public OrderedEquipmentQuantity() {
    }

    public OrderedEquipmentQuantity(int id, String serialNumber, String equipmentName, String category, int quantity, Date purshaseDate) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.equipmentName = equipmentName;
        this.category = category;
        this.quantity = quantity;
        this.purshaseDate = purshaseDate;
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

    public Date getPurshedDate() {
        return purshaseDate;
    }

    public void setPurshaseDate(Date purshaseDate) {
        this.purshaseDate = purshaseDate;
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
                quantity + '\t' +
                purshaseDate + '\n';
    }


}
