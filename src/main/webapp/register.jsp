<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>Login</title>
  <link rel="stylesheet" href="includes/style_form.css">

</head>
<body>
<div class="login-box" >
  <h2>Login</h2>
  <form action="/updateuser" method="post" id="my">
<c:forEach var="list" items="${list}">
    <div class="user-box" >
      <input type="text"  value="${list.username}" name="username" required="">
      <label>Username</label>
    </div>
        <input value="${list.id}" name="id" hidden >
    <div class="user-box">
      <input type="email" value="${list.email}" name="email" required="">
      <label>Email</label>
    </div>
    <div class="user-box">
      <input type="password" value="${list.password}" name="password" required="">
      <label>Password</label>
    </div>
    <a onclick="document.getElementById('my').submit();">
      <span></span>
      <span></span>
      <span></span>
      <span></span>
      Save User
    </a>
  </c:forEach>
  </form>
</div>
</body>
</html>
