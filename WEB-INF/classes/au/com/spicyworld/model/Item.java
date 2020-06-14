package au.com.spicyworld.model;

import javax.servlet.http.Part;

public class Item {

	private String item_id;
	private String item_name;
	private String item_category;
	private float item_price;
	private int item_quantitymax;
	private Part item_image;

	public String getItem_id() {
		return item_id;
	}

	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getItem_category() {
		return item_category;
	}

	public void setItem_category(String item_category) {
		this.item_category = item_category;
	}

	public float getItem_price() {
		return item_price;
	}

	public void setItem_price(float item_price) {
		this.item_price = item_price;
	}

	public int getItem_quantitymax() {
		return item_quantitymax;
	}

	public void setItem_quantitymax(int item_quantitymax) {
		this.item_quantitymax = item_quantitymax;
	}

	public Part getItem_image() {
		return item_image;
	}
	public void setItem_image(Part part) {
		this.item_image = part;
	}

	@Override
	public String toString() {
		return "Item [item_id=" + item_id + ", item_name=" + item_name + ", item_category=" + item_category
				+ ", item_price=" + item_price + ", item_quantitymax=" + item_quantitymax + ", item_image=" + item_image
				+ ", getItem_id()=" + getItem_id() + ", getItem_name()=" + getItem_name() + ", getItem_category()="
				+ getItem_category() + ", getItem_price()=" + getItem_price() + ", getItem_quantitymax()="
				+ getItem_quantitymax() + ", getItem_image()=" + getItem_image() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
