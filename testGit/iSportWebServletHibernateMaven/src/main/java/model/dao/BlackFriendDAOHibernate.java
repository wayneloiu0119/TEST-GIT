package model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import model.BlackFriendDAO;
import model.bean.BlackFriendBean;



@Repository
public class BlackFriendDAOHibernate implements BlackFriendDAO  {

	public static void main(String[] args) {
		
		ApplicationContext context =
				new ClassPathXmlApplicationContext("beans.config.xml");
		
		try {
			SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
			sessionFactory.getCurrentSession().beginTransaction();
			
			
			
			BlackFriendDAO blackFriendDAO = (BlackFriendDAO) context.getBean("blackFriendDAO");
		
			
			sessionFactory.getCurrentSession().getTransaction().commit();
		} finally {
			((ConfigurableApplicationContext) context).close();
		}
		

	}

	private SessionFactory sessionFactory;
	public BlackFriendDAOHibernate(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}


	/* (non-Javadoc)
	 * @see model.dao.BlackFriendDAO#getSession()
	 */
	@Override
	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	/* (non-Javadoc)
	 * @see model.dao.BlackFriendDAO#select(int)
	 */
	@Override
	public BlackFriendBean select(int blackFriendId) {
		return this.getSession().get(BlackFriendBean.class, blackFriendId);
	}


	/* (non-Javadoc)
	 * @see model.dao.BlackFriendDAO#select()
	 */
	@Override
	public List<BlackFriendBean> select(){
		return this.getSession().createQuery("FROM BlackFriendBean",BlackFriendBean.class).list();
		
	}

	//**************************************************************************************************************
	// memberId 查詢關係
	/* (non-Javadoc)
	 * @see model.dao.BlackFriendDAO#selectMemberId(int)
	 */
	@Override
	public List<Object[]> selectMemberId(int memberId) {
		return this.getSession().createNativeQuery(
				"SELECT BlackFriend.BlackFriendId, BlackFriend.MemberId, BlackFriend.RelationMemberId,Member.MemberName,BlackFriend.BlackFriendType, BlackFriend.States FROM BlackFriend INNER JOIN Member ON  BlackFriend.RelationMemberId = Member.MemberId where BlackFriend.MemberId = " + memberId).list();}
	
	// 關係查詢
	
	/* (non-Javadoc)
	 * @see model.dao.BlackFriendDAO#selectFrienType(int, java.lang.String)
	 */
	@Override
	public List<Object[]> selectFrienType(int memberId, String blackFriendType) {
		Query query = this.getSession().createNativeQuery(
				"SELECT BlackFriend.BlackFriendId, BlackFriend.MemberId, BlackFriend.RelationMemberId,Member.MemberName ,BlackFriend.BlackFriendType, BlackFriend.States FROM BlackFriend INNER JOIN Member ON  BlackFriend.RelationMemberId = Member.MemberId where BlackFriend.MemberId = ? and BlackFriendType = ?");
		query.setParameter(1, memberId);
		query.setParameter(2, blackFriendType);
		return query.list();
	}
	
	//**************************************************************************************************************
	/* (non-Javadoc)
	 * @see model.dao.BlackFriendDAO#insert(model.BlackFriendBean)
	 */
	@Override
	public BlackFriendBean insert(BlackFriendBean bean) {
		if(bean!=null) {
			BlackFriendBean select = this.select(bean.getBlackFriendId());
			if(select==null) {
				this.getSession().save(bean);
				return bean;
			}
		}
		return null;
	}


	/* (non-Javadoc)
	 * @see model.dao.BlackFriendDAO#update(int, int, java.lang.String, java.lang.String, int)
	 */
	@Override
	public BlackFriendBean update(
			int memberId,int relationMemberId,String blackFriendType,String states,int blackFriendId) {
		
		BlackFriendBean bean = this.select(blackFriendId);
		if(bean!=null) {
			bean.setMemberId(memberId);
			bean.setRelationMemberId(relationMemberId);
			bean.setBlackFriendType(blackFriendType);
			bean.setStates(states);
			return bean;
		}
		return null;
	}


	/* (non-Javadoc)
	 * @see model.dao.BlackFriendDAO#delete(int)
	 */
	@Override
	public boolean delete(int blackFriendId) {
		BlackFriendBean bean = this.select(blackFriendId);
		if(bean!=null) {
			this.getSession().delete(bean);
			return true;
		}
		return false;
	}

}
