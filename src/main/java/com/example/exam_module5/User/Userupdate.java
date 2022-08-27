package com.example.exam_module5.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateuser")
public class Userupdate extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idd=req.getParameter("id");
        int  id= Integer.parseInt(idd);
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        String lastname=req.getParameter("email");
        UserDAoaaa.update(id,username,password, lastname);
        resp.setContentType("text/html");
        resp.sendRedirect("user_view");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
      resp.sendRedirect("user_view");
    }

}
