package model;

import java.util.List;

import model.bean.GameBean;

public interface GameDAO {

	GameBean select(int gameId);

	List<GameBean> select();

	GameBean insert(GameBean bean);

	GameBean update(GameBean bean);

	boolean delete(int gameId);

}