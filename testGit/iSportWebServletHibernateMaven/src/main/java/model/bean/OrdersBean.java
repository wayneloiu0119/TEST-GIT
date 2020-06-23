package model.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Orders")
public class OrdersBean {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int orderId;
	private int memberId;
	private Date orderDate;
	private double orderPrice;
	private String payment;
	
	@Override
	public String toString() {
		return "OrdersBean [OrderId=" + orderId + ", OrderDate=" + orderDate + ", OrderPrice=" + orderPrice
				+ ", Payment=" + payment + ", MemberId=" + memberId + "]";
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public double getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(double orderPrice) {
		this.orderPrice = orderPrice;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}
}
