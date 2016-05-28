package serviceImpl;

import java.rmi.RemoteException;

import service.UserService;

public class UserServiceImpl implements UserService{
	private String username1="admin";
	private String password1="123456";
	@Override
	public boolean login(String username, String password) throws RemoteException {
		System.out.println(username);
		System.out.println(password);
		return username.equals(username1)&&password.equals(password1);
	}

	@Override
	public boolean logout(String username) throws RemoteException {
		return username.equals(username1);
	}

}
