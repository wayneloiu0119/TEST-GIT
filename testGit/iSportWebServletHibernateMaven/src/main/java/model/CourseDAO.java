package model;

import java.sql.Blob;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import model.bean.CourseBean;

public interface CourseDAO {

	Session getSession();

	CourseBean select(int courseId);

	public List<CourseBean> select();

	// CourseBean update(CourseBean bean);
	CourseBean update(int courseId, String courseName, Date courseStartDate, Date courseEndDate, String courseWeek,
			String courseStartTime, String courseEndTime, int frequency, double coursePrice, double discount,
			double discountPrice, int typeId, String courseKind, Blob coursePic, int roomId, int memberId);

	CourseBean insert(CourseBean bean);

	boolean delete(int courseId);

}