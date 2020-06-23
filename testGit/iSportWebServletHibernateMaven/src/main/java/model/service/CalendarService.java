package model.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.CalendarDAO;
import model.CourseDAO;
import model.bean.CalendarBean;
import model.bean.CourseBean;

@Service
public class CalendarService {
	@Autowired
	private CalendarDAO calendarDAO;
	@Autowired
	private CourseDAO courseDAO;

	public CalendarService(CalendarDAO calendarDAO) {
		this.calendarDAO = calendarDAO;
	}
	// public static void main(String[] args) {
	// ApplicationContext context=new
	// ClassPathXmlApplicationContext("beans.config.xml");
	// try {
	// SessionFactory sessionFactory = (SessionFactory)
	// context.getBean("sessionFactory");
	// sessionFactory.getCurrentSession().beginTransaction();
	//
	// CalendarService service = (CalendarService)
	// context.getBean("calendarService");
	//
	// //select
	//// CalendarBean bean=new CalendarBean();
	//// bean.setCalendarId(2);
	//// List<CalendarBean> beans = service.select(bean);
	//// System.out.println("beans=" + beans);
	// //selectAll
	// List<CalendarBean> beans = service.select(null);
	// System.out.println("beans=" + beans);
	// //insert
	//// CalendarBean bean=new CalendarBean();
	////// bean.setCalendarId(999); //流水號 不給值
	//// bean.setRoomDate(new Date());
	//// bean.setRoomId(105);
	//// bean.setPeriod(2);
	//// bean.setCourseId("1005");
	//// CalendarBean insert=service.insert(bean);
	//// System.out.println("insert="+insert);
	// //用課程(CourseId)查詢
	// //insert 一個月的資料(輸入年,月)
	// //update 課程(每堂(select起始日期,結束日期,星期,教室,時段 update CourseId))
	//
	// sessionFactory.getCurrentSession().getTransaction().commit();
	// } finally {
	// ((ConfigurableApplicationContext)context).close();
	// }
	// }

	// 功能
	// select by courseId
	public List<CalendarBean> select(CalendarBean bean) {
		List<CalendarBean> result = null;
		if (bean != null && bean.getCourseId() != 0) {
			result = calendarDAO.select(bean.getCourseId());
			// if (temp != null) {
			// result = new ArrayList<CalendarBean>();
			// result.add(temp);
			// }
		} else {
			result = calendarDAO.select();
		}
		return result;
	}

	// public List<CalendarBean> calendarSelect(CalendarBean bean) {
	// List<CalendarBean> result = null;
	// if (bean != null && bean.getCourseId() != 0) {
	// List<CalendarBean> temp = calendarDAO.select(bean.getCourseId());
	// if (temp != null) {
	// result = new ArrayList<CalendarBean>();
	// result.add(temp);
	// }
	// } else {
	// result = calendarDAO.select();
	// System.out.println(result);
	// }
	// return result;
	// }

	// insert
	public CalendarBean insert(CalendarBean bean) {
		CalendarBean result = null;
		CourseBean coursebean = null;
		if (bean != null) {
			// 用courseId去select出course TABLE的資料insert進calendar裡
			coursebean = courseDAO.select(bean.getCourseId());
			bean.setCourseName(coursebean.getCourseName());
			bean.setCourseStart(coursebean.getCourseStartDate().toString());
			bean.setCourseEnd(coursebean.getCourseEndDate().toString());
			result = calendarDAO.insert(bean);
		}
		return result;
	}

	// insert(輸入courseid)
	public List<CalendarBean> insertCourse(CalendarBean bean) {
		List<CalendarBean> result = null;
		CourseBean coursebean = null;

		int a1 = 1;
		if (bean != null && bean.getCourseId() != 0) {
			// 用courseId去select出course TABLE的資料insert進calendar裡
			// 用courseId搜尋得到coursebean 1002
			coursebean = courseDAO.select(bean.getCourseId());
			List<CalendarBean> temp = calendarDAO.select(bean.getCourseId());
			
			if (temp.isEmpty()) {

				// 設定日期格式
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

				// String 2017-10-02
				String startDay = sdf.format(coursebean.getCourseStartDate());

				// x為當週的兩堂課相差天數
				int x = Integer.parseInt(coursebean.getCourseWeek().substring(2, 3))
						- Integer.parseInt(coursebean.getCourseWeek().substring(0, 1));
				Calendar calendar = Calendar.getInstance();
				// Date轉成Calendar格式以方便進行日期的加減
				calendar.setTime(coursebean.getCourseStartDate());

				result = new ArrayList<>();

				// 作(堂數/2)次for迴圈 因為一星期有兩堂課
				for (int i = 1; i <= (coursebean.getFrequency() / 2); i++) {
					// 第1堂課程資料
					if (i == 1) {
						bean.setCourseId(coursebean.getCourseId());
						bean.setCourseName(coursebean.getCourseName());
						bean.setCourseStart(startDay + "T" + coursebean.getCourseStartTime());
						bean.setCourseEnd(startDay + "T" + coursebean.getCourseEndTime());
						CalendarBean bean1 = calendarDAO.insert(bean);
						result.add(bean1);
					} else {
						// Calendar轉Date格式
						Date d1 = calendar.getTime();
						// Date轉String格式
						String reStr = sdf.format(d1);
						CalendarBean bean2 = new CalendarBean();
						bean2.setCourseId(coursebean.getCourseId());
						bean2.setCourseName(coursebean.getCourseName());
						bean2.setCourseStart(reStr + "T" + coursebean.getCourseStartTime());
						bean2.setCourseEnd(reStr + "T" + coursebean.getCourseEndTime());
						CalendarBean bean1 = calendarDAO.insert(bean2);
						result.add(bean1);

					}
					
					a1 = a1 + 1;

					// 第一堂課日期加x天得到第二堂課日期
					calendar.add(calendar.DAY_OF_YEAR, x);
					// Calendar轉Date格式
					Date d2 = calendar.getTime();
					// Date轉String格式
					String reStr = sdf.format(d2);

					CalendarBean bean2 = new CalendarBean();
					bean2.setCourseId(coursebean.getCourseId());
					bean2.setCourseName(coursebean.getCourseName());
					// 第二堂課日期
					bean2.setCourseStart(reStr + "T" + coursebean.getCourseStartTime());
					bean2.setCourseEnd(reStr + "T" + coursebean.getCourseEndTime());

					CalendarBean bean3 = calendarDAO.insert(bean2);
					result.add(bean3);
					// 得到一週的第一堂課時間
					calendar.add(calendar.DAY_OF_YEAR, -x);

					// +7天得到下一週的第一堂課時間
					calendar.add(calendar.DAY_OF_YEAR, 7);

					a1 = a1 + 1;
				}

			}
		}
		return result;
	}

	// update
	public CalendarBean update(CalendarBean bean) {
		CalendarBean result = null;
		if (bean != null) {
			result = calendarDAO.update(bean.getCalendarId(), bean.getCourseId(), bean.getCourseName(),
					bean.getCourseStart(), bean.getCourseEnd());
		}
		return result;
	}

	// delete
	public int delete(CalendarBean bean) {
		int result = 0;
		if (bean != null) {
			System.out.println("將執行刪除");
			result = calendarDAO.deleteCourseId(bean.getCourseId());

			System.out.println("課程" + bean.getCourseId() + "已刪除");
		}
		return result;
	}

}
