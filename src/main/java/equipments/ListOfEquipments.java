package equipments;

import java.math.BigDecimal;
import java.sql.Date;

public class ListOfEquipments {
    private int id;
    private String serialNumber;
    private String equipmentName;
    private String category;

    public ListOfEquipments() {
    }

    public ListOfEquipments(int id, String serialNumber, String equipmentName, String category) {
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

    @Override
    public String toString() {
        return "SchoolEquipment{\n" +
                "id=" + id +"\n" +
                ", serialNumber='" + serialNumber + '\n' +
                ", equipmentName='" + equipmentName + '\n' +
                ", category='" + category + '\n' +
                '}';
    }
}
