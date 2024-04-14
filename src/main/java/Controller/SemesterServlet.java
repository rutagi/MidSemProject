package Controller;

import Dao.SemesterDao;
import domain.Semester;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;


@WebServlet("/Semester")
public class SemesterServlet extends HttpServlet {
       
	private SemesterDao semesterDao;

    @Override
    public void init() throws ServletException {
        super.init();
        semesterDao = new SemesterDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "list":
                listAllSemesters(response);
                break;
            case "delete":
                deleteSemester(request, response);
                break;
            // Add more cases for additional actions if needed
            default:
                listAllSemesters(response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            addSemester(request, response);
        }
    }

    private void listAllSemesters(HttpServletResponse response) throws IOException {
        List<Semester> semesters = semesterDao.selectAllSemesters();

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.println("[");
        for (int i = 0; i < semesters.size(); i++) {
            Semester semester = semesters.get(i);
            out.print("{ \"semid\": \"" + semester.getSemid() + "\", \"name\": \"" + semester.getName() + "\", \"startdate\": \"" + semester.getStartdate() + "\", \"enddate\": \"" + semester.getEnddate() + "\" }");
            if (i < semesters.size() - 1) {
                out.println(",");
            }
        }
        out.println("]");
    }

    private void deleteSemester(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String idParam = request.getParameter("id");
        if (idParam != null && !idParam.isEmpty()) {
            int id = Integer.parseInt(idParam);
            if (semesterDao.deleteSemester(id)) {
                response.setStatus(HttpServletResponse.SC_OK);
            } else {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    private void addSemester(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("semesterName");
        String startdate = request.getParameter("startDate");
        String enddate = request.getParameter("endDate");

        if (name != null && !name.isEmpty() && startdate != null && !startdate.isEmpty() && enddate != null && !enddate.isEmpty()) {
                LocalDate startDate = LocalDate.parse(startdate);
                LocalDate endDate = LocalDate.parse(enddate);

                Semester newSemester = new Semester();
                newSemester.setName(name);
                newSemester.setStartdate(startDate);
                newSemester.setEnddate(endDate);

                semesterDao.insertSemester(newSemester);

                response.setStatus(HttpServletResponse.SC_CREATED);
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        
    }

    @Override
    public void destroy() {
        super.destroy();
        // Clean up resources like closing connections
    }
}
