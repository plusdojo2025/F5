package models.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.dto.JoinLandry;

public class Test {

	/* ユーザーIDと洗濯物IDを指定してユーザーが所持している洗濯物１つを編集と削除 */
	public List<JoinLandry> GetLaundryUDSelect(int user_id, int clothes_id) {
		Connection conn = null;
		List<JoinLandry> LaundryUDList = new ArrayList<JoinLandry>();

		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/F5?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");

			// SQL文をセットする
			String sql = 
				    "SELECT "
				    + "c.user_id, "
				    + "c.clothes_id, "
				    + "c.clothes_img, "
				    + "c.remarks, "
				    + "c.favorite, "
				    + "c.created_at, "
				    + "c.updated_at, "
				    + "c.category_id, "
				    + "cm.category_name, "
				    + "wm.washing_mark_id, "
				    + "wm.washing_mark_icon, "
				    + "wm.washing_mark_number, "
				    + "lcm.laundry_category_id, "
				    + "lcm.laundry_category_name "
				    + "FROM clothes AS c "
				    + "INNER JOIN category_mst AS cm ON c.category_id = cm.category_id "
				    + "LEFT JOIN clothes_mark AS cmk ON c.clothes_id = cmk.clothes_id "
				    + "LEFT JOIN washing_mark_mst AS wm ON cmk.washing_mark_id = wm.washing_mark_id "
				    + "LEFT JOIN laundry_category_mst AS lcm ON wm.laundry_category_id = lcm.laundry_category_id "
				    + "WHERE c.user_id = ? AND c.clothes_id = ?";
			
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setInt(1, user_id);
            pStmt.setInt(2, clothes_id);

			// SQL文を実行し、結果をrsへ格納
			ResultSet rs = pStmt.executeQuery();

			// １行づつ取り出し、結果をclothesListにコピーする
			while (rs.next()) {
				JoinLandry jl = new JoinLandry(
					    rs.getInt("user_id"),
					    rs.getInt("clothes_id"),
					    rs.getBytes("clothes_img"),
					    rs.getString("remarks"),
					    rs.getBoolean("favorite"),
					    rs.getString("created_at"),
					    rs.getString("updated_at"),
					    rs.getInt("category_id"),
					    rs.getString("category_name"),
					    rs.getInt("washing_mark_id"),
					    rs.getBytes("washing_mark_icon"),
					    rs.getInt("washing_mark_number"),
					    rs.getInt("laundry_category_id"),
					    rs.getString("laundry_category_name")
					);
				LaundryUDList.add(jl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			LaundryUDList = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			LaundryUDList = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					LaundryUDList = null;
				}
			}
		}

		// 結果のリストを返す
		return LaundryUDList;
	}
}
