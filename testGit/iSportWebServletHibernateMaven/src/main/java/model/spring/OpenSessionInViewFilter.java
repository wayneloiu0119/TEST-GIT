package model.spring;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class OpenSessionInViewFilter implements Filter {
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		Transaction transaction = null;
		try {
			transaction = sessionFactory.getCurrentSession().getTransaction();
			if (transaction != null && !transaction.isActive()) {
				sessionFactory.getCurrentSession().beginTransaction();
			}
			chain.doFilter(request, response);
			sessionFactory.getCurrentSession().getTransaction().commit();
		} catch (HibernateException e) {
			sessionFactory.getCurrentSession().getTransaction().rollback();
			e.printStackTrace();
			chain.doFilter(request, response);
		}
	}

	private SessionFactory sessionFactory;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String sessionFactoryBeanName = filterConfig.getInitParameter("sessionFactoryBeanName");
		if (sessionFactoryBeanName == null || sessionFactoryBeanName.length() == 0) {
			sessionFactoryBeanName = "sessionFactory";
		}

		ApplicationContext context = WebApplicationContextUtils
				.getWebApplicationContext(filterConfig.getServletContext());
		this.sessionFactory = (SessionFactory) context.getBean("sessionFactory");
	}

	@Override
	public void destroy() {

	}
}
