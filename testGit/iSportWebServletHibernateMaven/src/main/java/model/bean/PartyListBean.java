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
@Table(name="PartyList")
public class PartyListBean {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int partyListId;
	private int partyId;
	private int memberId;
	private String partyJoinDate;
	private String partyJoinTime;
	
	public static void main(String[] args) {
		
		try {
//			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
//			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			
//			select
//			PartyListBean b = session.get(PartyListBean.class, 2);
//			System.out.println(b);
			
			
			
//			selectAll
//			Query query = session.createQuery("from PartyListBean");
//			List<PartyListBean> list = query.list();
//			for (PartyListBean gb : list) {
//				System.out.print(gb.getPartyListId() + ",");
//				System.out.print(gb.getPartyId() + ",");
//				System.out.print(gb.getMemberId() + ",");
//				System.out.print(gb.getPartyJoinDate() + ",");
//				System.out.print(gb.getPartyJoinTime());
//				System.out.println();
//			}
			
//			insert
//			PartyListBean plb = new PartyListBean();
//			plb.setPartyId(3);;
//			plb.setMemberId(5);
//			plb.setPartyJoinDate("2017/01/20");
//			plb.setPartyJoinTime("15:20");
//			session.save(plb);
			
//			update
//			PartyListBean plb = new PartyListBean();
//			plb.setPartyListId(9);
//			plb.setPartyId(3);;
//			plb.setMemberId(5);
//			plb.setPartyJoinDate("2000/01/25");
//			plb.setPartyJoinTime("10:20");
//			session.update(plb);

			
//			delete
//			PartyListBean plb = session.get(PartyListBean.class, 9);
//			session.delete(plb);
			
			
			
//			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
//			HibernateUtil.closeSessionFactory();
		}
		
	}

	public int getPartyListId() {
		return partyListId;
	}

	public void setPartyListId(int partyListId) {
		this.partyListId = partyListId;
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

	public String getPartyJoinDate() {
		return partyJoinDate;
	}

	public void setPartyJoinDate(String partyJoinDate) {
		this.partyJoinDate = partyJoinDate;
	}

	public String getPartyJoinTime() {
		return partyJoinTime;
	}

	public void setPartyJoinTime(String partyJoinTime) {
		this.partyJoinTime = partyJoinTime;
	}

	@Override
	public String toString() {
		return "PartyListBean [partyListId=" + partyListId + ", partyId=" + partyId + ", memberId=" + memberId
				+ ", partyJoinDate=" + partyJoinDate + ", partyJoinTime=" + partyJoinTime + "]";
	}
	
	

	
	
}
