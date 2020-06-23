package model.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import model.TypeDAO;
import model.bean.TypeBean;

@Service
public class TypeService {

	@Autowired
	private TypeDAO typeDAO;

	///////////////////////////////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
		try {
			SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
			sessionFactory.getCurrentSession().beginTransaction();

			TypeService service = (TypeService) context.getBean("typeService");

			// Select
			List<TypeBean> selects = service.select(null);
			System.out.println("selects =" + selects);

			sessionFactory.getCurrentSession().getTransaction().commit();
		} finally {
			((ConfigurableApplicationContext) context).close();
		}

	}

	///////////////////////////////////////////////////////////////////////////////////////
	public List<TypeBean> select(TypeBean bean) {
		List<TypeBean> result = null;
		if (bean != null && bean.getTypeId() != 0) {
			TypeBean temp = typeDAO.select(bean.getTypeId());
			if (temp != null) {
				result = new ArrayList<TypeBean>();
				result.add(temp);
			}
		} else {
			result = typeDAO.select();
		}
		return result;
	}

	public TypeBean insert(TypeBean bean) {
		TypeBean result = null;
		if (bean != null) {
			result = typeDAO.insert(bean);
		}
		return result;
	}

	public TypeBean update(TypeBean bean) {
		TypeBean result = null;
		if (bean != null) {
			result = typeDAO.update(bean.getTypeName(), bean.getTypeId());
		}
		return result;
	}

	public boolean delete(TypeBean bean) {
		boolean result = false;
		if (bean != null) {
			result = typeDAO.delete(bean.getTypeId());
		}
		return result;

	}
}
