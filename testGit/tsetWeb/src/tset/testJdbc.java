package tset;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class testJdbc {
	
	

	public static void main(String[] args) {

		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		
		String tsetSelect = "SELECT * FROM MENBER";
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String counUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
			conn = DriverManager.getConnection(counUrl, "SYSTEM", "123");
			stmt = conn.prepareStatement(tsetSelect);
			rset = stmt.executeQuery();
			while (rset.next()) {
				System.out.println(rset.getString("user_id"));
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		

	}

}
