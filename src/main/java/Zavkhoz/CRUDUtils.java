package Zavkhoz;

import equipments.SchoolEquipment;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CRUDUtils {
    public static List<SchoolEquipment> getEquipmentData(String query) {
        List<SchoolEquipment> schoolEquipments = new ArrayList<>();

        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String serialNumber = rs.getString("serial_number");
                String equipmentName = rs.getString("equipment_name");
                String category = rs.getString("category");
                int quantity = rs.getInt("quantity");
                BigDecimal price = rs.getBigDecimal("price");
                BigDecimal deliveryRate = rs.getBigDecimal("delivery_rate");
                BigDecimal totalPrice = rs.getBigDecimal("total_price");
                Date purchaseDate = rs.getDate("purchase_date");

                schoolEquipments.add(new SchoolEquipment(id, serialNumber, equipmentName, category, quantity, price, deliveryRate, totalPrice, purchaseDate));
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return schoolEquipments;
    }



}
