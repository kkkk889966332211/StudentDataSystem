package com.inter;

import com.bean.Student;

import java.sql.SQLException;
import java.util.List;

public interface interfaceStudent {
    public List<Student> getAllStudent() throws Exception;
    public boolean updateStudent(Student student) throws SQLException;
    public boolean deleteStudent(Student student);
    public boolean AddStudent(Student student);
    public List<Student> getAllStudentDetails();
    public String getClass(int sno);
}
