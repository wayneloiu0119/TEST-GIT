package model.bean;

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
@Table(name="GAME")
public class GameBean {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int gameId;
	private String gameName;
	private String gameDate;
	private String gameTime;
	private int number;
	private int numberMax;
	private String gameLocation;
	private String deadLine;
	private String states;
	private int typeId;
	private String gameText;
	
	
	public static void main(String[] args) {
		try {
//			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
//			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			
			
			//selectOne
//			GameBean select = session.get(GameBean.class, 1);
//			System.out.println(select);
			
			
//			selectAll
//			Query query = session.createQuery("from GameBean");
//			List<GameBean> list = query.list();
//			for (GameBean gb : list) {
//				System.out.print(gb.getGameId()+ ",");
//				System.out.print(gb.getGameName()+ ",");
//				System.out.print(gb.getGameDate() + ",");
//				System.out.print(gb.getGameTime() + ",");
//				System.out.print(gb.getNumber() + ",");
//				System.out.print(gb.getNumberMax() + ",");
//				System.out.print(gb.getGameLocation() + ",");
//				System.out.print(gb.getDeadLine() +",");
//				System.out.print(gb.getStates() +",");
//				System.out.print(gb.getTypeId() +",");
//				System.out.print(gb.getGameText() +",");
//				System.out.println();
//			}
			
//			insert
//			GameBean insert = new GameBean();
//			insert.setGameName("舉重");
//			insert.setGameDate("2017/10/30");
//			insert.setGameTime("17:00");
//			insert.setNumber(5);
//			insert.setNumberMax(10);
//			insert.setGameLocation("iSport");
//			insert.setDeadLine("2017/10/15");
//			insert.setStates("尚未額滿");
//			insert.setTypeId(20);
//			insert.setGameText("提升個人肌力、速度、平衡、柔軟性及心肺功能");
//			session.save(insert);

//			update
//			GameBean update = new GameBean();
//			update.setGameId(9);
//			update.setGameName("舉重");
//			update.setGameDate("2017/9/30");
//			update.setGameTime("17:00");
//			update.setNumber(5);
//			update.setNumberMax(100);
//			update.setGameLocation("iSport");
//			update.setDeadLine("2017/10/15");
//			update.setStates("尚未額滿");
//			update.setTypeId(20);
//			update.setGameText("提升個人肌力、速度、平衡、柔軟性及心肺功能");
//			session.update(update);
			
//			delete
//			GameBean delete = session.get(GameBean.class, 9);
//			session.delete(delete);
			
			
//			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}finally {
//			HibernateUtil.getSessionFactory().close();
		}
		
		
	}


	@Override
	public String toString() {
		return "GameBean [gameId=" + gameId + ", gameName=" + gameName + ", gameDate=" + gameDate + ", gameTime="
				+ gameTime + ", number=" + number + ", numberMax=" + numberMax + ", gameLocation=" + gameLocation
				+ ", deadLine=" + deadLine + ", states=" + states + ", typeId=" + typeId + ", gameText=" + gameText
				+ "]";
	}


	public int getGameId() {
		return gameId;
	}


	public void setGameId(int gameId) {
		this.gameId = gameId;
	}


	public String getGameName() {
		return gameName;
	}


	public void setGameName(String gameName) {
		this.gameName = gameName;
	}


	public String getGameDate() {
		return gameDate;
	}


	public void setGameDate(String gameDate) {
		this.gameDate = gameDate;
	}


	public String getGameTime() {
		return gameTime;
	}


	public void setGameTime(String gameTime) {
		this.gameTime = gameTime;
	}


	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	public int getNumberMax() {
		return numberMax;
	}


	public void setNumberMax(int numberMax) {
		this.numberMax = numberMax;
	}


	public String getGameLocation() {
		return gameLocation;
	}


	public void setGameLocation(String gameLocation) {
		this.gameLocation = gameLocation;
	}


	public String getDeadLine() {
		return deadLine;
	}


	public void setDeadLine(String deadLine) {
		this.deadLine = deadLine;
	}


	public String getStates() {
		return states;
	}


	public void setStates(String states) {
		this.states = states;
	}


	public int getTypeId() {
		return typeId;
	}


	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}


	public String getGameText() {
		return gameText;
	}


	public void setGameText(String gameText) {
		this.gameText = gameText;
	}
	
}
