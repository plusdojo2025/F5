package models.dto;

import java.io.Serializable;

public class Category implements Serializable{
	private int category_id;		/* カテゴリーID */
	private String category_name;	/* カテゴリー名前 */
	
	/* コンストラクタ */
	public Category(int category_id, String category_name) {
		this.category_id = category_id;
		this.category_name = category_name;
	}

	/* ゲッター・セッター */
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

}
