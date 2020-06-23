package model;

import java.util.List;

import model.bean.PartyBean;

public interface PartyDAO {

	PartyBean select(int partyId);

	List<PartyBean> select();

	boolean insert(PartyBean bean);

	PartyBean update(PartyBean bean);

	boolean delete(int partyId);

}