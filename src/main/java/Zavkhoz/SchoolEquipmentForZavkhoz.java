package Zavkhoz;

import java.math.BigDecimal;
import java.sql.Date;

public class SchoolEquipmentForZavkhoz {
    private int id;
    private String serialNumber;
    private String equipmentName;
    private String category;
    private int quantity;
    private Date purchaseDate;

    public SchoolEquipmentForZavkhoz() {
    }

    public SchoolEquipmentForZavkhoz(int id, String serialNumber, String equipmentName, String category, int quantity, Date purchaseDate) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.equipmentName = equipmentName;
        this.category = category;
        this.quantity = quantity;
        this.purchaseDate = purchaseDate;
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

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @Override
    public String toString() {
        return id + '\t' +
                serialNumber + '\t' +
                equipmentName + '\t' +
                category + '\t' +
                quantity + '\t' +
                purchaseDate + '\n';

    }
}