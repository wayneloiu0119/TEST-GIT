package model;

import java.util.List;

import model.bean.OrdersListBean;

public interface OrdersListDAO {

	// 複合主鍵查詢
	OrdersListBean select(int orderId, int courseId);

	List<OrdersListBean> select(int orderId);

	List<OrdersListBean> select();

	OrdersListBean insert(OrdersListBean bean);

	OrdersListBean update(int memberId, String courseName, double coursePrice, int orderId, int courseId);

	boolean delete(int orderId, int courseId);

}