package lk.ijse.pos.dto;

public class ItemDTO {
    private String code;
    private String name;
    private int qtyOnHand;
    private double price;

    public ItemDTO(String code, String name, int qtyOnHand, double price) {
        this.code = code;
        this.name = name;
        this.qtyOnHand = qtyOnHand;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQtyOnHand() {
        return qtyOnHand;
    }

    public void setQtyOnHand(int qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
