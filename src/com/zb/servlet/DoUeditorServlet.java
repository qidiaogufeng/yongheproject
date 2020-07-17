package com.zb.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/doueditor")
public class DoUeditorServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String data = request.getParameter("content");
        System.out.println(data);//此处可连接并传入数据库

        request.setAttribute("data",data);
        request.getRequestDispatcher("/daily.jsp").forward(request,response);
    }
}
