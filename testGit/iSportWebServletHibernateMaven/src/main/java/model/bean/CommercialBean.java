package model.bean;

import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.HibernateException;



@Entity
@Table(name="COMMERCIAL")
public class CommercialBean {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int commercialId;
	private int gameId;
	private int courseId;
	private String link;
	private Blob pic;
	
	public static void main(String[] args) {
		try {
//			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
//			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			
//			SelectOne
//			DMBean b = session.get(DMBean.class, 1);
//			System.out.println(b);
			
//			SelecetAll
//			Query query = session.createQuery("from DMBean");
//			List<DMBean> list = query.list();
//			for(DMBean b :list) {
//				System.out.print(b.getDmId()+ ",");
//				System.out.print(b.getGameId()+ ",");
//				System.out.print(b.getCourseId() + ",");
//				System.out.print(b.getLink() );
//				System.out.println();
//			}
			
			
//			insert
//			DMBean b = new DMBean();
//			b.setGameId(1);
//			b.setCourseId(0);
//			b.setLink("000");
//			session.save(b);
			
			
//			b.setGameId(0);
//			b.setCourseId(1003);
//			b.setLink("111");
//			session.save(b);
			
//			delete
//			DMBean b = session.get(DMBean.class, 8);
//			session.delete(b);
			
//			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}finally {
//			HibernateUtil.closeSessionFactory();
		}
	}

	public int getCommercialId() {
		return commercialId;
	}

	public void setCommercialId(int commercialId) {
		this.commercialId = commercialId;
	}

	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Blob getPic() {
		return pic;
	}

	public void setPic(Blob pic) {
		this.pic = pic;
	}

	@Override
	public String toString() {
		return "CommercialBean [commercialId=" + commercialId + ", gameId=" + gameId + ", courseId=" + courseId
				+ ", link=" + link + ", pic=" + pic + "]";
	}




	
	
	
	
}
