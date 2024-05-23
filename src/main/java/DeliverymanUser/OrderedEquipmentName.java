package DeliverymanUser;

import java.util.Date;

public class OrderedEquipmentName {
    private int id;
    private String serialNumber;
    private String equipmentName;
    private String category;
    private Date orderedDate;

    public OrderedEquipmentName() {
    }

    public OrderedEquipmentName(int id, String serialNumber, String equipmentName, String category, Date orderedDate) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.equipmentName = equipmentName;
        this.category = category;
        this.orderedDate = orderedDate;
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

    public Date getOrderedDate() {
        return orderedDate;
    }

    public void setOrderedDate(Date orderedDate) {
        this.orderedDate = orderedDate;
    }

    @Override
    public String toString() {
        return id + '\t' +
                serialNumber + '\t' +
                equipmentName + '\t' +
                category + '\t' +
                orderedDate + '\n';

    }
}
