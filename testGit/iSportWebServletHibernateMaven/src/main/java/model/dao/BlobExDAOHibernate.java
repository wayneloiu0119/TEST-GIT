package model.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Blob;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import model.bean.BlobExBean;

@Repository
public class BlobExDAOHibernate {

	public static void main(String[] args) throws FileNotFoundException {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
		try {
			SessionFactory sessionFactroy = (SessionFactory) context.getBean("sessionFactory");
			sessionFactroy.getCurrentSession().beginTransaction();
			BlobExDAOHibernate blobExDAO = (BlobExDAOHibernate) context.getBean("blobExDAOHibernate");
			BlobExBean bean = new BlobExBean();

			// Select
			BlobExBean select = blobExDAO.select(2);
			System.out.println("select =" + select);
			List<BlobExBean> selects = blobExDAO.select();
			System.out.println("selects =" + selects);

			// Insert
			// 取得檔案
			File file = new File("src/pic/Tomcat.gif");
			FileInputStream fis = new FileInputStream(file);

			// https://stackoverflow.com/questions/20614973/read-write-blob-data-in-chunks-with-hibernate
			Blob photo = blobExDAO.getSession().getLobHelper().createBlob(fis, file.length());

			bean.setName("肥貓B");
			bean.setPhoto(photo);

			// BlobExBean insert = blobExDAO.insert(bean);
			// System.out.println("insert=" + insert);

			// Update
			// BlobExBean update = blobExDAO.update("肥貓GG", photo, 1);
			// System.out.println("update=" + update);

			// Delete
			// bean.setId(5);
			// boolean i = blobExDAO.delete(bean);
			// System.out.println(i);

			sessionFactroy.getCurrentSession().getTransaction().commit();
		} finally {
			((ConfigurableApplicationContext) context).close();
		}

	}

	///////////////////////////////////////////////////////////////////////////////////////
	private SessionFactory sessionFactory;

	public BlobExDAOHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public BlobExBean select(int id) {

		return this.getSession().get(BlobExBean.class, id);
	}

	public List<BlobExBean> select() {

		return this.getSession().createQuery("FROM BlobExBean", BlobExBean.class).list();
	}

	public BlobExBean insert(BlobExBean bean) {
		if (bean != null) {
			BlobExBean select = this.select(bean.getId());
			if (select == null) {
				this.getSession().save(bean);
				return bean;
			}
		}
		return null;
	}

	public BlobExBean update(String name, Blob photo, int id) {
		BlobExBean bean = this.select(id);
		if (bean != null) {
			bean.setName(name);
			bean.setPhoto(photo);
			return bean;
		}
		return null;
	}

	public boolean delete(int id) {
		BlobExBean select = this.select(id);
		if (select != null) {
			this.getSession().delete(select);
			return true;
		}
		return false;
	}
}
