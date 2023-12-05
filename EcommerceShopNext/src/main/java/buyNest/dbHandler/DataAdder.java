package buyNest.dbHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DataAdder {

	public static  boolean addtrans(int bid, String uname, String bname) {
		
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="system";
		String password="sosha";
		String sql="INSERT INTO trans VALUES(?,?,?)";
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection(url, user, password);
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, bid);
			ps.setString(2, bname);
			ps.setString(3, uname);
			ps.executeUpdate();
		}catch(Exception e){
			System.out.println("Problem in adding book");
			e.printStackTrace();
			return false;
		}			
		return true;
	}

	}


