package model.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import model.bean.GameListBean;
import model.dao.GameListHibernateDAO;

@Service
public class GameListService {
	@Autowired
	private GameListHibernateDAO glDAO;

	public GameListService(GameListHibernateDAO glDAO) {
		this.glDAO = glDAO;
	}


	// 顯示會員加入哪比賽
	public List<Object[]> showGameByMemberId(int memberId) {
		List<Object[]> beans = null;
		beans = glDAO.selectByMemeberId(memberId);
		if (beans != null) {
			return beans;
		}
		System.out.println("目前未加入任何比賽");
		return null;
	}

	// 顯示比賽有哪些人參加
	public List<Object[]> showMemberByGameId(int gameId) {
		List<Object[]> beans = null;
		beans = glDAO.selectByGameId(gameId);
		// 判斷該項比賽是否有參賽者
		if (beans != null && beans.size() != 0) {
			return beans;
		}
		System.out.println("比賽尚未有會員加入");
		return null;
	}

	// 顯示所有比賽內的所有成員
	public List<Object[]> selectAllGameAllMember() {
		List<Object[]> beans = null;
		beans = glDAO.selectAll();
		if (beans != null) {
			return beans;
		}
		System.out.println("尚未有參賽者參加任何比賽");
		return null;
	}

	// 顯示該會員是否有在該比賽內
	public GameListBean checkMemeberInGame(int memberId, int gameId) {
		GameListBean bean = glDAO.selectByOne(memberId, gameId);
		if (bean != null) {
			return bean;
		}
		System.out.println("尚未加入比賽");
		return null;
	}

	// 會員加入比賽
	public GameListBean joinGame(GameListBean bean) {
		// 判斷會員是否已加入，避免重複
		GameListBean glb = this.checkMemeberInGame(bean.getMemberId(), bean.getGameId());
		if (glb == null) {
			Date tempDate = new java.util.Date();
			SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy/MM/dd");
			SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");
			String gameJoinDate = sdfDate.format(tempDate);
			String gameJoinTime = sdfTime.format(tempDate);
			bean.setGameJoinDate(gameJoinDate);
			bean.setGameJoinTime(gameJoinTime);
			glDAO.insert(bean);
			return bean;
		}
		System.out.println("你已經加入該比賽");
		return null;
	}

	// 會員退出比賽
	public boolean quitGame(int memberId, int gameId) {
		GameListBean bean = this.checkMemeberInGame(memberId, gameId);
		if (bean != null) {
			glDAO.delete(bean.getMemberId(), bean.getGameId());
			return true;
		}
		System.out.println("無該筆資料(已經刪除)");
		return false;
	}
}
