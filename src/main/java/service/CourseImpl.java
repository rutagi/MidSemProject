package service;

import java.rmi.RemoteException;
import java.util.List;

import Dao.CourseDao;
import domain.Course;
import interfaces.CourseInterface;

public class CourseImpl implements CourseInterface {
    private CourseDao dao = new CourseDao();

    @Override
    public void insertCourse(Course course) throws RemoteException {
        dao.createcourse(course);
    }

    @Override
    public Course selectCourse(int courseId) throws RemoteException {
        return dao.selectCourse(courseId);
    }

    @Override
    public List<Course> selectAllCourses() throws RemoteException {
        return dao.selectAllCourse();
    }

    @Override
    public boolean deleteCourse(int id) throws RemoteException {
        return dao.deleteCourse(id);
    }

    @Override
    public void updateCourse(Course course) throws RemoteException {
        dao.updateCourse(course);
    }

    @Override
    public List<Course> getCourseByDepAndSemester(int academicUnitId, int semesterId) {
        return dao.getCoursesByAcademicUnitAndSemester(academicUnitId, semesterId);
    }

    @Override
    public List<Course> getCoursesPerStudent(int studentId) throws RemoteException {
        return dao.getCoursesByStudent(studentId);
    }
}
