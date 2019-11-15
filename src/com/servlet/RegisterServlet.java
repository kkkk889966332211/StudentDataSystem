package com.servlet;


import com.DAO.userDao;
import com.bean.User;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class RegisterServlet extends HttpServlet {


    public RegisterServlet() {
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
        request.setCharacterEncoding("UTF-8");    //设置请求数据的字符编码格式
        String name = request.getParameter("username"); //获得请求表单中的用户名
        String pwd = request.getParameter("password");  //获得请求表单中的密码
        System.out.println("register name:"+name);
        System.out.println("register password:"+pwd);
        User user = new User();
        user.setUsername(name);
        user.setPassword(pwd);
        userDao ud = new userDao();
        if(ud.register(user)){
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        else {
            response.sendRedirect("index.jsp");
        }
    }

    /**
     * Initialization of the servlet. <br>
     *
     * @throws ServletException if an error occurs
     */
    public void init() throws ServletException {
        // Put your code here
    }
}
