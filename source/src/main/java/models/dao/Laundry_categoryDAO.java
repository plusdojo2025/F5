package models.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.dto.Laundry_category;


public class Laundry_categoryDAO{
	//洗濯カテゴリー(漂白、家庭洗濯など)を取得する。
	public List<Laundry_category> getLaundryCategory(){
		Connection conn = null;
		List<Laundry_category> laundry_categoryList= new ArrayList<>();
		try {
			//JDBCドライバに接続
			Class.forName("com.mysql.cj.jdbc.Driver");
			//データベースに接続をする
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/F5?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");
			
			
			String sql = "SELECT laundry_category_id,laundry_category_name FROM laundry_category_mst";
			//プリペアードステイトメント
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			//SQLの実行
			ResultSet rs = pStmt.executeQuery();
			//結果をコレクションにコピー
			while (rs.next()) {
				Laundry_category laundry_category = new Laundry_category(
						rs.getInt("laundry_category_id"),
						rs.getString("laundry_category_name")
						);
				
				laundry_categoryList.add(laundry_category);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			laundry_categoryList = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			laundry_categoryList = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					laundry_categoryList = null;
				}
			}
		}
		return laundry_categoryList; 
	}
}