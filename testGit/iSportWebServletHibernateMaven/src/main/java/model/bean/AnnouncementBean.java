package model.bean;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="Announcement")
public class AnnouncementBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int announcementId;
	private int memberId;
	private int gameId;
	private int courseId;
	private String announcemenText;
	
	public static void main(String[] args){

		}

	
	@Override
	public String toString() {
		return "AnnouncementBean [AnnouncementId=" + announcementId + ", MemberId=" + memberId + ", GameId=" + gameId
				+ ", CourseId=" + courseId + ", AnnouncemenText=" + announcemenText + "]";
	}


	
	public int getAnnouncementId() {
		return announcementId;
	}
	public void setAnnouncementId(int announcementId) {
		this.announcementId = announcementId;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public int getGameId() {
		return gameId;
	}
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getAnnouncemenText() {
		return announcemenText;
	}
	public void setAnnouncemenText(String announcemenText) {
		this.announcemenText = announcemenText;
	}
	


	
}
