package liimo;
public class BasicQueries {
	public String UseDB(String Name)
	{
		return "USE " + Name.toUpperCase();
	}
	
	public String CreateDB(String Name)
	{
		return "Create Database " + Name;
	}
	public String getTables()
	{
		return "SHOW TABLES;";
	}
	public String getDBs()
	{
		return "SELECT *FROM sys.databases";
	}
	public String getTable(String Name)
	{
		return "SELECT * FROM " + Name + ";";
	}
	
	

}
