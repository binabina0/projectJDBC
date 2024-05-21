package DeliverymanUser;

import Zavkhoz.DBUtils;
import equipments.DeliveredSchoolEquipment;
import equipments.OrderedSchoolEquipment;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CRUDUtils {
    private static final String SELECT_ALL_ORDERED_EQUIPMENT = "SELECT * FROM OrderedSchoolEquipment";
    private static final String SELECT_ALL_DELIVERED_EQUIPMENT = "SELECT * FROM DeliveredSchoolEquipment";
    private static final String INSERT_EQUIPMENT = "INSERT INTO DeliveredSchoolEquipment(serial_number, equipment_name, category, quantity, price, delivery_rate, total_price, purchase_date) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_PASSWORD = "SELECT deliveryman_password FROM Deliveryman WHERE delivery_username = ?";

    private static final String DELETE_EQUIPMENT_BY_NAME_OR_SN = "DELETE FROM OrderedSchoolEquipment WHERE equipment_name = ? OR serial_number = ?";
    private static final String SELECT_EQUIPMENT_BY_NAME_OR_SN = "SELECT * FROM OrderedSchoolEquipment WHERE equipment_name = ? OR serial_number = ?";
    public static String deliverymanPassword(String deliverymanName) {
        String password = null;
        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PASSWORD)) {

            preparedStatement.setString(1, deliverymanName);
            preparedStatement.executeQuery();

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                password = rs.getString("deliveryman_password");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return password;
    }

    public static List<OrderedEquipmentName> getOrederedEquipmentNameList (){
        List<OrderedEquipmentName> orderedEquipmentsName = new ArrayList<>();
        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ORDERED_EQUIPMENT)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String serialNumber = rs.getString("serial_number");
                String equipmentName = rs.getString("equipment_name");
                String category = rs.getString("category");
                Date purchaseDate = rs.getDate("purchase_date");
                orderedEquipmentsName.add(new OrderedEquipmentName(id, serialNumber, equipmentName, category, purchaseDate));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orderedEquipmentsName;
    }
    public static List<OrderedEquipmentQuantity> getOrderedEquipmentQuantity (){
        List<OrderedEquipmentQuantity> orderedEquipmentQuantities = new ArrayList<>();
        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ORDERED_EQUIPMENT)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String serialNumber = rs.getString("serial_number");
                String equipmentName = rs.getString("equipment_name");
                String category = rs.getString("category");
                int quantity = rs.getInt("quantity");
                Date purchaseDate = rs.getDate("purchase_date");
                orderedEquipmentQuantities.add(new OrderedEquipmentQuantity(id, serialNumber, equipmentName, category, quantity, purchaseDate));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orderedEquipmentQuantities;
    }

    public static List<DeliveredEquipmentQuantity> getDeliveredEquipmentQuantity (){
        List<DeliveredEquipmentQuantity> deliveredEquipmentQuantities = new ArrayList<>();
        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DELIVERED_EQUIPMENT)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String serialNumber = rs.getString("serial_number");
                String equipmentName = rs.getString("equipment_name");
                String category = rs.getString("category");
                int quantity = rs.getInt("quantity");
                Date deliveredDate = rs.getDate("delivered_date");
                deliveredEquipmentQuantities.add(new DeliveredEquipmentQuantity(id, serialNumber, equipmentName, category, quantity, deliveredDate));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return deliveredEquipmentQuantities;
    }

    public static List<DeliverymansDeliveryRate> getDeliverymansDeliveryRate(){
        List<DeliverymansDeliveryRate> deliverymansDeliveryRates = new ArrayList<>();
        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DELIVERED_EQUIPMENT)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String serialNumber = rs.getString("serial_number");
                String equipmentName = rs.getString("equipment_name");
                String category = rs.getString("category");
                int quantity = rs.getInt("quantity");
                BigDecimal deliveryRate = rs.getBigDecimal("delivery_rate");
                deliverymansDeliveryRates.add(new DeliverymansDeliveryRate(id, serialNumber, equipmentName, category, quantity, deliveryRate));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return deliverymansDeliveryRates;
    }

    public static List<DeliveredSchoolEquipment> saveDeliveredEquipment(String equipmentIdentifier) {
        List<DeliveredSchoolEquipment> deliveredEquipments = new ArrayList<>();
        OrderedSchoolEquipment equipment = null;

        try (Connection connection = DBUtils.getConnection()) {
           PreparedStatement selectStmt = connection.prepareStatement(SELECT_EQUIPMENT_BY_NAME_OR_SN);
                selectStmt.setString(1, equipmentIdentifier);
                selectStmt.setString(2, equipmentIdentifier);
                ResultSet selectedById = selectStmt.executeQuery();
                while (selectedById.next()) {
                    equipment = new OrderedSchoolEquipment(
                            selectedById.getInt("id"),
                            selectedById.getString("serial_number"),
                            selectedById.getString("equipment_name"),
                            selectedById.getString("category"),
                            selectedById.getInt("quantity"),
                            selectedById.getBigDecimal("price"),
                            selectedById.getBigDecimal("delivery_rate"),
                            selectedById.getBigDecimal("total_price"),
                            selectedById.getDate("purchase_date")
                    );
                }

                try (PreparedStatement deleteStmt = connection.prepareStatement(DELETE_EQUIPMENT_BY_NAME_OR_SN)) {
                    deleteStmt.setString(1, equipment.getEquipmentName());
                    deleteStmt.setString(2, equipment.getSerialNumber());
                    deleteStmt.executeUpdate();

                 PreparedStatement insertStmt = connection.prepareStatement(INSERT_EQUIPMENT);
                    insertStmt.setString(1, equipment.getSerialNumber());
                    insertStmt.setString(2, equipment.getEquipmentName());
                    insertStmt.setString(3, equipment.getCategory());
                    insertStmt.setInt(4, equipment.getQuantity());
                    insertStmt.setBigDecimal(5, equipment.getPrice());
                    insertStmt.setBigDecimal(6, equipment.getDeliveryRate());
                    insertStmt.setBigDecimal(7, equipment.getTotalPrice());
                    insertStmt.setDate(8, new Date(System.currentTimeMillis()));
                    insertStmt.executeUpdate();


                PreparedStatement deliveredEquipmentsStmt = connection.prepareStatement(SELECT_ALL_DELIVERED_EQUIPMENT);
                    ResultSet rs = deliveredEquipmentsStmt.executeQuery();
                    while (rs.next()) {
                        deliveredEquipments.add(new DeliveredSchoolEquipment(
                                rs.getInt("id"),
                                rs.getString("serial_number"),
                                rs.getString("equipment_name"),
                                rs.getString("category"),
                                rs.getInt("quantity"),
                                rs.getBigDecimal("price"),
                                rs.getBigDecimal("delivery_rate"),
                                rs.getBigDecimal("total_price"),
                                rs.getDate("delivered_date")
                        ));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return deliveredEquipments;
    }

        public static List<DeliveredSchoolEquipment> getDeliveredEquipmentData() {
        List<DeliveredSchoolEquipment> schoolEquipments = new ArrayList<>();

        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DELIVERED_EQUIPMENT)) {
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
                Date deliveredDate = rs.getDate("delivered_date");

                schoolEquipments.add(new DeliveredSchoolEquipment(id, serialNumber, equipmentName, category, quantity, price, deliveryRate, totalPrice, deliveredDate));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return schoolEquipments;
    }

}
