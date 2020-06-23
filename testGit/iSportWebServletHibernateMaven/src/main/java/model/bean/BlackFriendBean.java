package model.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BlackFriend")
public class BlackFriendBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int blackFriendId;
	private int memberId;
	private int relationMemberId;
	private String blackFriendType;
	private String States;
	
	@Override
	public String toString() {
		return "BlackFriendBean [blackFriendId=" + blackFriendId + ", memberId=" + memberId + ", relationMemberId="
				+ relationMemberId + ", BlackFriendType=" + blackFriendType + ", States=" + States + "]";
	}
	public int getBlackFriendId() {
		return blackFriendId;
	}
	public void setBlackFriendId(int blackFriendId) {
		this.blackFriendId = blackFriendId;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public int getRelationMemberId() {
		return relationMemberId;
	}
	public void setRelationMemberId(int relationMemberId) {
		this.relationMemberId = relationMemberId;
	}
	public String getBlackFriendType() {
		return blackFriendType;
	}
	public void setBlackFriendType(String blackFriendType) {
		this.blackFriendType = blackFriendType;
	}
	public String getStates() {
		return States;
	}
	public void setStates(String states) {
		States = states;
	}
	

	
}
