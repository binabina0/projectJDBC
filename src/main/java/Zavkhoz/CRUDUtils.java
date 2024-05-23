package Zavkhoz;

import equipments.ListOfEquipments;
import equipments.OrderedSchoolEquipment;
import equipments.SchoolEquipment;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CRUDUtils {
    private static final String SELECT_BY_EQUIPMENT = "SELECT * FROM SchoolEquipment WHERE equipment_name = ?";
    private static final String SELECT_BY_SERIAL_NUMBER = "SELECT * FROM SchoolEquipment WHERE serial_number = ?";
    private static final String SELECT_ALL_EQUIPMENT = "SELECT * FROM SchoolEquipment";
    private static final String SELECT_ALL_ORDERED_EQUIPMENT = "SELECT * FROM OrderedSchoolEquipment";
    private static final String INSERT_EQUIPMENT = "INSERT INTO OrderedSchoolEquipment(serial_number, equipment_name, category, quantity, price, ordered_date) VALUES(?, ?, ?, ?, ?, ?)";
    private static final String DELETE_EQUIPMENT = "DELETE FROM OrderedEquipment WHERE id = ?";
    private static final String SELECT_PASSWORD = "SELECT zavkhoz_password FROM Zavkhoz WHERE zavkhoz_username = ?";

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

    public static List<SchoolEquipment> allEquipmentData() {
        List<SchoolEquipment> schoolEquipments = new ArrayList<>();

        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EQUIPMENT)) {
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

    public static List<ListOfEquipments> listOfEquipment() {
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

    public static String zavkhozPassword(String zavkhozName) {
        String password = null;
        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PASSWORD)) {

            preparedStatement.setString(1, zavkhozName);
            preparedStatement.executeQuery();

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                password = rs.getString("zavkhoz_password");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return password;
    }

        public static List<SchoolEquipmentForZavkhoz> getSearchedEquipmentByName (String equipment){
            List<SchoolEquipmentForZavkhoz> searchedEquipments = new ArrayList<>();
            try (Connection connection = DBUtils.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_EQUIPMENT)) {

                preparedStatement.setString(1, equipment);
                preparedStatement.executeQuery();

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
    public static List<SchoolEquipmentForZavkhoz> getSearchedEquipmentBySerialNumber (String equipment){
        List<SchoolEquipmentForZavkhoz> searchedEquipments = new ArrayList<>();
        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_SERIAL_NUMBER)) {

            preparedStatement.setString(1, equipment);
            preparedStatement.executeQuery();

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

    public static List<OrderedSchoolEquipment> saveOrderedEquipment(OrderedSchoolEquipment equipment) {
        List<OrderedSchoolEquipment> equipments = new ArrayList<>();

        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EQUIPMENT)) {

            preparedStatement.setString(1, equipment.getSerialNumber());
            preparedStatement.setString(2, equipment.getEquipmentName());
            preparedStatement.setString(3, equipment.getCategory());
            preparedStatement.setInt(4, equipment.getQuantity());
            preparedStatement.setBigDecimal(5, equipment.getPrice());
            preparedStatement.setDate(8, equipment.getOrderedDate());
            preparedStatement.executeUpdate();

            PreparedStatement orderedEquipments = connection.prepareStatement(SELECT_ALL_ORDERED_EQUIPMENT);
            ResultSet rs = orderedEquipments.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String serialNumber = rs.getString("serial_number");
                String equipmentName = rs.getString("equipment_name");
                String category = rs.getString("category");
                int quantity = rs.getInt("quantity");
                BigDecimal price = rs.getBigDecimal("price");
                BigDecimal deliveryRate = rs.getBigDecimal("delivery_rate");
                BigDecimal totalPrice = rs.getBigDecimal("total_price");
                Date orderedDate = rs.getDate("ordered_date");

                equipments.add(new OrderedSchoolEquipment(id, serialNumber, equipmentName, category, quantity, price, deliveryRate, totalPrice, orderedDate));
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return equipments;
    }
    public static List<OrderedSchoolEquipment> getOrderedEquipmentData() {
        List<OrderedSchoolEquipment> schoolEquipments = new ArrayList<>();

        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ORDERED_EQUIPMENT)) {
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
                Date orderedDate = rs.getDate("ordered_date");

                schoolEquipments.add(new OrderedSchoolEquipment(id, serialNumber, equipmentName, category, quantity, price, deliveryRate, totalPrice, orderedDate));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return schoolEquipments;
    }

    public static List<OrderedSchoolEquipment> deleteEquipment(String equipment) {
        List<OrderedSchoolEquipment> updatedEquipments = new ArrayList<>();

        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EQUIPMENT)) {

            preparedStatement.setString(1, equipment);
            preparedStatement.executeUpdate();

            PreparedStatement allSelect = connection.prepareStatement("SELECT * FROM students");
            ResultSet rs = allSelect.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String serialNumber = rs.getString("serial_number");
                String equipmentName = rs.getString("equipment_name");
                String category = rs.getString("category");
                int quantity = rs.getInt("quantity");
                BigDecimal price = rs.getBigDecimal("price");
                BigDecimal deliveryRate = rs.getBigDecimal("delivery_rate");
                BigDecimal totalPrice = rs.getBigDecimal("total_price");
                Date orderedDate = rs.getDate("ordered_date");
                updatedEquipments.add(new OrderedSchoolEquipment(id, serialNumber, equipmentName, category, quantity, price, deliveryRate, totalPrice, orderedDate));
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return updatedEquipments;
    }
}