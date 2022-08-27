<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title> Update Product</title>
    <link rel="stylesheet" href="webjars/bootstrap/5.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.14.0-beta2/css/bootstrap-select.min.css">
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.14.0-beta2/js/bootstrap-select.min.js"></script>
</head>
<body>
<h1>Update Product</h1>
<div class="row">
    <div class="col-md-6 offset-3">
        <form action="/update" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <input value="${product.getId()}" type="hidden" name="id">
                <label for="title">Title:</label>
                <input id="title" value="${product.getName()}" type="text" name="title">
            </div>
            <div class="form-group">
                <label for="salary">Salary:</label>
                <input id="salary" name="salary">${product.getSalary()}</div>
            <div class="form-group">
                <label for="categoryId">Select category:</label>
                <select id="categoryId" name="categoryId " required>
                    <option disabled value="0">Select category:</option>
                    <c:forEach items="${categoryList}" var="category">
                        <option value="${category.getId()}">${category.getName()}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="image">Upload cover image:</label>
                <input id="image" value="null" type="file" placeholder="Select Photo" name="image">
            </div>
            <div class="form-group">
                <input type="submit" value="Save">
            </div>
        </form>
    </div>
</div>
</body>
</html>