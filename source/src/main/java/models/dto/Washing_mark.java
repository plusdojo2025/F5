package models.dto;

import java.io.Serializable;

public class Washing_mark implements Serializable {
	private int washing_id;	// 洗濯表示ID
	private byte[] washing_mark_icon;	// アイコン
	private String washing_mark_info;	// 洗濯表示情報
	private int laundry_category_id;	// 洗濯表示カテゴリーID
	private int washing_mark_number;	// 図柄番号
	
	public int getWashing_id() {
		return washing_id;
	}
	public void setWashing_id(int washing_id) {
		this.washing_id = washing_id;
	}
	public byte[] getWashing_mark_icon() {
		return washing_mark_icon;
	}
	public void setWashing_mark_icon(byte[] washing_mark_icon) {
		this.washing_mark_icon = washing_mark_icon;
	}
	public String getWashing_mark_info() {
		return washing_mark_info;
	}
	public void setWashing_mark_info(String washing_mark_info) {
		this.washing_mark_info = washing_mark_info;
	}
	public int getLaundry_category_id() {
		return laundry_category_id;
	}
	public void setLaundry_category_id(int laundry_category_id) {
		this.laundry_category_id = laundry_category_id;
	}
	public int getWashing_mark_number() {
		return washing_mark_number;
	}
	public void setWashing_mark_number(int washing_mark_number) {
		this.washing_mark_number = washing_mark_number;
	}
	
	public Washing_mark(int washing_id, byte[] washing_mark_icon, String washing_mark_info, int laundry_category_id,
			int washing_mark_number) {
		super();
		this.washing_id = washing_id;
		this.washing_mark_icon = washing_mark_icon;
		this.washing_mark_info = washing_mark_info;
		this.laundry_category_id = laundry_category_id;
		this.washing_mark_number = washing_mark_number;
	}
	public Washing_mark() {
		super();
		this.washing_id = 0;
		this.washing_mark_info = "";
		this.laundry_category_id = 0;
		this.washing_mark_number = 0;
	}
}
