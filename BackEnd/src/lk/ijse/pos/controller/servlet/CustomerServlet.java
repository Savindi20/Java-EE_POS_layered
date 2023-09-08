package lk.ijse.pos.controller.servlet;

import lk.ijse.pos.bo.BOFactory;
import lk.ijse.pos.bo.custom.CustomerBO;
import lk.ijse.pos.dto.CustomerDTO;
import lk.ijse.pos.util.MessageUtil;

import javax.json.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {

    private final CustomerBO customerBO = (CustomerBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.CUSTOMER);
    private final MessageUtil messageUtil = new MessageUtil();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JsonArrayBuilder allCustomers = Json.createArrayBuilder();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/posapi", "root", "1234");

            ArrayList<CustomerDTO> all = customerBO.getAllCustomers(connection);
            for (CustomerDTO customerDTO : all) {

                JsonObjectBuilder customer = Json.createObjectBuilder();

                customer.add("id", customerDTO.getCusId());
                customer.add("name", customerDTO.getCusName());
                customer.add("address",customerDTO.getAddress());
                customer.add("salary", customerDTO.getSalary());

                allCustomers.add(customer.build());

            }
            resp.getWriter().print(messageUtil.buildJsonObject("OK", "Successfully Loaded", allCustomers).build());

        }catch (ClassNotFoundException | SQLException e){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().print(messageUtil.buildJsonObject("Error", e.getLocalizedMessage(), "").build());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cusId = req.getParameter("cusId");
        String cusName = req.getParameter("cusName");
        String cusAddress = req.getParameter("cusAddress");
        double cusSalary = Double.parseDouble(req.getParameter("cusSalary"));

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/posapi", "root", "1234");

            customerBO.saveCustomer(connection, new CustomerDTO(cusId, cusName, cusAddress, cusSalary));

            resp.setStatus(200);
            resp.getWriter().print(messageUtil.buildJsonObject("OK", "Successfully Added", "").build());

        } catch (SQLException | ClassNotFoundException e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().print(messageUtil.buildJsonObject("Error", e.getLocalizedMessage(), "").build());

        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cusId = req.getParameter("cusId");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/posapi", "root", "1234");

            customerBO.deleteCustomer(connection, cusId);

            resp.setStatus(200);
            resp.getWriter().print(messageUtil.buildJsonObject("OK", "Successfully Loaded", "").build());

        } catch (SQLException | ClassNotFoundException e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().print(messageUtil.buildJsonObject("Error", e.getLocalizedMessage(), "").build());
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        JsonObject customer = Json.createReader(req.getReader()).readObject();

        String cusId = customer.getString("id");
        String cusName = customer.getString("name");
        String cusAddress = customer.getString("address");
        double cusSalary = Double.parseDouble(customer.getString("cusSalary"));
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/posapi", "root", "1234");

            customerBO.updateCustomer(connection, new CustomerDTO(cusId, cusName, cusAddress, cusSalary));

            resp.setStatus(200);
            resp.getWriter().print(messageUtil.buildJsonObject("OK", "Successfully Updated", "").build());

      } catch (SQLException | ClassNotFoundException e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().print(messageUtil.buildJsonObject("Error", e.getLocalizedMessage(), "").build());
        }
    }
}
