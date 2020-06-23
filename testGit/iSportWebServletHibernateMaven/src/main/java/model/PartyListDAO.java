package model;

import java.util.List;

import model.bean.PartyListBean;

public interface PartyListDAO {

	// 以MemberId查詢該會員目前所參加的活動
	List<Object[]> selectByMemeberId(int memberId);

	List<Object[]> selectByPartyId(int partyId);

	List<Object[]> selectall();

	PartyListBean selectByOne(int memberId, int partyId);

	PartyListBean insert(PartyListBean bean);

	boolean delete(int memberId, int PartyId);

}