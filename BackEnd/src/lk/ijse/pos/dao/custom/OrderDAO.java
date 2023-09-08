package lk.ijse.pos.dao.custom;

import lk.ijse.pos.dao.CrudDAO;
import lk.ijse.pos.entity.Order;

import java.sql.Connection;

public interface OrderDAO extends CrudDAO<Connection, Order, String>{
}
