package lk.ijse.pos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@AllArgsConstructor
@Data
@ToString
public class CustomerDTO {
    String cusId;
    String cusName;
    String address;
    double salary;
}
