package Deliveryman;

import java.math.BigDecimal;
import java.sql.Date;

public class DeliverymansDeliveryRate {
    private int id;
    private String serialNumber;
    private String equipmentName;
    private String category;
    private int quantity;
    private BigDecimal deliveryRate;

    public DeliverymansDeliveryRate() {
    }

    public DeliverymansDeliveryRate(int id, String serialNumber, String equipmentName, String category, int quantity, BigDecimal deliveryRate) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.equipmentName = equipmentName;
        this.category = category;
        this.quantity = quantity;
        this.deliveryRate = deliveryRate;
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

    public BigDecimal getDeliveryRate() {
        return deliveryRate;
    }

    public void setDeliveryRate(BigDecimal deliveryRate) {
        this.deliveryRate = deliveryRate;
    }

    @Override
    public String toString() {
        return "DeliveredSchoolEquipment{" +
                "id=" + id + '\n' +
                ", serialNumber='" + serialNumber + '\n' +
                ", equipmentName='" + equipmentName + '\n' +
                ", category='" + category + '\n' +
                ", quantity=" + quantity + '\n' +
                ", deliveryRate=" + deliveryRate + '\n' +
                '}';
    }
}
