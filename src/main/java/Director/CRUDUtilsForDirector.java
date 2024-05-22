package Director;

import Zavkhoz.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CRUDUtilsForDirector {
    private static final String SELECT_ALL_EQUIPMENT = "SELECT * FROM SchoolEquipment";
    public static List<SchoolEquipmentQuantity> listOfEquipmentQuantity() {
        List<SchoolEquipmentQuantity> quantityOfEquipments = new ArrayList<>();

        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EQUIPMENT)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String serialNumber = rs.getString("serial_number");
                String equipmentName = rs.getString("equipment_name");
                String category = rs.getString("category");
                int quantity = rs.getInt("quantity");

                quantityOfEquipments.add(new SchoolEquipmentQuantity(id, serialNumber, equipmentName, category, quantity));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return quantityOfEquipments;
    }
}
