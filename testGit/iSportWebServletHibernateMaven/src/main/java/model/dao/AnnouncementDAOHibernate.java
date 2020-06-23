package model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import model.AnnouncementDAO;
import model.bean.AnnouncementBean;





@Repository
public class AnnouncementDAOHibernate implements AnnouncementDAO {

	 public static void main(String[] args) {
	 ApplicationContext context = new
	 ClassPathXmlApplicationContext("beans.config.xml");

	 try {
	 SessionFactory sessionFactory = (SessionFactory)
	 context.getBean("sessionFactory");
	 sessionFactory.getCurrentSession().beginTransaction();
	
//	 AnnouncementDAO announcementDAO = (AnnouncementDAO)
//	 context.getBean("announcementDAO");
//	
//	 System.out.println(announcementDAO.selectAll());
//	
//	 List<Object[]> list = announcementDAO.selectAll();
//		for (Object[] a : list) {
//			for (int i = 0; i < list.get(0).length; i++) {
//				System.out.print(a[i] + ",");
//				
//			}
//			System.out.println();
//		}
	 
	 
	 
	 
	 sessionFactory.getCurrentSession().getTransaction().commit();
	 } finally {
	 ((ConfigurableApplicationContext) context).close();
	 }
	 }

	private SessionFactory sessionFactory;

	public AnnouncementDAOHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	/* (non-Javadoc)
	 * @see model.AnnouncementDAO#getSession()
	 */
	@Override
	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	

	/* (non-Javadoc)
	 * @see model.AnnouncementDAO#select()
	 */
	@Override
	public List<AnnouncementBean> select() {
		return this.getSession().createQuery("FROM AnnouncementBean",AnnouncementBean.class).list();
	}



	/* (non-Javadoc)
	 * @see model.AnnouncementDAO#selectByAnnouncementId(int)
	 */
	@Override
	public AnnouncementBean selectByAnnouncementId(int announcementId) {

		return this.getSession().get(AnnouncementBean.class, announcementId);
	}



//	public AnnouncementBean selectByGameId(int gameId) {
//
//		return this.getSession().get(AnnouncementBean.class, gameId);
//	}



//	public AnnouncementBean selectByCourseId(int courseId) {
//
//		return this.getSession().get(AnnouncementBean.class, courseId);
//	}




	/* (non-Javadoc)
	 * @see model.AnnouncementDAO#selectAllGame()
	 */
	@Override
	public List<Object[]> selectAllGame() {
		return this.getSession().createNativeQuery("SELECT Announcement.AnnouncementId, Announcement.MemberId, Announcement.GameId, Game.GameName,Announcement.AnnouncemenText FROM Announcement INNER JOIN Game ON Announcement.GameId = Game.GameId").list();}
	
	


	/* (non-Javadoc)
	 * @see model.AnnouncementDAO#selectGameId(int)
	 */
	@Override
	public List<Object[]> selectGameId(int gameId) {
		return this.getSession().createNativeQuery("SELECT Announcement.AnnouncementId, Announcement.MemberId, Announcement.GameId, Game.GameName,Announcement.AnnouncemenText FROM Announcement INNER JOIN Game ON Announcement.GameId = Game.GameId where Announcement.GameId =" + gameId).list();}
	



	/* (non-Javadoc)
	 * @see model.AnnouncementDAO#selectAllCourse()
	 */
	@Override
	public List<Object[]> selectAllCourse() {
		return this.getSession().createNativeQuery("SELECT Announcement.AnnouncementId, Announcement.MemberId, Announcement.CourseId, Course.CourseName,Announcement.AnnouncemenText FROM Announcement INNER JOIN Course ON Announcement.CourseId = Course.CourseId").list();}
	
	

	/* (non-Javadoc)
	 * @see model.AnnouncementDAO#selectCourseId(int)
	 */
	@Override
	public List<Object[]> selectCourseId(int courseId) {
		return this.getSession().createNativeQuery("SELECT Announcement.AnnouncementId, Announcement.MemberId, Announcement.CourseId, Course.CourseName,Announcement.AnnouncemenText FROM Announcement INNER JOIN Course ON Announcement.CourseId = Course.CourseId where Announcement.CourseId =" + courseId).list();}
	


	/* (non-Javadoc)
	 * @see model.AnnouncementDAO#selectAll()
	 */
	@Override
	public List<Object[]> selectAll() {
		return this.getSession().createNativeQuery("SELECT          Announcement.AnnouncementId, Announcement.MemberId, Announcement.GameId, Game.GameName, \r\n" + 
				"                            Announcement.CourseId, Course.CourseName, Announcement.AnnouncemenText\r\n" + 
				"FROM              Announcement INNER JOIN\r\n" + 
				"                            Game ON Announcement.GameId = Game.GameId INNER JOIN\r\n" + 
				"                            Course ON Announcement.CourseId = Course.CourseId").list();
	}




	/* (non-Javadoc)
	 * @see model.AnnouncementDAO#insert(model.AnnouncementBean)
	 */
	@Override
	public AnnouncementBean insert(AnnouncementBean bean) {
		if (bean != null) {
			AnnouncementBean select = this.selectByAnnouncementId(bean.getAnnouncementId());
			if (select == null) {
				this.getSession().save(bean);
				return bean;
			}
		}
		return null;
	}



	/* (non-Javadoc)
	 * @see model.AnnouncementDAO#update(int, int, int, java.lang.String, int)
	 */
	@Override
	public AnnouncementBean update(int memberId, int gameId, int courseId, String announcemenText, int announcementId) {

		AnnouncementBean bean = this.selectByAnnouncementId(announcementId);
		if (bean != null) {
			bean.setMemberId(memberId);
			bean.setGameId(gameId);
			bean.setCourseId(courseId);
			bean.setAnnouncemenText(announcemenText);
			return bean;
		}
		return null;
	}



	/* (non-Javadoc)
	 * @see model.AnnouncementDAO#delete(int)
	 */
	@Override
	public boolean delete(int announcementId) {
		AnnouncementBean bean = this.selectByAnnouncementId(announcementId);
		if (bean != null) {
			this.getSession().delete(bean);
			return true;
		}
		return false;
	}

}
