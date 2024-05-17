package equipments;

import java.math.BigDecimal;
import java.sql.Date;

public class SchoolEquipment {
    private int id;
    private String serialNumber;
    private String equipmentName;
    private String category;
    private int quantity;
    private BigDecimal price;
    private BigDecimal deliveryRate;
    private BigDecimal totalPrice;
    private Date purchaseDate;

    public SchoolEquipment() {
    }

    public SchoolEquipment(int id, String serialNumber, String equipmentName, String category, int quantity, BigDecimal price, BigDecimal deliveryRate, BigDecimal totalPrice, Date purchaseDate) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.equipmentName = equipmentName;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
        this.deliveryRate = deliveryRate;
        this.totalPrice = totalPrice;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getDeliveryRate() {
        return deliveryRate;
    }

    public void setDeliveryRate(BigDecimal deliveryRate) {
        this.deliveryRate = deliveryRate;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @Override
    public String toString() {
        return "SchoolEquipment{" +
                "id=" + id +
                ", serialNumber='" + serialNumber + '\'' +
                ", equipmentName='" + equipmentName + '\'' +
                ", category='" + category + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", deliveryRate=" + deliveryRate +
                ", totalPrice=" + totalPrice +
                ", purchaseDate=" + purchaseDate +
                '}';
    }
}

