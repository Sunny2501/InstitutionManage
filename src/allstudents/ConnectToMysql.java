package allstudents;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToMysql 
{
	
	public static Connection doConnect()
	{
		Connection con=null;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/institute","root","");
			System.out.println("Connected");
			
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return con;
		
	}

	public static void main(String[] args)
	{
			
		doConnect();

	}

}
