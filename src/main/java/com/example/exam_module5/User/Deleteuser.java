package com.example.exam_module5.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/deleteuser")
public class Deleteuser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("id");
        int  idd= Integer.parseInt(id);
        UserDao.deleteuser(idd);
        PrintWriter out=resp.getWriter();
        resp.setContentType("text/html");
        req.getRequestDispatcher("user_view").include(req, resp);
        out.close();
    }
}
