package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.XML.DOMxml;
import com.bean.Student;
import com.sun.java.browser.plugin2.DOM;
import com.util.ConnectionDB1;
import com.inter.interfaceStudent;
import com.util.ConnectionDB2;

public class studentDao  implements interfaceStudent {
    /*
    @Override
    public List<Student> getAllStudent(){
        List<Student> list = new ArrayList<Student>();
        Connection conn1 = ConnectionDB1.getCon();
        Connection conn2 = ConnectionDB2.getCon();
        String sql1 = "select * from grade1";
        String sql2 = "select * from grade2";
        try {
            PreparedStatement pst1 = conn1.prepareStatement(sql1);
            PreparedStatement pst2 = conn2.prepareStatement(sql2);
            ResultSet rs1 = pst1.executeQuery();
            ResultSet rs2 = pst2.executeQuery();
            while(rs1.next()){
                Student st = new Student();
                st.setSno(rs1.getInt("学号"));
                st.setName(rs1.getString("姓名"));
                st.setTotal(rs1.getInt("总成绩"));
                list.add(st);
            }
            rs1.close();
            pst1.close();

            while(rs2.next()){
                Student st = new Student();
                st.setSno(rs2.getInt("sno"));
                st.setName(rs2.getString("name"));
                st.setTotal(rs2.getInt("total"));
                list.add(st);
            }
            rs2.close();
            pst2.close();

        } catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public String getClass(int sno){
        String classname = "创造营一班";
        if(sno>2000){
            classname = "创造营二班";
        }
        return classname;
    }


    @Override
    public boolean AddStudent(Student student){
        Connection conn1 = ConnectionDB1.getCon();
        Connection coon2 = ConnectionDB2.getCon();
        String sql1 = "insert into grade1(sno, name,sdept,chinese,math,total) values(?,?,?,?,?,?)";
        String sql2 = "insert into grade2(学号,姓名,专业,语文,数学,总成绩) values(?,?,?,?,?,?)";
       // String sql4 = "insert into basic2(学号,姓名,专业) values(?,?,?)";
        int i = 0;
        try{
            PreparedStatement pst1 = conn1.prepareStatement(sql1);
            pst1.setInt(1, student.getSno());
            pst1.setString(2, student.getName());
            pst1.setString(3,student.getSdept());
            pst1.setInt(4,student.getChinese());
            pst1.setInt(5,student.getMath());
            pst1.setInt(6, student.getTotal());
            i = pst1.executeUpdate();
            pst1.close();
        } catch (SQLException e){
            e.printStackTrace();
        }

        try {
            PreparedStatement pst2 = coon2.prepareStatement(sql2);
            pst2.setInt(1, student.getSno());
            pst2.setString(2, student.getName());
            pst2.setString(3,student.getSdept());
            pst2.setInt(4,student.getChinese());
            pst2.setInt(5,student.getMath());
            pst2.setInt(6, student.getTotal());
            pst2.executeUpdate();
            pst2.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return i > 0;
    }

    @Override
    public boolean updateStudent(Student student) throws SQLException {
        Connection conn1 = ConnectionDB1.getCon();
        Connection conn2 = ConnectionDB2.getCon();

        //String sql2 = "UPDATE basic set name=?,sdept=? WHERE sno = "+student.getSno();
        String sql1 = "UPDATE grade1 set 姓名=?,专业=?,语文=?,数学=?,总成绩=? WHERE 学号 = "+student.getSno();
        String sql2 = "UPDATE grade2 set name=?,sdept=?,Chinese=?,Math=?,Total=? WHERE sno = "+student.getSno();
        //String sql4 = "UPDATE basic2 set 姓名=?,专业=? WHERE 学号 = "+student.getSno();
        int i = 0;
        try{
            PreparedStatement pst1 = conn1.prepareStatement(sql1);
            pst1.setString(1, student.getName());
            pst1.setString(2,student.getSdept());
            pst1.setInt(3,student.getChinese());
            pst1.setInt(4,student.getMath());
            pst1.setInt(5,student.getTotal());
            i = pst1.executeUpdate();
            pst1.close();
        } catch (SQLException e){
            e.printStackTrace();
        }


        try{
            PreparedStatement pst2 = conn2.prepareStatement(sql2);
            pst2.setString(1, student.getName());
            pst2.setString(2,student.getSdept());
            pst2.setInt(3,student.getChinese());
            pst2.setInt(4,student.getMath());
            pst2.setInt(5,student.getTotal());
            pst2.executeUpdate();
            pst2.close();
        } catch (SQLException e){
            e.printStackTrace();
        }



        return i > 0;
    }


    @Override
    public boolean deleteStudent(Student student){
        Connection conn1 = ConnectionDB1.getCon();
        Connection conn2 = ConnectionDB2.getCon();
        String sql1 = "DELETE FROM grade1 where 学号 = " + student.getSno();
        String sql2 = "DELETE FROM grade2 where sno = " + student.getSno();
        int i = 0;
        try{
            PreparedStatement pst1 = conn1.prepareStatement(sql1);
            i = pst1.executeUpdate();
            pst1.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

        try {
            PreparedStatement pst2 = conn2.prepareStatement(sql2);
            pst2.executeUpdate();
            pst2.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return i > 0;
    }

    public List<Student> getAllStudentDetails(){
        List<Student> list = new ArrayList<Student>();
        Connection conn1 = ConnectionDB1.getCon();
        Connection conn2 = ConnectionDB2.getCon();
        String sql1 = "select * from grade1";
        String sql2 = "select * from grade2";

        try {
            PreparedStatement pst1 = conn1.prepareStatement(sql1);
            ResultSet rs1 = pst1.executeQuery();
            PreparedStatement pst2 = conn2.prepareStatement(sql2);
            ResultSet rs2 = pst2.executeQuery();

            while(rs1.next()){
                Student st = new Student();
                st.setSno(rs1.getInt("学号"));
                st.setName(rs1.getString("姓名"));
                st.setSdept(rs1.getString("专业"));
                st.setChinese(rs1.getInt("语文"));
                st.setMath(rs1.getInt("数学"));
                st.setTotal(rs1.getInt("总成绩"));
                list.add(st);
            }
            rs1.close();
            pst1.close();

            while(rs2.next()){
                Student st = new Student();
                st.setSno(rs2.getInt("sno"));
                st.setName(rs2.getString("name"));
                st.setSdept(rs2.getString("sdept"));
                st.setChinese(rs2.getInt("Chinese"));
                st.setMath(rs2.getInt("Math"));
                st.setTotal(rs2.getInt("total"));
                list.add(st);
            }

            rs2.close();
            pst2.close();


        } catch(SQLException e){
            e.printStackTrace();
        }


        return list;
    }
*/
    @Override
    public List<Student> getAllStudent() throws Exception {
        List<Student> list = new ArrayList<Student>();
        Connection conn1 = ConnectionDB1.getCon();
        Connection conn2 = ConnectionDB2.getCon();
        DOMxml dom = new DOMxml();
        dom.Num();
        dom.CreateWeb();
        dom.UniformField();
        dom.AllFields();
        for(int i= 0 ;i<2;i++) {
            String sql1 = "select * from " + dom.getDbTable().get(i).get(1);
            try {
                if(i==0) {
                    PreparedStatement pst1 = conn1.prepareStatement(sql1);
                    ResultSet rs1 = pst1.executeQuery();
                    while (rs1.next()) {
                        Student st = new Student();
                        st.setSno(rs1.getInt(dom.getAllFiled().get(i).get(0).get(0)));
                        st.setName(rs1.getString(dom.getAllFiled().get(i).get(0).get(1)));
                        st.setTotal(rs1.getInt(dom.getAllFiled().get(i).get(0).get(5)));
                        System.out.println(dom.getAllFiled().get(i).get(0).get(0));
                        System.out.println(dom.getAllFiled().get(i).get(0).get(1));
                        System.out.println(dom.getAllFiled().get(i).get(0).get(5));
                        list.add(st);
                        System.out.println(st);
                    }
                    rs1.close();
                    pst1.close();
                }
                else {
                    PreparedStatement pst1 = conn2.prepareStatement(sql1);
                    ResultSet rs1 = pst1.executeQuery();
                    while (rs1.next()) {
                        Student st = new Student();
                        st.setSno(rs1.getInt(dom.getAllFiled().get(i).get(0).get(0)));
                        st.setName(rs1.getString(dom.getAllFiled().get(i).get(0).get(1)));
                        st.setTotal(rs1.getInt(dom.getAllFiled().get(i).get(0).get(5)));
                        list.add(st);
                    }
                    rs1.close();
                    pst1.close();
                }



            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
            return list;
    }

    @Override
    public String getClass(int sno){
        String classname = "创造营一班";
        if(sno>2000){
            classname = "创造营二班";
        }
        return classname;
    }


    @Override
    public boolean AddStudent(Student student){
        Connection conn1 = ConnectionDB1.getCon();
        Connection coon2 = ConnectionDB2.getCon();
        String sql1 = "insert into grade1(sno, name,sdept,chinese,math,total) values(?,?,?,?,?,?)";
        String sql2 = "insert into grade2(学号,姓名,专业,语文,数学,总成绩) values(?,?,?,?,?,?)";
        // String sql4 = "insert into basic2(学号,姓名,专业) values(?,?,?)";
        int i = 0;
        try{
            PreparedStatement pst1 = conn1.prepareStatement(sql1);
            pst1.setInt(1, student.getSno());
            pst1.setString(2, student.getName());
            pst1.setString(3,student.getSdept());
            pst1.setInt(4,student.getChinese());
            pst1.setInt(5,student.getMath());
            pst1.setInt(6, student.getTotal());
            i = pst1.executeUpdate();
            pst1.close();
        } catch (SQLException e){
            e.printStackTrace();
        }

        try {
            PreparedStatement pst2 = coon2.prepareStatement(sql2);
            pst2.setInt(1, student.getSno());
            pst2.setString(2, student.getName());
            pst2.setString(3,student.getSdept());
            pst2.setInt(4,student.getChinese());
            pst2.setInt(5,student.getMath());
            pst2.setInt(6, student.getTotal());
            pst2.executeUpdate();
            pst2.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return i > 0;
    }

    @Override
    public boolean updateStudent(Student student) throws SQLException {
        Connection conn1 = ConnectionDB1.getCon();
        Connection conn2 = ConnectionDB2.getCon();

        //String sql2 = "UPDATE basic set name=?,sdept=? WHERE sno = "+student.getSno();
        String sql1 = "UPDATE grade1 set 姓名=?,专业=?,语文=?,数学=?,总成绩=? WHERE 学号 = "+student.getSno();
        String sql2 = "UPDATE grade2 set name=?,sdept=?,Chinese=?,Math=?,Total=? WHERE sno = "+student.getSno();
        //String sql4 = "UPDATE basic2 set 姓名=?,专业=? WHERE 学号 = "+student.getSno();
        int i = 0;
        try{
            PreparedStatement pst1 = conn1.prepareStatement(sql1);
            pst1.setString(1, student.getName());
            pst1.setString(2,student.getSdept());
            pst1.setInt(3,student.getChinese());
            pst1.setInt(4,student.getMath());
            pst1.setInt(5,student.getTotal());
            i = pst1.executeUpdate();
            pst1.close();
        } catch (SQLException e){
            e.printStackTrace();
        }


        try{
            PreparedStatement pst2 = conn2.prepareStatement(sql2);
            pst2.setString(1, student.getName());
            pst2.setString(2,student.getSdept());
            pst2.setInt(3,student.getChinese());
            pst2.setInt(4,student.getMath());
            pst2.setInt(5,student.getTotal());
            pst2.executeUpdate();
            pst2.close();
        } catch (SQLException e){
            e.printStackTrace();
        }



        return i > 0;
    }


    @Override
    public boolean deleteStudent(Student student){
        Connection conn1 = ConnectionDB1.getCon();
        Connection conn2 = ConnectionDB2.getCon();
        String sql1 = "DELETE FROM grade1 where 学号 = " + student.getSno();
        String sql2 = "DELETE FROM grade2 where sno = " + student.getSno();
        int i = 0;
        try{
            PreparedStatement pst1 = conn1.prepareStatement(sql1);
            i = pst1.executeUpdate();
            pst1.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

        try {
            PreparedStatement pst2 = conn2.prepareStatement(sql2);
            pst2.executeUpdate();
            pst2.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return i > 0;
    }

    public List<Student> getAllStudentDetails() {
        List<Student> list = new ArrayList<Student>();
        Connection conn1 = ConnectionDB1.getCon();
        Connection conn2 = ConnectionDB2.getCon();
        String sql1 = "select * from grade1";
        String sql2 = "select * from grade2";

        try {
            PreparedStatement pst1 = conn1.prepareStatement(sql1);
            ResultSet rs1 = pst1.executeQuery();
            PreparedStatement pst2 = conn2.prepareStatement(sql2);
            ResultSet rs2 = pst2.executeQuery();

            while (rs1.next()) {
                Student st = new Student();
                st.setSno(rs1.getInt("学号"));
                st.setName(rs1.getString("姓名"));
                st.setSdept(rs1.getString("专业"));
                st.setChinese(rs1.getInt("语文"));
                st.setMath(rs1.getInt("数学"));
                st.setTotal(rs1.getInt("总成绩"));
                list.add(st);
            }
            rs1.close();
            pst1.close();

            while (rs2.next()) {
                Student st = new Student();
                st.setSno(rs2.getInt("sno"));
                st.setName(rs2.getString("name"));
                st.setSdept(rs2.getString("sdept"));
                st.setChinese(rs2.getInt("Chinese"));
                st.setMath(rs2.getInt("Math"));
                st.setTotal(rs2.getInt("total"));
                list.add(st);
            }

            rs2.close();
            pst2.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return list;
    }
}
