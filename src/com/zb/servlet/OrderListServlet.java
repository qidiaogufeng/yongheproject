package com.zb.servlet;

import com.zb.dao.OrderDao;
import com.zb.pojo.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/orderlist")
public class OrderListServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response){
        System.out.println("订单列表查询");
        OrderDao orderDao = new OrderDao();

        try {
            List<Order> list = orderDao.findAll();
            request.setAttribute("list",list);
            request.getRequestDispatcher("/order_list.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
