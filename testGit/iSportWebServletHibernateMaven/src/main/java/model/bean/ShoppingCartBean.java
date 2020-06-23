package model.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SHOPPINGCART")

public class ShoppingCartBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int shoppingCartId;
	private int courseId;
	private String courseName;
	private Date courseStartDate;
	private String courseStartTime;
	private double coursePrice;
	private double discount;
	private int memberId;

	// public static void main(String[] args) {
	// try {
	//
	// HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
	// Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	//
	// ShoppingCartBean select = session.get(ShoppingCartBean.class, 1);
	// System.out.println("select = " + select);
	//
	// HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
	// } finally {
	// HibernateUtil.closeSessionFactory();
	// }
	// }

	@Override
	public String toString() {
		return "ShoppingCartBean [shoppingCartId=" + shoppingCartId + ", courseId=" + courseId + ", courseName="
				+ courseName + ", courseStartDate=" + courseStartDate + ", courseStartTime=" + courseStartTime
				+ ", coursePrice=" + coursePrice + ", discount=" + discount + ", memberId=" + memberId + "]";
	}

	public int getShoppingCartId() {
		return shoppingCartId;
	}

	public void setShoppingCartId(int shoppingCartId) {
		this.shoppingCartId = shoppingCartId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Date getCourseStartDate() {
		return courseStartDate;
	}

	public void setCourseStartDate(Date courseStartDate) {
		this.courseStartDate = courseStartDate;
	}

	public String getCourseStartTime() {
		return courseStartTime;
	}

	public void setCourseStartTime(String courseStartTime) {
		this.courseStartTime = courseStartTime;
	}

	public double getCoursePrice() {
		return coursePrice;
	}

	public void setCoursePrice(double coursePrice) {
		this.coursePrice = coursePrice;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

}
