package com.servlet;

import com.DAO.studentDao;
import com.bean.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class AdStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");    //设置请求数据的字符编码格式
        int sno = Integer.parseInt(request.getParameter("sno"));
        String name = request.getParameter("name"); //获得请求表单中的姓名
        String sdept = request.getParameter("sdept");
        int Chinese = Integer.parseInt(request.getParameter("Chinese"));  //获得请求表单中的语文成绩
        int Math = Integer.parseInt(request.getParameter("Math"));
        //int Total = Integer.parseInt(request.getParameter("TotalGrade"));
        Student student = new Student();
        student.setSno(sno);
        student.setName(name);
        student.setSdept(sdept);
        student.setChinese(Chinese);
        student.setMath(Math);
        student.setTotal(Chinese+Math);
        studentDao sd = new studentDao();
        if(sd.AddStudent(student)){
            request.getRequestDispatcher("success.jsp").forward(request, response);
        }
        else {
            response.sendRedirect("success.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    public void init() throws ServletException {
        // Put your code here
    }
}
