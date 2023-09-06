package lk.ijse.pos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderDetailDTO {
    private String orderId;
    private String itemCode;
    private double price;
    private int qty;
}
