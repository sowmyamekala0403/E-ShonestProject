package buyNest.dbHandler;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import elib.book.Book;

import java.util.ArrayList;

public class DataFetcher {
	public static String fetchPassword(String uname) {
		String driver="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="system";
		String password="sosha";
		String sql="SELECT pass FROM members WHERE uname=?";
		String dbPass="";
		try {
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url,user,password);
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setString(1, uname);
			ResultSet rs=ps.executeQuery();
			rs.next();
			dbPass=rs.getString(1);
		}catch(Exception e) {
			System.out.println("Login Problem issues");
			e.printStackTrace();
		}
		return dbPass;
	}
	
	public static List fetchUsersInfo() {
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="system";
		String password="sosha";
		String sql="SELECT uname,email,gender,address FROM members";
		List ulist=new ArrayList();
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection(url, user, password);
			Statement st=con.createStatement();
			
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				String temp=rs.getString(1)+":"+rs.getString(2)+":"+rs.getString(3)+":"+rs.getString(4);
				ulist.add(temp);
			}
			
		}catch(Exception e){
			System.out.println("Problem in Login");
		}			
		return ulist;
	}
	
	
	
	
	
	public static List fetchBooksInfos() {
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="system";
		String password="sosha";
		String sql="SELECT bid,bname,bdesc,author,bimg FROM books";
		List ilist=new ArrayList();
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection(url, user, password);
			Statement st=con.createStatement();
			
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				String temp=""+rs.getInt(1)+":"+rs.getString(2)+":"+rs.getString(3)+":"+rs.getString(4)+":"+rs.getString(5);
				ilist.add(temp);
			}
			
		}catch(Exception e){
			System.out.println("Problem in fetching product");
			e.printStackTrace();
		}			
		return ilist;
	}
	
	public static Book getProductById(int bid) {
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="system";
		String password="sosha";
		String sql="SELECT bname,author FROM books WHERE bid=?";
		Book p=null;
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection(url, user, password);
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, bid);
			ResultSet rs=ps.executeQuery();
			rs.next();
			String bname=rs.getString(1);
			String author=rs.getString(2);
			
			p=new Book(bid,bname,author);
		}catch(Exception e){
			System.out.println("Problem in fetching product by id");
			e.printStackTrace();
		}			
		finally {
			return p;
		}
	}
	public static List fetchTransInfos() {
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="system";
		String password="sosha";
		String sql="SELECT bid,bname,uname FROM trans";
		List blist=new ArrayList();
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection(url, user, password);
			Statement st=con.createStatement();
			
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				String temp=rs.getString(1)+":"+rs.getString(2)+":"+rs.getString(3);
				blist.add(temp);
			}
			
		}catch(Exception e){
			System.out.println("Problem in Login");
		}			
		return blist;
	}
	
	
	
}
