package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import model.CustomerBean;
import model.ProductBean;
import model.ProductDAO;




//<!-- 	<bean id="productDAO" class="model.dao.ProductDAOJdbc"> -->
//<!-- 	<constructor-arg ref="dataSource"></constructor-arg> -->
//<!-- 	</bean> -->





@Component(value="productDAO")

public class ProductDAOJdbc implements ProductDAO {
	@Autowired
//	private static final String URL = "jdbc:sqlserver://localhost:1433;database=java";
//	private static final String USERNAME = "sa";
//	private static final String PASSWORD = "sa123456";

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
		ProductDAO productDAO = (ProductDAO) context.getBean("productDAO");
		
		
		
		//ProductDAO productDAO = new ProductDAOJdbc();
		ProductBean bean = productDAO.select(1);
		System.out.println(bean);
		
		((ConfigurableApplicationContext) context).close();		
	}
	
	
	

	public ProductDAOJdbc(DataSource dataSource) {
	this.dataSource = dataSource;
}




	private DataSource dataSource ;
	public ProductDAOJdbc() {
		DriverManagerDataSource dmds = new DriverManagerDataSource();
		dmds.setUrl("jdbc:sqlserver://localhost:1433;database=java");
		dmds.setUsername("sa");
		dmds.setPassword("sa123456");
		
		dataSource = dmds;
	}
	
	
	
	private static final String SELECT_BY_ID = "select * from product where id=?";
	public ProductBean select(int id) {
		ProductBean result = null;

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;

		try {
//			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement(SELECT_BY_ID);
			stmt.setInt(1, id);
			rset = stmt.executeQuery();
			if(rset.next()) {
				result = new ProductBean();
				result.setName(rset.getString("name"));
				result.setPrice(rset.getDouble("price"));
		
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rset!=null) {
				try {
					rset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}
			if (stmt!=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}
			if (conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}
		}
		return result;
	}
	
	private static final String SELECT_ALL = "select * from product";
	public List<ProductBean> select() {
		List<ProductBean> result = null;

		return result;
	}
	
	private static final String INSERT =
			"insert into product (id, name, price, make, expire) values (?, ?, ?, ?, ?)";
	public ProductBean insert(ProductBean bean) {
		ProductBean result = null;

		return result;
	}
	
	private static final String UPDATE =
			"update product set name=?, price=?, make=?, expire=? where id=?";
	public ProductBean update(String name,
			double price, java.util.Date make, int expire, int id) {
		ProductBean result = null;

		return result;
	}
	
	private static final String DELETE = "delete from product where id=?";
	public boolean delete(int id) {

		return false;
	}
}
