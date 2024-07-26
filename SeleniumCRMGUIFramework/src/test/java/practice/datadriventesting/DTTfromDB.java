package practice.datadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DTTfromDB {

	public static void main(String[] args) throws SQLException {
		
		
		//Step 1: load/ register the database driver
			Driver driverRef= new Driver();
			DriverManager.registerDriver(driverRef);
			
		//Step 2: connect to database
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", "root");
			System.out.println("done connection");
		
		//Step 3: Create SQL statement
			Statement stat=conn.createStatement();
		//Step 4: Execute Select query and get Result
			ResultSet resset=stat.executeQuery("select * from employees");
			while(resset.next())
			{
				System.out.println(resset.getString(1)+"  "+resset.getString(2)+"  "+resset.getString(3)+"  "+resset.getString(4));
			}
		//Step 5: Close the connection
			conn.close();
		
	}

}
