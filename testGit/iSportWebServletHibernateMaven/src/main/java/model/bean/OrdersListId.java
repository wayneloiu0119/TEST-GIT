package model.bean;

import java.io.Serializable;

public class OrdersListId implements Serializable {

	protected int orderId;
	protected int courseId;

	public OrdersListId() {
	}

	public OrdersListId(int orderId, int courseId) {
		this.orderId = orderId;
		this.courseId = courseId;
	}

	// equals, hashCode

	@Override
	public String toString() {
		return "OrdersListId [orderId=" + orderId + ", courseId=" + courseId + "]";
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
}
