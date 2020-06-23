package model.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import model.AnnouncementDAO;
import model.bean.AnnouncementBean;





@Service
public class AnnouncementService {
	@Autowired
	private AnnouncementDAO announcementDAO;

	public AnnouncementService(AnnouncementDAO announcementDAO) {
		this.announcementDAO = announcementDAO;
	}

//	public static void main(String[] args) {
//		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
//
//		try {
//			SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
//			sessionFactory.getCurrentSession().beginTransaction();
//			AnnouncementService announcementService = (AnnouncementService) context.getBean("announcementService");
//			// 查詢全部
//			List<AnnouncementBean> selects = announcementService.selects(null);
//			System.out.println("selects=" + selects);
//			
//			
//			
//			// 查詢單筆
//			// AnnouncementBean bean = new AnnouncementBean();
//			// bean.setAnnouncementId(1);
//			// List<AnnouncementBean> select1=announcementService.selects(bean);
//			// System.out.println( "select1=" + select1 + "\n");
//			// 新增一筆資料
//			// AnnouncementBean xxx = new AnnouncementBean();
//			// xxx.setMemberId(3);
//			// xxx.setGameId(3);
//			// xxx.setCourseId(0);
//			// xxx.setAnnouncemenText("【新光三越xWORLD GYM】 健美有氧戰鬥營");
//			// AnnouncementBean insert1 = service.insert(xxx);
//			// 更新一筆資料
//			// AnnouncementBean ccc = new AnnouncementBean();
//			// ccc.setMemberId(5);
//			// ccc.setGameId(0);
//			// ccc.setCourseId(1001);
//			// ccc.setAnnouncemenText(null);
//			// ccc.setAnnouncementId(14);
//			// service.update(ccc);
//			// 刪除一筆資料
//			// AnnouncementBean ggg = new AnnouncementBean();
//			// ggg.setAnnouncementId(14);
//			// boolean delete1 = service.delete(ggg);
//			//
//
//			sessionFactory.getCurrentSession().getTransaction().commit();
//		} finally {
//			((ConfigurableApplicationContext) context).close();
//		}
//	}
//
	public List<AnnouncementBean> selects(AnnouncementBean bean) {
		List<AnnouncementBean> result = null;
		if (bean != null && bean.getAnnouncementId() != 0) {
			AnnouncementBean temp = announcementDAO.selectByAnnouncementId(bean.getAnnouncementId());
			if (temp != null) {
				result = new ArrayList<AnnouncementBean>();
				result.add(temp);
			}
		} else {
			result = announcementDAO.select();
		}
		return result;
	}
	
	//**************************************************************
		//查詢 All Game
		public List<Object[]> selectAllGame()  {
			List<Object[]> result = null;
			result = announcementDAO.selectAllGame();
			if(!result.isEmpty()){
				return result;
			}
			return null;
			
			
		}
		//查詢GameId
		public List<Object[]> selectGameId(int gameId) {
			List<Object[]> result = null;
			System.out.println("XXXXXXXXXXXX");
			result = announcementDAO.selectGameId(gameId);
			if(!result.isEmpty() && result.size()!=0){
				return result;
			}
			return null;
		}
		
		//查詢 All Course
			public List<Object[]> selectAllCourse() {
				List<Object[]> result = null;
				result = announcementDAO.selectAllCourse();
				if(!result.isEmpty()){
					return result;
				}
				return null;
			}
			//查詢CourseId
			public List<Object[]> selectCourseId(int courseId) {
				List<Object[]> result = null;
				result = announcementDAO.selectCourseId(courseId);
				if(!result.isEmpty() && result.size()!=0){
					return result;
				}
				return null;
			}
		
		
		//查詢全部
		public List<Object[]> selectAll() {
			List<Object[]> result = null;
			result = announcementDAO.selectAll();
			if(!result.isEmpty()){
				return result;
			}
			return null;
		}
		
		//**************************************************************

	public AnnouncementBean insert(AnnouncementBean bean) {
		AnnouncementBean result = null;
		if (bean != null) {
			result = announcementDAO.insert(bean);
		}
		return result;
	}

	public AnnouncementBean update(AnnouncementBean bean) {
		AnnouncementBean result = null;
		if (bean != null) {
			result = announcementDAO.update(bean.getMemberId(), bean.getGameId(), bean.getCourseId(),
					bean.getAnnouncemenText(), bean.getAnnouncementId());
		}
		return result;
	}

	public boolean delete(AnnouncementBean bean) {
		boolean result = false;
		if (bean != null) {
			result = announcementDAO.delete(bean.getAnnouncementId());
		}
		return result;
	}

}
