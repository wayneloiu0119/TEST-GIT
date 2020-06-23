package model.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Blob;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import model.CourseDAO;
import model.bean.CourseBean;

@Repository
public class CourseDAOHibernate implements CourseDAO {
	public static void main(String[] args) throws FileNotFoundException {
		ApplicationContext context=new ClassPathXmlApplicationContext("beans.config.xml");
		try {
			SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
			sessionFactory.getCurrentSession().beginTransaction();			
			CourseDAO courseDAO = (CourseDAO)context.getBean("courseDAOHibernate");
			
			//insert
			CourseBean bean = new CourseBean();
//			bean.setCourseId(courseId);
			bean.setCourseName("伏地挺身xxx");
			bean.setCourseStartDate(new Date());
			bean.setCourseEndDate(new Date());
			bean.setCourseStartTime("15:00:00");
			bean.setCourseEndTime("17:00:00");
			bean.setFrequency(10);
			bean.setCoursePrice(1000);
			bean.setDiscount(1);
			bean.setDiscountPrice(1000);
			bean.setCourseKind("團體");
			bean.setTypeId(20);
			//insert image
			File file = new File("images/nba.jpg");
			FileInputStream fis = new FileInputStream(file);
			// https://stackoverflow.com/questions/20614973/read-write-blob-data-in-chunks-with-hibernate
			Blob photo = courseDAO.getSession().getLobHelper().createBlob(fis, file.length());
			bean.setCoursePic(photo);
			
			bean.setRoomId(101);
			bean.setMemberId(1);
			CourseBean insert=courseDAO.insert(bean);
			System.out.println("insert = "+insert+"\n");
			
			//update1
//			boolean update = courseDAO.update(1007, "飛輪海", new Date(11), new Date(8888), "15:00:00", "17:00:00", 
//					6, 5000d, 1d, 5000d, "私人", 20, null, 101, 1);
//			System.out.println("update = "+update+"\n");
			//update2
//			CourseBean bean = new CourseBean();
//			bean.setCourseId(1001);
//			bean.setCourseName("伏地挺身xxxx");
//			bean.setCourseStartDate(new Date());
//			bean.setCourseEndDate(new Date(86400));
//			bean.setCourseStartTime("15:00:00");
//			bean.setCourseEndTime("17:00:00");
//			bean.setFrequency(10);
//			bean.setCoursePrice(1000d);
//			bean.setDiscount(1d);
//			bean.setDiscountPrice(1000d);
//			bean.setCourseKind("團體");
//			bean.setTypeId(20);
//			bean.setCoursePic(null);
//			bean.setRoomId(101);
//			bean.setMemberId(1);
//			CourseBean update2=courseDAO.update(bean);
//			System.out.println("update="+update2);

			// Delete
//			boolean delete = courseDAO.delete(1007);
//			System.out.println("delete = " + delete);
//			
			//select
			CourseBean select=courseDAO.select(1001);
			System.out.println("select = "+select+"\n");
			
			
			sessionFactory.getCurrentSession().getTransaction().commit();
		} finally {
			((ConfigurableApplicationContext)context).close();
		}
	}
	
	private SessionFactory sessionFactory;
	public CourseDAOHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public CourseBean select(int courseId) {
		return this.getSession().get(CourseBean.class, courseId);
	}
	
	@Override
	public List<CourseBean> select(){
		return this.getSession().createQuery("FROM CourseBean",CourseBean.class).list();
	}
	
//	@Override
//	public CourseBean update(CourseBean bean) {
//			CourseBean select = this.select(bean.getCourseId());
//			if(select!=null) {
//				this.getSession().saveOrUpdate(select);
//				return bean;
//			}
//		return null;
//	}
	
	@Override
	public CourseBean insert(CourseBean bean) {
		if(bean!=null) {
			CourseBean select = this.select(bean.getCourseId());
			if(select==null) {
				this.getSession().saveOrUpdate(bean);
				return bean;
			}
		}
		return null;
	}
	
	@Override
	public CourseBean update(int courseId, String courseName, Date courseStartDate, Date courseEndDate, String courseWeek, 
			String courseStartTime, String courseEndTime, int frequency, double coursePrice, double discount, 
			double discountPrice, int typeId, String courseKind, Blob coursePic, int roomId, int memberId) {
//		CourseBean bean = this.getSession().get(CourseBean.class, courseId);
		CourseBean bean=this.select(courseId);
		if(bean!=null) {
			bean.setCourseId(courseId);
			bean.setCourseName(courseName);
			bean.setCourseStartDate(courseStartDate);
			bean.setCourseEndDate(courseEndDate);
			bean.setCourseWeek(courseWeek);	
			bean.setCourseStartTime(courseStartTime);
			bean.setCourseEndTime(courseEndTime);
			bean.setFrequency(frequency);
			bean.setCoursePrice(coursePrice);
			bean.setDiscount(discount);
			bean.setDiscountPrice(discountPrice);
			bean.setTypeId(typeId);
			bean.setCourseKind(courseKind);
			bean.setCoursePic(coursePic);
			bean.setRoomId(roomId);
			bean.setMemberId(memberId);
			
			return bean;
		}
		return null;
	}
	
	@Override
	public boolean delete(int courseId) {
		CourseBean bean = this.select(courseId);
		if(bean!=null) {
			this.getSession().delete(bean);
			return true;	
		}
		return false;
	}
	
	
}
