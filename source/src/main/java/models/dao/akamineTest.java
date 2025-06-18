package models.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.dto.Clothes;

public class akamineTest {
	
	/* ユーザーが所持している全ての洗濯物を取得してリストにして返す */
	public List<Clothes> getAllclothes(int user_id) {
		Connection conn = null;
		List<Clothes> clothesList = new ArrayList<Clothes>();

		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/F5?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");

			// SQL文をセットする
			String sql = "SELECT clothes_id, clothes_img, favorite, user_id FROM clothes WHERE user_id = ?";
			
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setInt(1, user_id);


			// SQL文を実行し、結果をrsへ格納
			ResultSet rs = pStmt.executeQuery();

			// １行づつ取り出し、結果をclothesListにコピーする
			while (rs.next()) {
				Clothes clo = new Clothes(
						rs.getInt("clothes_id"),
						rs.getBytes("clothes_img"),
						rs.getInt("category_id"),
						rs.getString("remarks"),
						rs.getInt("user_id"),
						rs.getBoolean("favorite"),
						rs.getString("created_at"),
						rs.getString("updated_at")
					);
				clothesList.add(clo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			clothesList = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			clothesList = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					clothesList = null;
				}
			}
		}

		// 結果のリストを返す
		return clothesList;
	}

}
