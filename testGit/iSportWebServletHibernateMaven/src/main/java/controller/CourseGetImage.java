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

import model.bean.CourseBean;
import model.service.CourseService;

@Controller
@RequestMapping("/pages/CourseGetImage")
public class CourseGetImage {

	@Autowired
	CourseService courseService;

	@RequestMapping(method = { RequestMethod.POST, RequestMethod.GET })
	public void method(String courseId, HttpServletResponse response) {
		InputStream is = null;

		// 設定圖片輸出格式

		try {
			CourseBean bean = new CourseBean();

			bean.setCourseId(Integer.parseInt(courseId));
			List<CourseBean> courseBean = courseService.select(bean);
			if (courseBean != null) {
				// System.out.println("courseBean.get(0)=" + courseBean.get(0));
				is = courseBean.get(0).getCoursePic().getBinaryStream();
				// System.out.println("is=" + is);
				if (is != null) {
					response.setContentType("image/jpg");
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
