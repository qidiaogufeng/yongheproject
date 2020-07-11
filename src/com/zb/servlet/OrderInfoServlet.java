package com.zb.servlet;

import com.zb.dao.OrderDao;
import com.zb.pojo.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/orderInfo")
public class OrderInfoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url=request.getRequestURI();
        Integer id = Integer.parseInt(request.getParameter("id"));
//        System.out.println(id);
        OrderDao orderDao = new OrderDao();
        Order order = orderDao.findById(id);
        request.setAttribute("order",order);
        request.getRequestDispatcher("/order_update.jsp").forward(request,response);
    }
}
