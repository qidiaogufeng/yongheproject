package com.zb.servlet;

import com.zb.dao.OrderDao;
import com.zb.pojo.Order;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/orderadd")
public class OrderAddServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String doorname = request.getParameter("doorname");
//        System.out.println(doorname);
        String order_no = request.getParameter("order_no");
        String order_type = request.getParameter("order_type");
        String pnum1 = request.getParameter("pnum");
        Integer pnum = Integer.valueOf(pnum1);
        String cashier = request.getParameter("cashier");
//        String  order_time1 = request.getParameter("order_time");
//        Timestamp order_time = Timestamp.valueOf(order_time1);
//        String pay_time1 = request.getParameter("pay_time");
//        Timestamp pay_time = Timestamp.valueOf(pay_time1);
        String pay_type = request.getParameter("pay_type");
        String price1 = request.getParameter("price");
        Double price = Double.valueOf(price1);
        Order order =new Order();
        order.setDoorname(doorname);
//        order.setDoor_id(door_id);
        order.setOrder_no(order_no);
        order.setOrder_type(order_type);
        order.setPnum(pnum);
        order.setCashier(cashier);
//        order.setOrder_time(order_time);
//        order.setPay_time(pay_time);
        order.setPay_type(pay_type);
        order.setPrice(price);
        OrderDao orderDao =new OrderDao();

        try {
            orderDao.addOrder(order);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect(""+request.getContextPath()+"/orderlist");
    }

}
