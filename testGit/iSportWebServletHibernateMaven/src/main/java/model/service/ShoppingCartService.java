package model.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import model.ShoppingCartDAO;
import model.bean.ShoppingCartBean;

@Service
public class ShoppingCartService {
	@Autowired
	private ShoppingCartDAO shoppingCartDAO;

	///////////////////////////////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");

		try {
			SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
			sessionFactory.getCurrentSession().beginTransaction();
			ShoppingCartService service = (ShoppingCartService) context.getBean("shoppingCartService");

			// Select
			ShoppingCartBean shoppingCartBean = new ShoppingCartBean();

			// shoppingCartBean.setMemberId(5);
			// List<ShoppingCartBean> selectByMemberId =
			// service.selectByMemberId(shoppingCartBean);
			// System.out.println("selectByMemberId = " + selectByMemberId);

			shoppingCartBean.setShoppingCartId(3);
			List<ShoppingCartBean> selectByShoppongCartId = service.select(shoppingCartBean);
			System.out.println("selectByShoppongCartId=" + selectByShoppongCartId);

			List<ShoppingCartBean> beans = service.select(null);
			System.out.println("beans = " + beans);

			// Insert
			// shoppingCartBean.setMemberId(3);
			// shoppingCartBean.setCourseId(1004);
			// shoppingCartBean.setCourseName("大GG課程");
			// shoppingCartBean.setCoursePrice(5000);
			// ShoppingCartBean insert = service.insert(shoppingCartBean);
			// System.out.println("insert = "+insert);

			sessionFactory.getCurrentSession().getTransaction().commit();
		} finally {
			((ConfigurableApplicationContext) context).close();
		}
	}
	///////////////////////////////////////////////////////////////////////////////////////

	// 依教練搜尋
	public List<ShoppingCartBean> selectByMemberId(ShoppingCartBean bean) {
		List<ShoppingCartBean> result = null;
		if (bean != null && bean.getMemberId() != 0) {
			result = shoppingCartDAO.selectByMemberId(bean.getMemberId());
		}
		return result;

	}

	public List<ShoppingCartBean> select(ShoppingCartBean bean) {
		List<ShoppingCartBean> result = null;

		if (bean != null && bean.getShoppingCartId() != 0) {
			ShoppingCartBean temp = shoppingCartDAO.select(bean.getShoppingCartId());
			if (temp != null) {
				result = new ArrayList<>();
				result.add(temp);
			}
		} else {
			result = shoppingCartDAO.select();
		}
		return result;
	}

	public ShoppingCartBean insert(ShoppingCartBean bean) {

		ShoppingCartBean result = null;

		if (bean != null) {
			result = shoppingCartDAO.insert(bean);
		}
		return result;
	}

	public ShoppingCartBean update(ShoppingCartBean bean) {

		ShoppingCartBean result = null;
		if (bean != null) {
			result = shoppingCartDAO.update(bean.getCourseId(), bean.getCourseName(), bean.getCourseStartDate(),
					bean.getCourseStartTime(), bean.getCoursePrice(), bean.getDiscount(), bean.getMemberId(),
					bean.getShoppingCartId());
		}
		return result;
	}

	public boolean delete(ShoppingCartBean bean) {
		boolean result = false;
		if (bean != null) {
			result = shoppingCartDAO.delete(bean.getShoppingCartId());
		}
		return result;
	}
}
