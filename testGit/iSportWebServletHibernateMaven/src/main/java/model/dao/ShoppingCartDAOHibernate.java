package model.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import model.ShoppingCartDAO;
import model.bean.ShoppingCartBean;

@Repository
public class ShoppingCartDAOHibernate implements ShoppingCartDAO {

	///////////////////////////////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
		try {
			SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
			sessionFactory.getCurrentSession().beginTransaction();

			ShoppingCartDAO shoppingCartDAO = (ShoppingCartDAO) context.getBean("shoppingCartDAOHibernate");
			// Select
			ShoppingCartBean select = shoppingCartDAO.select(1);
			System.out.println("select = " + select);

			List<ShoppingCartBean> selects = shoppingCartDAO.select();
			System.out.println("selects = " + selects);

			// Insert
			// ShoppingCartBean bean = new ShoppingCartBean();
			// bean.setMemberId(3);
			// bean.setCourseId(1002);
			// bean.setCourseName("反重力基礎課程");
			// bean.setCoursePrice(9478);
			// ShoppingCartBean insert = shoppingCartDAO.insert(bean);
			// System.out.println(insert);

			// Update
			// ShoppingCartBean update = shoppingCartDAO.update(5, 1003, "功能性訓練", 7000, 14);
			// System.out.println("update = " + update);

			// Delete
			// boolean delete = shoppingCartDAO.delete(4);
			// System.out.println("delete = " + delete);

			sessionFactory.getCurrentSession().getTransaction().commit();
		} finally {
			((ConfigurableApplicationContext) context).close();
		}
	}

	///////////////////////////////////////////////////////////////////////////////////////
	@Autowired
	private SessionFactory sessionFactory;

	public ShoppingCartDAOHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public ShoppingCartBean select(int ShoppingCartId) {
		return this.getSession().get(ShoppingCartBean.class, ShoppingCartId);
	}

	// 依課程教練搜尋
	@Override
	public List<ShoppingCartBean> selectByMemberId(int memeberId) {
		return this.getSession()
				.createQuery("FROM ShoppingCartBean where MemberId = " + memeberId, ShoppingCartBean.class).list();
	}

	@Override
	public List<ShoppingCartBean> select() {

		return this.getSession().createQuery("FROM ShoppingCartBean", ShoppingCartBean.class).list();
	}

	@Override
	public ShoppingCartBean insert(ShoppingCartBean bean) {
		if (bean != null) {
			ShoppingCartBean select = this.select(bean.getShoppingCartId());
			if (select == null) {
				this.getSession().save(bean);
				return bean;
			}
		}
		return null;
	}

	@Override
	public ShoppingCartBean update(int courseId, String courseName, Date courseStartDate, String courseStartTime,
			double coursePrice, double discount, int memberId, int shoppingCartId) {
		ShoppingCartBean bean = this.select(shoppingCartId);
		if (bean != null) {
			bean.setMemberId(memberId);
			bean.setCourseId(courseId);
			bean.setCourseName(courseName);
			bean.setCoursePrice(coursePrice);

			return bean;
		}
		return null;
	}

	@Override
	public boolean delete(int shoppingCartId) {
		ShoppingCartBean bean = this.select(shoppingCartId);
		if (bean != null) {
			this.getSession().delete(bean);
			return true;
		}
		return false;
	}

}
