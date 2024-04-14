package Controller;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import Dao.CourseDao;
import domain.Course;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/Course")
public class CourseServlet extends HttpServlet {
    private CourseDao courseDao;

    @Override
    public void init() throws ServletException {
        super.init();
        courseDao = new CourseDao(); 
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "list":
                listAllCourses(response);
                break;
            case "getCourseById":
                getCourseById(request, response);
                break;
            case "delete":
                deleteCourse(request, response);
                break;
            case "update":
                updateCourse(request, response);
                break;
            default:
                listAllCourses(response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            addCourse(request, response);
        }
    }

    private void listAllCourses(HttpServletResponse response) throws IOException {
        List<Course> courses = courseDao.selectAllCourse();

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.println("[");
        for (int i = 0; i < courses.size(); i++) {
            Course course = courses.get(i);
            out.print("{ \"courseId\": \"" + course.getCourseid() + "\", \"courseName\": \"" + course.getCourseName() + "\" }");
            if (i < courses.size() - 1) {
                out.println(",");
            }
        }
        out.println("]");
    }

    private void getCourseById(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int courseId = Integer.parseInt(request.getParameter("courseId"));
        Course course = courseDao.selectCourse(courseId);

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        if (course != null) {
            out.println("{ \"courseId\": \"" + course.getCourseid() + "\", \"courseName\": \"" + course.getCourseName() + "\" }");
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    private void deleteCourse(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int courseId = Integer.parseInt(request.getParameter("courseId"));
        
        if (courseDao.deleteCourse(courseId)) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    private void updateCourse(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int courseId = Integer.parseInt(request.getParameter("courseId"));
        String updatedName = request.getParameter("updatedName");
        
        Course existingCourse = courseDao.selectCourse(courseId);

        if (existingCourse != null) {
            existingCourse.setCourseName(updatedName);
            courseDao.updateCourse(existingCourse);

            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    private void addCourse(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String courseName = request.getParameter("courseName");

        if (courseName != null && !courseName.isEmpty()) {
            Course newCourse = new Course();
            newCourse.setCourseName(courseName);

            courseDao.createcourse(newCourse);
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
