package lk.ijse.pos.controller.servlet;

import lk.ijse.pos.bo.BOFactory;
import lk.ijse.pos.bo.custom.ItemBO;
import lk.ijse.pos.dto.ItemDTO;
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

@WebServlet(urlPatterns = "/item")
public class ItemServlet extends HttpServlet {
    private final MessageUtil messageUtil = new MessageUtil();
    ItemBO itemBO = (ItemBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ITEM);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        JsonArrayBuilder allItems = Json.createArrayBuilder();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/posapi", "root", "1234");

            ArrayList<ItemDTO> items = itemBO.getAllItems(connection);
            for (ItemDTO item : items) {
                JsonObjectBuilder jsonItem = Json.createObjectBuilder();

                jsonItem.add("code", item.getCode());
                jsonItem.add("name", item.getName());
                jsonItem.add("qty", item.getQtyOnHand());
                jsonItem.add("price", item.getPrice());

                allItems.add(jsonItem.build());
            }
            resp.setStatus(200);
            resp.getWriter().print(messageUtil.buildJsonObject("OK","Successfully Loaded..!",allItems).build());

        }catch (ClassNotFoundException | SQLException e){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().print(messageUtil.buildJsonObject("OK",e.getLocalizedMessage(),"").build());
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("code");
        String name = req.getParameter("itemName");
        int qty = Integer.parseInt(req.getParameter("qtyOnHand"));
        double price = Double.parseDouble(req.getParameter("price"));

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/posapi", "root", "1234");

            if (itemBO.saveItem(connection, new ItemDTO(code, name, qty, price))) {
                resp.setStatus(200);
                resp.getWriter().print(messageUtil.buildJsonObject("OK","Successfully Added", "").build());
            }
        } catch (SQLException | ClassNotFoundException e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().print(messageUtil.buildJsonObject("Error",e.getLocalizedMessage(), "").build());

        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("code");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/posapi", "root", "1234");
            PreparedStatement pstm = connection.prepareStatement("DELETE FROM Item WHERE code=?");

            pstm.setString(1, code);

            resp.setStatus(200);
            resp.getWriter().print(messageUtil.buildJsonObject("OK", "Successfully Deleted", "").build());

        } catch (SQLException | ClassNotFoundException e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().print(messageUtil.buildJsonObject("Error", e.getLocalizedMessage(), "").build());
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JsonReader reader = Json.createReader(req.getReader());
        JsonObject item = reader.readObject();

        String code = item.getString("code");
        String name = item.getString("itemName");
        int qty = item.getInt("qtyOnHand");
        double price = Double.parseDouble(item.getString("price"));

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/posapi", "root", "1234");
            if (itemBO.updateItem(connection, new ItemDTO(code, name, qty, price))){
                resp.setStatus(200);
                resp.getWriter().print(messageUtil.buildJsonObject("OK", "Successfully Updated", "").build());
            }

        } catch (SQLException | ClassNotFoundException e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().print(messageUtil.buildJsonObject("Error", e.getLocalizedMessage(), "").build());
        }
    }
}