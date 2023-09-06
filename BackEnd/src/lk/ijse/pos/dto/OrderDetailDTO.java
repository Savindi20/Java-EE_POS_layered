package lk.ijse.pos.dto;

public class OrderDetailDTO {
    private String orderId;
    private String itemCode;
    private double price;
    private int qty;

    public OrderDetailDTO(String orderId, String itemCode, double price, int qty) {
        this.orderId = orderId;
        this.itemCode = itemCode;
        this.price = price;
        this.qty = qty;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
