package service;

import java.rmi.RemoteException;
import java.util.List;

import Dao.StudentRegDao;
import domain.StudentRegistration;
import interfaces.StudentRegistrationInterface;

public class StudentRegImpl implements StudentRegistrationInterface {
     private StudentRegDao dao = new StudentRegDao();
     @Override
	public void insertStudent(StudentRegistration student) throws RemoteException {
		// TODO Auto-generated method stub
    	 dao.insertStudent(student);
		
	}

	@Override
	public StudentRegistration selectStudent(int studentId) throws RemoteException {
		// TODO Auto-generated method stub
		return dao.selectStudent(studentId);
	}

	@Override
	public List<StudentRegistration> selectAllStudents() throws RemoteException {
		// TODO Auto-generated method stub
		return dao.selectAllStudents();
	}

	@Override
	public boolean deleteStudent(int id) throws RemoteException {
		// TODO Auto-generated method stub
		return dao.deleteStudent(id);
	}

	@Override
	public void updateStudent(StudentRegistration student) throws RemoteException {
		// TODO Auto-generated method stub
		dao.updateStudent(student);
	}

	@Override
	public List<StudentRegistration> studentsperSem(int semid) throws RemoteException {
		// TODO Auto-generated method stub
		return dao.getStudentsRegisteredForSemester(semid);
	}

	@Override
	public List<StudentRegistration> studperSemAndDep(int acid, int semid) throws RemoteException {
		// TODO Auto-generated method stub
		return dao.getStudentsByAcademicUnitAndSemester(semid, semid);
	}

	@Override
	public List<StudentRegistration> studperSemCourse(int courseid, int semid) throws RemoteException {
		// TODO Auto-generated method stub
		return dao.getStudentsByCourseAndSemester(courseid, semid);
	}

}
