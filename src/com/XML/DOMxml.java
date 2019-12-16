package com.XML;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import com.bean.Student;
import com.util.ConnectionDB1;
import com.util.ConnectionDB2;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMxml {
    HashMap<String, String> hash = new HashMap<String, String>();
    ArrayList<ArrayList<String>> lists = new ArrayList();//统一的字段名
    ArrayList<ArrayList<String>> unfields = new ArrayList();//统一的字段名标签
    ArrayList<ArrayList<ArrayList<String>>> allfields = new ArrayList();
    ArrayList<ArrayList<String>> db_table = new ArrayList();
    int db_num, table_num;

    //获取数据库和表的数量
    public void Num() throws Exception {
        //创建DOM文档对象
        DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = dFactory.newDocumentBuilder();
        Document doc;
        doc = builder.parse(new File("D:\\学习\\应用集成\\实验\\网页管理系统尝试\\src\\com\\XML\\student.xml"));

        NodeList nl = doc.getElementsByTagName("DBname");
        db_num = nl.getLength();
        //System.out.println(db_num);
        nl = doc.getElementsByTagName("table_name");
        table_num = nl.getLength();
        //System.out.println(table_num);
    }


    //获取网页显示的统一 字段名 lists
    public void CreateWeb() {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(new File("D:\\学习\\应用集成\\实验\\网页管理系统尝试\\src\\com\\XML\\student.xml"));
            NodeList students = document.getChildNodes();

            for (int i = 0; i < students.getLength(); i++) {
                //x
                Node student = students.item(i);
                //db table
                NodeList userInfo = student.getChildNodes();
                for (int j = 4; j < userInfo.getLength(); j++) {//由于要获取表名，标签是成对出现的所以不需要打印db和table，从4开始
                    if (userInfo.item(j).getNodeName() != "#text") {
                        //获得第二级
                        Node node = userInfo.item(j);
                        //获得第三级
                        NodeList userMeta = node.getChildNodes();
                        //System.out.println(node.getNodeName());
                        ArrayList<String> list = new ArrayList<String>();
                        list.add(node.getNodeName());
                        for (int k = 0; k < userMeta.getLength(); k++) {
                            //System.out.println(userMeta.item(k).getNodeName());fanhui kong
                            if (userMeta.item(k).getNodeName() != "#text") {
                                list.add(userMeta.item(k).getTextContent());
                                //System.out.print(userMeta.item(k).getTextContent());
                            }
                        }
                        lists.add(list);
                    }
                }
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //获取统一的字段标签 unfields
    public void UniformField() {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(new File("D:\\学习\\应用集成\\实验\\网页管理系统尝试\\src\\com\\XML\\student.xml"));
            NodeList users = document.getChildNodes();

            for (int i = 0; i < users.getLength(); i++) {
                //x
                Node user = users.item(i);
                //db table
                NodeList userInfo = user.getChildNodes();
                for (int j = 4; j < userInfo.getLength(); j++) {
                    if (userInfo.item(j).getNodeName() != "#text") {
                        //db
                        Node node = userInfo.item(j);
                        //dbname
                        NodeList userMeta = node.getChildNodes();
                        //System.out.println(node.getNodeName());
                        ArrayList<String> field = new ArrayList();
                        field.add(node.getNodeName());
                        for (int k = 0; k < userMeta.getLength(); k++) {
                            if (userMeta.item(k).getNodeName() != "#text") {
                                //System.out.println(userMeta.item(k).getNodeName());
                                field.add(userMeta.item(k).getNodeName());
                            }
                        }
                        unfields.add(field);
                    }
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //获取所有的字段名
    public void AllFields() throws Exception {
        //创建DOM文档对象
        DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = dFactory.newDocumentBuilder();
        Document doc;


        for (int i = 1; i <= db_num; i++) {
            ArrayList<ArrayList<String>> t = new ArrayList();
            doc = builder.parse(new File("D:\\学习\\应用集成\\实验\\网页管理系统尝试\\src\\com\\XML\\" + i + ".xml"));
            ArrayList<String> db = new ArrayList();
            NodeList nl = doc.getElementsByTagName("DBname");//获取当前数据库所有表数据
            Node classNode = nl.item(0).getFirstChild();//获得数据库名
            db.add(classNode.getNodeValue());
            int count = 1;
            for (ArrayList<String> name : unfields) {
                ArrayList<String> f = new ArrayList();//装字段
                nl = doc.getElementsByTagName("table" + count + "_name");//获得table1下所有节点
                classNode = nl.item(0).getFirstChild();//获得表名
                db.add(classNode.getNodeValue());
                count++;
                for (int j = 1; j < name.size(); j++) {
                    nl = doc.getElementsByTagName(name.get(j));
                    classNode = nl.item(0).getFirstChild();
                    f.add(classNode.getNodeValue());
                }
                t.add(f);
            }
            db_table.add(db);
            allfields.add(t);
        }
    }

    public ArrayList<ArrayList<String>> getDbTable() {
        return db_table;
    }

    public ArrayList<ArrayList<ArrayList<String>>> getAllFiled() throws Exception {
        return allfields;
    }

    public ArrayList<ArrayList<String>> getUniformField() {
        return unfields;
    }

    public ArrayList<ArrayList<String>> getLists() {
        return lists;
    }

    public static void main(String args[]) throws Exception {
        DOMxml doc = new DOMxml();
        doc.Num();
        doc.CreateWeb();
        doc.UniformField();
        doc.AllFields();
        for (int j = 0; j < doc.getAllFiled().size(); j++) {

            System.out.println(doc.getDbTable().get(j).get(1));
        }
        System.out.println(doc.lists);
        System.out.println(doc.unfields);
        System.out.println(doc.allfields);
        System.out.println(doc.db_table);

        System.out.println(doc.getDbTable().get(1).get(1));
        List<Student> list = new ArrayList<Student>();
        Connection conn1 = ConnectionDB1.getCon();
        Connection conn2 = ConnectionDB2.getCon();
        for (int i = 0; i < 2; i++) {
            String sql1 = "select * from " + doc.getDbTable().get(i).get(1);
            try {
                if(i==0) {
                    PreparedStatement pst1 = conn1.prepareStatement(sql1);
                    ResultSet rs1 = pst1.executeQuery();
                    while (rs1.next()) {
                        Student st = new Student();
                        st.setSno(rs1.getInt(doc.getAllFiled().get(i).get(0).get(0)));
                        st.setName(rs1.getString(doc.getAllFiled().get(i).get(0).get(1)));
                        st.setTotal(rs1.getInt(doc.getAllFiled().get(i).get(0).get(5)));
                        list.add(st);
                    }
                    rs1.close();
                    pst1.close();
                }
                else {
                    PreparedStatement pst1 = conn2.prepareStatement(sql1);
                    ResultSet rs1 = pst1.executeQuery();
                    while (rs1.next()) {
                        Student st = new Student();
                        st.setSno(rs1.getInt(doc.getAllFiled().get(i).get(0).get(0)));
                        st.setName(rs1.getString(doc.getAllFiled().get(i).get(0).get(1)));
                        st.setTotal(rs1.getInt(doc.getAllFiled().get(i).get(0).get(5)));
                        list.add(st);
                    }
                    rs1.close();
                    pst1.close();
                }



            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i).getName());
        }
    }
}

