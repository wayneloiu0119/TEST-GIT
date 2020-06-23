package model.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import model.OrdersDAO;
import model.bean.OrdersBean;

@Service
public class OrdersService {
	@Autowired
	private OrdersDAO ordersDAO;
	public OrdersService(OrdersDAO ordersDAO) {
		this.ordersDAO=ordersDAO;
	}
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("beans.config.xml");
		try {
//			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
			sessionFactory.getCurrentSession().beginTransaction();
			
//			OrdersService service=new OrdersService(new OrdersDAOHibernate(HibernateUtil.getSessionFactory()));
			OrdersService service = (OrdersService) context.getBean("ordersService");

			//select
			OrdersBean bean=new OrdersBean();
			bean.setOrderId(1060915001);
			List<OrdersBean> beans = service.select(bean);
			System.out.println("beans=" + beans);
			//selectAll
//			List<OrdersBean> beans = service.select(null);
//			System.out.println("beans=" + beans);
			//insert
//			OrdersBean bean=new OrdersBean();
////			bean.setCalendarId(999); //流水號 不給值
//			bean.setRoomDate(new Date());
//			bean.setRoomId(105);
//			bean.setPeriod(2);
//			bean.setCourseId("1005");
//			OrdersBean insert=service.insert(bean);
//			System.out.println("insert="+insert);
			//用課程(CourseId)查詢
			//insert 一個月的資料(輸入年,月)
			//update 課程(每堂(select起始日期,結束日期,星期,教室,時段  update CourseId))
			
//			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
			sessionFactory.getCurrentSession().getTransaction().commit();
		} finally {
//			HibernateUtil.closeSessionFactory();
			((ConfigurableApplicationContext)context).close();
		}
	}

	//select
	public List<OrdersBean> select(OrdersBean bean){
		List<OrdersBean> result=null;
		if(bean!=null && bean.getOrderId()!=0) {
			OrdersBean temp=ordersDAO.select(bean.getOrderId());
			if(temp!=null) {
				result=new ArrayList<OrdersBean>();
				result.add(temp);
			}
		}else {
			result=ordersDAO.select();
		}
		return result;
	}
	//insert
	public OrdersBean insert(OrdersBean bean) {
		OrdersBean result=null;
		if(bean!=null) {
			result=ordersDAO.insert(bean);
		}
		return result;
	}
	//update
	public OrdersBean update(OrdersBean bean) {
		OrdersBean result=null;
		if(bean!=null) {
			result=ordersDAO.update(bean.getOrderId(), bean.getMemberId(), bean.getOrderDate(), bean.getOrderPrice(),
					bean.getPayment());
		}
		return result;
	}
	//delete
	public boolean delete(OrdersBean bean) {
		boolean result=false;
		if(bean!=null) {
			result=ordersDAO.delete(bean.getOrderId());
			System.out.println("課程"+bean.getOrderId()+"已刪除");
			return true;
		}
		return result;
	}

}
