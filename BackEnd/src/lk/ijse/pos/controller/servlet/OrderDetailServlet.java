package lk.ijse.pos.controller.servlet;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(urlPatterns = "/order_detail")
public class OrderDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/posapi", "root", "1234");
            PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Order_Detail");
            ResultSet rst = pstm.executeQuery();
            JsonArrayBuilder allItems = Json.createArrayBuilder();

            while (rst.next()) {
                JsonObjectBuilder item = Json.createObjectBuilder();
                item.add("orderId", rst.getString("orderId"));
                item.add("code", rst.getString("code"));
                item.add("price", rst.getString("price"));
                item.add("qty", rst.getDouble("qty"));
                allItems.add(item.build());
            }

            JsonObjectBuilder job = Json.createObjectBuilder();
            job.add("state","OK");
            job.add("message","Successfully Loaded..!");
            job.add("data",allItems.build());
            resp.getWriter().print(job.build());

        }catch (ClassNotFoundException | SQLException e){
            JsonObjectBuilder rjo = Json.createObjectBuilder();
            rjo.add("state","Error");
            rjo.add("message",e.getLocalizedMessage());
            rjo.add("data","");
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            resp.getWriter().print(rjo.build());
        }
    }
}
