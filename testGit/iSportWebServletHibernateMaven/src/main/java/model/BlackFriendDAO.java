package model;

import java.util.List;

import org.hibernate.Session;

import model.bean.BlackFriendBean;



public interface BlackFriendDAO {

	Session getSession();

	BlackFriendBean select(int blackFriendId);

	List<BlackFriendBean> select();

	//**************************************************************************************************************
	// memberId 查詢關係
	List<Object[]> selectMemberId(int memberId);

	List<Object[]> selectFrienType(int memberId, String blackFriendType);

	//**************************************************************************************************************
	BlackFriendBean insert(BlackFriendBean bean);

	BlackFriendBean update(int memberId, int relationMemberId, String blackFriendType, String states,
			int blackFriendId);

	boolean delete(int blackFriendId);

}