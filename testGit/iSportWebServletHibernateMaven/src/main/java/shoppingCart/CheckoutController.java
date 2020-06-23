package shoppingCart;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import model.spring.PrimitiveNumberEditor;

@Controller
@RequestMapping("/shoppingCart")
public class CheckoutController {

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.registerCustomEditor(int.class, new PrimitiveNumberEditor(java.lang.Integer.class, true));
		webDataBinder.registerCustomEditor(double.class, new PrimitiveNumberEditor(java.lang.Double.class, true));
	}

	// 當使用者按下『結帳』時，瀏覽器會送出請求到本程式
	@RequestMapping(value = "/checkOrder.controller", method = { RequestMethod.GET, RequestMethod.POST })
	public String checkOrder(Model model, HttpSession session) {

		if (session == null) { // 使用逾時
			System.out.println("------------------session == null------------------");
			model.addAttribute("Errors", "使用逾時，請重新登入(CheckoutController checkOrder:SessionTimeOut)");
			return "login";
		}
		ShoppingCart cart = (ShoppingCart) session.getAttribute("ShoppingCart");
		if (cart == null) {
			// 如果找不到購物車(通常是Session逾時)，沒有必要往下執行
			// 導向首頁
			return "login";
		}

		// 結帳
		// RequestDispatcher rd = request.getRequestDispatcher("OrderConfirm.jsp");
		return "OrderConfirm";
	}

	// 當使用者按下『放棄購物』時，瀏覽器會送出請求到本程式
	@RequestMapping(value = "/giveUp.controller", method = { RequestMethod.GET, RequestMethod.POST })
	public String giveUpOrder(Model model, HttpSession session) {

		ShoppingCart cart = (ShoppingCart) session.getAttribute("ShoppingCart");
		if (cart != null) {
			// 由session物件中移除ShoppingCart物件
			session.removeAttribute("ShoppingCart");
		}
		return "index";
	}

	// 本方法可修改購物車內的商品資料，刪除某項商品
	@RequestMapping(value = "/updateOrder.controller", method = { RequestMethod.GET, RequestMethod.POST })
	public String updateOrder(Model model, HttpSession session, @RequestParam("courseId") String courseId) {
		// @RequestParam("courseId") String courseId
//		String courseId = request.getParameter("courseId");
		System.out.println("------courseId--------=" + courseId);
		// System.out.println("------courseId1--------=" + courseId1);
		if (session == null) { // 使用逾時
			System.out.println("------------------session == null------------------");
			model.addAttribute("Errors", "使用逾時，請重新登入(CheckoutController updateOrder:SessionTimeOut)");
			return "login";
		}
		ShoppingCart cart = (ShoppingCart) session.getAttribute("ShoppingCart");
		if (cart == null) {
			// 如果找不到購物車(通常是Session逾時)，沒有必要往下執行
			// 導向首頁
			return "login";
		}
		cart.deleteCourse(Integer.parseInt(courseId)); // 刪除購物車內的某項商品
		// cart.deleteCourse(1001);
		return "ShowCartContent";
	}
}
