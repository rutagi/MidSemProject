package service;

import java.rmi.RemoteException;

import Dao.UserDao;
import domain.User;
import interfaces.UserInterface;

public class UserImpl implements UserInterface {
     private  UserDao dao = new UserDao();
	@Override
	public void insertUser(User user) throws RemoteException {
		// TODO Auto-generated method stub
		dao.insertUser(user);
	}
	@Override
	public User getUserByEmail(String email) throws RemoteException {
		// TODO Auto-generated method stub
		return dao.getUserByEmail(email);
	}
	

}
