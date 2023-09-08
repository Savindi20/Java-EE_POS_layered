package lk.ijse.pos.dao.custom.impl;

import lk.ijse.pos.dao.custom.ItemDAO;
import lk.ijse.pos.entity.Item;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO{
    @Override
    public ArrayList<Item> getAll(Connection connection) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Connection connection, Item dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Connection connection, Item dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Item search(Connection connection, String s) throws SQLException, ClassNotFoundException {
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
