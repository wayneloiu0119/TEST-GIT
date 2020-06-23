package model.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;


@Entity
@Table(name="GAMELIST")
public class GameListBean implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int gameListId;
	private int gameId;
	private int memberId;
	private String gameJoinDate;
	private String gameJoinTime;
	
	public static void main(String[] args) {
	
		try {
//			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
//			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			
//			select
//			GameListBean b = session.get(GameListBean.class, 2);
			
//			selectAll
//			Query query = session.createQuery("from GameListBean");
//			List<GameListBean> list = query.list();
//			for (GameListBean gb : list) {
//				System.out.print(gb.gameListId+ ",");
//				System.out.print(gb.getGameId()+ ",");
//				System.out.print(gb.getMemberId() + ",");
//				System.out.print(gb.getGameJoinDate() + ",");
//				System.out.print(gb.getGameJoinTime());
//				System.out.println();
//			}
			
//			insert
//			GameListBean glb = new GameListBean();
//			glb.setGameId(2);
//			glb.setMemberId(5);
//			glb.setGameJoinDate("2017/01/20");
//			glb.setGameJoinTime("15:20");
//			session.save(glb);
			
//			update
//			GameListBean glb = new GameListBean();
//			glb.setGameListId(7);
//			glb.setGameId(3);
//			glb.setMemberId(3);
//			glb.setGameJoinDate("2000/01/20");
//			glb.setGameJoinTime("17:20");
//			session.update(glb);

			
//			delete
//			GameListBean glb = session.get(GameListBean.class, 7);
//			session.delete(glb);
			
//			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}finally {
//			HibernateUtil.closeSessionFactory();
		}
		
	}
	
	public int getGameListId() {
		return gameListId;
	}
	public void setGameListId(int gameListId) {
		this.gameListId = gameListId;
	}
	public int getGameId() {
		return gameId;
	}
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getGameJoinDate() {
		return gameJoinDate;
	}
	public void setGameJoinDate(String gameJoinDate) {
		this.gameJoinDate = gameJoinDate;
	}
	public String getGameJoinTime() {
		return gameJoinTime;
	}
	public void setGameJoinTime(String gameJoinTime) {
		this.gameJoinTime = gameJoinTime;
	}
	@Override
	public String toString() {
		return "gameListBean [gameListId=" + gameListId + ", gameId=" + gameId + ", memberId=" + memberId
				+ ", gameJoinDate=" + gameJoinDate + ", gameJoinTime=" + gameJoinTime + "]";
	}
	
	
	
}
