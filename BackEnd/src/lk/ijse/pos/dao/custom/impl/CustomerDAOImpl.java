package lk.ijse.pos.dao.custom.impl;

import lk.ijse.pos.dao.SQLUtil;
import lk.ijse.pos.dao.custom.CustomerDAO;
import lk.ijse.pos.entity.Customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public ArrayList<Customer> getAll(Connection connection) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery(connection, "SELECT * FROM Customer");
        ArrayList<Customer> allCustomers = new ArrayList<>();
        while (rst.next()) {
            allCustomers.add(new Customer(rst.getString(1), rst.getString(2), rst.getString(3), rst.getDouble(4)));
        }
        return allCustomers;
    }

    @Override
    public boolean save(Connection connection, Customer entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate(connection, "INSERT INTO Customer VALUES (?,?,?,?)", entity.getCustomerId(), entity.getCustomerName(), entity.getAddress(), entity.getSalary());
    }

    @Override
    public boolean update(Connection connection, Customer dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Customer search(Connection connection, String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean exit(Connection connection, String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(Connection connection, String s) throws SQLException, ClassNotFoundException {
        return false;
    }
}
