package com.example.exam_module5.Product;

import com.example.exam_module5.Category.CategoryDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;

import static com.example.exam_module5.utils.Util.UPLOAD_DIRECTORY;


@WebServlet("/add-product")
@MultipartConfig(maxFileSize = 10_000_000)
public class AddProduct extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("categoryList", CategoryDao.getAllCategories());
        req.getRequestDispatcher("/add-product.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        Integer salary = Integer.valueOf(req.getParameter("salary"));
        Long categoryId = Long.valueOf(req.getParameter("categoryId"));
        Part imagePart = req.getPart("image");
        Product product = Product.builder()
                .name(title)
                .salary(salary)
                .categoryId(categoryId)
                .imgUrl(uploadAndGetImageUrl(imagePart))
                .build();
        boolean result = ProductDao.addProduct(product);
        if (result) {
            resp.sendRedirect("/product?added=true");
        }
    }

    private String uploadAndGetImageUrl(Part imagePart) {
        try {

            File uploadDir = new File(UPLOAD_DIRECTORY);
            if (!uploadDir.exists())
                uploadDir.mkdir();
            int index = imagePart.getSubmittedFileName().lastIndexOf('.');
            String extension = imagePart.getSubmittedFileName().substring(index + 1);
            String imgName = System.currentTimeMillis() + "." + extension;
            String imgPath = uploadDir.getPath() + "/" + imgName;
            imagePart.write(imgPath);
            return imgName;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
