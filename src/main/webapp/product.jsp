
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Product</title>
    <link rel="stylesheet" href="webjars/bootstrap/5.1.3/css/bootstrap.min.css">
</head>
<body>
<%@include file="navuser.html" %>
<section class="container mt-4 ">
    <c:if test="${message != null}">
        <h1>${message}</h1>
    </c:if>

    <div class="row justify-content-around">

        <c:forEach items="${productList}" var="product">
            <div class="card my-4 text-center shadow col-md-3" style="width: 18rem;">
                <img src="files/${product.getImgUrl()}" style="align-items: center" class="card-img-top" alt="${product.getName()} ">
                <div class="card-body">
                    <h5 class="card-title">${product.getName()}</h5>
                    <p class="card-text">${product.getCategory().getName()}</p>
                    <p class="card-text">${product.getSalary()}</p>
                </div>
            </div>
        </c:forEach>
    </div>
</section>
</body>
</html>
