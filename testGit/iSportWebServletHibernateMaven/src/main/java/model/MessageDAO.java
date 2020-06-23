package model;

import java.sql.Blob;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import model.bean.MessageBean;



public interface MessageDAO {

	Session getSession();

	MessageBean select(int messageId);

	List<MessageBean> select();

	//*************************************************************************************************	
	//查詢所有
	List<Object[]> selectAll();

	//MemberId查詢
	List<Object[]> selectMemberId(int memberId);

	//*************************************************************************************************	
	MessageBean insert(MessageBean bean);

	MessageBean update(int memberId, Date messageTime, String typeName, String messageText, Blob messagePic, int star,
			int messageId);

	boolean delete(int messageId);

}