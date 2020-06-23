package model.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


@Entity
@Table(name="Calendar")
public class CalendarBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Expose(deserialize = false)
	private int calendarId;
//	@Expose(deserialize = false)
	private int courseId;
	@SerializedName("title")
	private String courseName;
	@SerializedName("start")
	private String courseStart;
	@SerializedName("end")
	private String courseEnd;
	
	@Override
	public String toString() {
		return "CalendarBean [calendarId=" + calendarId + ", courseId=" + courseId + ", courseName=" + courseName
				+ ", courseStart=" + courseStart + ", courseEnd=" + courseEnd + "]";
	}
	public int getCalendarId() {
		return calendarId;
	}
	public void setCalendarId(int calendarId) {
		this.calendarId = calendarId;
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
	public String getCourseStart() {
		return courseStart;
	}
	public void setCourseStart(String courseStart) {
		this.courseStart = courseStart;
	}
	public String getCourseEnd() {
		return courseEnd;
	}
	public void setCourseEnd(String courseEnd) {
		this.courseEnd = courseEnd;
	}
	

}