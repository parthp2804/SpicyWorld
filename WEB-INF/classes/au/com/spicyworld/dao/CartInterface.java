package au.com.spicyworld.dao;

import java.sql.SQLException;
import java.util.Map;

public interface CartInterface {
	public boolean CartAddToListHash(String item_id) throws SQLException;
	public Map< String ,Integer> getCartListHash();
	public boolean delfromCart(String item_id) throws SQLException;
	public boolean delItemfromCart(String item_id) throws SQLException;
	public void emptyCart();
}
