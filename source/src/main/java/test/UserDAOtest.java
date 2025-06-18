package test;

import models.dao.UsersDAO;
import models.dto.Users;

public class UserDAOtest {
	
//	private int user_id;		 //ユーザーID
//	private String password;	 //パスワード
//	private String nickname;	 //ニックネーム
//	private String email;		 //メールアドレス
//	private byte[] photo;			 //写真情報
//	private String created_at;	 //登録日
//	private String updated_at;	 //更新日


	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		UsersDAO dao = new UsersDAO();
		System.out.println("---------- select()のテスト1 ----------");
		Users user = dao.login_select("tsutsu@softbank.co.jp");
		if (user != null) {
		    System.out.println("User ID: " + user.getUser_id());
		    System.out.println("Nickname: " + user.getNickname());
		    System.out.println("Email: " + user.getEmail());
		    System.out.println("Created at: " + user.getCreated_at());
		    System.out.println("Updated at: " + user.getUpdated_at());
		} else {
		    System.out.println("ユーザーが見つかりませんでした。");
		}
		// insert()のテスト
		System.out.println("---------- insert()のテスト ----------");
		Users insRec = new Users(0,"password","つつみ","tsuts@softbank.co.jp", null, null,null);
		if (dao.insert(insRec)) {
			System.out.println("登録成功！");	
		} else {
			System.out.println("登録失敗！");
		}
		// update()のテスト
		System.out.println("---------- update()のテスト ----------");
		Users upRec = new Users(2,"password","つつみ","tutumi@att-sys.co.jp",null,null,null);
		if (dao.update(upRec)) {
			System.out.println("更新成功！");
		} else {
			System.out.println("更新失敗！");
		}
		//delete()のテスト
		System.out.println("---------- delete()のテスト ----------");
		
		Users delRec = new Users(1,"password","ツツミ","tutumi@att-sys.co.jp",null,null,null);
		if (dao.delete(delRec)) {
			System.out.println("削除成功！");
		} else {
			System.out.println("削除失敗！");
		}
	}
	
}
