package lk.ijse.pos.bo.custom;

import lk.ijse.pos.dto.CustomerDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBO {
    ArrayList<CustomerDTO> getAllCustomer(Connection connection) throws SQLException, ClassNotFoundException;

    boolean saveCustomer(Connection connection, CustomerDTO customerDTO) throws SQLException, ClassNotFoundException;

    boolean updateCustomer(Connection connection, CustomerDTO customerDTO) throws SQLException, ClassNotFoundException;

    boolean exitsCustomer(Connection connection, String id) throws SQLException, ClassNotFoundException;

    void deleteCustomer(Connection connection, String id) throws SQLException, ClassNotFoundException;

    String generateNewCustomerId(Connection connection) throws SQLException, ClassNotFoundException;

    ArrayList<CustomerDTO> filterCustomers(Connection connection, String field, String value) throws SQLException, ClassNotFoundException;
}