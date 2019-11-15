<%--
  Created by IntelliJ IDEA.
  User: lzx666
  Date: 2018/8/14
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <!-- Bootstrap core CSS -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <!--link rel="stylesheet" href="first.css" /-->
    <link rel="stylesheet" href="login.css" />
</head>
<body>
<div class="container">
    <form
            action="registerServlet"
            method="post">

        <h3>
            <a href="success.jsp">用户注册</a>
        </h3>

        <label
                for="input"
                class="sr-only">用户名</label>

        <input
                type="text"
                id="input"
                class="form-control"
                placeholder="用户名"
                name="username"
                required>

        <label
                for="inputPassword"
                class="sr-only">密码</label>

        <input
                type="password"
                id="inputPassword"
                class="form-control"
                placeholder="密码"
                name="password"
                required>
        <label
                for="inputPassword1"
                class="sr-only">确认密码</label>

        <input
                type="password"
                id="inputPassword1"
                class="form-control"
                placeholder="确认密码"
                name="password"
                required>

        <button
                class="btn btn-lg btn-primary btn-sm"
                type="submit"
        >确  认</button>

        <button
                class="btn btn-lg btn-primary btn-sm"
                type="reset"
        >取  消</button>
        <button
                class="btn btn-lg btn-primary btn-sm"
                type="button"
                onclick="window.location='details.jsp'"
        >返  回</button>
    </form>

</div>
</body>
</html>
