package model.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import model.CalendarDAO;
import model.CourseDAO;
import model.bean.CalendarBean;
import model.bean.CourseBean;

@Service
public class CourseService {
	@Autowired
	private CourseDAO courseDAO;
	@Autowired
	private CalendarDAO calendarDAO;

	public CourseService(CourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
		try {
			SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
			sessionFactory.getCurrentSession().beginTransaction();
			CourseService service = (CourseService) context.getBean("courseService");

			// select 搜尋
			// List<CourseBean> bean=service.select(null);
			// System.out.println("bean="+bean);
			// insert 新增一門課程
			// CourseBean bean=new CourseBean();
			// bean.setCourseName("伏地挺身x1111xxx");
			// bean.setCourseStartDate(new Date());
			// bean.setCourseEndDate(new Date(86400));
			// bean.setCourseStartTime("15:00:00");
			// bean.setCourseEndTime("17:00:00");
			// bean.setFrequency(10);
			// bean.setCoursePrice(1000d);
			// bean.setDiscount(1d);
			// bean.setDiscountPrice(1000d);
			// bean.setCourseKind("團體");
			// bean.setTypeId(20);
			// bean.setCoursePic(null);
			// bean.setRoomId(101);
			// bean.setMemberId(1);
			// CourseBean insert=service.insert(bean);
			// System.out.println("insert="+insert);

			// update 修改課程資料
			// CourseBean bean=new CourseBean();
			// bean.setCourseId(1005);
			// bean.setCourseName("伏地挺身xxxx");
			// bean.setCourseStartDate(new Date());
			// bean.setCourseEndDate(new Date(86400));
			// bean.setCourseStartTime("15:00:00");
			// bean.setCourseEndTime("17:00:00");
			// bean.setFrequency(10);
			// bean.setCoursePrice(1000d);
			// bean.setDiscount(1d);
			// bean.setDiscountPrice(1000d);
			// bean.setCourseKind("團體");
			// bean.setTypeId(20);
			// bean.setCoursePic(null);
			// bean.setRoomId(105);
			// bean.setMemberId(1);
			// CourseBean update=service.update(bean);
			// System.out.println("update="+update);
			// delete 刪除一筆課程
			// CourseBean bean=new CourseBean();
			// bean.setCourseId(1006);
			// boolean delete=service.delete(bean);
			// System.out.println("delete="+delete);

			sessionFactory.getCurrentSession().getTransaction().commit();
		} finally {
			((ConfigurableApplicationContext) context).close();
		}
	}

	// select
	public List<CourseBean> select(CourseBean bean) {
		List<CourseBean> result = null;
		if (bean != null && bean.getCourseId() != 0) {
			CourseBean temp = courseDAO.select(bean.getCourseId());
			if (temp != null) {
				// System.out.println("CourseWeek=" + temp.getCourseWeek());
				result = new ArrayList<CourseBean>();
				result.add(temp);
			}
		} else {
			result = courseDAO.select();
		}
		return result;
	}
	// select for calendar
	// public List<String> selectForCalendar(){
	// List<String> result=null;
	// CourseBean bean=new CourseBean();
	// for() {
	//
	// }
	// return result;
	// }

	// insert
	public CourseBean insert(CourseBean bean) {
		CourseBean result = null;
		if (bean != null) {
			result = courseDAO.insert(bean);
		}
		return result;
	}

	// update
	public CourseBean update(CourseBean bean) {
		CourseBean result = null;
		CalendarBean calendarBean = new CalendarBean();
		if (bean != null) {
			result = courseDAO.update(bean.getCourseId(), bean.getCourseName(), bean.getCourseStartDate(),
					bean.getCourseEndDate(), bean.getCourseWeek(), bean.getCourseStartTime(), bean.getCourseEndTime(),
					bean.getFrequency(), bean.getCoursePrice(), bean.getDiscount(), bean.getDiscountPrice(),
					bean.getTypeId(), bean.getCourseKind(), bean.getCoursePic(), bean.getRoomId(), bean.getMemberId());
		}

		////////////////////////////////////////////////
		/// 以下測試///////

		//
		//
		//
		//// System.out.println(bean.getCourseStartDate().toString());
		// //呼叫calendarBean的insert方法(把course資料丟到calendar)
		// //日期判斷
		// SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); //設定日期格式
		//
		// String startDay=sdf.format(bean.getCourseStartDate()); //2017-10-02
		// String endDay=sdf.format(bean.getCourseEndDate()); //2017-10-19
		// int startDayInt=Integer.parseInt(startDay.substring(8)); //02
		// int endDayInt=Integer.parseInt(endDay.substring(8)); //19
		//
		//// int
		// days=Integer.parseInt(endDay.substring(8))-Integer.parseInt(startDay.substring(8));
		// //19-02=17
		//
		// //第一筆資料
		// calendarBean.setCourseId(bean.getCourseId());
		//// calendarBean.setCourseName(bean.getCourseId()+" "+bean.getCourseName()+"
		// "+bean.getRoomId()+"教室"); //名稱太長
		// calendarBean.setCourseName(bean.getCourseName());
		// calendarBean.setCourseStart(startDay+"T"+bean.getCourseStartTime());
		// calendarBean.setCourseEnd(startDay+"T"+bean.getCourseStartTime());
		// calendarBean=calendarDAO.insert(calendarBean);
		//
		//
		//
		// for(int i=1;i<(bean.getFrequency()/2);i++) { //作(堂數/2)次for迴圈 因為一星期有兩堂課
		//
		// }
		//
		// Calendar calendar=Calendar.getInstance();
		// calendar.setTime(bean.getCourseStartDate()); //Date轉成Calendar格式以方便進行日期的加減
		//
		//
		// int
		// x=Integer.parseInt(bean.getCourseWeek().substring(2,3))-Integer.parseInt(bean.getCourseWeek().substring(0,1));
		// calendar.add(calendar.DAY_OF_YEAR, x); //加x天
		//// System.out.println(calendar.toString());
		// Date d1=calendar.getTime(); //Calendar轉Date格式
		// String reStr = sdf.format(d1); //Date轉String格式
		//// System.out.println(reStr);
		//
		//
		//
		// calendarBean.setCourseId(bean.getCourseId());
		// calendarBean.setCourseName(bean.getCourseName());
		// calendarBean.setCourseStart(reStr+"T"+bean.getCourseStartTime());
		// calendarBean.setCourseEnd(reStr+"T"+bean.getCourseStartTime());
		// calendarBean=calendarDAO.insert(calendarBean);

		// calendarBean.setCourseId(bean.getCourseId());
		// calendarBean.setCourseName(bean.getCourseId()+" "+bean.getCourseName()+"
		// "+bean.getRoomId()+"教室");
		// calendarBean.setCourseStart(bean.getCourseStartDate().toString()+"T"+bean.getCourseStartTime());
		// calendarBean.setCourseEnd(bean.getCourseEndDate().toString()+"T"+bean.getCourseStartTime());
		// calendarBean=calendarDAO.insert(calendarBean);

		/// 以上測試/////
		//////////////////////////////////////////////////

		return result;
	}

	// delete
	public boolean delete(CourseBean bean) {
		boolean result = false;
		if (bean != null) {
			result = courseDAO.delete(bean.getCourseId());
		}
		return result;
	}
}
