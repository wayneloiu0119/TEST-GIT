package model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import model.TypeDAO;
import model.bean.TypeBean;

@Repository
public class TypeDAOHibernate implements TypeDAO {

	///////////////////////////////////////////////////////////////////////////////////////
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
		try {
			SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
			sessionFactory.getCurrentSession().beginTransaction();

			TypeDAO typeDAOJdbc = (TypeDAO) context.getBean("typeDAOHibernate");

			// Select
			TypeBean select = typeDAOJdbc.select(10);
			System.out.println("select =" + select);
			List<TypeBean> selects = typeDAOJdbc.select();
			System.out.println("selects =" + selects);

			// Insert
			TypeBean typeBean = new TypeBean();
			 typeBean.setTypeName("幹GG");
			// TypeBean insert = typeDAOJdbc.insert(typeBean);
			// System.out.println("insert =" + insert);

			// Update
			TypeBean update = typeDAOJdbc.update("反重力基礎課程", 10);
			System.out.println("update = " + update);

			// Delete
			boolean delete = typeDAOJdbc.delete(80);
			System.out.println("delete =" + delete);
			sessionFactory.getCurrentSession().getTransaction().commit();
		} finally {
			((ConfigurableApplicationContext) context).close();
		}

	}

	///////////////////////////////////////////////////////////////////////////////////////

	@Autowired
	private SessionFactory sessionFactory;

	public TypeDAOHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;

	}

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public TypeBean select(int typeid) {

		return this.getSession().get(TypeBean.class, typeid);
	}

	@Override
	public List<TypeBean> select() {
		return this.getSession().createQuery("FROM TypeBean", TypeBean.class).list();
	}

	@Override
	public TypeBean insert(TypeBean bean) {
		if (bean != null) {
			TypeBean select = this.select(bean.getTypeId());
			if (select == null) {
				this.getSession().save(bean);
				return bean;
			}
		}
		return null;
	}

	@Override
	public TypeBean update(String typeName, int typeId) {
		TypeBean bean = this.select(typeId);
		if (bean != null) {
			bean.setTypeName(typeName);
			return bean;
		}
		return null;
	}

	@Override
	public boolean delete(int typeId) {
		TypeBean select = this.select(typeId);
		if (select != null) {
			this.getSession().delete(select);
			return true;
		}
		return false;
	}
}
