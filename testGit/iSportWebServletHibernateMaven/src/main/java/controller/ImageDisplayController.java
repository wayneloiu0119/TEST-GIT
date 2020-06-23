package controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import model.bean.CommercialBean;
import model.service.CommercialService;

@Controller
@RequestMapping("/Commercail/getImage.controller")
public class ImageDisplayController {

	@Autowired
	private CommercialService commService;

	@RequestMapping(method = { RequestMethod.POST, RequestMethod.GET })
	public void method(String commercialId, HttpServletResponse response) {

		InputStream is = null;

		try {
			CommercialBean comBean = commService.selectOneCommercial(Integer.parseInt(commercialId));
			if (comBean != null) {
				is = comBean.getPic().getBinaryStream();
				response.setContentType("image/gif");
				if (is != null) {
					int len = 0;
					byte[] bytes = new byte[8192];
					while ((len = is.read(bytes)) != -1) {
						response.getOutputStream().write(bytes, 0, len);
					}
				}

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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
