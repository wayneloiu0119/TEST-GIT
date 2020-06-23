package model;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import model.bean.OrdersBean;

public interface OrdersDAO {

	Session getSession();

	OrdersBean select(int orderId);

	List<OrdersBean> select();

	OrdersBean update(int orderId, int memberId, Date orderDate, double orderPrice, String payment);

	OrdersBean insert(OrdersBean bean);

	boolean delete(int OrderId);

}