package models.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.dto.JoinLandry;

public class akamineTest {
	
	/* 洗濯物の絞りこみ検索 */
	public List<JoinLandry> GetLaundryUDSelect(int user_id) {
		Connection conn = null;
		List<JoinLandry> SearchList = new ArrayList<JoinLandry>();

		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/F5?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");

			// SQL文をセットする
			String sql = "SELECT clothes_id, clothes_img, category_id, remarks, user_id, favorite, created_at, updated_at "
			           + "FROM clothes "
			           + "WHERE user_id = ? AND favorite = true";
			
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setInt(1, user_id);

			// SQL文を実行し、結果をrsへ格納
			ResultSet rs = pStmt.executeQuery();

			// １行づつ取り出し、結果をclothesListにコピーする
			while (rs.next()) {
				JoinLandry ser = new JoinLandry(
						
						rs.getInt("clothes_id"),
						rs.getBytes("clothes_img"),
						rs.getInt("category_id"),
						rs.getString("remarks"),
						rs.getInt("user_id"),
						rs.getBoolean("favorite"),
						rs.getString("created_at"),
						rs.getString("updated_at")
						
					);
				SearchList.add(ser);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			SearchList = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			SearchList = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					SearchList = null;
				}
			}
		}

		// 結果のリストを返す
		return SearchList;
	}

}
