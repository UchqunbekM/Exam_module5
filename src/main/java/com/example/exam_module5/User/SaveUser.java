package com.example.exam_module5.User;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/SaveLog")
public class SaveUser extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String name = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User user=new User();
        user.setUsername(name);
        user.setPassword(password);
        user.setEmail(email);
        UserDAoaaa.save_user(user);
        resp.sendRedirect("/product");
    }
}
