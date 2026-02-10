package service;

import dao.StudentDAO;
import model.Student;
import java.sql.Date;

public class StudentService {
    StudentDAO d = new StudentDAO();

    public void addP(int id, String fn, Date doj) throws Exception {
        d.add(new Student(id, fn, "PART", doj));
    }

    public void addF(int id, String fn, Date doj) throws Exception {
        d.add(new Student(id, fn, "FULL", doj));
    }

    public void remove(int id) throws Exception {
        d.remove(id);
    }

    public void view(int id) throws Exception {
        d.view(id);
    }

    public void viewAll() throws Exception {
        d.viewAll("select * from student");
    }

    public void sortById() throws Exception {
        d.viewAll("select * from student order by id");
    }

    public void sortByFn() throws Exception {
        d.viewAll("select * from student order by fn");
    }

    public void sortByDoj() throws Exception {
        d.viewAll("select * from student order by doj");
    }
}
