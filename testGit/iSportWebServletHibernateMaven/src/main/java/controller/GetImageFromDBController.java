package controller;

import java.io.IOException;
import java.io.InputStream;

import java.sql.SQLException;
import java.util.List;


import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import model.bean.MessageBean;
import model.service.MessageService;




@Controller
@RequestMapping("/pages/getImage.controller")
public class GetImageFromDBController {

	@Autowired
	MessageService messageService;

	@RequestMapping(method = { RequestMethod.GET })
	public void getImage(MessageBean bean, @RequestParam("messageId") String id, HttpServletResponse response) {
System.out.println("id="+ id);
		InputStream is = null;
		bean.setMessageId(Integer.parseInt(id));

		List<MessageBean> messageBean = messageService.selects(bean);
		System.out.println("bean=" + bean);
		response.setContentType("image/jpg");

		try {
			is = messageBean.get(0).getMessagePic().getBinaryStream();
			System.out.println("is=" + is);
			int len = 0;
			byte[] bytes = new byte[8192];
			while ((len = is.read(bytes)) != -1) {
				response.getOutputStream().write(bytes, 0, len);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				response.getOutputStream().flush();
				response.getOutputStream().close();

			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
