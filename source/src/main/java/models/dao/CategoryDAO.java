package models.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.dto.Category;

public class CategoryDAO {

	/* 洗濯物カテゴリー名の全カテゴリーを取得してリストにして返す */
	public List<Category> getAllCategories() {
		Connection conn = null;
		List<Category> categoryList = new ArrayList<Category>();

		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/f5?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");

			// SQL文をセットする
			String sql = "SELECT category_id, category_name FROM category_mst";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を実行し、結果をrsへ格納
			ResultSet rs = pStmt.executeQuery();

			// １行づつ取り出し、結果をcatListにコピーする
			while (rs.next()) {
				Category cat = new Category(rs.getInt("category_id"), rs.getString("category_name"));
				categoryList.add(cat);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			categoryList = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			categoryList = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					categoryList = null;
				}
			}
		}

		// 結果のリストを返す
		return categoryList;
	}

}