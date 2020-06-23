package model.dao;

import java.sql.Blob;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import model.MessageDAO;
import model.bean.MessageBean;




@Repository
public class MessageDAOHibernate implements MessageDAO   {

	public static void main(String[] args) {
		ApplicationContext context =
				new ClassPathXmlApplicationContext("beans.config.xml");
		
		try {
			SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
			sessionFactory.getCurrentSession().beginTransaction();
			
			
			
			MessageDAO messageDAO = (MessageDAO) context.getBean("messageDAO");
		
			

		} finally {
			((ConfigurableApplicationContext) context).close();
		}
		
	}

	private SessionFactory sessionFactory;
	public MessageDAOHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	

	/* (non-Javadoc)
	 * @see model.dao.MessageDAO#getSession()
	 */
	@Override
	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	


	/* (non-Javadoc)
	 * @see model.dao.MessageDAO#select(int)
	 */
	@Override
	public MessageBean select(int messageId) {
		return this.getSession().get(MessageBean.class, messageId);
	}
	

	/* (non-Javadoc)
	 * @see model.dao.MessageDAO#select()
	 */
	@Override
	public List<MessageBean> select(){
		return this.getSession().createQuery("FROM MessageBean", MessageBean.class).list();
	}
	
	//*************************************************************************************************	
	//查詢所有
	/* (non-Javadoc)
	 * @see model.dao.MessageDAO#selectAll()
	 */
	@Override
	public List<Object[]> selectAll() {
		return this.getSession().createNativeQuery("SELECT Message.MessageId, Message.MemberId, Member.MemberName, Message.MessageTime, Message.TypeName, Message.MessageText, Message.MessagePic, Message.Star FROM Message INNER JOIN Member ON Message.MemberId = Member.MemberId").list();
	}
	
	//MemberId查詢
	/* (non-Javadoc)
	 * @see model.dao.MessageDAO#selectMemberId(int)
	 */
	@Override
	public List<Object[]> selectMemberId(int memberId) {
		return this.getSession().createNativeQuery("SELECT Message.MessageId, Message.MemberId, Member.MemberName, Message.MessageTime, Message.TypeName, Message.MessageText, Message.MessagePic, Message.Star FROM Message INNER JOIN Member ON Message.MemberId = Member.MemberId where Message.MemberId =" + memberId ).list();
	}
	

	//*************************************************************************************************	
	/* (non-Javadoc)
	 * @see model.dao.MessageDAO#insert(model.MessageBean)
	 */
	@Override
	public MessageBean insert(MessageBean bean) {
		if(bean!=null) {
			MessageBean select = this.select(bean.getMessageId());
			if(select==null) {
				this.getSession().save(bean);
				return bean;
			}
		}
		return null;
	}
	


	/* (non-Javadoc)
	 * @see model.dao.MessageDAO#update(int, java.util.Date, java.lang.String, java.lang.String, java.sql.Blob, int, int)
	 */
	@Override
	public MessageBean update(int memberId,Date messageTime,String typeName,
			String messageText,Blob messagePic,int star,int messageId) {
		MessageBean bean = this.select(messageId);
		if(bean!=null) {
			bean.setMemberId(memberId);
			bean.setMessageTime(messageTime);
			bean.setTypeName(typeName);
			bean.setMessageText(messageText);
			bean.setMessagePic(messagePic);
			bean.setStar(star);
			return bean;
		}
		return null;
	}
	


	/* (non-Javadoc)
	 * @see model.dao.MessageDAO#delete(int)
	 */
	@Override
	public boolean delete(int messageId ) {
		MessageBean bean = this.select(messageId);
		if(bean!=null) {
			this.getSession().delete(bean);
			return true;
		}
		return false;
	}
}
