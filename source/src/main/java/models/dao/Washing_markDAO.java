package models.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.dto.Washing_mark;
public class Washing_markDAO {
	//洗濯表示(洗濯マーク)を取得
	public List<Washing_mark> getWashing_mark(){
		Connection conn = null;
		List<Washing_mark> Washing_markList = new ArrayList<>();
		try {
			//JDBCドライバに接続
			Class.forName("com.mysql.cj.jdbc.Driver");
			//データベースに接続をする
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/f5?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");
			//SQL文の作成 洗濯マークの情報を取得
			//laundry_category_mstテーブルにある洗濯カテゴリーの名前を取得可能
			String sql = "SELECT washing_mark_id, washing_mark_icon, washing_mark_info, "
			           + "washing_mark_mst.laundry_category_id,washing_mark_number, laundry_category_mst.laundry_category_name "
			           + "FROM washing_mark_mst "
			           + "JOIN laundry_category_mst "
			           + "ON washing_mark_mst.laundry_category_id = laundry_category_mst.laundry_category_id";
			
			//プリペアードステイトメント
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			//SQLの実行
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
				Washing_mark washing_mark = new Washing_mark(
						rs.getInt("washing_mark_id"),
						rs.getBytes("washing_mark_icon"),
						rs.getString("washing_mark_info"),
						rs.getInt("laundry_category_id"),
						rs.getInt("washing_mark_number"),
						rs.getString("laundry_category_name")						);
				Washing_markList.add(washing_mark);
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
			Washing_markList = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			Washing_markList = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					Washing_markList = null;
				}
			}
		}
		return Washing_markList;
	}
	
	public Washing_mark findByNumber(int number) {
	    Connection conn = null;
	    Washing_mark wm = null;

	    try {
	        // JDBCドライバ読み込み
	        Class.forName("com.mysql.cj.jdbc.Driver");

	     // DBへ接続
	        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/f5?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");

	     // numberで1件だけ検索するSQL文
	        String sql = "SELECT washing_mark_id, washing_mark_icon, washing_mark_info, washing_mark_mst.laundry_category_id, washing_mark_number, laundry_category_mst.laundry_category_name "
	                + "FROM washing_mark_mst "
	                + "JOIN laundry_category_mst "
	                + "ON washing_mark_mst.laundry_category_id = laundry_category_mst.laundry_category_id "
	                + "WHERE washing_mark_id = ?";

	        PreparedStatement pStmt = conn.prepareStatement(sql);
	        pStmt.setInt(1, number);

	        ResultSet rs = pStmt.executeQuery();

	     // 検索結果があればBcオブジェクトに格納
	        if (rs.next()) {
	            wm = new Washing_mark(
	                rs.getInt("washing_mark_id"),
	                rs.getBytes("washing_mark_icon"),
	                rs.getString("washing_mark_info"),
	                rs.getInt("laundry_category_id"),
	                rs.getInt("washing_mark_number"),
	                rs.getString("laundry_category_name")
	            );
	        }
	    } catch (SQLException | ClassNotFoundException e) {
	        e.printStackTrace();
	    } finally {
	        if (conn != null) {
	            try {
	                conn.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    return wm;  // nullの可能性あり
	}
}
