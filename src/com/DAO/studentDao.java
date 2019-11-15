package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import com.bean.Student;
import com.util.ConnectionDB1;
import com.inter.interfaceStudent;
import com.util.ConnectionDB2;

public class studentDao  implements interfaceStudent {
    @Override
    public List<Student> getAllStudent(){
        List<Student> list = new ArrayList<Student>();
        Connection conn = ConnectionDB1.getCon();
        String sql = "select * from grade";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Student st = new Student();
                st.setSno(rs.getInt("sno"));
                st.setName(rs.getString("name"));
                st.setTotal(rs.getInt("total"));
                list.add(st);
            }
            rs.close();
            pst.close();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }


    @Override
    public boolean AddStudent(Student student){
        Connection conn1 = ConnectionDB1.getCon();
        Connection coon2 = ConnectionDB2.getCon();
        String sql1 = "insert into grade(sno, name,chinese,math,total) values(?,?,?,?,?)";
        String sql2 = "insert into basic(sno,name,sdept) values(?,?,?)";
        String sql3 = "insert into grade2(学号,姓名,语文,数学,总成绩) values(?,?,?,?,?)";
        String sql4 = "insert into basic2(学号,姓名,专业) values(?,?,?)";
        int i = 0;
        try{
            PreparedStatement pst1 = conn1.prepareStatement(sql1);
            pst1.setInt(1, student.getSno());
            pst1.setString(2, student.getName());
            //pst.setString(3,student.getSdept());
            pst1.setInt(3,student.getChinese());
            pst1.setInt(4,student.getMath());
            pst1.setInt(5, student.getTotal());
            i = pst1.executeUpdate();
            pst1.close();
        } catch (SQLException e){
            e.printStackTrace();
        }

        try {
            PreparedStatement pst2 = conn1.prepareStatement(sql2);
            pst2.setInt(1, student.getSno());
            pst2.setString(2, student.getName());
            pst2.setString(3,student.getSdept());
            pst2.executeUpdate();
            pst2.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try{
            PreparedStatement pst3 = coon2.prepareStatement(sql3);
            pst3.setInt(1, student.getSno());
            pst3.setString(2, student.getName());
            //pst.setString(3,student.getSdept());
            pst3.setInt(3,student.getChinese());
            pst3.setInt(4,student.getMath());
            pst3.setInt(5, student.getTotal());
            pst3.executeUpdate();
            pst3.close();
        } catch (SQLException e){
            e.printStackTrace();
        }

        try {
            PreparedStatement pst4 = coon2.prepareStatement(sql4);
            pst4.setInt(1, student.getSno());
            pst4.setString(2, student.getName());
            pst4.setString(3,student.getSdept());
            pst4.executeUpdate();
            pst4.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return i > 0;
    }

    @Override
    public boolean updateStudent(Student student) throws SQLException {
        Connection conn1 = ConnectionDB1.getCon();
        Connection conn2 = ConnectionDB2.getCon();
        String sql1 = "UPDATE grade set name=?,Chinese=?,Math=?,Total=? WHERE sno = "+student.getSno();
        String sql2 = "UPDATE basic set name=?,sdept=? WHERE sno = "+student.getSno();
        String sql3 = "UPDATE grade2 set 姓名=?,语文=?,数学=?,总成绩=? WHERE 学号 = "+student.getSno();
        String sql4 = "UPDATE basic2 set 姓名=?,专业=? WHERE 学号 = "+student.getSno();
        int i = 0;
        try{
            PreparedStatement pst1 = conn1.prepareStatement(sql1);
            pst1.setString(1, student.getName());
            pst1.setInt(2,student.getChinese());
            pst1.setInt(3,student.getMath());
            pst1.setInt(4,student.getTotal());
            i = pst1.executeUpdate();
            pst1.close();
        } catch (SQLException e){
            e.printStackTrace();
        }

        try{
            PreparedStatement pst2 = conn1.prepareStatement(sql2);
            pst2.setString(1, student.getName());
            pst2.setString(2,student.getSdept());
            pst2.executeUpdate();
            pst2.close();
        } catch (SQLException e){
            e.printStackTrace();
        }

        try{
            PreparedStatement pst3 = conn2.prepareStatement(sql3);
            pst3.setString(1, student.getName());
            pst3.setInt(2,student.getChinese());
            pst3.setInt(3,student.getMath());
            pst3.setInt(4,student.getTotal());
            pst3.executeUpdate();
            pst3.close();
        } catch (SQLException e){
            e.printStackTrace();
        }

        try{
            PreparedStatement pst4 = conn2.prepareStatement(sql4);
            pst4.setString(1, student.getName());
            pst4.setString(2,student.getSdept());
            pst4.executeUpdate();
            pst4.close();
        } catch (SQLException e){
            e.printStackTrace();
        }



        return i > 0;
    }


    @Override
    public boolean deleteStudent(Student student){
        Connection conn1 = ConnectionDB1.getCon();
        Connection conn2 = ConnectionDB2.getCon();
        String sql1 = "DELETE FROM grade where sno = " + student.getSno();
        String sql2 = "DELETE FROM basic where sno = " + student.getSno();
        String SQL1 = "DELETE FROM grade2 where 学号 = " + student.getSno();
        String SQL2 = "DELETE FROM basic2 where 学号 = " + student.getSno();
        int i = 0;
        try{
            PreparedStatement pst1 = conn1.prepareStatement(sql1);
            i = pst1.executeUpdate();
            pst1.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        try {
            PreparedStatement pst2 = conn1.prepareStatement(sql2);
            pst2.executeUpdate();
            pst2.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try{
            PreparedStatement pst1 = conn2.prepareStatement(SQL1);
            i = pst1.executeUpdate();
            pst1.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        try {
            PreparedStatement pst2 = conn2.prepareStatement(SQL2);
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
        String sql1 = "select * from grade";
        String sql2 = "select * from basic";
        try {
            PreparedStatement pst1 = conn1.prepareStatement(sql1);
            ResultSet rs1 = pst1.executeQuery();
            PreparedStatement pst2 = conn1.prepareStatement(sql2);
            ResultSet rs2 = pst2.executeQuery();
            while(rs1.next()&&rs2.next()){
                Student st = new Student();
                st.setSno(rs1.getInt("sno"));
                st.setName(rs1.getString("name"));
                st.setSdept(rs2.getString("sdept"));
                st.setChinese(rs1.getInt("Chinese"));
                st.setMath(rs1.getInt("Math"));
                st.setTotal(rs1.getInt("total"));
                list.add(st);
            }
            rs1.close();
            rs2.close();
            pst1.close();
            pst2.close();
        } catch(SQLException e){
            e.printStackTrace();
        }


        return list;
    }

}
