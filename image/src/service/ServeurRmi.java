package service;

import java.rmi.Remote;
import java.rmi.RemoteException;

import javax.servlet.http.Part;

public interface ServeurRmi extends Remote {
	
	public boolean save(String title , Part filePart) throws RemoteException;

}
