<%--
  Created by IntelliJ IDEA.
  User: lzx666
  Date: 2018/8/6
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.DAO.userDao"%>
<%@ page import="com.bean.User"%>
<%@ page import="java.util.List" %>
<%@ page import="com.DAO.studentDao"%>
<%@ page import="com.bean.Student"%>

<html>

<head>
    <title>R1SE数据库显示</title>
    <!--link rel="stylesheet" href="first.css" /-->
    <link rel="stylesheet" href="login.css" />
</head>
<style>
    table
    {
        width: 60%;
    }
    .data{
        color:black;
        border:2px solid RGB(73,161,225);
        border-collapse: collapse;
        font-size:17px;
    }
    .data caption{
        font-size: 22px;
        font-weight: bold;
    }
    .data td
    {
        vertical-align: middle;
        text-align: center;
    }
    .data th{
        color: cornflowerblue;
    }
    .data tr{
        background-color: #C0C0C0;
    }
</style>
<body>
<div style="text-align: center;">
    <table class="data" border="4">
        <caption style="color: #177cb0">数据库信息</caption>
        <thead>
        <tr>
            <th>学号</th>
            <th>姓名</th>
            <th>成绩</th>
            <th>删除操作</th>
            <th>查看详情</th>

        </tr>
        </thead>
        <tbody align="center" valign="middle">
        <%
            /*userDao ud = new userDao();
            List<User> users1 = ud.getAllUsers();
            for(User p: users1){*/
            studentDao studentDao = new studentDao();
            List<Student> students = studentDao.getAllStudent();
            for(Student student: students){
        %>
        <tr>
            <td><%=student.getSno() %></td>
            <td><%=student.getName() %></td>
            <td><%=student.getTotal() %></td>
            <td><a href="DStudentServlet?sno=<%=student.getSno()%>">删除</a></td>
            <td><a href="details.jsp">详情</a> </td>

        </tr>
        </tbody>
        <%} %>
    </table>
</div>
<button><a href="register.jsp">新增</a></button>
</body>
</html>
