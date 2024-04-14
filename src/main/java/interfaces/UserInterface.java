package interfaces;

import java.rmi.RemoteException;

import domain.User;

public interface UserInterface {
	void insertUser(User user) throws RemoteException;
    User getUserByEmail(String email) throws RemoteException;
} 
