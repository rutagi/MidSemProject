package interfaces;

import java.rmi.RemoteException;
import java.util.List;

import domain.Student;

public interface StudentInterface {
    void insertStudent(Student student)throws RemoteException;

    Student selectStudent(int studentId)throws RemoteException;

    List<Student> selectAllStudents()throws RemoteException;
    boolean deleteStudent(int id)throws RemoteException;

    void updateStudent(Student student)throws RemoteException;
    Student authenticate(String email, String password) throws RemoteException;
}
