package model.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import model.PartyDAO;
import model.bean.PartyBean;

@Repository
public class PartyHibernateDAO implements PartyDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
		try {

			sessionFactory.getCurrentSession().beginTransaction();
			PartyHibernateDAO dao = (PartyHibernateDAO) context.getBean("partyHibernateDAO");

			// SleectALL
//			 System.out.println(dao.select());

			// selectMemberParty
//			 System.out.println(dao.selectMemeberParty(2));

			// SelectOne
//			 System.out.println(dao.select(1));

			// Insert
			PartyBean pb = new PartyBean();
//			 pb.setPartyName("夜跑");
//			 pb.setMemberId(2);
//			 pb.setPartyDate("2017/10/20");
//			 pb.setPartyTime("20:00");
//			 pb.setNumber(3);
//			 pb.setNumberMax(5);
//			 pb.setPartyLocation("大安森林公園");
//			 dao.insert(pb);

			// update
			// pb.setPartyId(6);
			// pb.setPartyName("夜跑");
			// pb.setMemberId(2);
			// pb.setPartyDate("2017/10/20");
			// pb.setPartyTime("20:00");
			// pb.setNumber(3);
			// pb.setNumberMax(1000);
			// pb.setPartyLocation("你家大爆炸");
			// dao.update(pb);

			// delete
//			 dao.delete(7);

			sessionFactory.getCurrentSession().getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {

			((ConfigurableApplicationContext) context).close();
		}

	}

	public PartyBean select(int partyId) {
		return this.getSession().get(PartyBean.class, partyId);
	}

	public List<PartyBean> selectMemeberParty(int MemeberId) {
		return this.getSession().createQuery("From PartyBean where MemberId = " + MemeberId, PartyBean.class).list();
	}

	public List<PartyBean> select() {
		return this.getSession().createQuery("From PartyBean", PartyBean.class).list();
	}

	public boolean insert(PartyBean bean) {
		if (bean != null) {
			PartyBean pb = this.select(bean.getPartyId());
			if (pb == null) {
				this.getSession().save(bean);
				return true;
			}
		}
		return false;
	}

	public PartyBean update(PartyBean bean) {
		PartyBean pb = this.select(bean.getPartyId());
		if (pb != null) {
			pb.setPartyName(bean.getPartyName());
			pb.setPartyDate(bean.getPartyDate());
			pb.setPartyTime(bean.getPartyTime());
			pb.setNumber(bean.getNumber());
			pb.setNumberMax(bean.getNumberMax());
			pb.setPartyLocation(bean.getPartyLocation());
			return this.getSession().get(PartyBean.class, pb.getPartyId());
		}
		return null;
	}

	public boolean delete(int partyId) {
		PartyBean pb = this.select(partyId);
		if (pb != null) {
			this.getSession().delete(pb);
			return true;
		}
		return false;
	}

}
