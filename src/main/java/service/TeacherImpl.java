package service;

import java.rmi.RemoteException;
import java.util.List;

import Dao.TeacherDao;
import domain.Teacher;
import interfaces.TeacherInterface;

public class TeacherImpl implements TeacherInterface {
     private TeacherDao  dao = new TeacherDao();
     @Override
	public void insertTeacher(Teacher teacher) throws RemoteException {
		// TODO Auto-generated method stub
    	 dao.insertTeacher(teacher);
		
	}

	@Override
	public Teacher selectTeacher(int teacherId) throws RemoteException {
		// TODO Auto-generated method stub
		return dao.selectTeacher(teacherId);
	}

	@Override
	public List<Teacher> selectAllTeachers() throws RemoteException {
		// TODO Auto-generated method stub
		return dao.selectAllTeachers();
	}

	@Override
	public boolean deleteTeacher(int id) throws RemoteException {
		// TODO Auto-generated method stub
		return dao.deleteTeacher(id);
	}

	@Override
	public void updateTeacher(Teacher teacher) throws RemoteException {
		// TODO Auto-generated method stub
		dao.updateTeacher(teacher);
	}
 
}
