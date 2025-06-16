package models.dto;

import java.io.Serializable;

public class Clothes implements Serializable{
	
	private int clothes_id;				/* 洋服ID */
	private byte[] clothes_img;      /*洋服画像データ*/
	private int category_id;	           /* カテゴリーID*/
	private String remarks;	           /*洗い方メモ*/
	private int users_id;			       /*役職名*/
	private Boolean favorite;				/* お気に入り */
	private String created_at;			/*登録日*/
	private String updated_at;	    /* 更新日 */
	
	public Clothes(int clothes_id, byte[] clothes_img, int category_id, String remarks, int users_id, Boolean favorite,
			String created_at, String updated_at) {
		super();
		this.clothes_id = clothes_id;
		this.clothes_img = clothes_img;
		this.category_id = category_id;
		this.remarks = remarks;
		this.users_id = users_id;
		this.favorite = favorite;
		this.created_at = created_at;
		this.updated_at = updated_at;
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
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public int getUsers_id() {
		return users_id;
	}
	public void setUsers_id(int users_id) {
		this.users_id = users_id;
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
	
	public Clothes() {
		super();
		this.clothes_id = 0;
		this.category_id = 0;
		this.remarks = "";
		this.users_id = 0;
		this.favorite = false;
		this.created_at = "";
		this.updated_at = "";
	}
}