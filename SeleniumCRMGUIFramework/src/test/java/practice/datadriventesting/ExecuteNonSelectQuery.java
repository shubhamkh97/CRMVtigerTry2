package practice.datadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ExecuteNonSelectQuery {

	public static void main(String[] args) throws Throwable {
		Driver driverRef= new Driver();
		DriverManager.registerDriver(driverRef);
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", "root");
		Statement stat= conn.createStatement();
		int res=stat.executeUpdate("insert into employees value('1001','Debata','Suvam','x7800','suvam01@gmail.com','5','1143','Sales')");
		System.out.println(res);
		conn.close();

	}

}
