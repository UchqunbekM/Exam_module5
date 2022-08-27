package com.example.exam_module5.Product;

import com.example.exam_module5.Category.Category;
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
import java.net.URLDecoder;
import java.util.List;

import static com.example.exam_module5.utils.Util.UPLOAD_DIRECTORY;

@WebServlet("/update")
@MultipartConfig(maxFileSize = 10_000_000)
public class UpdateProduct extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String sid = req.getParameter("id");
        int id;
        if (sid != null) {
            id = Integer.parseInt(sid);
            Product product = ProductDao.getProductInfo(id);
            List<Category> categoryList = CategoryDao.getAllCategories();
            req.setAttribute("product", product);
            req.setAttribute("categoryList", categoryList);
            req.getRequestDispatcher("updateproduct.jsp").forward(req, resp);
        }
        req.setAttribute("to", "update");
        req.getRequestDispatcher("/product").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        String name = req.getParameter("title");
        Integer salary = Integer.valueOf(req.getParameter("salary"));
        Long categoryId = Long.valueOf(req.getParameter("categoryId"));
        Part imagePart = req.getPart("image");
        Product product = Product.builder()
                .id(id)
                .name(name)
                .salary(salary)
                .categoryId(categoryId)
                .imgUrl(uploadAndGetImageUrl(imagePart))
                .build();
        Boolean update = ProductDao.updateProduct(product);
        if (update) {
            resp.sendRedirect("/product?update=true");
        }
    }

    private String uploadAndGetImageUrl(Part imagePart) {
        try {
            String contextPath = getServletContext().getContextPath();
            File uploadDir = new File(UPLOAD_DIRECTORY, URLDecoder.decode(contextPath, "UTF-8"));
            if (!uploadDir.exists())
                uploadDir.mkdir();
            int index = imagePart.getSubmittedFileName().lastIndexOf('.');
            String extension = imagePart.getSubmittedFileName().substring(index + 1);
            String uploadDirPath = uploadDir.getPath();
            long longtime = System.currentTimeMillis();
            String imgPath = "D:\\library-management-system\\src\\main\\webapp\\images" + "\\" +
                    longtime + "." + extension;
            imagePart.write(imgPath);
            uploadDirPath = uploadDirPath.substring(1);
            uploadDirPath += "\\" + longtime + "." + extension;
            String img=uploadDirPath.substring(51);

            System.out.println(img);
            return img;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}