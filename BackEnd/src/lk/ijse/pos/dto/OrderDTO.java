package lk.ijse.pos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class OrderDTO {
    private String orderId;
    private String cusId;
    private double cost;
    private String orderDate;
    private List<OrderDetailDTO> orderDetails;
}
