package lk.ijse.pos.bo.custom.impl;

import lk.ijse.pos.bo.SuperBO;
import lk.ijse.pos.bo.custom.ItemBO;
import lk.ijse.pos.dto.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOImpl implements ItemBO, SuperBO {
    @Override
    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public void deleteItems(String id) throws SQLException, ClassNotFoundException {

    }

    @Override
    public void saveItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {

    }

    @Override
    public void updateItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {

    }

    @Override
    public boolean exitsItem(String id) throws SQLException, ClassNotFoundException {
        return false;
    }
}
