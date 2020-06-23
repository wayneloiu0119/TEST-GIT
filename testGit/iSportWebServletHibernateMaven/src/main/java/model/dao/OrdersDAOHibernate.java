package model.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import model.OrdersDAO;
import model.bean.OrdersBean;

@Repository
public class OrdersDAOHibernate implements OrdersDAO {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("beans.config.xml");
		try {
			SessionFactory sessionFactory=(SessionFactory)context.getBean("sessionFactory");
			sessionFactory.getCurrentSession().beginTransaction();
			OrdersDAO ordersDAO=(OrdersDAO)context.getBean("ordersDAOHibernate");
			
			// insert
//			OrdersBean bean = new OrdersBean();
//			// bean.setOrderId("201709159");
//			bean.setMemberId(5);
//			bean.setOrderDate(new Date());
//			bean.setOrderPrice(1000d);
//			bean.setPayment("信用卡付款");
//			OrdersBean insert = ordersDAO.insert(bean);
//			System.out.println("insert = " + insert + "\n");
			// update
//			boolean update = ordersDAO.update(1060915002, 3, new Date(86400), 2000d, "信用卡付款");
//			System.out.println("update = " + update + "\n");
			// Delete
//			boolean delete = ordersDAO.delete(1060916001);
//			System.out.println("delete = " + delete);

			// select
			OrdersBean select = ordersDAO.select(1060915002);
			System.out.println("select = " + select + "\n");
			//selectAll
//			List<OrdersBean> selectAll = ordersDAO.select();
//			System.out.println("selectAll=" + selectAll);

			sessionFactory.getCurrentSession().getTransaction().commit();
		} finally {
			((ConfigurableApplicationContext)context).close();
		}
	}

	private SessionFactory sessionFactory;

	public OrdersDAOHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public OrdersBean select(int orderId) {
		return this.getSession().get(OrdersBean.class, orderId);
	}

	// public List<OrdersBean> select(String orderId) {
	// return this.getSession().createQuery("FROM OrdersBean WHERE OrdersId=" +
	// orderId,OrdersBean.class).list();
	// }
	@Override
	public List<OrdersBean> select() {
		return this.getSession().createQuery("from OrdersBean", OrdersBean.class).list();
	}

	@Override
	public OrdersBean update(int orderId, int memberId, Date orderDate, double orderPrice, String payment) {
		OrdersBean bean = this.getSession().get(OrdersBean.class, orderId);
		if (bean != null) {
			bean.setOrderId(orderId);
			bean.setMemberId(memberId);
			bean.setOrderDate(orderDate);
			bean.setOrderPrice(orderPrice);
			bean.setPayment(payment);
			return bean;
		}
		return null;
	}

	@Override
	public OrdersBean insert(OrdersBean bean) {
		if (bean != null) {
			OrdersBean select = this.select(bean.getOrderId());
			if (select == null) {
				Query query = this.getSession().createNativeQuery(
						"insert into Orders (MemberId,OrderDate,OrderPrice,Payment) VALUES (?,?,?,?)");

				query.setParameter(1, bean.getMemberId());
				query.setParameter(2, bean.getOrderDate());
				query.setParameter(3, bean.getOrderPrice());
				query.setParameter(4, bean.getPayment());

				query.executeUpdate();
				return bean;
			}
		}
		return null;
	}
	// @Override
	// public OrdersBean insert(OrdersBean bean) {
	// if (bean != null) {
	// OrdersBean select = this.select(bean.getOrderId());
	// if (select == null) {
	// this.getSession().saveOrUpdate(bean);
	// return bean;
	// }
	// }
	// return null;
	// }

	@Override
	public boolean delete(int OrderId) {
		OrdersBean bean = this.select(OrderId);
		if (bean != null) {
			this.getSession().delete(bean);
			return true;
		}
		return false;
	}

}
