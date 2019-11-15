package com.servlet;

import com.DAO.studentDao;
import com.bean.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DStudentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int sno = Integer.parseInt(request.getParameter("sno"));
        System.out.println(sno);
        Student student = new Student();
        student.setSno(sno);
        System.out.println("delete name:"+student.getName());
        studentDao sd = new studentDao();
        if(sd.deleteStudent(student)){
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

    }
}
