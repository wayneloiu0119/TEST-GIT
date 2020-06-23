package model.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import model.bean.BlobExBean;
import model.dao.BlobExDAOHibernate;

@Service
public class BlobExService {
	@Autowired
	private BlobExDAOHibernate blobExDAOHibernate;

	///////////////////////////////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
		try {
			SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
			sessionFactory.getCurrentSession().beginTransaction();

			BlobExService service = (BlobExService) context.getBean("blobExService");
			BlobExBean bean = new BlobExBean();
			// Select
			List<BlobExBean> beans = service.select(null);
			System.out.println("beans =" + beans);

			sessionFactory.getCurrentSession().getTransaction().commit();
		} finally {
			((ConfigurableApplicationContext) context).close();
		}
	}
	///////////////////////////////////////////////////////////////////////////////////////

	public List<BlobExBean> select(BlobExBean bean) {
		List<BlobExBean> result = null;
		if (bean != null && bean.getId() != 0) {
			BlobExBean temp = blobExDAOHibernate.select(bean.getId());
			if (temp != null) {
				result = new ArrayList<>();
				result.add(temp);
			}
		} else {
			result = blobExDAOHibernate.select();

		}

		return result;
	}

	public BlobExBean insert(BlobExBean bean) {
		BlobExBean result = null;
		if (bean != null) {
			result = blobExDAOHibernate.insert(bean);
		}
		return result;
	}

	public BlobExBean update(BlobExBean bean) {
		BlobExBean result = null;
		if (bean != null) {
			result = blobExDAOHibernate.update(bean.getName(), bean.getPhoto(), bean.getId());
		}
		return result;
	}

	public boolean delete(BlobExBean bean) {
		boolean result = false;
		if (bean != null) {
			result = blobExDAOHibernate.delete(bean.getId());
		}
		return result;

	}
}
