package com.example.exam_module5;

import com.example.exam_module5.User.User;
import com.example.exam_module5.User.UserDAo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/login")
public class Login extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        List<User> users = UserDAo.getAllUsers();
        PrintWriter out = resp.getWriter();
        for (User user : users) {
            HttpSession httpSession=req.getSession(true);
            httpSession.setAttribute("IsCreatedSession",true);
            httpSession.setAttribute("name",name);
            if (name.equals("admin") && password.equals("admin")) {
                resp.sendRedirect("/product");
                return;
            } else if (user.getPassword().equals(password)){
                resp.sendRedirect("/products");
            }
        }
        resp.setContentType("text/html");
        out.println("<h1 style=\"color: red\"> Login or Password incorrect!</h1>");
        req.getRequestDispatcher("index.html").include(req, resp);
        out.close();
    }
}