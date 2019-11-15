<%--
  Created by IntelliJ IDEA.
  User: lzx666
  Date: 2018/8/6
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>登录</title>
  <!-- Bootstrap core CSS -->
  <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom styles for this template -->
  <!--link rel="stylesheet" href="first.css" /-->
  <link rel="stylesheet" href="login.css" />
</head>
<body>
<div class="container">
  <form
          action="loginServlet"
          method="post">

    <h3>
      <a href="index.jsp">用户登陆</a>
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

    <button
            class="btn btn-lg btn-primary btn-block"
            type="submit"
            id="submit">登录</button>

    <a
            href="zhuce.jsp">注册</a>
  </form>
</div>

<div id="footer">
  <a target="_blank"
     href="https://github.com/LouZhiX">
    <img src="byr.jpg"
         width="30px"
         height="20px" class="img-circle">Copyright</a>
  by lzx.
</div>
<script>
  var error ='<%=request.getParameter("error")%>';
  if(error == 'yes'){
    alert("账号或者密码错误!");
  }
</script>
</body>
</html>
