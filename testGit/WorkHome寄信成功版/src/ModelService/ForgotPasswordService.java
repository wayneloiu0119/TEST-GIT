package ModelService;

import ModelBean.MemberBean;
import ModelDAO.MemberDAO;

public class ForgotPasswordService {

	public MemberBean ForgotPassword(String id,String email) {
		MemberDAO dao = new MemberDAO(); 
		MemberBean mb = dao.select(id);
		
		
		if(mb != null && email.equals(mb.getEmail())) {
			return mb;
		}
		else return null;
	}
}
