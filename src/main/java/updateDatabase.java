
import java.sql.*;

public class updateDatabase {
	String url;
	Connection conn;
	Statement stm;
	public updateDatabase() throws SQLException{
	url = "jdbc:mysql://localhost:3306/stationary";
	conn = DriverManager.getConnection(url,"root","2002");
	stm = conn.createStatement();
	}
	public boolean update(String tName,String id,int newStock) throws SQLException {
		String q = "update "+tName+" t set t.stock = t.stock - "+newStock+" where id = '"+id+"'";
		int affectedRows = stm.executeUpdate(q);
		if(affectedRows != 0) return true;
		return false;
	}
}
