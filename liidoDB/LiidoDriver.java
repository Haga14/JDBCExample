package liidoDB;

import java.sql.*;
import java.util.Scanner;


import liimo.*;
public class LiidoDriver {

	public static void main(String[] args) {
		//create a JDBCCreateDB instance. This class simplifies the Database connectivity and creation through an object oriented approach
		JDBCCreateDB Database = new JDBCCreateDB();
		
		
		Database.loadJDBCDriver(); //Load the JDBC Driver
		Connection connect = Database.connectDBMS();//"ankr", "root", "pass"); //Connect to and a database *The JDBCCreateDB class can also create a DB.
		
		CreateTable tableMaker = new CreateTable(); //The CreateTable class allows a user to create a table and add columns and rows without touch SQL.
		System.out.println("Please enter the table name");
		String tableName = InputGetter.getAlphaString(new Scanner(System.in)); //The getAlphaString method of the InputGetter class ensures that the user inputs a String consisting off only letters
		
		Statement stmnt = null;
		String SQL = tableMaker.buildTable(tableName);//The builTable method of the CreateTable class constructs the necessary SQL statements to create a table with columns
		System.out.println("\n\n\n" + SQL);//Print the SQL statements
		
		try {
			stmnt = connect.createStatement();
			stmnt.executeUpdate(SQL);//Execute the SQL statements assembled in the CreateTable.buildTable method to create a table with columns.
			System.out.println("Table created and populated successfuly...");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ResultSet rs = null;//This result set will hold the table columns
		try {
			rs = stmnt.executeQuery("Select * From " + tableName);//Get the table data
			SQL = tableMaker.insertRow(tableName, rs.getMetaData());//Pass the table name and table metadata into the CreateTable.insertRow method. This method helps a user insert rows without touching SQL.
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println(SQL);
		try
		{
			stmnt.executeUpdate(SQL);//Execute the SQL statements to insert rows created in the CreateTable.insertRow method.
			System.out.println("row inserted successfuly");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		Database.closeConnections();//This method closes the open connections.

		
		
	}

}
