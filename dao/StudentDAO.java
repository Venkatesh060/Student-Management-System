package dao;

import model.Student;
import util.DBUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public void add(Student s) throws Exception {
        try (Connection c = DBUtil.getCon();
             PreparedStatement p = c.prepareStatement("insert into student values(?,?,?,?)")) {
            p.setInt(1, s.id);
            p.setString(2, s.fn);
            p.setString(3, s.type);
            p.setDate(4, s.doj);
            p.executeUpdate();
        }
    }

    public void remove(int id) throws Exception {
        try (Connection c = DBUtil.getCon();
             PreparedStatement p = c.prepareStatement("delete from student where id=?")) {
            p.setInt(1, id);
            p.executeUpdate();
        }
    }

    public void view(int id) throws Exception {
        try (Connection c = DBUtil.getCon();
             PreparedStatement p = c.prepareStatement("select * from student where id=?")) {
            p.setInt(1, id);
            try (ResultSet r = p.executeQuery()) {
                while (r.next())
                    System.out.println(r.getInt(1) + " " + r.getString(2) + " " + r.getString(3) + " " + r.getDate(4));
            }
        }
    }

    public void viewAll(String q) throws Exception {
        try (Connection c = DBUtil.getCon();
             Statement s = c.createStatement();
             ResultSet r = s.executeQuery(q)) {
            while (r.next())
                System.out.println(r.getInt(1) + " " + r.getString(2) + " " + r.getString(3) + " " + r.getDate(4));
        }
    }

    public List<Student> getAll() throws Exception {
        List<Student> list = new ArrayList<>();
        try (Connection c = DBUtil.getCon();
             Statement s = c.createStatement();
             ResultSet r = s.executeQuery("select * from student")) {
            while (r.next())
                list.add(new Student(r.getInt(1), r.getString(2), r.getString(3), r.getDate(4)));
        }
        return list;
    }
}
