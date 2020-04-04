package dao;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Picture;

public class Database {
	Connection co = null;

    public boolean ouvrir() throws ClassNotFoundException {
        boolean res = false;
        try {
            System.out.println("driver");
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("driver fin");
            co = DriverManager.getConnection("jdbc:mysql://localhost:3306/image", "root", "");
            res = true;
            System.out.println("ouverture de la base de donnée image :)");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Erreur Base.ouvrir " + e.getMessage());
        }
        return res;
    }

    public boolean close() {
        boolean res = false;
        if (co != null) try {
            co.close();
            res = true;
            System.out.println("fermeture de la base de donnée journal :)");
        } catch (Exception e) {
        }
        return res;
    }
    
    


    public boolean savePicture(InputStream inputStream, String title) throws SQLException {

        String sql = "INSERT INTO image(image,titre) VALUES(?,?) ";
        ResultSet rst = null;
        FileInputStream fis = null;
        System.out.println("input");
        PreparedStatement ps = co.prepareStatement(sql);
        System.out.println("inpu2t2");

        if (inputStream != null) {
            // fetches input stream of the upload file for the blob column
            System.out.println("blob");
            ps.setBlob(1, inputStream);
        }
        ps.setString(2, title);

        int row = ps.executeUpdate();

        return (row > 0 ? true : false);
    }

    public ArrayList<Picture> getPictures() {
        ArrayList<Picture> lst = new ArrayList<Picture>();

        String sql = "select *from image";
        try {
            PreparedStatement ps = co.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	
            	Picture picture = new Picture();
            	picture.setPicture(rs.getBlob("image"));
            	System.out.println("blooob : " + rs.getBlob("image") );

            	picture.setTitle(rs.getString("titre"));
            	
                lst.add(picture);
            }
        } catch (Exception e) {
            System.out.println("Erreur Base.listerImage " + e.getMessage());
        }
        return lst;

    }
    
    
    
}
