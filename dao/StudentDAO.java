package dao;

import model.Student;
import util.DBUtil;
import java.sql.*;

public class StudentDAO {

    public void add(Student s) throws Exception {
        Connection c = DBUtil.getCon();
        PreparedStatement p =
            c.prepareStatement("insert into student values(?,?,?,?)");
        p.setInt(1, s.id);
        p.setString(2, s.fn);
        p.setString(3, s.type);
        p.setDate(4, s.doj);
        p.executeUpdate();
        c.close();
    }

    public void remove(int id) throws Exception {
        Connection c = DBUtil.getCon();
        PreparedStatement p =
            c.prepareStatement("delete from student where id=?");
        p.setInt(1, id);
        p.executeUpdate();
        c.close();
    }

    public void view(int id) throws Exception {
        Connection c = DBUtil.getCon();
        PreparedStatement p =
            c.prepareStatement("select * from student where id=?");
        p.setInt(1, id);
        ResultSet r = p.executeQuery();
        while (r.next())
            System.out.println(r.getInt(1)+" "+r.getString(2)+" "+r.getString(3)+" "+r.getDate(4));
        c.close();
    }

    public void viewAll(String q) throws Exception {
        Connection c = DBUtil.getCon();
        Statement s = c.createStatement();
        ResultSet r = s.executeQuery(q);
        while (r.next())
            System.out.println(r.getInt(1)+" "+r.getString(2)+" "+r.getString(3)+" "+r.getDate(4));
        c.close();
    }
}
