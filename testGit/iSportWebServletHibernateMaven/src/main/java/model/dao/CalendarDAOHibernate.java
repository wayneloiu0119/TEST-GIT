package model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import model.CalendarDAO;
import model.bean.CalendarBean;

@Repository
public class CalendarDAOHibernate implements CalendarDAO {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");

		try {
			SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
			sessionFactory.getCurrentSession().beginTransaction();

			CalendarDAO calendarDAO = (CalendarDAO) context.getBean("calendarDAOHibernate");

			// update
			// CalendarBean update = calendarDAO.update(1, new java.util.Date(86400), 105,
			// 99, "1005");
			// System.out.println("update = "+update+"\n");
			// insert
			// CalendarBean bean=new CalendarBean();
			// bean.setRoomDate(new java.util.Date(86400));
			// bean.setRoomId(103);
			// bean.setPeriod(3);
			// bean.setCourseId("1005");
			// CalendarBean insert=calendarDAO.insert(bean);
			// System.out.println("insert = "+insert+"\n");
			// Delete
			// boolean delete = calendarDAO.delete(5);
			// System.out.println("delete = " + delete);

			// select
			// List<CalendarBean> select=calendarDAO.select();
			// System.out.println("select = "+select+"\n");

			sessionFactory.getCurrentSession().getTransaction().commit();
		} finally {
			((ConfigurableApplicationContext) context).close();
		}
	}

	@Autowired
	private SessionFactory sessionFactory;

	public CalendarDAOHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public List<CalendarBean> select(int courseId) {
		return this.getSession().createQuery("from CalendarBean where courseId =" + courseId, CalendarBean.class)
				.list();
	}

	// @Override
	// public List<CalendarBean> select() {
	// return this.getSession().get(CalendarBean.class, calendarId);
	// }

	@Override
	public List<CalendarBean> select() {
		return this.getSession().createQuery("from CalendarBean", CalendarBean.class).list();
	}

//	@Override
//	public List<CalendarBean> selectCourseId(int courseId) {
//		return this.getSession().createQuery("from CalendarBean where CourseId = " + courseId, CalendarBean.class)
//				.list();
//	}

	@Override
	public CalendarBean update(int calendarId, int courseId, String courseName, String courseStart, String courseEnd) {
		CalendarBean bean = this.getSession().get(CalendarBean.class, calendarId);
		if (bean != null) {
			bean.setCalendarId(calendarId);
			bean.setCourseId(courseId);
			bean.setCourseName(courseName);
			bean.setCourseStart(courseStart);
			bean.setCourseEnd(courseEnd);
			return bean;
		}
		return null;
	}

	@Override
	public CalendarBean insert(CalendarBean bean) {
		if (bean != null) {
			List<CalendarBean> select = this.select(bean.getCalendarId());
			if (select.isEmpty()) {
				this.getSession().saveOrUpdate(bean);
				return bean;
			}
		}
		return null;
	}

	@Override
	public boolean delete(int calendarId) {
		List<CalendarBean> bean = this.select(calendarId);
		if (bean != null) {
			this.getSession().delete(bean);
			return true;
		}
		return false;
	}

	@Override
	public int deleteCourseId(int courseId) {

		System.out.println("將執行刪除");
		Query query = this.getSession().createQuery("delete from CalendarBean where CourseId = " + courseId);

		System.out.println(courseId + " = " + this.select(courseId));
		return query.executeUpdate();

	}

}
