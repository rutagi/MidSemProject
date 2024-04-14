package service;

import java.rmi.RemoteException;
import java.util.List;

import Dao.StudentDao;
import domain.Student;
import interfaces.StudentInterface;

public class StudentImpl implements StudentInterface {
    private StudentDao dao = new StudentDao();
	@Override
	public void insertStudent(Student student) throws RemoteException {
		// TODO Auto-generated method stub
		dao.insertStudent(student);
	}

	@Override
	public Student selectStudent(int studentId) throws RemoteException {
		// TODO Auto-generated method stub
		return dao.selectStudent(studentId);
	}

	@Override
	public List<Student> selectAllStudents() throws RemoteException {
		// TODO Auto-generated method stub
		return dao.selectAllStudents();
	}

	@Override
	public boolean deleteStudent(int id) throws RemoteException {
		// TODO Auto-generated method stub
		return dao.deleteStudent(id);
	}

	@Override
	public void updateStudent(Student student) throws RemoteException {
		// TODO Auto-generated method stub
		dao.updateStudent(student);
	}

	@Override
	public Student authenticate(String email, String password) throws RemoteException {
		// TODO Auto-generated method stub
		return dao.authenticate(email, password);
	}
	

}
