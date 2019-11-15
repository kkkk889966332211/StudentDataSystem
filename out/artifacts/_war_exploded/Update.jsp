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
    <title>添加学生</title>
    <!-- Bootstrap core CSS -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <!--link rel="stylesheet" href="first.css" /-->
    <link rel="stylesheet" href="login.css" />
</head>
<body>
<div class="container">
    <form
            action="UpdateStudentServlet"
            method="post">


        <h3>
            <a href="Update.jsp">添加学生</a>
        </h3>

        <label
                for="input1"
                class="sr-only"
        >学号</label>

        <input
                type="text"
                id="input1"
                value="<%=request.getParameter("sno")%>"
                class="form-control"
                placeholder="学号"
                name="sno"
                required>
        <label
                for="input2"
                class="sr-only">姓名</label>

        <input
                type="text"
                id="input2"
                class="form-control"
                placeholder="姓名"
                name="name"
                required>

        <label
                for="input3"
                class="sr-only">专业</label>

        <input
                type="text"
                id="input3"
                class="form-control"
                placeholder="专业"
                name="sdept"
                required>

        <label
                for="input4"
                class="sr-only">语文成绩</label>

        <input
                type="text"
                id="input4"
                class="form-control"
                placeholder="语文成绩"
                name="chinese"
                required>

        <label
                for="input5"
                class="sr-only">数学成绩</label>

        <input
                type="text"
                id="input5"
                class="form-control"
                placeholder="数学成绩"
                name="math"
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
