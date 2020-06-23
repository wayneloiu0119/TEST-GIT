package model.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import model.bean.PartyListBean;
import model.dao.PartyListHibernateDAO;
@Repository
public class PartyListService {
	@Autowired
	private PartyListHibernateDAO plDAO;

	public PartyListService(PartyListHibernateDAO plDAO) {
		this.plDAO = plDAO;
	}

	// 顯示該會員參加的活動
	public List<Object[]> showPartyByMemeberId(int memberId) {
		List<Object[]> beans = null;
		beans = plDAO.selectByMemeberId(memberId);
		if (beans != null) {
			return beans;
		}
		return null;
	}

	// 顯示該活動內所有會員
	public List<Object[]> showMemberByPartyID(int partyId) {
		List<Object[]> beans = null;
		beans = plDAO.selectByPartyId(partyId);
		if (beans != null) {
			return beans;
		}
		return null;

	}

	// 顯示所有活動
	public List<Object[]> showAllPartyAllMember() {
		List<Object[]> beans;
		beans = plDAO.selectall();
		if (beans != null) {
			return beans;
		}
		return null;
	}

	// 顯示該會員是否在該比賽內
	public PartyListBean checkMemberInParty(int memberId, int partyId) {
		PartyListBean bean = plDAO.selectByOne(memberId, partyId);
		if (bean != null) {
			return bean;
		}
		return null;
	}

	// 該會員加入活動
	public PartyListBean joinParty(PartyListBean bean) {
		PartyListBean plb = this.checkMemberInParty(bean.getMemberId(), bean.getPartyId());
		if (plb == null) {
			Date tempDate = new java.util.Date();
			SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy/MM/dd");
			SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");
			String partyJoinDate = sdfDate.format(tempDate);
			String partyJoinTime = sdfTime.format(tempDate);
			bean.setPartyJoinDate(partyJoinDate);
			bean.setPartyJoinTime(partyJoinTime);
			plDAO.insert(bean);
			return bean;
		}
		return null;
	}

	// 會員退出活動
	public boolean quitParty(int memberId, int partyId) {
		PartyListBean bean = this.checkMemberInParty(memberId, partyId);
		if (bean != null) {
			plDAO.delete(bean.getMemberId(), bean.getPartyId());
			return true;
		}
		return false;
	}

}
