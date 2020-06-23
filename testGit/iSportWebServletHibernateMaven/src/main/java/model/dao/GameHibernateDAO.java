package model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.GameDAO;
import model.bean.GameBean;
@Repository
public class GameHibernateDAO implements GameDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	public GameBean select(int gameId) {
		return this.getSession().get(GameBean.class, gameId);
	}

	public List<GameBean> select() {
		return this.getSession().createQuery("from GameBean", GameBean.class).list();
	}

	public GameBean insert(GameBean bean) {
		if (bean != null) {
			GameBean gameBean = this.select(bean.getGameId());
			if (gameBean.getGameId() == 0) {
				this.getSession().save(bean);
				return bean;
			}
		}
		return null;
	}

	public GameBean update(GameBean bean) {
		GameBean gb = this.select(bean.getGameId());
		if (gb != null) {
			gb.setGameName(bean.getGameName());
			gb.setGameDate(bean.getGameDate());
			gb.setGameTime(bean.getGameTime());
			gb.setNumber(bean.getNumber());
			gb.setNumberMax(bean.getNumberMax());
			gb.setGameLocation(bean.getGameLocation());
			gb.setDeadLine(bean.getDeadLine());
			gb.setStates(bean.getStates());
			gb.setTypeId(bean.getTypeId());
			gb.setGameText(bean.getGameText());
			return this.getSession().get(GameBean.class, gb.getGameId());
		}
		return null;
	}

	public boolean delete(int gameId) {
		GameBean gb = this.select(gameId);
		if (gb != null) {
			this.getSession().delete(gb);
			return true;
		}
		return false;
	}

}
