package lk.ijse.pos.dao.custom;

import lk.ijse.pos.dao.CrudDAO;
import lk.ijse.pos.entity.OrderDetail;

import java.sql.Connection;

public interface OrderDetailDAO extends CrudDAO<Connection, OrderDetail, String> {
}
