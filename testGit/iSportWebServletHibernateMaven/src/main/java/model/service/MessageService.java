package model.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import model.MessageDAO;
import model.bean.MessageBean;



@Service
public class MessageService {
	
	private  MessageDAO messageDAO;
	public MessageService(MessageDAO messageDAO) {
		this.messageDAO = messageDAO;
	}

//	public static void main(String[] args) {
//		
//		ApplicationContext context =
//				new ClassPathXmlApplicationContext("beans.config.xml");
//		
		
//		try {
//			SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
//			sessionFactory.getCurrentSession().beginTransaction();
//			MessageService messageService = (MessageService) context.getBean("messageService");
//			//查詢全部
//			
//			List<MessageBean> selects = messageService.selects(null);
//			System.out.println("selects="+selects );
//			//查詢查詢單筆
//			MessageBean bean = new MessageBean();
//			bean.setMessageId(1);
//			List<MessageBean> select1=service.selects(bean);
//			System.out.println( "select1=" + select1 + "\n");
//			//新增一筆資料
//			MessageBean xxx = new MessageBean();
//			xxx.setMemberId(3);
//			xxx.setMessageTime(new java.util.Date(78763));
//			xxx.setTypeName("揪團運動");
//			xxx.setMessageText("暱稱: 只要沒良心 , 什麼都不難");
//			xxx.setMessagePic(null);
//			xxx.setStar(3);
//			MessageBean insert1 = service.insert(xxx);
//			//更新一筆資料
//			MessageBean ccc = new MessageBean();
//			ccc.setMemberId(5);
//			xxx.setMessageTime(new java.util.Date(78763));
//			xxx.setTypeName("揪團運動");
//			xxx.setMessageText("暱稱: 只要沒良心 , 什麼都不難");
//			xxx.setMessagePic(null);
//			xxx.setStar(3);
//			//刪除一筆資料
//			MessageBean ggg = new MessageBean();
//			ggg.setMessageId(7);
//			boolean delete1 = service.delete(ggg);
			
		
			
			
			
			
			

//			sessionFactory.getCurrentSession().getTransaction().commit();
//		} finally {
//			((ConfigurableApplicationContext) context).close();
//		}
//	}
	
	public List<MessageBean> selects(MessageBean bean){
		List<MessageBean> result = null;
		if(bean!=null && bean.getMessageId()!=0) {
			MessageBean temp = messageDAO.select(bean.getMessageId());
			if(temp!=null) {
				result = new ArrayList<MessageBean>();
				result.add(temp);
			}
		}else {
			result = messageDAO.select();
		}
		return result;
	}
	//*******************************************************************************************
		//查詢全部
			public List<Object[]> selectAll(MessageBean baen) {
				List<Object[]> result = null;
				result = messageDAO.selectAll();
				if(!result.isEmpty()){
					return result;
				}
				return null;
			}
		//MemberId查詢	
			public List<Object[]> selectMemberId(int memberId) {
				List<Object[]> result = null;
				result = messageDAO.selectMemberId(memberId);
				if(!result.isEmpty() && result.size()!=0){
					return result;
				}
				return null;
			}
		
			
		//*******************************************************************************************
	
	
	
	
	public MessageBean insert(MessageBean bean) {
		java.util.Date tempDate = new java.util.Date();
		java.sql.Date  sqlDate = new java.sql.Date(tempDate.getTime());
		bean.setMessageTime(sqlDate);
		MessageBean result = null;
		if(bean!=null) {
			result = messageDAO.insert(bean);
		}
		return result;
	}
	public MessageBean update(MessageBean bean) {
		MessageBean result = null;
		if(bean!=null) {
			result = messageDAO.update(bean.getMemberId(), 
					bean.getMessageTime(), bean.getTypeName(), bean.getMessageText(), bean.getMessagePic(),bean.getStar(),bean.getMessageId());
		}
		return result;
	}
	public boolean delete(MessageBean bean) {
		boolean result = false;
		if(bean!=null) {
			result = messageDAO.delete(bean.getMessageId());
		}
		return result;
	}

	

}
