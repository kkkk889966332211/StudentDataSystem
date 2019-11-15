package com.servlet;

import com.DAO.studentDao;
import com.bean.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UpdateStudentServlet")
public class UpdateStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");    //设置请求数据的字符编码格式
        Student student = new Student();
        System.out.println("执行到此处");
        int sno = Integer.parseInt(request.getParameter("sno"));
        System.out.println(request.getParameter("sno"));
        System.out.println(request.getParameter("name"));
        String name = request.getParameter("name"); //获得请求表单中的姓名

        System.out.println(request.getParameter("sdept"));
        String sdept = request.getParameter("sdept");
        System.out.println(request.getParameter("chinese"));
        int Chinese = Integer.parseInt(request.getParameter("chinese"));  //获得请求表单中的语文成绩
        int Math = Integer.parseInt(request.getParameter("math"));
        //int Total = Integer.parseInt(request.getParameter("TotalGrade"));
        student.setSno(sno);
        student.setName(name);
        student.setSdept(sdept);
        student.setChinese(Chinese);
        student.setMath(Math);
        student.setTotal(Chinese+Math);

        studentDao sd = new studentDao();
        try {
            if(sd.updateStudent(student)){
                request.getRequestDispatcher("details.jsp").forward(request, response);
            }
            else {
                response.sendRedirect("details.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
