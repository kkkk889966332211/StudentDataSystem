package com.servlet;

import com.DAO.userDao;
import com.bean.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class DeleteServlet extends HttpServlet {


    public DeleteServlet() {
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
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
        User user = new User();
        user.setId(id);
        System.out.println("delete name:"+user.getUsername());
        userDao ud = new userDao();
        if(ud.deleteUser(user)){
            request.getRequestDispatcher("success.jsp").forward(request, response);
        }
        else {
            response.sendRedirect("success.jsp");
        }
    }

    /**
     * Initialization of the servlet.
     *
     * @throws ServletException if an error occurs
     */
    public void init() throws ServletException {

    }
}
