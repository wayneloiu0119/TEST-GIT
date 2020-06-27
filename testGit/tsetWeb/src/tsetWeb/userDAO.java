package tsetWeb;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




public class userDAO  {
	
	/* (non-Javadoc)
	 * @see tsetWeb.userImp#insertUser(tsetWeb.userBean)
	 */
	public userBean insertUser(userBean userbaen) {
		
		userBean result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		
		StringBuilder insert = new StringBuilder();
		
		insert.append(" INSERT INTO MENBER(USER_ID,USER_NAME,PASSWORD,GEBDER,EMAIL,PHONE,ADDRESS,BIRTHDAY,INSERT_TIME)  ");
	    insert.append(" VALUES (?,?,?,?,?,?,?,?,?) ");
	    
	    try {
			Class.forName("oracle.jdbc.OracleDriver");
			String counUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
			conn = DriverManager.getConnection(counUrl, "SYSTEM", "123");
			stmt = conn.prepareStatement(insert.toString());
			
			stmt.setString(1,userbaen.getUserId());
			stmt.setString(2,userbaen.getUserName());
			stmt.setString(3,userbaen.getPswd());
			stmt.setString(4,userbaen.getGender());
			stmt.setString(5,userbaen.getEmail());
			stmt.setInt(6, userbaen.getPhone());
			stmt.setString(7,userbaen.getAddress());
			
			//日期轉換
			//java.util.Date bir = userbaen.getBirthday();
			//java.sql.Date brdate = new java.sql.Date(bir.getTime());
			Date brdate = new Date(userbaen.getBirthday().getTime());
			stmt.setDate(8,brdate);
			//java.util.Date nwt = userbaen.getInsertTime();
			//java.sql.Date inTime = new java.sql.Date(nwt.getTime());
			Date inTime = new Date(userbaen.getInsertTime().getTime());
			stmt.setDate(9,inTime);
			int i = stmt.executeUpdate();
			System.out.println("i="+i);
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}		
		return result;
	}
	
	public userBean selectForUserId(userBean userbean) {
		
		userBean userbn = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		StringBuilder sfUserId = new StringBuilder();
		sfUserId.append("SELECT LIST_ID,USER_ID,USER_NAME,PASSWORD,GEBDER,PHONE,ADDRESS,");
		sfUserId.append("BIRTHDAY,USER_LEVEL,EMAIL,INSERT_TIME FROM MENBER WHERE USER_ID = ? ");
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String counUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
			conn = DriverManager.getConnection(counUrl, "SYSTEM", "123");
			stmt = conn.prepareStatement(sfUserId.toString());
			stmt.setString(1,userbean.getUserId());
			rset = stmt.executeQuery();
			while(rset.next()) {
				userbn = new userBean();
				userbn.setListId(rset.getString("LIST_ID"));
				userbn.setUserId(rset.getString("USER_ID"));
				userbn.setUserName(rset.getString("USER_NAME"));
				userbn.setPswd(rset.getString("PASSWORD"));
				userbn.setGender(rset.getString("GEBDER"));
				userbn.setPhone(rset.getInt("PHONE"));
				userbn.setAddress(rset.getString("ADDRESS"));
				userbn.setBirthday(rset.getDate("BIRTHDAY"));
				userbn.setUserLevel(rset.getString("USER_LEVEL"));
				userbn.setEmail(rset.getString("EMAIL"));
				userbn.setInsertTime(rset.getDate("INSERT_TIME"));
						
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
		
		return userbn;
	}
	
	
	

}
