package model.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.PartyListDAO;
import model.bean.PartyListBean;

@Repository
public class PartyListHibernateDAO implements PartyListDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> selectByMemeberId(int memberId) {
		return this.getSession().createNativeQuery("SELECT Party.PartyId, Party.MemberId, Party.PartyName, Party.PartyDate, Party.PartyTime, Party.PartyLocation FROM Party INNER JOIN PartyList ON Party.PartyId = PartyList.PartyId where Party.MemberId = " + memberId)
				.list();
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> selectByPartyId(int partyId) {
		return this.getSession().createNativeQuery("SELECT Party.PartyId, Party.MemberId, Party.PartyName, Party.PartyDate, Party.PartyTime, Party.PartyLocation FROM Party INNER JOIN PartyList ON Party.PartyId = PartyList.PartyId where Party.PartyId = " + partyId)
				.list();
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> selectall() {
		return this.getSession().createNativeQuery(" SELECT PartyList.PartyId, Party.MemberId, Party.PartyName, Party.PartyDate, Party.PartyTime, Party.PartyLocation FROM PartyList INNER JOIN Party ON PartyList.PartyId = Party.PartyId").list();
	}

	public PartyListBean selectByOne(int memberId, int partyId) {
		List<PartyListBean> list = new ArrayList<PartyListBean>();
		list = this.getSession()
				.createQuery("from PartyListBean where MemberId = " + memberId + "AND PartyId =" + partyId,
						PartyListBean.class)
				.list();
		// list陣列內無資料 Size為0
		if (list.size() == 0) {
			return null;
		} else {
			// 有資料回傳List內第一筆資料
			return list.get(0);
		}
	}

	public PartyListBean insert(PartyListBean bean) {
		if (bean != null) {
			PartyListBean glb = this.selectByOne(bean.getMemberId(), bean.getPartyId());
			if (glb == null) {
				this.getSession().save(bean);
				return bean;
			}
		}
		return null;
	}

	public boolean delete(int memberId, int PartyId) {
		PartyListBean glb = this.selectByOne(memberId, PartyId);
		if (glb != null) {
			this.getSession().delete(glb);
			return true;
		} else {
			return false;
		}
	}

}
