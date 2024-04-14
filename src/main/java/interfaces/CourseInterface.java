package interfaces;

import java.rmi.RemoteException;
import java.util.List;

import domain.Course;

public interface CourseInterface {
	void insertCourse(Course course) throws RemoteException;

	Course selectCourse(int courseId) throws RemoteException;

	List<Course> selectAllCourses() throws RemoteException;

	boolean deleteCourse(int id) throws RemoteException;

	void updateCourse(Course course) throws RemoteException;

	List<Course> getCourseByDepAndSemester(int academicUnitId, int semesterId) throws RemoteException;

	List<Course> getCoursesPerStudent(int studentId) throws RemoteException;
}
