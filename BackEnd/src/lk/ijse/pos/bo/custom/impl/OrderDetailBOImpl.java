package lk.ijse.pos.bo.custom.impl;

import lk.ijse.pos.bo.SuperBO;
import lk.ijse.pos.bo.custom.OrderDetailBO;
import lk.ijse.pos.dto.OrderDetailDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailBOImpl implements OrderDetailBO, SuperBO {
    @Override
    public ArrayList<OrderDetailDTO> getAllOrderDetails() throws SQLException, ClassNotFoundException {
        return null;
    }
}
