package servlet;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.Database;
import model.Picture;

/**
 * Servlet implementation class GetPicture
 */
@WebServlet("/GetPicture")
public class GetPicture extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetPicture() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Database dataBase = new Database();
		  try {
	            dataBase.ouvrir();
	            
	        } catch (ClassNotFoundException e1) {
	            // TODO Auto-generated catch block
	            e1.printStackTrace();
	        }
	        
		  Blob pictureBlob = null;  
		  
		  byte[] imgData = null;
		  
		  String title =request.getParameter("title");
		  
		  ArrayList<Picture> pictures = dataBase.getPictures();
	
		  for(Picture pic : pictures) {
			  
			  if (pic.getTitle().equals(title)) {
				  
				  	Picture picture = new Picture();
		    		
		    		picture.setTitle(pic.getTitle());
		    	
		    		picture.setPicture(pic.getPicture());
		    		
		    		pictureBlob = picture.getPicture();
		    		
		    
		    		break;
				  
			  }
			  
		  }
		  
		  try {
				// Read Blob
				int pictureBlobLength = (int) pictureBlob.length();  
				imgData = pictureBlob.getBytes(1, pictureBlobLength);
			} 
		  catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		  response.setContentType("image/jpeg"); // Send and return picture
	       OutputStream o = response.getOutputStream();
	       o.write(imgData);       // Write image in outputStream
	       o.flush();
	       o.close();
	       dataBase.close();
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
