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

import model.bean.BlobExBean;
import model.service.BlobExService;

@Controller
@RequestMapping("/pages/BolbExGetImage")
public class BolbExGetImage {

	@Autowired
	BlobExService blobExService;

	@RequestMapping(method = { RequestMethod.GET })
	public void getImage(BlobExBean bean, @RequestParam("id") String id, HttpServletResponse response) {

		InputStream is = null;
		bean.setId(Integer.parseInt(id));

		List<BlobExBean> blobExBean = blobExService.select(bean);

		response.setContentType("image/jpg");

		try {
			is = blobExBean.get(0).getPhoto().getBinaryStream();

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
