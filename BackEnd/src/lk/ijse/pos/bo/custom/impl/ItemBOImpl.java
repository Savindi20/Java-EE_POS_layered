package lk.ijse.pos.bo.custom.impl;

import lk.ijse.pos.bo.SuperBO;
import lk.ijse.pos.bo.custom.ItemBO;
import lk.ijse.pos.dao.DAOFactory;
import lk.ijse.pos.dao.custom.ItemDAO;
import lk.ijse.pos.dto.ItemDTO;
import lk.ijse.pos.entity.Item;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOImpl implements ItemBO, SuperBO {
    ItemDAO itemDAO = (ItemDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ITEM);

    @Override
    public ArrayList<ItemDTO> getAllItems(Connection connection) throws SQLException, ClassNotFoundException {
        ArrayList<Item> all = itemDAO.getAll(connection);
        ArrayList<ItemDTO> allItems = new ArrayList<>();
        for (Item item :
                all) {
            allItems.add(new ItemDTO(item.getCode(), item.getName(), item.getQty(), item.getPrice()));
        }
        return allItems;
    }

    @Override
    public void deleteItems(Connection connection, String id) throws SQLException, ClassNotFoundException {

    }

    @Override
    public void saveItem(Connection connection, ItemDTO itemDTO) throws SQLException, ClassNotFoundException {

    }

    @Override
    public void updateItem(Connection connection, ItemDTO itemDTO) throws SQLException, ClassNotFoundException {

    }

    @Override
    public boolean exitsItem(Connection connection, String id) throws SQLException, ClassNotFoundException {
        return false;
    }
}
