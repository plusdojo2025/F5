package models.dto;

import java.io.Serializable;

public class Users implements Serializable {
	private int user_id;		 //ユーザーID
	private String password;	 //パスワード
	private String nickname;	 //ニックネーム
	private String email;		 //メールアドレス
	private byte[] photo;			 //写真情報
	private String created_at;	 //登録日
	private String updated_at;	 //更新日
	
//ゲッターとセッター（ソースメニュー →　getterおよびsetterの生成）	 
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
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
	


//コンストラクタ(ソースメニュー →　フィールドを使用してコンストラクタを生成)
	public Users(int user_id, String password, String nickname, String email, byte[] photo, String created_at,
			String updated_at) {
		super();
		this.user_id = user_id;
		this.password = password;
		this.nickname = nickname;
		this.email = email;
		this.photo = photo;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}

//引数なしのコンストラクタ
	public Users() {
		super();
		this.user_id = 0;
		this.password = "";
		this.nickname = "";
		this.email = "";
		this.photo = null;
		this.created_at = "";
		this.updated_at = "";
	}
}
