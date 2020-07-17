package com.zb.servlet;

import com.google.gson.Gson;
import com.zb.dao.OrderDao;
import com.zb.pojo.JsonResult;
import com.zb.pojo.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/dopage")
public class DoPageServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //当前页
        Integer pageOn = Integer.parseInt(request.getParameter("page"));
        //每页显示几条
        Integer pageSize = Integer.parseInt(request.getParameter("limit"));
        OrderDao orderDao = new OrderDao();
        List<Order> list = orderDao.dopage(pageOn,pageSize);
        Integer count = orderDao.pagecount();
        JsonResult jr = new JsonResult(0,"成功",count,list);
        Gson gson = new Gson();
        String json = gson.toJson(jr);
        System.out.println(json);
        response.getWriter().write(json);
    }


}
