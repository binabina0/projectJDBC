package equipments;

import java.math.BigDecimal;
import java.sql.Date;

public class DeliveredSchoolEquipment {
    private int id;
    private String serialNumber;
    private String equipmentName;
    private String category;
    private int quantity;
    private BigDecimal price;
    private BigDecimal deliveryRate;
    private BigDecimal totalPrice;
    private Date deliveredDate;

    public DeliveredSchoolEquipment() {
    }

    public DeliveredSchoolEquipment(int id, String serialNumber, String equipmentName, String category, int quantity, BigDecimal price, BigDecimal deliveryRate, BigDecimal totalPrice, Date deliveredDate) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.equipmentName = equipmentName;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
        this.deliveryRate = deliveryRate;
        this.totalPrice = totalPrice;
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

    public Date getDeliveredDate() {
        return deliveredDate;
    }

    public void setDeliveredDate(Date deliveredDate) {
        this.deliveredDate = deliveredDate;
    }

    @Override
    public String toString() {
        return "DeliveredSchoolEquipment{" +
                "id=" + id +
                ", serialNumber='" + serialNumber + '\'' +
                ", equipmentName='" + equipmentName + '\'' +
                ", category='" + category + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", deliveryRate=" + deliveryRate +
                ", totalPrice=" + totalPrice +
                ", deliveredDate=" + deliveredDate +
                '}';
    }
}
