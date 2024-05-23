package Director;

import Zavkhoz.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CRUDUtilsForDirector {
    private static final String SELECT_MAX_EQUIPMENT = "SELECT id, serial_number, equipment_name, category, quantity FROM SchoolEquipment WHERE quantity = (SELECT MAX(quantity) FROM SchoolEquipment)";
    private static final String SELECT_ALL_EQUIPMENT_GROUPED_BY_CATEGORY = "SELECT category, SUM(quantity) AS quantity FROM SchoolEquipment GROUP BY category";
    private static final String SELECT_MIN_EQUIPMENT = "SELECT id, serial_number, equipment_name, category, quantity FROM SchoolEquipment WHERE quantity = (SELECT MIN(quantity) FROM SchoolEquipment)";
    private static final String SELECT_PASSWORD = "SELECT director_password FROM Director WHERE director_username = ?";


    public static String directorPassword(String username) {
        String password = null;

        try (Connection connection = DBUtils.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PASSWORD)) {
            preparedStatement.setString(1, username);
            preparedStatement.executeQuery();

            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()) {
                password = rs.getString("director_password");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return password;
    }
    public static List<EquipmentGroupByCategory> listOfEquipmentQuantity() {
        List<EquipmentGroupByCategory> quantityOfEquipments = new ArrayList<>();

        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EQUIPMENT_GROUPED_BY_CATEGORY)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String category = rs.getString("category");
                int quantity = rs.getInt("quantity");

                quantityOfEquipments.add(new EquipmentGroupByCategory(category, quantity));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return quantityOfEquipments;
    }

    public static List<SchoolEquipmentQuantity> maxEquipmentQuantity() {
        List<SchoolEquipmentQuantity> quantityOfEquipments = new ArrayList<>();

        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MAX_EQUIPMENT)) {
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

    public static List<SchoolEquipmentQuantity> minEquipmentQuantity() {
        List<SchoolEquipmentQuantity> quantityOfEquipments = new ArrayList<>();

        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MIN_EQUIPMENT)) {
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
