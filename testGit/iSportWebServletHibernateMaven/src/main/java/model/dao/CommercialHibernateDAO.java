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

import model.CommercialDAO;
import model.bean.CommercialBean;


@Repository
public class CommercialHibernateDAO implements CommercialDAO {
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
			CommercialHibernateDAO dao = (CommercialHibernateDAO) context.getBean("commercialHibernateDAO");

			// Select
//			 System.out.println(dao.select(1));

			// SelectAll
//			 List<CommercialBean> select = dao.select();
//			 System.out.println(select);

			// insert
//			CommercialBean db = new CommercialBean();
//			 db.setGameId(0);
//			 db.setCourseId(1003);
//			 dao.insert(db);

			// update
//			 db.setCommercialId(6);
//			 db.setGameId(1);
//			 db.setCourseId(0);
//			 dao.update(db);

			// delete
			 System.out.println(dao.delete(7));

			sessionFactory.getCurrentSession().getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			((ConfigurableApplicationContext) context).close();
		}

	}

	public CommercialBean select(int commercialId) {
		return this.getSession().get(CommercialBean.class, commercialId);
	}

	public List<CommercialBean> select() {
		return this.getSession().createQuery("From CommercialBean", CommercialBean.class).list();
	}

	public boolean insert(CommercialBean bean) {
		if (bean != null) {
			CommercialBean selectId = this.select(bean.getCommercialId());
			if (selectId == null) {
				this.getSession().save(bean);
				return true;
			}
		}
		return false;
	}

	public CommercialBean update(CommercialBean bean) {
		// 先用Id把資料庫內現有該Id欄位資料放置update
		CommercialBean update = this.select(bean.getCommercialId());
		if (update != null) {
			// 將新的(bean)資料放置update
			update.setGameId(bean.getGameId());
			update.setLink(bean.getLink());
			update.setPic(bean.getPic());
			// 將新的update丟回資料庫
			return this.getSession().get(CommercialBean.class, update.getCommercialId());
		}
		return null;
	}

	public boolean delete(int commercialId) {
		CommercialBean dmBean = this.select(commercialId);
		if (dmBean != null) {
			this.getSession().delete(dmBean);
			return true;
		}
		return false;
	}

}
