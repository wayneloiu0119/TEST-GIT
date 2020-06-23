package model.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import model.bean.CommercialBean;
import model.dao.CommercialHibernateDAO;

@Service
public class CommercialService {
	@Autowired
	private CommercialHibernateDAO commDao ;
	public CommercialService(CommercialHibernateDAO commDao) {
		this.commDao = commDao;
	}

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			CommercialService commService = (CommercialService) context.getBean("commercialService");

//		selectOne
//			System.out.println(commService.selectOneCommercial(2));
			
			
//		selectAll
//			System.out.println(commService.selectAllCommercial());
			
			
//		insertNewDM
			CommercialBean bean = new CommercialBean();
//			bean.setCourseId(0);
//			bean.setGameId(2);
//			commService.insertNewGameDM(bean);
			
//			insertCourseID
//			DMBean bean = new DMBean();
//			bean.setCourseId(1002);
//			bean.setGameId(0);
//			commService.insertNewGcourseDM(bean);
			
			
//			delete
//			System.out.println(commService.deleteCommercial(8));
			
			
			
			sessionFactory.getCurrentSession().getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}finally {
			((ConfigurableApplicationContext) context).close();
		}
	}
	
	
	
	
	// 查詢單筆DM
	public CommercialBean selectOneCommercial(int commercialId) {
		// 檢查資料客是否有這筆資料
		CommercialBean bean = commDao.select(commercialId);
		if (bean != null) {

			// 資料庫有這筆資料
			return bean;
		}
		System.out.println("查無此DM");
		return null;
	}

	// 查詢全部Dm
	public List<CommercialBean> selectAllCommercial() {
		List<CommercialBean> beans = null;
		beans = commDao.select();
		// 檢查資料庫是否有任一筆Dm
		if (beans != null) {
			return beans;
		}
		System.out.println("目前尚無任何DM");
		return null;
	}

	// 新增一筆GameDM
	public CommercialBean insertNewGameDM(CommercialBean bean) {
		// 檢查bean是否為null
		if (bean != null) {
			if(bean.getGameId() != 0) {
				bean.setCourseId(0);
				commDao.insert(bean);
				return bean;
			}
			System.out.println("請輸入正確GameID");
		}
		return null;
	}

	
	//新增一筆CourseDM
	public CommercialBean insertNewGcourseDM(CommercialBean bean) {
		// 檢查bean是否為null
		if (bean != null) {
			if(bean.getCourseId() !=0) {
				bean.setGameId(0);
				commDao.insert(bean);
				return bean;	
			}
			System.out.println("請輸入正確CourseID");
		}
		return null;
	}
	
	
	// 刪除Dm
	public boolean deleteCommercial(int commercialId) {
		// 檢查資料庫是否有該筆資料
		CommercialBean bean = commDao.select(commercialId);
		if (bean != null) {
			commDao.delete(bean.getCommercialId());
			System.out.println("刪除成功");
			return true;
		}
		System.out.println("刪除失敗，請輸入正確DM的ID");
		return false;
	}

}
