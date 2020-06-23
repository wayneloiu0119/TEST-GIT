package model;

import java.util.List;

import org.hibernate.Session;

import model.bean.AnnouncementBean;



public interface AnnouncementDAO {

	Session getSession();

	List<AnnouncementBean> select();

	AnnouncementBean selectByAnnouncementId(int announcementId);

	List<Object[]> selectAllGame();

	List<Object[]> selectGameId(int gameId);

	List<Object[]> selectAllCourse();

	List<Object[]> selectCourseId(int courseId);

	List<Object[]> selectAll();

	AnnouncementBean insert(AnnouncementBean bean);

	AnnouncementBean update(int memberId, int gameId, int courseId, String announcemenText, int announcementId);

	boolean delete(int announcementId);

}