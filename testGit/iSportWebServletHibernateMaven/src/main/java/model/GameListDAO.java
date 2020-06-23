package model;

import java.util.List;

import model.bean.GameListBean;

public interface GameListDAO {

	// 以MemberId查詢該會員目前所參加的比賽
	List<Object[]> selectByMemeberId(int memberId);

	List<Object[]> selectByGameId(int gameId);

	List<Object[]> selectAll();

	GameListBean selectByOne(int memberId, int gameId);

	boolean insert(GameListBean bean);

	boolean delete(int memberId, int gameId);



}