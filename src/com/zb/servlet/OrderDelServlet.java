package com.zb.servlet;

import com.zb.dao.OrderDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/orderDelete")
public class OrderDelServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request,HttpServletResponse response) throws IOException {
        System.out.println("Go To Here !");
        String id1 = request.getParameter("id");
        Integer id = Integer.valueOf(id1);
        System.out.println(id);
        OrderDao orderDao = new OrderDao();
        orderDao.deleteById(id);
        response.sendRedirect(""+request.getContextPath()+"/orderlist");
    }
}
