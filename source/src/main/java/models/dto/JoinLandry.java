package models.dto;

import java.io.Serializable;

public class JoinLandry implements Serializable{
	/* usersテーブル */
	private int user_id;					/* ユーザーID */
	
	/* clothes */
	private int clothes_id;					/* 洗濯物ID */
	private byte[] clothes_img;				/* 洗濯物画像 */
	private String remarks;					/*洗い方メモ*/
	private Boolean favorite;				/*お気に入り*/
	private String created_at;				/* 登録日 */
	private String updated_at;				/* 更新日 */
	
	/* category_mst */
	private int category_id;				/* カテゴリーID */
	private String category_name;			/* カテゴリー名前 */
	
	/* washing_mark_mst */
	private int washing_mark_id;			/* 洗濯表示ID */
	private byte[] washing_mark_icon;		/* 洗濯表示アイコン */
	private int washing_mark_number;		/* 図柄番号 */
	
	/* laundry_category_mst */
	private int laundry_category_id;		/* 洗濯物カテゴリーID */
	private String laundry_category_name;	/* 洗濯物カテゴリー名 */
	
	/* コンストラクタ */
	public JoinLandry(int user_id, int clothes_id, byte[] clothes_img, String remarks, Boolean favorite,
			String created_at, String updated_at, int category_id, String category_name, int washing_mark_id,
			byte[] washing_mark_icon, int washing_mark_number, int laundry_category_id, String laundry_category_name) {
		super();
		this.user_id = user_id;
		this.clothes_id = clothes_id;
		this.clothes_img = clothes_img;
		this.remarks = remarks;
		this.favorite = favorite;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.category_id = category_id;
		this.category_name = category_name;
		this.washing_mark_id = washing_mark_id;
		this.washing_mark_icon = washing_mark_icon;
		this.washing_mark_number = washing_mark_number;
		this.laundry_category_id = laundry_category_id;
		this.laundry_category_name = laundry_category_name;
	}

	/* ゲッター・セッター */
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getClothes_id() {
		return clothes_id;
	}

	public void setClothes_id(int clothes_id) {
		this.clothes_id = clothes_id;
	}

	public byte[] getClothes_img() {
		return clothes_img;
	}

	public void setClothes_img(byte[] clothes_img) {
		this.clothes_img = clothes_img;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Boolean getFavorite() {
		return favorite;
	}

	public void setFavorite(Boolean favorite) {
		this.favorite = favorite;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public int getWashing_mark_id() {
		return washing_mark_id;
	}

	public void setWashing_mark_id(int washing_mark_id) {
		this.washing_mark_id = washing_mark_id;
	}

	public byte[] getWashing_mark_icon() {
		return washing_mark_icon;
	}

	public void setWashing_mark_icon(byte[] washing_mark_icon) {
		this.washing_mark_icon = washing_mark_icon;
	}

	public int getWashing_mark_number() {
		return washing_mark_number;
	}

	public void setWashing_mark_number(int washing_mark_number) {
		this.washing_mark_number = washing_mark_number;
	}

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
}
