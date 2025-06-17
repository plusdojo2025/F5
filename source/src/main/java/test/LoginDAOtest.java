package test;

import models.dao.LoginDAO;
import models.dto.Users;

public class LoginDAOtest {
	public static void main(String[] args) {
		testIsLoginOK1(); // ユーザーが見つかる場合のテスト
		testIsLoginOK2(); // ユーザーが見つからない場合のテスト
	}

	// ユーザーが見つかる場合のテスト
	public static void testIsLoginOK1() {
		LoginDAO dao = new LoginDAO();

		// emailとpasswordを格納
		Users users = new Users();
		users.setEmail("test@example.com");
		users.setPassword("testpass123");

		if (dao.isLoginOK(users)) {
			System.out.println("testIsLoginOK1：テストが成功しました");
		} else {
			System.out.println("testIsLoginOK1：テストが失敗しました");
		}
	}
	
	// ユーザーが見つからない場合のテスト
	public static void testIsLoginOK2() {
		LoginDAO dao = new LoginDAO();

		// emailとpasswordを格納
		Users users = new Users();
		users.setEmail("notfound@example.com");
		users.setPassword("wrongpass");

		if (!dao.isLoginOK(users)) {
			System.out.println("testIsLoginOK2：テストが成功しました");
		} else {
			System.out.println("testIsLoginOK2：テストが失敗しました");
		}
	}
}
