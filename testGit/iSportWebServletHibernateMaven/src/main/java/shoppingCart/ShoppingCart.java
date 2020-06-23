package shoppingCart;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import model.bean.ShoppingCartBean;

public class ShoppingCart {

	public ShoppingCart() {
	};

	private Map<Integer, ShoppingCartBean> cart = new LinkedHashMap<>();

	// ${ShoppingCart.content}
	public Map<Integer, ShoppingCartBean> getContent() {
		return cart;
	}

	public void addToCart(int courseId, ShoppingCartBean bean) {
		if (bean == null) {
			return;
		}
		// 如果客戶在伺服器端沒有此項商品的資料，則客戶第一次購買此項商品
		if (cart.get(courseId) == null) {
			cart.put(courseId, bean);
		} else {
			// 如果客戶在伺服器端已有此項商品的資料，則客戶『加購』此項商品
			// ShoppingCartBean oib = cart.get(bookID);
			// // 加購的數量：oi.getQty()
			// // 原有的數量：oib.getQty()
			// oib.setQty(oi.getQty() + oib.getQty());

		}
	}

	// 刪除某項商品
	public int deleteCourse(int courseId) {
		if (cart.get(courseId) != null) {
			cart.remove(courseId); // Map介面的remove()方法
			return 1;
		} else {
			return 0;
		}
	}

	// ${ShoppingCart.itemNumber}
	public int getItemNumber() {
		return cart.size();
	}

	// ${ShoppingCart.subtotal}
	// 計算購物車內所有商品的合計金額(每項商品的單價*數量的總和)
	public double getSubtotal() {
		double subTotal = 0;
		Set<Integer> set = cart.keySet();
		for (int n : set) {
			double price = cart.get(n).getCoursePrice();
			double discount = cart.get(n).getDiscount();
			// int qty = cart.get(n).getQty();
			subTotal += price * discount;
		}
		return subTotal;
	}

	public void listCart() {
		Set<Integer> set = cart.keySet();
		for (Integer courseId : set) {
			System.out.printf("ShoppingCartId=%3d, MemberId=%3d, CourseId=%3d,  CourseName=%s,  CoursePrice=%5.2f",
					cart.get(courseId).getShoppingCartId(), cart.get(courseId).getMemberId(), courseId,
					cart.get(courseId).getCourseName(), cart.get(courseId).getCoursePrice());
			System.out.println();
			System.out.println("----------------------------------------------------------------------------------");
		}
		// 修改商品的數量
		// public boolean modifyQty(int courseId, ShoppingCartBean bean) {
		// if (cart.get(courseId) != null && oi.getQty() > 0) {
		// cart.put(courseId, bean);
		// return true;
		// } else {
		// return false;
		// }
		// }

		// public boolean modifyQty(int courseId, int newQty) {
		// if (cart.get(courseId) != null) {
		// ShoppingCartBean bean = cart.get(courseId);
		// bean.setQty(newQty);
		// // cart.put(bookID, oi);
		// return true;
		// } else {
		// return false;
		// }
		// }

	}
}
