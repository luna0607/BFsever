package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import service.IOService;
import service.UserService;
import serviceImpl.IOServiceImpl;
import serviceImpl.UserServiceImpl;

public  class DataRemoteObject extends UnicastRemoteObject implements IOService, UserService {

	private static final long serialVersionUID = 4029039744279087114L;
	private IOService iOService;
	private UserService userService;
	 DataRemoteObject() throws RemoteException {
		iOService = new IOServiceImpl();
		userService = new UserServiceImpl();
	}
    @Override
	public ArrayList<String> readFileFullName() throws RemoteException{
		return iOService.readFileFullName();
	}
	@Override
	public boolean writeFile(String file, String userId, String fileName,String time) throws RemoteException{
		// TODO Auto-generated method stub
		return iOService.writeFile(file, userId, fileName,time);
	}

	@Override
	public String readFile(String userId, String fileName) throws RemoteException{
		// TODO Auto-generated method stub
		return iOService.readFile(userId, fileName);
	}

	@Override
	public String readFileList(String userId) throws RemoteException{
		// TODO Auto-generated method stub
		return iOService.readFileList(userId);
	}

	@Override
	public boolean login(String username, String password) throws RemoteException {
		// TODO Auto-generated method stub
		return userService.login(username, password);
	}

	@Override
	public boolean logout(String username) throws RemoteException {
		// TODO Auto-generated method stub
		return userService.logout(username);
	}

}
