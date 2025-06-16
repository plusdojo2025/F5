package models.dto;

import java.io.Serializable;

public class Laundry_category implements Serializable {
	private int laundry_category_id;	// 洗濯表示カテゴリーID
	private String laundry_category_name;	// 洗濯表示名
	
	public int getLaundry_category_id() {
		return laundry_category_id;
	}
	public void setLaundry_category_id(int laundry_category_id) {
		this.laundry_category_id = laundry_category_id;
	}
	public String getLaundry_category_name() {
		return laundry_category_name;
	}
	public void setLaundry_category_name(String laundry_category_name) {
		this.laundry_category_name = laundry_category_name;
	}
	
	public Laundry_category(int laundry_category_id, String laundry_category_name) {
		super();
		this.laundry_category_id = laundry_category_id;
		this.laundry_category_name = laundry_category_name;
	}
	public Laundry_category() {
		super();
		this.laundry_category_id = 0;
		this.laundry_category_name = "";
	}
}	