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
@Table(name="PARTY")
public class PartyBean {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int partyId;
	private int memberId;
	private String partyName;
	private String partyDate;
	private String partyTime;
	private int number;
	private int numberMax;
	private String partyLocation;

	
	public static void main(String[] args) {
		try {
//			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
//			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			
			
//			Select
//			PartyBean p = session.get(PartyBean.class, 11);
//			System.out.println(p);
			
//			selectAll
//			Query query = session.createQuery("from PartyBean");
//			List<PartyBean> list = query.list();
//			for (PartyBean pb : list) {
//				System.out.print(pb.getPartyId() + ",");
//				System.out.print(pb.getMemberId()+ ",");
//				System.out.print(pb.getPartyName() + ",");
//				System.out.print(pb.getPartyDate() + ",");
//				System.out.print(pb.getPartyTime() + ",");
//				System.out.print(pb.getNumber() + ",");
//				System.out.print(pb.getNumberMax() + ",");
//				System.out.print(pb.getPartyLocation() );
//				System.out.println();
//			}
			
//			insert
//			PartyBean insert = new PartyBean();
//			insert.setMemberId(4);
//			insert.setPartyName("夜跑");
//			insert.setPartyDate("2017/10/20");
//			insert.setPartyTime("20:00");
//			insert.setNumber(3);
//			insert.setNumberMax(5);
//			insert.setPartyLocation("大安森林公園");
//			session.save(insert);
//			System.out.println(insert);
			
			
			
//			update
//			PartyBean update = new PartyBean();
//			update.setPartyId(13);
//			update.setMemberId(4);
//			update.setPartyName("夜跑");
//			update.setPartyDate("2017/10/20");
//			update.setPartyTime("20:00");
//			update.setNumber(5);
//			update.setNumberMax(5);
//			update.setPartyLocation("大安森林公園");
//			session.update(update);
			
//			delete
//			PartyBean delete = session.get(PartyBean.class, 13);
//			session.delete(delete);
			
//			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}finally {
//			HibernateUtil.closCeSessionFactory();
		}
		
	}


	@Override
	public String toString() {
		return "partyBean [partyId=" + partyId + ", memberId=" + memberId + ", partyName=" + partyName + ", partyDate="
				+ partyDate + ", partyTime=" + partyTime + ", number=" + number + ", numberMax=" + numberMax
				+ ", partyLocation=" + partyLocation + "]";
	}


	public int getPartyId() {
		return partyId;
	}


	public void setPartyId(int partyId) {
		this.partyId = partyId;
	}


	public int getMemberId() {
		return memberId;
	}


	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}


	public String getPartyName() {
		return partyName;
	}


	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}


	public String getPartyDate() {
		return partyDate;
	}


	public void setPartyDate(String partyDate) {
		this.partyDate = partyDate;
	}


	public String getPartyTime() {
		return partyTime;
	}


	public void setPartyTime(String partyTime) {
		this.partyTime = partyTime;
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


	public String getPartyLocation() {
		return partyLocation;
	}


	public void setPartyLocation(String partyLocation) {
		this.partyLocation = partyLocation;
	}
	
}
