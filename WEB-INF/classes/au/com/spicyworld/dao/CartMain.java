package au.com.spicyworld.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import au.com.spicyworld.dao.ItemImpl;

import au.com.spicyworld.dao.CartInterface;;

public class CartMain implements CartInterface {// Cart Implementation
	final ItemImpl itemimpl = new ItemImpl();
	final Map<String, Integer> cart = new HashMap<String, Integer>();

	public boolean CartAddToListHash(String item_id) throws SQLException {
		if (cart.containsKey(item_id)) {

			if (cart.get(item_id).intValue() < itemimpl.max_limit(item_id)) {
				cart.put(item_id, cart.get(item_id) + 1);

				return true;
			} else {

				return false;
			}

		} else {
			cart.put(item_id, 1);
			return true;
		}
	}

	@Override
	public Map<String, Integer> getCartListHash() {
		// TODO Auto-generated method stub
		return cart;
	}

	@Override
	public boolean delfromCart(String item_id) throws SQLException {
		// TODO Auto-generated method stub
		if (cart.containsKey(item_id)) {
			if (cart.get(item_id).intValue() > 1) {
				cart.put(item_id, cart.get(item_id) - 1);
				return true;
			} else {
				this.delItemfromCart(item_id);
				return true;
			}
		} else {
			return false;
		}
	}

	public boolean delItemfromCart(String item_id) throws SQLException {
		// TODO Auto-generated method stub
		if (cart.containsKey(item_id)) {
			cart.remove(item_id);
			return true;
		} else {
			return false;
		}
	}

	public void emptyCart() {
		// TODO Auto-generated method stub
		cart.clear();

	}

	public int getmax_limit(String item_id) throws SQLException {
		return itemimpl.max_limit(item_id);
	}

}
