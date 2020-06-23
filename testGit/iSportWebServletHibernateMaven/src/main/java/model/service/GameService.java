package model.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import model.bean.GameBean;
import model.dao.GameHibernateDAO;
@Service
public class GameService {
	@Autowired
	private GameHibernateDAO gameDao;

	public GameService(GameHibernateDAO gameDao) {
		this.gameDao = gameDao;
	}

//	public static void main(String[] args) {
//		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
//		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
//		try {
//			sessionFactory.getCurrentSession().beginTransaction();
//			GameService gameService = (GameService) context.getBean("gameService");

			// selectOne
//			 System.out.println(gameService.selectOneGame(4));

			// selectALL
//			 System.out.println(gameService.selectALLGame());

			// insertOneGame
//			 GameBean bean = new GameBean();
//			 bean.setGameName("舉重");
//			 bean.setGameDate("2017/10/30");
//			 bean.setGameTime("08:00");
//			 bean.setNumber(0);
//			 bean.setNumberMax(10);
//			 bean.setGameLocation("iSport");
//			 bean.setDeadLine("2017/10/15");
//			 bean.setStates("尚未額滿");
//			 bean.setTypeId(20);
//			 bean.setGameText("提升個人肌力、速度、平衡、柔軟性及心肺功能，推廣");
//			 gameService.insertNewGame(bean);

			// updataGameInfo
//			GameBean bean = new GameBean();
//			bean.setGameId(8);
//			bean.setGameName("舉重");
//			bean.setGameDate("2015/11/27");
//			bean.setGameTime("18:00");
//			bean.setNumber(0);
//			bean.setNumberMax(10000);
//			bean.setGameLocation("iSport");
//			bean.setDeadLine("2017/10/15");
//			bean.setStates("尚未額滿");
//			bean.setTypeId(20);
//			bean.setGameText("提升個人肌力、速度、平衡、柔軟性及心肺功能，推廣");
//			gameService.updateGameInfo(bean);

			
//			deleteGame
//			gameService.deleteGame(8);
			
			
//			sessionFactory.getCurrentSession().getTransaction().commit();
//		} catch (HibernateException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			((ConfigurableApplicationContext) context).close();
//		}
//	}

	// 查詢單筆比賽
	public GameBean selectOneGame(int gameId) {
		GameBean bean;
		// 查看資料庫是否有該筆資料
		bean = gameDao.select(gameId);
		if (bean != null && bean.getGameId() != 0) {
			// 如果有該筆資料
			return bean;
		}
		System.out.println("查無此項比賽");
		return null;
	}

	// 查詢所有比賽
	public List<GameBean> selectALLGame() {
		List<GameBean> beans = null;
		beans = gameDao.select();
		if (beans != null) {
			return beans;
		}
		System.out.println("目前尚無任何Game");
		return null;
	}

	// 新增單筆比賽
	public GameBean insertNewGame(GameBean bean) {
		// 輸入資料不為null
		if (bean != null) {
			gameDao.insert(bean);
			return bean;
		}
		System.out.println("新增失敗");
		return null;
	}

	// 更改比賽資料
	public GameBean updateGameInfo(GameBean bean) {
		 GameBean gb = this.selectOneGame(bean.getGameId());
		// 檢查資料庫有該筆資料
		if (gb != null) {
			// 該筆資料不為null且gameID不為0
			if (bean != null && bean.getGameId() != 0) {
				gameDao.update(bean);
				System.out.println("比賽ID" + bean.getGameId() + "修改成功");
				return bean;
			}
		}
		System.out.println("修改資料失敗");
		return null;
	}

	// 刪除比賽
	public boolean deleteGame(int gameId) {
		GameBean bean = this.selectOneGame(gameId);
		// 查詢資料庫是否有該項比賽且不為第0筆
		if (bean != null && bean.getGameId() != 0) {
			gameDao.delete(gameId);
			System.out.println("刪除成功");
			return true;
		}
		System.out.println("刪除失敗");
		return false;
	}

}
