package app;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import dao.StudentDAO;
import model.Student;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

@WebServlet("/addStudent")
public class StudentServlet extends HttpServlet {

    private StudentDAO studentDAO;

    @Override
    public void init() throws ServletException {
        studentDAO = new StudentDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Parse parameters matching the DAO's expectation
            int id = Integer.parseInt(request.getParameter("id"));
            String firstName = request.getParameter("firstname");
            String type = request.getParameter("type");
            Date doj = Date.valueOf(request.getParameter("doj")); // Format: yyyy-mm-dd

            // Create Student object using the constructor defined in model.Student
            Student student = new Student(id, firstName, type, doj);

            studentDAO.add(student);

            response.sendRedirect("addStudent");
        } catch (Exception e) {
            throw new ServletException("Error adding student", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Prevent browser caching
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        try {
            if (studentDAO == null) {
                studentDAO = new StudentDAO();
            }
            List<Student> list = studentDAO.getAll();

            out.println("<html><head><title>Student List</title><link rel='stylesheet' href='styles.css'></head><body>");
            out.println("<h2>All Students</h2>");
            out.println("<table border='1' cellpadding='10'><tr><th>ID</th><th>Name</th><th>Type</th><th>DOJ</th></tr>");
            if (list.isEmpty()) {
                out.println("<tr><td colspan='4'>No students found in database.</td></tr>");
            } else {
                for(Student s : list) {
                    out.println("<tr><td>" + s.id + "</td><td>" + s.fn + "</td><td>" + s.type + "</td><td>" + s.doj + "</td></tr>");
                }
            }
            out.println("</table>");
            out.println("<br><a href='index.html'>Add New Student</a>");
            out.println("</body></html>");
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<p>Error: " + e.getMessage() + "</p>");
        }
    }
}