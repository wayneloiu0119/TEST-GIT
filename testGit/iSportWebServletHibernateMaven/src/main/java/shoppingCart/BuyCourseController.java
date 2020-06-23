package shoppingCart;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.CourseDAO;
import model.bean.ShoppingCartBean;
import model.spring.PrimitiveNumberEditor;

//當使用者按下『加入購物車』時，瀏覽器會送出請求到本程式

@Controller
@RequestMapping(value = "/shoppingCart/buycourse.controller")
public class BuyCourseController {

	@Autowired
	CourseDAO courseDAOHibernate;

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.registerCustomEditor(int.class, new PrimitiveNumberEditor(java.lang.Integer.class, true));
		webDataBinder.registerCustomEditor(double.class, new PrimitiveNumberEditor(java.lang.Double.class, true));
		webDataBinder.registerCustomEditor(java.util.Date.class,
				new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}

	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST })
	public String buyCourse(ShoppingCartBean bean, BindingResult bindingResult, Model model, HttpSession session) {
		// @RequestParam("pageNo") String pageNo

		if (session == null) { // 使用逾時
			System.out.println("------------------session == null------------------");
			model.addAttribute("Errors", "使用逾時，請重新登入(BuyCourseController:SessionTimeOut)");
			return "login";
		}
		System.out.println("------------------session------------------");

		// 取出存放在session物件內的ShoppingCart物件
		ShoppingCart cart = (ShoppingCart) session.getAttribute("ShoppingCart");
		// 如果找不到ShoppingCart物件
		if (cart == null) {
			// 就新建ShoppingCart物件
			cart = new ShoppingCart();
			// 將此新建ShoppingCart的物件放到session物件內
			session.setAttribute("ShoppingCart", cart); // ${ShoppingCart.zzz}
		}

		// if (pageNo == null) {
		// pageNo = "1";
		// }

		// 進行資料型態的轉換

		// 將訂單資料封裝到OrderItemBean內
		// ShoppingCartBean shoppingCartBean = new
		// ShoppingCartBean(bean.getShoppingCartId(), bean.getMemberId(),
		// bean.getCourseId(), bean.getCourseName(), bean.getCoursePrice());

		// ShoppingCartBean shoppingCartBean = shoppingCartService.insert(bean);

		// 將ShoppingCartBean加入ShoppingCart的物件內
		cart.addToCart(bean.getCourseId(), bean);
		cart.listCart();

		return "cartTest";
	}
}
