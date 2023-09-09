package lk.ijse.pos.bo.custom;

import lk.ijse.pos.bo.SuperBO;
import lk.ijse.pos.dto.OrderDetailDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface OrderDetailBO extends SuperBO {
    ArrayList<OrderDetailDTO> getAllOrderDetails() throws SQLException, ClassNotFoundException;
}
