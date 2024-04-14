package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.StudentDao;
import domain.Student;

@WebServlet("/Student")
public class StudentServlet extends HttpServlet {
    
private StudentDao studentDao;
@Override
public void init() throws ServletException {
    super.init();
    studentDao = new StudentDao();
}
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
        
        }
        switch (action) {
            case "list":
                listAllStudents( response);
                break;
            case "delete":
                deleteStudent(request,response);
                break;
            default:
                 listAllStudents(response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
         if ("add".equals(action)) {
            addStudent(request, response);
           }
         }

    private void listAllStudents(HttpServletResponse response) throws IOException {
        List<Student> students = studentDao.selectAllStudents();
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.println("[");
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            out.print( "{\"id\": \"" + student.getId() + "\", \"regNo\": \"" + student.getRegNo() + "\", \"firstName\": \"" + student.getFirstName() + "\",\"lastName\": \"" + student.getLastName() + "\",\"email\": \"" + student.getEmail() + "\",\"phone\": \"" + student.getPhone() + "\", \"dob\": \"" + student.getDob() + "\"}");
            if (i < students.size() - 1) {
                out.println(",");
            }
        }
        out.println("]");
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        if (id  != null && id.isEmpty()) {
            int studentId = Integer.parseInt(id);
            if (studentDao.deleteStudent(studentId)){
           response.setStatus(HttpServletResponse.SC_OK);
        }else{
                   response.setStatus(HttpServletResponse.SC_NOT_FOUND);
           }
       
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
    private void addStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String regNo = request.getParameter("regNo");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String dob = request.getParameter("dob");
        String password = request.getParameter("password");

        if (regNo != null && !regNo.isEmpty() && firstName != null && !firstName.isEmpty() && lastName != null && !lastName.isEmpty() &&
                email != null && !email.isEmpty() && phone != null && !phone.isEmpty() && dob != null && !dob.isEmpty() &&
                password != null && !password.isEmpty()) {

            try {
                LocalDate dateOfBirth = LocalDate.parse(dob);

                Student newStudent = new Student();
                newStudent.setRegNo(regNo);
                newStudent.setFirstName(firstName);
                newStudent.setLastName(lastName);
                newStudent.setEmail(email);
                newStudent.setPhone(phone);
                newStudent.setDob(dob);
                newStudent.setPassword(password);

                studentDao.insertStudent(newStudent);

                response.setStatus(HttpServletResponse.SC_CREATED);
            } catch (DateTimeParseException e) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            } catch (Exception e) { 
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
               e.printStackTrace();
            }
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
  @Override
    public void destroy() {
        super.destroy();
        
    }
}
