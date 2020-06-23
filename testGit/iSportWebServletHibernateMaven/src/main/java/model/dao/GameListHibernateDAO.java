package model.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.GameListDAO;
import model.bean.GameListBean;

@Repository
public class GameListHibernateDAO implements GameListDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	public List<Object[]> selectByMemeberId(int memberId) {
		return this.getSession().createNativeQuery("SELECT Game.GameId, Game.GameName, Game.GameDate, Game.GameTime, GameList.MemberId,GameList.GameJoinDate, GameList.GameJoinTime, Game.GameLocation, Game.States, Game.DeadLine FROM Game INNER JOIN GameList ON Game.GameId = GameList.GameId  where GameList.MemberId = " + memberId)
				.list();
	}

	public List<Object[]> selectByGameId(int gameId) {
		return this.getSession().createNativeQuery("SELECT Game.GameId, Game.GameName, Game.GameDate, Game.GameTime, GameList.MemberId,GameList.GameJoinDate, GameList.GameJoinTime, Game.GameLocation, Game.States, Game.DeadLine FROM Game INNER JOIN GameList ON Game.GameId = GameList.GameId   where Game.GameId = " + gameId).list();
		}

	public List<Object[]> selectAll() {
		return this.getSession().createNativeQuery("SELECT Game.GameId, Game.GameName, Game.GameDate, Game.GameTime, GameList.MemberId,GameList.GameJoinDate, GameList.GameJoinTime, Game.GameLocation, Game.States, Game.DeadLine FROM Game INNER JOIN GameList ON Game.GameId = GameList.GameId").list();
		}

	public GameListBean selectByOne(int memberId, int gameId) {
		List<GameListBean> list = new ArrayList<GameListBean>();
		list = this.getSession().createQuery("from GameListBean where MemberId = " + memberId + "AND gameId =" + gameId,
				GameListBean.class).list();
		// list陣列內無資料 Size為0
		if (list.size() == 0) {
			return null;
		} else {
			// 有資料回傳List內第一筆資料
			return list.get(0);
		}
	}

	public boolean insert(GameListBean bean) {
		if (bean != null) {
			GameListBean glb = this.selectByOne(bean.getMemberId(), bean.getGameId());
			if (glb == null) {
				this.getSession().save(bean);
				return true;
			}
		}
		return false;
	}

	public boolean delete(int memberId, int gameId) {
		GameListBean glb = this.selectByOne(memberId, gameId);
		if (glb != null) {
			this.getSession().delete(glb);
			return true;
		} else {
			return false;
		}
	}
}
