package model;

import java.util.List;

import model.bean.CalendarBean;

public interface CalendarDAO {

	List<CalendarBean> select(int courseId);

	List<CalendarBean> select();
	
	CalendarBean update(int calendarId, int courseId, String courseName, String courseStart, String courseEnd);

	CalendarBean insert(CalendarBean bean);

	boolean delete(int calendarId);
	
	int deleteCourseId(int courseId);

}