package com.example.exam_module5.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/delete")


public class DeleteProduct extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String sid = req.getParameter("id");
        int id;
        if (sid!=null) {
         id = Integer.parseInt(sid);

          Boolean delete = ProductDao.deleteProduct(id);

            if (delete) {
                resp.sendRedirect("/product?delet=true");
            }
            return;
        }
        req.setAttribute("to","delete");
        req.getRequestDispatcher("/product").forward(req,resp);
    }
}
