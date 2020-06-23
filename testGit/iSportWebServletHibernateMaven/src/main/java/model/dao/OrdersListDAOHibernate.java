package model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import model.OrdersListDAO;
import model.bean.OrdersListBean;
import model.bean.OrdersListId;

@Repository
public class OrdersListDAOHibernate implements OrdersListDAO {

	///////////////////////////////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");

		try {
			SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
			sessionFactory.getCurrentSession().beginTransaction();

			OrdersListDAO ordersListDAO = (OrdersListDAO) context.getBean("ordersListDAOHibernate");

			// Select
			OrdersListBean selectone = ordersListDAO.select(1060913003, 1004);
			System.out.println("selectone = " + selectone);

			List<OrdersListBean> select = ordersListDAO.select(1060913001);
			System.out.println("select = " + select);

			List<OrdersListBean> selects = ordersListDAO.select();
			System.out.println("selects = " + selects);

			// insert
			OrdersListBean bean = new OrdersListBean();
			bean.setOrderId(1060913003);
			bean.setMemberId(5);
			bean.setCourseId(1004);
			bean.setCourseName("JAVA++");
			bean.setCoursePrice(7200);
			// OrdersListBean insert = ordersListDAO.insert(bean);
			// System.out.println("insert = " + insert);

			// Update

			// OrdersListBean update = ordersListDAO.update(5, "JAVA--", 8888, 1060913003,
			// 1001);
			// System.out.println("update = " + update);

			// Delete
			// boolean delete = ordersListDAO.delete(bean);
			// System.out.println("delete = " + delete);

			sessionFactory.getCurrentSession().getTransaction().commit();
		} finally {
			((ConfigurableApplicationContext) context).close();

		}
	}

	///////////////////////////////////////////////////////////////////////////////////////

	@Autowired
	private SessionFactory sessionFactory;

	public OrdersListDAOHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public OrdersListBean select(int orderId, int courseId) {

		OrdersListId ordersListId = new OrdersListId();
		ordersListId.setOrderId(orderId);
		ordersListId.setCourseId(courseId);

		return this.getSession().get(OrdersListBean.class, ordersListId);
	}

	@Override
	public List<OrdersListBean> select(int orderId) {
		return this.getSession().createQuery("FROM OrdersListBean where orderId =" + orderId, OrdersListBean.class)
				.list();
	}

	@Override
	public List<OrdersListBean> select() {

		return this.getSession().createQuery("FROM OrdersListBean", OrdersListBean.class).list();
	}

	@Override
	public OrdersListBean insert(OrdersListBean bean) {
		if (bean != null) {
			OrdersListBean select = this.select(bean.getOrderId(), bean.getCourseId());
			if (select == null) {
				this.getSession().save(bean);
				return bean;
			}
		}
		return null;
	}

	@Override
	public OrdersListBean update(int memberId, String courseName, double coursePrice, int orderId, int courseId) {
		OrdersListBean bean = this.select(orderId, courseId);
		if (bean != null) {
			bean.setMemberId(memberId);
			bean.setCourseName(courseName);
			bean.setCoursePrice(coursePrice);
			return bean;
		}
		return null;
	}

	@Override
	public boolean delete(int orderId, int courseId) {
		OrdersListBean select = this.select(orderId, courseId);
		if (select != null) {
			this.getSession().delete(select);
			return true;
		}
		return false;
	}
}
