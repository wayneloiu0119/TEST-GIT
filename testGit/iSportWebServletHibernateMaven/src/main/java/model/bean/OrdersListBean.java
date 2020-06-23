package model.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(OrdersListId.class)
@Table(name = "ORDERSLIST")
public class OrdersListBean implements Serializable {

	@Id
	private int orderId;
	@Id
	private int courseId;

	private int memberId;
	private String courseName;
	private double coursePrice;

	// public static void main(String[] args) {
	// try {
	//
	// HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
	// Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	//
	// // Query<OrdersListBean> query = session.createQuery("FROM OrdersListBean
	// where
	// // orderId = ?",
	// // OrdersListBean.class);
	// // query.setParameter(0, 1060913001);
	// // System.out.println(query.list());
	//
	// OrdersListId ordersListId = new OrdersListId();
	// ordersListId.setOrderId(1060913003);
	// ordersListId.setCourseId(1004);
	// OrdersListBean select = session.get(OrdersListBean.class, ordersListId);
	// System.out.println(select);
	//
	// HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
	// } finally {
	// HibernateUtil.closeSessionFactory();
	// }
	// }

	@Override
	public String toString() {
		return "OrdersListBean [orderId=" + orderId + ", courseId=" + courseId + ", memberId=" + memberId
				+ ", courseName=" + courseName + ", coursePrice=" + coursePrice + "]";
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public double getCoursePrice() {
		return coursePrice;
	}

	public void setCoursePrice(double coursePrice) {
		this.coursePrice = coursePrice;
	}

}
