package mySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQLProject {
	public static void main(String[] args) throws Exception {
		String db = "jdbc:mysql://localhost:3306";
		String user = "root";
		String password = "1829";
		Connection connection = DriverManager.getConnection(db,user,password);
		if (connection==null) {
			System.out.println("JDBC Not Connected");
		} else {
			System.out.println("JDBC Connected");
		}	
Statement stmt = connection.createStatement();
		
		String createDatabase = "create database db_SQLProject";
		String useDB = "use db_SQLProject";
		String createTable = "create table Emp_class (Empcode int, Empname varchar(10), Emppage int, EmpSalary int)";
		String insert = "insert into Emp_class values (101,'Jenny',25,10000),(102,'Jacky',30,20000),(103,'Joe',20,40000),(104,'John',40,80000),(105,'Shameer',25,90000)";
		String select = "Select * from Emp_class";

		stmt.execute(createDatabase);
		stmt.execute(useDB);
		stmt.execute(createTable);
		stmt.execute(insert);
				ResultSet rs = stmt.executeQuery(select);
				while (rs.next()) {
					System.out.println(rs.getInt("Empcode")+ " " + rs.getString("Empname") + " " + rs.getInt("Emppage")+ " " + rs.getInt("EmpSalary"));		
				}
				connection.close();
}
}