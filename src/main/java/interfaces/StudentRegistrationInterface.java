package interfaces;

import java.rmi.RemoteException;
import java.util.List;

import domain.StudentRegistration;

public interface StudentRegistrationInterface {
	void insertStudent(StudentRegistration student) throws RemoteException;

    StudentRegistration selectStudent(int studentId)throws RemoteException;

    List<StudentRegistration> selectAllStudents()throws RemoteException;

    boolean deleteStudent(int id)throws RemoteException;

    void updateStudent(StudentRegistration student)throws RemoteException;
    List<StudentRegistration>studentsperSem(int semid) throws RemoteException;
    List<StudentRegistration>studperSemAndDep(int acid,int semid) throws RemoteException;
    List<StudentRegistration>studperSemCourse(int courseid, int semid) throws RemoteException;
}
