package ModelDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import ModelBean.MemberBean;

public class MemberDAO {
	
	
	
//	public MemberBean getSelectsId(String id) {
//		return select(id);
//	}

	private static final String SELECT_BY_ID = "Select memberId, password, name, birthday,email,phone from membertb where memberId = ?";

	public MemberBean select(String id) {

		MemberBean result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;

		try {

			Class.forName("oracle.jdbc.OracleDriver");
			String counUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(counUrl, "user", "123");
			stmt = conn.prepareStatement(SELECT_BY_ID);
			stmt.setString(1, id);
			rset = stmt.executeQuery();
			if (rset.next()) {
				result = new MemberBean();
				result.setMemberId(rset.getString("memberId"));
				result.setPassword(rset.getString("password"));
				result.setName(rset.getString("name"));
				result.setBirthday(rset.getDate("birthday"));
				result.setEmail(rset.getString("email"));
				result.setPhone(rset.getString("phone"));

			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (rset != null) {
				try {
					rset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return result;

	}

	public List<MemberBean> getAllMembers() {
		return select();
	}

	private static final String SELECT_ALL = "SELECT memberId,password,name,birthday,email,phone FROM membertb";

	public List<MemberBean> select() {
		List<MemberBean> result = null;

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String counUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(counUrl, "user", "123");
			stmt = conn.prepareStatement(SELECT_ALL);

			rset = stmt.executeQuery();
			result = new Vector<>();
			while (rset.next()) {
				MemberBean temp = new MemberBean();
				temp.setMemberId(rset.getString("memberId"));
				temp.setPassword(rset.getString("password"));
				temp.setName(rset.getString("name"));
				temp.setBirthday(rset.getDate("birthday"));
				temp.setEmail(rset.getString("email"));
				temp.setPhone(rset.getString("phone"));
				result.add(temp);

			}
			return result;
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		if (rset != null) {
			try {
				rset.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;

	}

	private static final String INSERT = "INSERT INTO membertb (memberId,password,name,birthday,email,phone) VALUES (?,?,?,?,?,?)";

	public MemberBean insertMemberTb(MemberBean bean) throws SQLException {

		MemberBean result = null;
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String counUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(counUrl, "user", "123");
			stmt = conn.prepareStatement(INSERT);

			stmt.setString(1, bean.getMemberId());
			stmt.setString(2, bean.getPassword());
			stmt.setString(3, bean.getName());

			java.util.Date temp = bean.getBirthday();
			if (temp != null) {
				java.sql.Date someTime = new java.sql.Date(temp.getTime());
				stmt.setDate(4, someTime);
			} else {
				stmt.setDate(4, null);
			}
			stmt.setString(5, bean.getEmail());
			stmt.setString(6, bean.getPhone());

			int i = stmt.executeUpdate();
			if (i == 1) {
				result = this.select(bean.getMemberId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	private static final String UPDATE = "UPDATE membertb SET password=?,name=?,birthday=?,email=?,phone=? WHERE memberId=?";

	public MemberBean updateMemberTb(MemberBean bean) {

		MemberBean result = null;
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String counUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(counUrl, "user", "123");
			stmt = conn.prepareStatement(UPDATE);

			stmt.setString(1, bean.getPassword());
			stmt.setString(2, bean.getName());
			java.util.Date temp = bean.getBirthday();
			if (temp != null) {
				java.sql.Date someTime = new java.sql.Date(temp.getTime());
				stmt.setDate(3, someTime);
			} else {
				stmt.setDate(3, null);
			}
			stmt.setString(4, bean.getEmail());
			stmt.setString(5, bean.getPhone());
			stmt.setString(6, bean.getMemberId());
			int i = stmt.executeUpdate();
			if (i == 1) {
				result = this.select(bean.getMemberId());
			}

		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return result;

	}

	private static final String DELETE = "DELETE FROM membertb WHERE memberId = ?";

	public int delete(int memberId) {

		int result = 0;
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String counUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(counUrl, "user", "123");
			stmt = conn.prepareStatement(DELETE);

			stmt.setInt(1, memberId);
			result = stmt.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}

		return result;

	}

}


 
