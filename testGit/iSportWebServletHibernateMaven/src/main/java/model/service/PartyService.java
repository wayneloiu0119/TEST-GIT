package model.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import model.bean.GameBean;
import model.bean.PartyBean;
import model.dao.GameHibernateDAO;
import model.dao.PartyHibernateDAO;
@Repository
public class PartyService {
	@Autowired
	private PartyHibernateDAO partyDao;

	public PartyService(PartyHibernateDAO partyDao) {
		this.partyDao = partyDao;
	}

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			PartyService partyService = (PartyService) context.getBean("partyService");

			// selectOne
//			 System.out.println(partyService.selectOneParty(4));

//			selectMemberParty
//			 System.out.println(partyService.selectMemeberParty(2));

			
			// selectALL
//			 System.out.println(partyService.selectALLParty());

			// insertOneParty
			 PartyBean bean = new PartyBean();
//			 bean.setMemberId(1);
//			 bean.setPartyName("夜跑");
//			 bean.setPartyDate("2017/10/20");
//			 bean.setPartyTime("20:00");
//			 bean.setNumber(3);
//			 bean.setNumberMax(5);
//			 bean.setPartyLocation("大安森林公園");
//			 partyService.insertNewParty(bean);

			// updataPartyInfo
//			PartyBean bean = new PartyBean();
//			bean.setPartyId(8);
//			 bean.setMemberId(1);
//			 bean.setPartyName("夜跑");
//			 bean.setPartyDate("2017/11/20");
//			 bean.setPartyTime("17:00");
//			 bean.setNumber(7);
//			 bean.setNumberMax(10);
//			 bean.setPartyLocation("大安森林公園");
//			 partyService.updatePartyInfo(bean);

			
//			deleteParty
			partyService.deleteParty(8);
			
			
			sessionFactory.getCurrentSession().getTransaction().commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			((ConfigurableApplicationContext) context).close();
		}
	}

private void insertNewParty(GameBean bean) {
		// TODO Auto-generated method stub
		
	}

	// 查詢單筆活動
	public PartyBean selectOneParty(int partyId) {
		PartyBean bean;
		// 查看資料庫是否有該筆資料
		bean = partyDao.select(partyId);
		if (bean != null) {
			// 如果有該筆資料
			return bean;
		}
		System.out.println("查無此項活動");
		return null;
	}

//	查詢該會員建立的活動
	public List<PartyBean> selectMemeberParty(int MemeberId){
		List<PartyBean> beans = null;
		beans = partyDao.selectMemeberParty(MemeberId);
		if(beans != null) {
			return beans;
		}
		System.out.println("尚未建立任何活動");
		return null;
	}
	
	
	// 查詢所有活動
	public List<PartyBean> selectALLParty() {
		List<PartyBean> beans = null;
		beans = partyDao.select();
		if (beans != null) {
			return beans;
		}
		System.out.println("目前尚無任何Party");
		return null;
	}

	// 新增單筆比賽
	public PartyBean insertNewParty(PartyBean bean) {
		// 輸入資料不為null
		if (bean != null) {
			partyDao.insert(bean);
			return bean;
		}
		System.out.println("新增失敗");
		return null;
	}

	// 更改活動資料
	public PartyBean updatePartyInfo(PartyBean bean) {
		PartyBean gb = this.selectOneParty(bean.getPartyId());
		// 檢查資料庫有該筆資料
		if (gb != null) {
			// 該筆資料不為null且gameID不為0
			if (bean != null) {
				partyDao.update(bean);
				System.out.println("活動ID" + bean.getPartyId() + "修改成功");
				return bean;
			}
		}
		System.out.println("修改資料失敗");
		return null;
	}

	// 刪除比賽
	public boolean deleteParty(int partyId) {
		PartyBean bean = this.selectOneParty(partyId);
		// 查詢資料庫是否有該項比賽且不為第0筆
		if (bean != null) {
			partyDao.delete(partyId);
			System.out.println("刪除成功");
			return true;
		}
		System.out.println("刪除失敗");
		return false;
	}
}
