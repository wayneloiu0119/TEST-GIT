package shoppingCart;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.bean.OrdersBean;
import model.bean.OrdersListBean;
import model.bean.ShoppingCartBean;
import model.service.OrdersService;
import model.service.OredersListService;

@Controller
public class ProcessOrderController {

	@Autowired
	OrdersService ordersService;

	@Autowired
	OredersListService oredersListService;

	@RequestMapping(value = "/shoppingCart/processOrder.controller", method = { RequestMethod.GET, RequestMethod.POST })
	public String processOrder(Model model, HttpSession session) {

		if (session == null) { // 使用逾時
			System.out.println("------------------session == null------------------");
			model.addAttribute("Errors", "使用逾時，請重新登入(ProcessOrderController :SessionTimeOut)");
			return "login";
		}

		// MemberBean mb = (MemberBean) session.getAttribute("LoginOK");
		// if (mb == null) {
		// return "login";
		// }

		ShoppingCart sc = (ShoppingCart) session.getAttribute("ShoppingCart");
		if (sc == null) {
			// 如果找不到購物車(通常是Session逾時)，沒有必要往下執行
			// 導向首頁
			return "index";
		}

		// if (finalDecision.equals("CANCEL")) {
		// session.removeAttribute("ShoppingCart");
		// response.sendRedirect(response.encodeRedirectURL(request.getContextPath()));
		// return; // 一定要記得 return
		// }

		// String memberId = mb.getMemberId();
		// Date today = (Date) session.getAttribute("today");

		// OrdersBean:封裝一筆訂單資料的容器(包含訂單主檔與訂單明細檔的資料)
		OrdersBean bean = new OrdersBean();
		// bean.setMemberId(Integer.parseInt(memberId));
		bean.setMemberId(1);
		bean.setOrderDate(new Date());
		bean.setOrderPrice(sc.getSubtotal());
		bean.setPayment("信用卡付款");

		OrdersBean insert = ordersService.insert(bean);
		List<OrdersBean> select = ordersService.select(insert);
		System.out.println("XXXXXXXXXXXXX="+select.get(select.size()-1));

		Map<Integer, ShoppingCartBean> cart = sc.getContent();
		Set<Integer> set = cart.keySet();
		for (Integer k : set) {
			ShoppingCartBean shoppingCartBean = cart.get(k);
			OrdersListBean ordersListBean = new OrdersListBean();

			// 從OrdersBean insert取出訂單編號
			ordersListBean.setOrderId(select.get(select.size()-1).getOrderId());
			ordersListBean.setCourseId(shoppingCartBean.getCourseId());
			ordersListBean.setCourseName(shoppingCartBean.getCourseName());
			ordersListBean.setCoursePrice(shoppingCartBean.getCoursePrice() * shoppingCartBean.getDiscount());
			// 教練
			ordersListBean.setMemberId(shoppingCartBean.getMemberId());

			oredersListService.insert(ordersListBean);
		}

		session.removeAttribute("ShoppingCart");
		// response.sendRedirect(response.encodeRedirectURL
		// ("../ThanksForOrdering.jsp"));
		return "index";

	}

}
