package Zavkhoz;

import equipments.SchoolEquipment;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CRUDUtils {
    private static String SELECT_BY_EQUIPMENT = "SELECT * WHERE equipment_name = ? FROM SchoolEquipment";
    private static String SELECT_BY_SERIAL_NUMBER = "SELECT * WHERE serial_number = ? FROM SchoolEquipment";
    private static String SELECT_ALL_EQUIPMENT = "SELECT * FROM SchoolEquipment";
    private static String INSERT_EQUIPMENT = "INSERT INTO SchoolEquipment(serial_number, equipment_name, category, quantity, price, delivery_rate, total_price, purchase_date) VALUES(?, ?, ?, ?, ?, ?, ?, ?);";

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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return schoolEquipments;
    }

    public static List<ListOfEquipments> getListOfEquipment(ListOfEquipments equipments) {
        List<ListOfEquipments> schoolEquipments = new ArrayList<>();

        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EQUIPMENT)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String serialNumber = rs.getString("serial_number");
                String equipmentName = rs.getString("equipment_name");
                String category = rs.getString("category");

                schoolEquipments.add(new ListOfEquipments(id, serialNumber, equipmentName, category));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return schoolEquipments;
    }

        public static List<SchoolEquipmentForZavkhoz> getSearchedEquipmentByName (SchoolEquipmentForZavkhoz equipment){
            List<SchoolEquipmentForZavkhoz> searchedEquipments = new ArrayList<>();
            try (Connection connection = DBUtils.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_EQUIPMENT)) {
                ResultSet rs = preparedStatement.executeQuery();

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String serialNumber = rs.getString("serial_number");
                    String equipmentName = rs.getString("equipment_name");
                    String category = rs.getString("category");
                    int quantity = rs.getInt("quantity");
                    Date purchaseDate = rs.getDate("purchase_date");
                    searchedEquipments.add(new SchoolEquipmentForZavkhoz(id, serialNumber, equipmentName, category, quantity, purchaseDate));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return searchedEquipments;
        }
        public static List<SchoolEquipment> getSearchedEquipmentBySerialNumber (SchoolEquipment equipment){
            List<SchoolEquipment> searchedEquipments = new ArrayList<>();
            try (Connection connection = DBUtils.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_SERIAL_NUMBER)) {
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
                    searchedEquipments.add(new SchoolEquipment(id, serialNumber, equipmentName, category, quantity, price, deliveryRate, totalPrice, purchaseDate));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return searchedEquipments;
        }

    public static List<SchoolEquipment> saveEquipment(SchoolEquipment equipment) {
        List<SchoolEquipment> equipments = new ArrayList<>();

        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EQUIPMENT)) {

            preparedStatement.setString(1, equipment.getSerialNumber());
            preparedStatement.setString(2, equipment.getEquipmentName());
            preparedStatement.setString(3, equipment.getCategory());
            preparedStatement.setInt(4, equipment.getQuantity());
            preparedStatement.setBigDecimal(5, equipment.getPrice());
            preparedStatement.setBigDecimal(6, equipment.getDeliveryRate());
            preparedStatement.setBigDecimal(7, equipment.getTotalPrice());
            preparedStatement.setDate(8, equipment.getPurchaseDate());
            preparedStatement.executeUpdate();

            equipments = getEquipmentData(SELECT_ALL_EQUIPMENT);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return equipments;
    }
}