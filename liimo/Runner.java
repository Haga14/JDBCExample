package liimo;
import java.sql.*;
public class Runner {
	
	private ResultSet rs;
	
	public ResultSet Qrun(Connection conn, String q)
	{
		Statement St;
		try {
			St = conn.createStatement();
			rs = St.executeQuery(q);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return rs;
	
	}
	
	public void Change(Connection conn, String q)
	{
		Statement St;
		
		try
		{
			St = conn.createStatement();
			St.executeUpdate(q);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

}
