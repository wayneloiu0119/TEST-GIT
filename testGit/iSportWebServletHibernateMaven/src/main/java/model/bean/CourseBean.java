package model.bean;

import java.sql.Blob;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Course")
public class CourseBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int courseId;
	private String courseName;
	private Date courseStartDate;
	private Date courseEndDate;
	private String courseWeek;
	private String courseStartTime;
	private String courseEndTime;
	private int frequency;
	private double coursePrice;
	private double discount;
	private double discountPrice;
	private int typeId;
	private String courseKind;
//	@Lob
	private Blob coursePic;	
	private int roomId;
	private int memberId;
	
	@Override
	public String toString() {
		return "CourseBean [courseId=" + courseId + ", courseName=" + courseName + ", courseStartDate="
				+ courseStartDate + ", courseEndDate=" + courseEndDate + ", courseWeek=" + courseWeek
				+ ", courseStartTime=" + courseStartTime + ", courseEndTime=" + courseEndTime + ", frequency="
				+ frequency + ", coursePrice=" + coursePrice + ", discount=" + discount + ", discountPrice="
				+ discountPrice + ", typeId=" + typeId + ", courseKind=" + courseKind + ", coursePic=" + coursePic
				+ ", roomId=" + roomId + ", memberId=" + memberId + "]";
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
	public Date getCourseEndDate() {
		return courseEndDate;
	}
	public void setCourseEndDate(Date courseEndDate) {
		this.courseEndDate = courseEndDate;
	}
	public String getCourseWeek() {
		return courseWeek;
	}
	public void setCourseWeek(String courseWeek) {
		this.courseWeek = courseWeek;
	}
	public String getCourseStartTime() {
		return courseStartTime;
	}
	public void setCourseStartTime(String courseStartTime) {
		this.courseStartTime = courseStartTime;
	}
	public String getCourseEndTime() {
		return courseEndTime;
	}
	public void setCourseEndTime(String courseEndTime) {
		this.courseEndTime = courseEndTime;
	}
	public int getFrequency() {
		return frequency;
	}
	public void setFrequency(int frequency) {
		this.frequency = frequency;
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
	public double getDiscountPrice() {
		return discountPrice;
	}
	public void setDiscountPrice(double discountPrice) {
		this.discountPrice = discountPrice;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getCourseKind() {
		return courseKind;
	}
	public void setCourseKind(String courseKind) {
		this.courseKind = courseKind;
	}
	public Blob getCoursePic() {
		return coursePic;
	}
	public void setCoursePic(Blob coursePic) {
		this.coursePic = coursePic;
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
}
