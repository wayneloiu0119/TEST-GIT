package model.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import model.BlackFriendDAO;
import model.bean.BlackFriendBean;




@Service
public class BlackFriendService {

	private BlackFriendDAO blackFriendDAO;

	public BlackFriendService(BlackFriendDAO blackFriendDAO) {
		this.blackFriendDAO = blackFriendDAO;
	}

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");

		try {
			sessionFactory.getCurrentSession().beginTransaction();
			BlackFriendService blackFriendService = (BlackFriendService) context.getBean("blackFriendService");
			// 查詢全部

			List<BlackFriendBean> selects = blackFriendService.selects(null);
			System.out.println("selects=" + selects);
			// //查詢單筆
			// BlackFriendBean bean = new BlackFriendBean();
			// bean.setBlackFriendId(1);
			// List<BlackFriendBean> select1=service.selects(bean);
			// System.out.println( "select1=" + select1 + "\n");
			// //新增一筆資料
			// BlackFriendBean xxx = new BlackFriendBean();
			// xxx.setMemberId(3);
			// xxx.setRelationMemberId(5);
			// xxx.setRelationMemberId(5);
			// xxx.setStates("審核中..");
			// BlackFriendBean insert1 = service.insert(xxx);
			// //更新一筆資料
			// BlackFriendBean ccc = new BlackFriendBean();
			// ccc.setMemberId(5);
			// ccc.setRelationMemberId(5);;
			// ccc.setRelationMemberId(5);
			// ccc.setStates("審核中..");
			// ccc.setBlackFriendId(2);
			// service.update(ccc);
			// //刪除一筆資料
			// BlackFriendBean ggg = new BlackFriendBean();
			// ggg.setBlackFriendId(5);
			// boolean delete1 = service.delete(ggg);
			//

			sessionFactory.getCurrentSession().getTransaction().commit();
		} finally {
			((ConfigurableApplicationContext) context).close();
		}
	}

	public List<BlackFriendBean> selects(BlackFriendBean bean) {
		List<BlackFriendBean> result = null;
		if (bean != null && bean.getBlackFriendId() != 0) {
			BlackFriendBean temp = blackFriendDAO.select(bean.getBlackFriendId());
			if (temp != null) {
				result = new ArrayList<BlackFriendBean>();
				result.add(temp);
			}
		}else {
			result = blackFriendDAO.select();
		}
		return result;
	}

	// *****************************************************************
		// MimberID 查詢
		public List<Object[]> selectFriendMemberId(int memberId) {
			List<Object[]> result = null;
			result = blackFriendDAO.selectMemberId(memberId);
			if (!result.isEmpty()) {
				return result;
			}
			return null;
		}

		// 關係 查詢
		public List<Object[]> selectFriendType(int memberId, String blackFriendType) {
			List<Object[]> result = null;
			result = blackFriendDAO.selectFrienType(memberId, blackFriendType);
			if (!result.isEmpty()) {
				return result;
			}
			return null;
		}

		// *****************************************************************
	
	
	
	public BlackFriendBean insert(BlackFriendBean bean) {
		BlackFriendBean result = null;
		if (bean != null) {
			result = blackFriendDAO.insert(bean);
		}
		return result;
	}

	public BlackFriendBean update(BlackFriendBean bean) {
		BlackFriendBean result = null;
		if (bean != null) {
			result = blackFriendDAO.update(bean.getMemberId(), bean.getRelationMemberId(), bean.getBlackFriendType(),
					bean.getStates(), bean.getBlackFriendId());
		}
		return result;
	}

	public boolean delete(BlackFriendBean bean) {
		boolean result = false;
		if (bean != null) {
			result = blackFriendDAO.delete(bean.getBlackFriendId());
		}
		return result;
	}

}
