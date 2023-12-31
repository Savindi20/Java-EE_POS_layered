package lk.ijse.pos.dao.custom.impl;

import lk.ijse.pos.dao.SQLUtil;
import lk.ijse.pos.dao.custom.ItemDAO;
import lk.ijse.pos.entity.Item;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO{
    @Override
    public ArrayList<Item> getAll(Connection connection) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery(connection, "SELECT * FROM Item");
        ArrayList<Item> allItems = new ArrayList<>();
        while (rst.next()) {
            allItems.add(new Item(rst.getString(1), rst.getString(2), rst.getInt(3), rst.getDouble(4)));
        }
        return allItems;
    }

    @Override
    public boolean save(Connection connection, Item entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate(connection, "INSERT INTO Item VALUES (?,?,?,?)", entity.getCode(), entity.getName(), entity.getQty(), entity.getPrice());
    }

    @Override
    public boolean update(Connection connection, Item entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate(connection, "UPDATE Item SET name=?, qty=?, price=? WHERE code=?", entity.getName(), entity.getQty(), entity.getPrice(), entity.getCode());
    }

    @Override
    public Item search(Connection connection, String code) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery(connection, "SELECT * FROM Item WHERE code=?", code);
        if (rst.next()) {
            return new Item(rst.getString(1), rst.getString(2), rst.getInt(3), rst.getDouble(4));
        }
        return null;
    }

    @Override
    public boolean exit(Connection connection, String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(Connection connection, String code) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate(connection, "DELETE FROM Item WHERE code=?", code);
    }
}
