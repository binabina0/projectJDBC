package Deliveryman;

import java.util.Date;

public class DeliveredEquipmentQuantity {
    private int id;
    private String serialNumber;
    private String equipmentName;
    private String category;
    private int quantity;
    private Date deliveredDate;

    public DeliveredEquipmentQuantity() {
    }

    public DeliveredEquipmentQuantity(int id, String serialNumber, String equipmentName, String category, int quantity, Date deliveredDate) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.equipmentName = equipmentName;
        this.category = category;
        this.quantity = quantity;
        this.deliveredDate = deliveredDate;
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

    public Date getDeliveredDate() {
        return deliveredDate;
    }

    public void setDeliveredDate(Date deliveredDate) {
        this.deliveredDate = deliveredDate;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "SchoolEquipment{\n" +
                "id=" + id +"\n" +
                ", serialNumber='" + serialNumber + '\n' +
                ", equipmentName='" + equipmentName + '\n' +
                ", category='" + category + '\n' +
                ", quantity=" + quantity + '\n' +
                ", deliveredDate=" + deliveredDate + '\n' +
                '}';
    }



}
