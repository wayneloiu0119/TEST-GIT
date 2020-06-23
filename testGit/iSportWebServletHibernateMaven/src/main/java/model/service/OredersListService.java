package model.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import model.OrdersListDAO;
import model.bean.OrdersListBean;

@Service
public class OredersListService {
	@Autowired
	private OrdersListDAO ordersListDAO;

	///////////////////////////////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
		try {
			SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
			sessionFactory.getCurrentSession().beginTransaction();
			OredersListService service = (OredersListService) context.getBean("oredersListService");

			// Select
			List<OrdersListBean> beans = service.select(null);
			System.out.println("beans = " + beans);
			sessionFactory.getCurrentSession().getTransaction().commit();
		} finally {
			((ConfigurableApplicationContext) context).close();
		}

	}
	///////////////////////////////////////////////////////////////////////////////////////

	public List<OrdersListBean> selectByOrderId(OrdersListBean bean) {
		List<OrdersListBean> result = null;
		if (bean != null && bean.getOrderId() != 0) {
			result = ordersListDAO.select(bean.getOrderId());
		}
		return result;

	}

	public List<OrdersListBean> select(OrdersListBean bean) {
		List<OrdersListBean> result = null;
		if (bean != null && bean.getOrderId() != 0 && bean.getCourseId() != 0) {
			OrdersListBean temp = ordersListDAO.select(bean.getOrderId(), bean.getCourseId());
			if (temp != null) {
				result = new ArrayList<>();
				result.add(temp);
			}
		} else {
			result = ordersListDAO.select();
		}

		return result;
	}

	public OrdersListBean insert(OrdersListBean bean) {
		OrdersListBean result = null;
		if (bean != null) {
			result = ordersListDAO.insert(bean);
		}
		return result;
	}

	public OrdersListBean update(OrdersListBean bean) {
		OrdersListBean result = null;
		if (bean != null) {
			result = ordersListDAO.update(bean.getMemberId(), bean.getCourseName(), bean.getCoursePrice(),
					bean.getOrderId(), bean.getCourseId());
		}
		return result;
	}

	public boolean delete(OrdersListBean bean) {
		boolean result = false;
		if (bean != null) {
			result = ordersListDAO.delete(bean.getOrderId(), bean.getCourseId());
		}
		return result;
	}
}
