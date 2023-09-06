package lk.ijse.pos.dto;

public class CustomerDTO {
    String cusId;
    String cusName;
    String address;
    double salary;

    public CustomerDTO(String cusId, String cusName, String address, double salary) {
        this.cusId = cusId;
        this.cusName = cusName;
        this.address = address;
        this.salary = salary;
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
