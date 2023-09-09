package lk.ijse.pos.bo.custom.impl;

import lk.ijse.pos.bo.custom.PurchaseOrderBO;
import lk.ijse.pos.dto.CustomerDTO;
import lk.ijse.pos.dto.ItemDTO;
import lk.ijse.pos.dto.OrderDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class PurchaseOrderBOImpl implements PurchaseOrderBO {

    @Override
    public boolean purchaseOrder(Connection connection, OrderDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public CustomerDTO searchCustomer(Connection connection, String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ItemDTO searchItem(Connection connection, String code) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean checkItemIsAvailable(Connection connection, String code) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean checkCustomerIsAvailable(Connection connection, String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateNewOrderID(Connection connection) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomers(Connection connection) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<ItemDTO> getAllItems(Connection connection) throws SQLException, ClassNotFoundException {
        return null;
    }
}
