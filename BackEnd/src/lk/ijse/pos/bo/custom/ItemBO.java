package lk.ijse.pos.bo.custom;

import lk.ijse.pos.dto.ItemDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBO {
    ArrayList<ItemDTO> getAllItems(Connection connection) throws SQLException, ClassNotFoundException;

    void deleteItems(Connection connection, String id) throws SQLException, ClassNotFoundException;

    void saveItem(Connection connection, ItemDTO itemDTO) throws SQLException, ClassNotFoundException;

    void updateItem(Connection connection, ItemDTO itemDTO) throws SQLException, ClassNotFoundException;

    boolean exitsItem(Connection connection, String id) throws SQLException, ClassNotFoundException;
}
