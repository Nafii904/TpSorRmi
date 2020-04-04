package service;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.http.Part;

import dao.Database;

public class ServeurRmiImpl extends UnicastRemoteObject implements ServeurRmi {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected ServeurRmiImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean save(String title , Part filePart) throws RemoteException {
		// TODO Auto-generated method stub
		
		Database dataBase = new Database();
		boolean res = false;

        try {
            dataBase.ouvrir();
        } catch (ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        
        try {
        	
			res =  dataBase.savePicture(filePart.getInputStream(), title);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        		
        dataBase.close();
		
		
		return res;
	}
	
	public static void main() {
		
		int port = 1000 ; 
		Registry registry = null ;
		
		try {
			LocateRegistry.createRegistry(port);
			registry = LocateRegistry.getRegistry(port);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			ServeurRmiImpl rmiImpl = new ServeurRmiImpl();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ServeurRmi srmi = null;
		 
		try {
			
			srmi = (ServeurRmi) UnicastRemoteObject.exportObject(srmi, 0);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			registry.rebind("serveurRMI", srmi);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("Serveur rmi lancé");
		 
	 }


}