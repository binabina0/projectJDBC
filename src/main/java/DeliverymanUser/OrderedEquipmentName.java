package DeliverymanUser;

import java.util.Date;

public class OrderedEquipmentName {
    private int id;
    private String serialNumber;
    private String equipmentName;
    private String category;
    private Date purshaseDate;

    public OrderedEquipmentName() {
    }

    public OrderedEquipmentName(int id, String serialNumber, String equipmentName, String category, Date purshaseDate) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.equipmentName = equipmentName;
        this.category = category;
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

    @Override
    public String toString() {
        return "SchoolEquipment{\n" +
                "id=" + id +"\n" +
                ", serialNumber='" + serialNumber + '\n' +
                ", equipmentName='" + equipmentName + '\n' +
                ", category='" + category + '\n' +
                ", deliveredDate=" + purshaseDate + '\n' +
                '}';
    }
}
