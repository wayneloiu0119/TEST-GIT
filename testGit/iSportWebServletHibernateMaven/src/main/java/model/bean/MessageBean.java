package model.bean;

import java.sql.Blob;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Message")
public class MessageBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int messageId;
	private int memberId;
	private Date messageTime;
	private String typeName;
	private String messageText;
	private Blob messagePic;
	private int star;
	
	
	@Override
	public String toString() {
		return "MessageBean [messageId=" + messageId + ", memberId=" + memberId + ", messageTime=" + messageTime
				+ ", typeName=" + typeName + ", messageText=" + messageText + ", messagePic=" + messagePic + ", star="
				+ star + "]";
	}
	public int getMessageId() {
		return messageId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public Date getMessageTime() {
		return messageTime;
	}
	public void setMessageTime(Date messageTime) {
		this.messageTime = messageTime;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getMessageText() {
		return messageText;
	}
	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}
	public Blob getMessagePic() {
		return messagePic;
	}
	public void setMessagePic(Blob messagePic) {
		this.messagePic = messagePic;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	

	

	
}
