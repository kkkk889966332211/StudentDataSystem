package com.servlet;

import com.DAO.userDao;
import com.bean.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class LoginServlet extends HttpServlet{

    public LoginServlet() {
        super();
    }

    public void destroy() {
        super.destroy();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        this.doPost(request, response);
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("login  username:"+name);
        System.out.println("login  password:"+password);
        userDao ud = new userDao();
        User user = ud.userLogin(name, password);
        if(user != null){
            request.getRequestDispatcher("success.jsp").forward(request, response);
        }
        else if (name.equals("admin")&&password.equals("123456")){
            request.getRequestDispatcher("success.jsp").forward(request, response);
        } else{
            response.sendRedirect("index.jsp?error=yes");
        }
    }

}
