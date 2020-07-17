package com.zb.servlet;

import com.google.gson.Gson;
import com.zb.dao.DoorDao;
import com.zb.pojo.Door;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/showsale")
public class ShowSaleServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("ShowSaleServlet");
        DoorDao doorDao = new DoorDao();
        List<Door> list = doorDao.showSale();
        System.out.println(list);

        //利用gson将对象转变成JSON格式的字符串
        Gson gson =new Gson();
        String json = gson.toJson(list);
        System.out.println(json);
        response.getWriter().write(json);
    }
}
