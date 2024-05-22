package equipments;

import java.math.BigDecimal;
import java.sql.Date;

public class OrderedSchoolEquipment {
    private int id;
    private String serialNumber;
    private String equipmentName;
    private String category;
    private int quantity;
    private BigDecimal price;
    private BigDecimal deliveryRate;
    private BigDecimal totalPrice;
    private Date orderedDate;

    public OrderedSchoolEquipment() {
    }

    public OrderedSchoolEquipment(int id, String serialNumber, String equipmentName, String category, int quantity, BigDecimal price, BigDecimal deliveryRate, BigDecimal totalPrice, Date orderedDate) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.equipmentName = equipmentName;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
        this.deliveryRate = deliveryRate;
        this.totalPrice = totalPrice;
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
                quantity + '\t' +
                price + '\t' +
                deliveryRate + '\t' +
                totalPrice + '\t' +
                orderedDate + '\n';
    }
}
