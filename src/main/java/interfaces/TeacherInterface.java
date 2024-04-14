package interfaces;

import java.rmi.RemoteException;
import java.util.List;

import domain.Teacher;

public interface TeacherInterface {
	  void insertTeacher(Teacher teacher)throws RemoteException;

	   Teacher selectTeacher(int teacherId)throws RemoteException;

	   List<Teacher> selectAllTeachers()throws RemoteException;

	   boolean deleteTeacher(int id)throws RemoteException;

	   void updateTeacher(Teacher teacher)throws RemoteException;
}
