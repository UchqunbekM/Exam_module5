<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
    <link rel="stylesheet" href="includes/styles.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js"
            integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.min.js"
            integrity="sha384-ODmDIVzN+pFdexxHEHFBQH3/9/vQ9uori45z4JjnFsRydbmQbmL5t1tQ0culUzyK"
            crossorigin="anonymous"></script>
</head>
<style>
    body{
        margin: 100px;
    }
</style>
<body>
<%@include file="nav.html" %>
<c:if test="${message != null}">
    <h1>${message}</h1>
</c:if>

<div class="card">
    <div class="table-title">
        <h2>User's List </h2>
        <a class="btn btn-success" href="add-product">Add New Product
        </a></div>
    <table class="table table-dark mt-4">
        <thead>
        <tr>
            <th>Product's Name</th>
            <th>Category</th>
            <th>Salary</th>
            <th>Image</th>
            <th>Delete</th>
            <th>Update</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${productList}" var="product">
            <tr>
                <td><strong></strong>${product.name}</td>
                <td>${product.getCategory().getName()}</td>
                <td>${product.salary}</td>
                <td><img src="files/${product.getImgUrl()}" style=" width: 100px; height:85px"  alt="${product.getName()} ">
                </td>
                <td>
                    <a class="btn btn-danger" href="delete?id=${product.getId()}"> Delete</a>
                </td>
                <td >
                    <a class="btn btn-warning" href="update?id=${product.getId()}"> Update</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</div>
</body>
</html>
