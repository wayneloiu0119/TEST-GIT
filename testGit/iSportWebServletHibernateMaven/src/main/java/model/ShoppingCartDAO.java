package model;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import model.bean.ShoppingCartBean;

public interface ShoppingCartDAO {

	Session getSession();

	ShoppingCartBean select(int ShoppingCartId);

	List<ShoppingCartBean> selectByMemberId(int memeberId);

	List<ShoppingCartBean> select();

	ShoppingCartBean insert(ShoppingCartBean bean);

	ShoppingCartBean update(int courseId, String courseName, Date courseStartDate, String courseStartTime,
			double coursePrice, double discount, int memberId, int shoppingCartId);

	boolean delete(int shoppingCartId);

}